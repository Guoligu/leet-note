package test.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class RentProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new RentInvocationHandler(target));
    }
}
