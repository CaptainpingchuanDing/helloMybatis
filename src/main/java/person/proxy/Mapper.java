package person.proxy;

public interface Mapper {

    void fly(String distance);

    void say(String name, String song);

    default void test(){
        System.out.println("默认方法");
    }
}
