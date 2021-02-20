package com.homework.aop;

/**
 * @author ohYoung
 * @date 2021/2/21 0:46
 */

public class ProxyClassImpl implements IProxyClass {
    @Override
    public int doSomething(int num) {
        System.out.println("方法执行中.....");
        return num;
    }

    @Override
    public int doSomething2(int num) {
        System.out.println("方法2执行中.....");
        return num;
    }
}
