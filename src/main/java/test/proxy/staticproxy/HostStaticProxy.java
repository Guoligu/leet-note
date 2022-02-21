package test.proxy.staticproxy;

import test.proxy.Rent;

public class HostStaticProxy implements Rent {

    private Rent rent;

    public HostStaticProxy(Rent rent) {
        this.rent = rent;
    }

    @Override
    public void rent() {
        System.out.println("检查房屋情况");
        rent.rent();
        System.out.println("租客付款");
    }
}
