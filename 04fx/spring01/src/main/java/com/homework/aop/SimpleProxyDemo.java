package com.homework.aop;

/**
 * @author ohYoung
 * @date 2021/2/21 0:46
 */
public class SimpleProxyDemo {
    public static void main(String[] args) throws SecurityException {
        ProxyClassImpl c = new ProxyClassImpl();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(c);
        IProxyClass proxyClass = (IProxyClass)proxyHandler.newProxyInstance();
        System.out.println(proxyClass.getClass().getName());
        System.out.println(proxyClass.doSomething2(5));
    }

}
