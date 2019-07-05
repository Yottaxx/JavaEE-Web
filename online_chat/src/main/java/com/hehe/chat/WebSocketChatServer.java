package com.hehe.chat;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket 聊天服务端
 *
 * @see ServerEndpoint WebSocket服务端 需指定端点的访问路径
 * @see Session   WebSocket会话对象 通过它给客户端发送消息
 */

@Component
@ServerEndpoint("/chat/{userId}") //这里是标定了指定的userId
public class WebSocketChatServer {

    /**
     * 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
     */
    private static Map<String, WebSocketChatServer> onlineWebSocketChatServers = new ConcurrentHashMap<>();
    //这里必须要实现在与服务器连接的时候与服务器进行注册 在映射中添加id:username键值对 以后每次消息发送需要给定发送得到标签
    private static Map<String, String> onlineId_User=new ConcurrentHashMap<>();


    private Session session;
    private String userId="";

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 当客户端打开连接：1.添加会话对象 2.更新在线人数
     */



    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId)
    {
        this.userId=userId;
        this.session=session;
        onlineWebSocketChatServers.put(userId,this);
        System.out.println("新建立了会话 user是："+this.userId+" session:"+this.session);
        //-------------------test add start-----------------------------//
        //this.onlineId_User.put(session.getId(),session.getId())
        //-------------------test add  end-----------------------------//
        sendMessageToAll(Message.jsonStr(Message.ENTER, "", "", onlineWebSocketChatServers.size(),"",userId));
        //初始化得到的数据是

    }

    /**
     * 当客户端发送消息：1.获取它的用户名和消息 2.发送消息给所有人
     * <p>
     * PS: 这里约定传递的消息为JSON字符串 方便传递更多参数！
     */
    @OnMessage
    public void onMessage( String jsonStr,Session session)
    {
        //这里显示的是使用websocket来动态的完成了这里使用 all 与id来进行标识到底是发送全部的还是发送部分的
        Message message = JSON.parseObject(jsonStr, Message.class);
        System.out.println("serve get json："+jsonStr);
        if(message.getTouser().equals("all"))
        {
            sendMessageToAll(Message.jsonStr(Message.SPEAK, message.getUsername(), message.getMsg(), onlineWebSocketChatServers.size(),message.getTouser(),message.getUserid()));
        }
        else
        {
            sendMessageToUser(Message.jsonStr(Message.SPEAK, message.getUsername(), message.getMsg(), onlineWebSocketChatServers.size(),message.getTouser(),message.getUserid()),message.getTouser());
            sendMessageToUser(Message.jsonStr(Message.SPEAK, message.getUsername(), message.getMsg(), onlineWebSocketChatServers.size(),message.getTouser(),message.getUserid()),message.getUserid());
        }
    }

    /**
     * 当关闭连接：1.移除会话对象 2.更新在线人数
     */
    @OnClose
    public void onClose(Session session) {
        onlineWebSocketChatServers.remove(this.userId);
        //System.out.println(this.onlineWebSocketChatServers.size() );
        sendMessageToAll(Message.jsonStr(Message.QUIT, "", "",onlineWebSocketChatServers.size(),"",""));
    }

    /**
     * 当通信发生异常：打印错误日志
     */
    @OnError
    public void onError(Session session, Throwable error)
    {
        error.printStackTrace();
    }

    /**
     * 公共方法：发送信息给所有人
     */
    private static void sendMessageToAll(String msg) {
        onlineWebSocketChatServers.forEach((key, value) -> {
            try {
                System.out.println(key+"："+msg+value);
                value.getSession().getBasicRemote().sendText(msg);//这里是发送字段是？
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    //      这里是实现一对一的发送消息
    private static void sendMessageToUser(String MessagejsonStr,String toUser)
    {
        try {
            onlineWebSocketChatServers.get(toUser).getSession().getBasicRemote().sendText(MessagejsonStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
