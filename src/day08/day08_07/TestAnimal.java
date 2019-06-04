package day08.day08_07;

/**
 * Created by cdx on 2019/1/16.
 * desc:
 */
public class TestAnimal {
   // private static final String TAG = "TestAnimal";


    public static void main(String[] args) {
        TestAnimal testAnimal=new TestAnimal();
        testAnimal.func(new Dog());
    }
    public void func(Animal a){
        a.eat();
        a.jump();
        if(a instanceof Dog)
            ((Dog) a).wang();
        if(a instanceof Cat)
            ((Cat) a).mimi();
    }
}
class Animal{

    public void eat(){
        System.out.println("吃");
    }
    public void jump(){
        System.out.println("跳");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃骨头");
    }
    public void jump(){
        System.out.println("狗急跳墙");
    }
    public void wang(){
        System.out.println("汪汪");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void jump(){
        System.out.println("猫急跳墙");
    }
    public void mimi(){
        System.out.println("喵喵");
    }
}