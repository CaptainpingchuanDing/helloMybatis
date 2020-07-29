package person.java8;

public class Java8Tester {

    /**
     * 在 java 8 之前，接口与其实现类之间的 耦合度 太高了（tightly coupled），当需要为一个接口添加方法时，所有的实现类都必须随之修改。
     * 默认方法解决了这个问题，它可以为接口添加新的方法，而不会破坏已有的接口的实现。
     * @param args
     */
    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}
