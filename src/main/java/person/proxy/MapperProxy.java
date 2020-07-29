package person.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy<T> implements InvocationHandler {

    private String interfaceName;

    public MapperProxy(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println(proxy.hashCode());
        System.out.println("person.proxy succeed!");
        System.out.println("method:" + method.getName());

        // 根据不同的方法名称，执行具体的逻辑
        // （mybatis也是这么做的，根据不同的方法，去找不同的 MappedStatement(一个增删改查)
        if(method.getName().equals("fly")){
            System.out.println("fly:" + args[0]);
        }else{
            System.out.println("say:   name:" + args[0]+",song:"+args[1]);
        }


        return null;
    }

    public T newInstance(MapperProxy<T> duckProxy) throws Exception {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader()
                , new Class[]{Class.forName(interfaceName, true, getClass().getClassLoader())}
                , duckProxy);
    }

}
