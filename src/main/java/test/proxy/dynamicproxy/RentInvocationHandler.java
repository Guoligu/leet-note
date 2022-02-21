package test.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RentInvocationHandler implements InvocationHandler {

    private Object target;
    public RentInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        if ("rent".equals(method.getName())) {
            System.out.println("检查房屋情况");
            method.invoke(target, args);
            System.out.println("租客付款");
        }
        return null;
    }
}
