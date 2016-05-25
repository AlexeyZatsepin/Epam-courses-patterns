package kpi.study.epam.state;

/**
 * Patterns
 * Created 5/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
class Example2Runner {

    public static void main(String[] args) {
        Human man =new Human();
        man.setState(new Work());
        for (int i = 0; i < 20; i++) {
            man.doSomething();
        }
    }
}


class Human{
    private Activity state;

    public void setState(Activity state){
        this.state=state;
    }
    public void doSomething(){
        state.doSomething(this);
    }
}


interface Activity{
    void doSomething(Human human);
}

class Work implements Activity{
    @Override
    public void doSomething(Human human) {
        System.out.println("works ..");
        human.setState(new WeekEnd());
    }
}
class WeekEnd implements Activity{
    private int count = 0;
    @Override
    public void doSomething(Human human) {
        if (count < 3 ){
            System.out.println("Zzz");
            count++;
        }else {
            human.setState(new Work());
        }
    }
}