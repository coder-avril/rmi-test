package com.lding;

import com.lding.rmi.IHelloService;
import java.rmi.Naming;

public class AppClient {
    public static void main(String[] args) throws Exception {
        // 通过lookup方法查找到对应的服务提供者
        IHelloService helloService = (IHelloService) Naming.lookup("rmi://127.0.0.1:1099/hello");
        String result = helloService.sayHello("avril");
        System.out.println("result = " + result);
    }
}
