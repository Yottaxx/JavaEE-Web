/**
 * 
 */
package com.example.eeprojecttrue.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.eeprojecttrue.Entity.Goods;
import com.example.eeprojecttrue.Entity.Collect;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CollectService;
import com.example.eeprojecttrue.Service.CommodityService;
import com.example.eeprojecttrue.Service.CustomerService;

/**
 * @author Yan Wanli
 *
 */
@Controller
public class IssueController {
	 @Autowired
	    private CommodityService commodityService;
	 @Autowired
	    private CustomerService customerService;
	 @Autowired
	    private CollectService collecService;
	  
	 
	 @PostMapping(value = "/commit")
	 public String newCommodity(@RequestParam(name="com_pic",required=false) MultipartFile[] image, Goods goods, HttpSession httpSession, HttpServletRequest request,Model model)
	    {
		
	        if(goods.getDescribe1()!=null) {
         	    Customer customer= (Customer) httpSession.getAttribute("customer");
         	    customer=customerService.findByEmail(customer.getEmail());
         	    goods.setCustomerid(customer.getId());
         	   commodityService.Save(goods);
         	   
       
         	    int count=1,count2=1;
         	   for(MultipartFile img:image)
         	   {
         	   if(count==1)
  			  {
         		  try {
         	            goods.setPicture1(image[0].getBytes());
         	        } catch (IOException e) {
         	            e.printStackTrace();
         	        }
  			  }
         	  if(count==2)
  			  {
         		  try {
         	            goods.setPicture2(image[1].getBytes());
         	        } catch (IOException e) {
         	            e.printStackTrace();
         	        }
  			  }
         	 if(count==3)
 			  {
        		  try {
        	            goods.setPicture3(image[2].getBytes());
        	        } catch (IOException e) {
        	            e.printStackTrace();
        	        }
 			  }
         	 count++;
         	   }
         	    
         	    
//         	    String path=request.getSession().getServletContext().getRealPath("/pictures");
//         	    switch(goods.getGoodsType())
//         	    {
//         	    case "cloth":path=request.getSession().getServletContext().getRealPath("/pictures/cloth/");break;
//         	    case "cosmetics": path=request.getSession().getServletContext().getRealPath("/pictures/cosmetics/");break;
//         	    case "books": path=request.getSession().getServletContext().getRealPath("/pictures/books/");break;
//         	    case "dailyUse":path=request.getSession().getServletContext().getRealPath("/pictures/dailyUse/");break;
//         	    case "sports": path=request.getSession().getServletContext().getRealPath("/pictures/sports/");break;
//         	    case "else": path=request.getSession().getServletContext().getRealPath("/pictures/else/");break;
//         	    default: path=request.getSession().getServletContext().getRealPath("/pictures/");
//         	    
//         	    }
//         	    System.out.println("path:"+path);
//         	    File fileUrl=new File(path);
//         	    
//         	    //如果文件路径不存在就创建文件夹
//         	   if(!fileUrl.exists()){
//                   fileUrl.mkdir();
//                   System.out.println("创建了文件夹");
//               }
//         	   
//         	   System.out.println("上传文件的个数："+image.length);
//         	   for(MultipartFile img:image)
//         	   {
//         		   if(!img.isEmpty())
//         		   {
//         			   //生成唯一标识符给图片命名，避免名字重复覆盖原有图片
//         			   String name=UUID.randomUUID().toString().replaceAll("-", "");
//         			   String url=path+name;
//         			   
//         			   //文件扩展名，就是上传图片的原始名字
////         			   System.out.println("类型："+commodity.getCom_kind());
////         			  switch(commodity.getCom_kind())
////               	    {
////               	    case "cloth":url=path+"/"+name; break;
////               	    case "cosmetics": url="/pictures/cosmetics/"+name;break;
////               	    case "books": url="/pictures/books/"+name;break;
////               	    case "dailyUse":url="/pictures/dailyUse/"+name;break;
////               	    case "sports": url="/pictures/sports/"+name;break;
////               	    case "else": url="/pictures/sports/"+name;break;
////               	    default:url=null;
////               	    
////               	    }
//         			  System.out.println("存入数据库的相对路径："+url);
//         			  if(count2==1)
//         			  {
//         				goods.setPortrait(url);
//         				 System.out.println("存入数据库的第一张图片");
//         			  }
//         			 if(count2==2)
//        			  {
//         				goods.setPortrait2(url);
//        				  System.out.println("存入数据库的第二张图片");
//        			  }
//         			if(count2==3)
//       			  {
//         				goods.setPortrait3(url);
//       				 System.out.println("存入数据库的第三张图片");
//       			  }
//         			   
//         		   }
//         		   count2++;
//         	   }

         	  commodityService.Save(goods);
	        	
	        	
	            return "redirect:/second-hand";

	        }else
	            return "secone-hand-issue";
	    }

	 @GetMapping(value = "Goods/image/get")
	    public ResponseEntity<byte[]> Image_Moment(int id, HttpServletResponse res)
	    {
	        res.setContentType("image/jpeg");
	        res.setCharacterEncoding("UTF-8");
	       
	        byte[] data=commodityService.findById(id).getPicture1();
	        return new ResponseEntity<>(data, HttpStatus.OK);

	    }
	    
	    @GetMapping(value = "/issue")
	    public String MyIssue(Model model,HttpSession httpSession)
	    {
	       Customer customer= (Customer) httpSession.getAttribute("customer");
     	   customer=customerService.findByEmail(customer.getEmail());
	       List<Goods> GoodsList=commodityService.findByCustomerID(customer.getId());
      	   int length=GoodsList.size();
      	   System.out.println("for循环开始");
      	   for(int i=0;i<length;i++)
      	   {
      		   System.out.println(GoodsList.get(i).toString());
      	   }
      	    model.addAttribute("data",GoodsList);
	        return "portfoliotwo";
	    }
	    
	    @GetMapping(value = "/buy")
	    public String MyBuy(Model model,HttpSession httpSession)
	    {
	        return "portfoliotwo";
	    }
	    
	    @GetMapping(value = "/collect")
	    public String MyCollect(Model model,HttpSession httpSession)
	    {

		    Customer customer= (Customer) httpSession.getAttribute("customer");
	     	customer=customerService.findByEmail(customer.getEmail());
	     	List<Collect> collectList=collecService.findByCustomerId(customer.getId());
	     	int len=collectList.size();
	        List<Goods> collectGoodsList=new ArrayList<Goods>();
	     	for(int i=0;i<len;i++)
	     	{
	     		int id=collectList.get(i).getGoodsId();
	     		System.out.println("收藏的商品ID:"+id);
	     		Goods good=commodityService.findById(id);
	     		System.out.println("收藏的商品"+good.toString());
	     		collectGoodsList.add(good);
	     	}
	     	
	     	 model.addAttribute("collectGoodsList",collectGoodsList);
	     	
	     	return "portfoliotwo";
	    }
	    
	    @GetMapping(value = "/issuedelete")
	    public String issueDelete( int id)
	    {
	    	
	    	commodityService.deleteById(id);
	        return "redirect:/issue";
	    }
	    
	    @GetMapping(value = "/collectdelete")
	    public String collectDelete(int id,HttpSession httpSession)
	    {
	    	Customer customer= (Customer) httpSession.getAttribute("customer");
	     	customer=customerService.findByEmail(customer.getEmail());
	     	int customerID=customer.getId();
	     	int goodsId=id;
	     	Collect collect=collecService.findByCustomerIdAndGoodsId(customerID, goodsId);
	     	collecService.deleteById(collect.getId());
	        return "redirect:/collect";
	    }
	    
}
