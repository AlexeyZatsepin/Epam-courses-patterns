package kpi.study.epam.state;

/**
 * Patterns
 * Created 5/25/16, with IntelliJ IDEA
 *
 * @author Alex
 */
class Runner {
    public static void main(String[] args) {
        Man man = new Man();
        System.out.println(man.toString());
        man.relax();
        man.setLocation(Man.Locations.BEACH);
        System.out.println(man.toString());
        man.relax();
        man.setLocation(Man.Locations.ANIMAL_FORREST);
        System.out.println(man.toString());
        man.relax();
        man.setLocation(Man.Locations.MUSHROOM_FORREST);
        System.out.println(man.toString());
        man.relax();
        man.setLocation(Man.Locations.HOME);
        System.out.println(man.toString());
        man.relax();
    }
}

//state
interface Hobby{
    default void relax(){
        System.out.println("relax ..");
    }
}

class Man{//context
    private Hobby state;
    private Locations location;

    public Man() {
        this.state = new CommonDay();
        this.location=Locations.HOME;
    }

    public void setState(Hobby state) {
        this.state = state;
    }

    public void setLocation(Locations location) {
        this.location = location;
        switch (location){
            case MUSHROOM_FORREST:
                setState(new Mushroomer());
                break;
            case BEACH:
                setState(new Fisherman());
                break;
            case ANIMAL_FORREST:
                setState(new Hunter());
                break;
            case HOME:
                setState(new CommonDay());
                break;
        }

    }
    void relax(){
        state.relax();
    }

    enum Locations{
        MUSHROOM_FORREST,BEACH,ANIMAL_FORREST,HOME
    }

    @Override
    public String toString() {
        return "Man status: " + state.getClass().getSimpleName() +
                ", and he on/at " + location +
                '}';
    }
}

class Hunter implements Hobby{
    @Override
    public void relax() {
        System.out.println("hunting..");
    }
}
class Mushroomer implements Hobby{
    @Override
    public void relax() {
        System.out.println("get mushrooms..");
    }
}
class Fisherman implements Hobby{
    @Override
    public void relax() {
        System.out.println("fishing..");
    }
}
class CommonDay implements Hobby{
}
