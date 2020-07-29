package person.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DuckInvocationHandler implements InvocationHandler {

    private Duck duck;

    public DuckInvocationHandler(Duck duck) {
        this.duck = duck;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("person.proxy succeed!");
        System.out.println("method:" + method.getName());
        try {
            if (method.getName().equals("fly")) {
                System.out.println("after dinner");
            } else {
                System.out.println("I have another skill");
            }
            method.invoke(duck, args);

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }

}
