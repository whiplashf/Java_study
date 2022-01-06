package com.hspedu.qqserver.service;

/*
    Author: Whiplash
    Date: 2022/1/4 17:05
    储存未读消息
*/

import com.hspedu.qqcommon.Message;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class StoreUnreadMessages {
    public static ConcurrentHashMap<String, ArrayList<Message>> massageBuf = new ConcurrentHashMap<>();

    public static void add(String userId, Message message){
        if(massageBuf.get(userId)==null){
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(message);
            massageBuf.put(userId, messages);
        } else {
            massageBuf.get(userId).add(message);
        }
    }

    public void remove(String userId){
        massageBuf.remove(userId);
    }
}
