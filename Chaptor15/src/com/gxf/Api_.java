package com.gxf;

/*
    Author: Whiplash
    Date: 2021/12/28 15:47
*/

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Api_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机 InetAddress 对象 getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
//根据指定主机名/域名获取 ip 地址对象 getByName
        InetAddress host2 = InetAddress.getByName("DESKTOP-836PNT1");
        System.out.println(host2);
        InetAddress host3 = InetAddress.getByName("www.hsp.com");
        System.out.println(host3);
//获取 InetAddress 对象的主机名 getHostName
        String host3Name = host3.getHostName();
        System.out.println(host3Name);
//获取 InetAddress 对象的地址 getHostAddress
        String host3Address = host3.getHostAddress();
        System.out.println(host3Address);
    }
}
