package com.lding;

import com.lding.rmi.HelloServiceImpl;
import com.lding.rmi.IHelloService;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AppServer {
    public static void main(String[] args) throws Exception {
        // 1. 注册服务端口（默认为1099）
        LocateRegistry.createRegistry(1099);
        // 2. 提供具体的服务对象
        IHelloService helloService = new HelloServiceImpl();
        // 3. 发布远程服务
        Naming.bind("rmi://127.0.0.1:1099/hello", helloService);
        System.out.println("AppServer 启动成功");
    }
}
