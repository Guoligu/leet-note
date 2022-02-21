package test.proxy;

public class Host implements Rent {


    @Override
    public void rent() {
        System.out.println("Host在出租房子");
    }
}
