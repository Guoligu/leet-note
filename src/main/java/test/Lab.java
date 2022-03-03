package test;

import java.io.IOException;
import java.util.*;

public class Lab {
    public static void main(String[] args) throws Exception {
        final int[] arr = {1, 2};
        arr[1] = 10;
        System.out.println(Arrays.toString(arr));

        System.out.println(Integer.toHexString(256));
        System.out.println(Integer.toBinaryString(256));

        System.out.println("\nreflection");
        Class<?>[] interfaces = LinkedList.class.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        System.out.println("\npolymorphic");
        Animal a = new Animal();
        a.show();
        Dog d = new Dog();
        d.show();
        Animal ad = new Dog();
        ad.show();
        System.out.println(ad.age);

        System.out.println("\nclassloader");
        System.out.println(System.getProperty("sum.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = Animal.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

        System.out.println("\nextends");
        System.out.println(Animal.i);
        System.out.println(Dog.i);


        System.out.println("\nString");
        String str = null;
        System.out.println(str);
        System.out.println("s=" + str);

        System.out.println("\nexception");
        Lab l = new Lab();
        l.testTry();
        System.out.println("in the main");

        System.out.println("\nstackOverFlowError");
        try {
            l.stackLeek();
        } catch (Throwable e) {
            System.out.println("当前栈深度: " + l.deep);
//            e.printStackTrace();
        }

        System.out.println("\nreference");
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2);

        System.out.println("\nCollection");
        List<Integer> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
        Map<Integer, Integer> m = new HashMap<>();
        m.put(10, null);
        m.put(null, 10);
        System.out.println(m);
        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(null);
        System.out.println(queue);

        System.out.println("\nLinkedHashMap");
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(3);
        map.put(1, 10);
        map.put(3, 113);
        map.put(2, 11);
        System.out.println(map.keySet());
        System.out.println(map.getOrDefault(3,-1));
        System.out.println(map.keySet());
        map.put(4, 14);
        System.out.println(map.keySet());
    }

    private String name;
    private int age;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab lab = (Lab) o;
        return age == lab.age && Objects.equals(name, lab.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public void testTry() {
        try {
            System.out.println("int testTry() method.");
            System.out.println("I will return now.");
            System.out.println(1 / 0);
            System.out.println("emmm...");
        } catch (Exception e) {
            System.out.println("exception.");
        } finally {
            System.out.println("I am finally block. omg, it's return.");
        }
    }

    private int deep = 0;
    public void stackLeek() {
        deep++;
        stackLeek();
    }
}


class Animal {
    public static int i;
    int age = 10;
    public void show() {
        System.out.println("animal");
        System.out.println(age);
    }
}

class Dog extends Animal {
    int age = 4;
    public void show() {
        System.out.println("dog");
        System.out.println(age);
    }

}