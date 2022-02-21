package test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class Lab {
    public static void main(String[] args) throws Exception {
        final int[] arr = {1, 2};
        arr[1] = 10;
        System.out.println(Arrays.toString(arr));

        System.out.println(Integer.toHexString(256));
        System.out.println(Integer.toBinaryString(256));

        System.out.println("\nreflection");

        System.out.println("\npoly");
        Animal a = new Animal();
        a.show();
        Dog d = new Dog();
        d.show();
        Animal ad = new Dog();
        ad.show();
        System.out.println(ad.age);


        System.out.println(System.getProperty("sum.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = Animal.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

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
}


class Animal {
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