package com.design;

public class SingleTon {
}


// 饿汉式单例，在类加载之初就创建单例对象，加载的时机取决于类的加载机制。
class S1{
    private S1(){};

    public static S1 s1 = new S1();

    public S1 getS1() {
        return s1;
    }
}

// 双重检查版本 double check
class S2{
    private S2(){};

    private static volatile S2 instance;

    public static S2 getInstance() {
        if (instance == null) {
            synchronized (S2.class) {
                if (instance == null) {
                    instance = new S2();
                }
            }
        }
        return instance;
    }
}

// 静态内部类，利用类加载机制，第一次调用一个类的静态变量，会触发类的加载，加载后会触发初始化。
class S3{

    private S3() {};

    private static class S3Inner {
        private static final S3 INSTANCE = new S3();
    }

    public static S3 getInstance() {
        return S3Inner.INSTANCE;
    }
}

// 枚举，完美，唯一的缺点是，在需要继承的场景无能为力
enum S4{
    INSTANCE;

}