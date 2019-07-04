package com.example.eeprojecttrue.Controller;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.eeprojecttrue.Entity.C_G;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Goods;
import com.example.eeprojecttrue.Entity.Collect;
import com.example.eeprojecttrue.Service.CustomerService;
import com.example.eeprojecttrue.Service.GoodsService;
import com.example.eeprojecttrue.Service.IssueService;
import com.example.eeprojecttrue.Service.CollectService;

@Controller
public class SecondController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CollectService collectService;
	
//	方法是get的时候可以访问网站二手，此处动态调用数据库将内容显示到二手市场主页

	@RequestMapping(value = "/second-hand.html",method = RequestMethod.GET)
    public String SecondHandHome2(Model model,HttpSession session)
    {
		//这里获取当前用户的id
		Customer customer = (Customer)session.getAttribute("customer");
        Integer customerId = customer.getId();
		
		List<Goods> list=goodsService.findAll();
		int page = 1;
		
		Goods []goods=new Goods[8];
        Goods temp;
        
        //构造goods+isCollect的类型
        List<C_G> cgs = new ArrayList<C_G>();
        
        for(int i=0;i<8;i++)
        {
            temp= list.get(i);
            goods[i]=temp;
            
            int isCollect = 0;
            if(collectService.findByCustomerIdAndGoodsId(customer.getId(), temp.getId())!=null) {//判断是否是已经收藏了的状态
	        	isCollect = 1;
	        }
            cgs.add(new C_G(temp,isCollect));
        }
       
        model.addAttribute("data",cgs);
        model.addAttribute("page",page);
        model.addAttribute("customerId",customerId);
        
        
        return "second-hand";
    }
	
	//分页请求
	@RequestMapping(value = "/second-hand-divPage{id}.html",method = RequestMethod.GET)
	public String SecondHandDivPage(@PathVariable("id") int id,Model model,HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customer");
        Integer customerId = customer.getId();
		
		List<Goods> Allgoods = goodsService.findAll();
		int n = Allgoods.size();
		System.out.println("n:" + n);
		ArrayList<Goods> goods = new ArrayList<Goods>();
		
		int page = id;
		List<C_G> cgs = new ArrayList<C_G>();
		//每一页构造8个
		for(int i = 0;i < 8;i++) {
			int j = (id-1) * 8 + i;
						
			if(j < n) {
				goods.add(Allgoods.get(j));
				System.out.println("j:" + j);
				
				int isCollect = 0;
			
				//这里使用if的方法判断出了问题，以防万一使用了for循环
	            List<Collect> collects = collectService.findByCustomerId(customerId);
	            for(int k = 0;k < collects.size();k++) {
	            	if(collects.get(k).getGoodsId() == Allgoods.get(j).getId()) {
	            		isCollect = 1;
	            		break;
	            	}
	            }
	            
	            cgs.add(new C_G(Allgoods.get(j),isCollect));
			}
			else {
				break;
			}
		}
		
		model.addAttribute("data", cgs);
		model.addAttribute("page",page);
		model.addAttribute("customerId",customerId);
		
		return "second-hand-divPage";
	}
	
	//查看商品详情页		
	@RequestMapping(value = "/goods-details{id}.html",method = RequestMethod.GET)
    public String GoodsDetail2(@PathVariable("id") int id,Model model,HttpSession session)
    {
		Customer customer = (Customer)session.getAttribute("customer");
		
		System.out.println("id:"+id);
        Goods goods = goodsService.findById(id);
        
        //判断商品是否已经收藏，方便改写商品详情页的显示信息
        int isCollect = 0;
        if(collectService.findByCustomerIdAndGoodsId(customer.getId(), id)!=null) {
        	isCollect = 1;
        }
        
        List<Goods> AllGoods = goodsService.findAll();
        int n = goodsService.findAll().size();
		Random r = new Random();
		
		//生成不重复的4个商品id用来传给推荐界面
		ArrayList<Goods> goods2 = new ArrayList<Goods>();
		for(int i = 0;i<4;i++) {
			int j = r.nextInt(10000)%n;
			goods2.add(AllGoods.get(j));
		}
		
		Date date = issueService.findDateByGoodsId(id);
		String customerName = issueService.findCustomerByGoodsId(id).getName();
		
	    model.addAttribute("customer",customer);
		model.addAttribute("isCollect",isCollect);
        model.addAttribute("data",goods);
        model.addAttribute("randomGoods",goods2);
        model.addAttribute("customerName",customerName);
        model.addAttribute("time", date);
        
        
        
        return "goods-details";
    }

	//购买页
	@RequestMapping(value = "/purchase.html",method = RequestMethod.GET)
    public String Purchase(Model model,HttpSession session)
    {
        return "purchase";
    }
	
	
	//收藏,只作刷新响应,将收藏的东西放到对应的列表里面
	@RequestMapping(value = "/second-hand-like",method = RequestMethod.GET)
    public @ResponseBody int Like(int id,int customerId,int isDelete)
    {
		
		Collect collect = new Collect(customerId, id);

		Customer customer = customerService.findById(customerId);
		Goods likeGoods = goodsService.findById(id);

		if (isDelete == 0 && (collectService.findByCustomerIdAndGoodsId(customerId, id)==null)) {// 说明顾客收藏了
			collectService.Save(collect);
			System.out.println(customer.getName() + " 收藏了" + likeGoods.getName());
		} else if(isDelete == 1 && (collectService.findByCustomerIdAndGoodsId(customerId, id)!=null)){
			collectService.Delete(collect);
			System.out.println(customer.getName() + "取消收藏" + likeGoods.getName());
		}

		return 1;
    }
	
	
	//显示二进制图片的请求
	@GetMapping(value = "LGoods/image/get")
    public ResponseEntity<byte[]> Image_Goods(int id, HttpServletResponse res)
    {
		byte[] data = goodsService.findById(id).getPicture1();
		System.out.println("显示二进制图片:" + data);
		res.setContentType("image/jpeg");
		res.setCharacterEncoding("UTF-8");
		return new ResponseEntity<>(data, HttpStatus.OK);

    }
    
    

}
