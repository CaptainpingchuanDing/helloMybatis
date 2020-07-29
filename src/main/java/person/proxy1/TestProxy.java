package person.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) throws Exception {
        Duck duck = new Duck();
        InvocationHandler duckInvocationHandler = new DuckInvocationHandler(duck);
        AnimallSkill duck1 = (AnimallSkill) Proxy.newProxyInstance(duck.getClass().getClassLoader(), duck.getClass().getInterfaces(), duckInvocationHandler);
        duck1.fly("10km");

    }
}
