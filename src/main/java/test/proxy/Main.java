package test.proxy;

import test.proxy.dynamicproxy.RentProxyFactory;
import test.proxy.staticproxy.HostStaticProxy;

public class Main {
    public static void main(String[] args) {
        Rent host = new Host();

        // 静态代理
        HostStaticProxy proxy = new HostStaticProxy(host);
        proxy.rent();

        // 动态代理
        Rent dProxy = (Rent) RentProxyFactory.getProxy(host);
        dProxy.rent();
    }
}
