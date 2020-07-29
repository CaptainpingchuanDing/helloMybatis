package person.proxy1;


public class Duck implements AnimallSkill{
    public void fly(String distance) {
        System.out.println("I can fly " + distance);
    }

    public void say(String name, String song) {
        System.out.println("My name is " + name + ", I can sing " + song);
    }
}
