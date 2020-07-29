package person.proxy;

public class TestProxy {

    public static void main(String[] args) throws Exception {
        MapperProxy<Mapper> duckProxy = new MapperProxy<>("person.proxy.Mapper");
        Mapper mapper = duckProxy.newInstance(duckProxy);
//        mapper.fly("10km");
        mapper.say("duck", "e e e ");

    }
}
