package kpi.study.epam.state;

/**
 * Patterns
 * Created 5/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
class Radio{ // Context
    private Station station;
    void setStation(Station station){
        this.station = station;
    }
    void nextStation(){
        if (station instanceof Radio7){
            setStation(new RadioFM());
        }else if(station instanceof RadioFM){
            setStation(new VestiFM());
        }else if(station instanceof VestiFM){
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Radio 7");
    }
}
class RadioFM implements Station{
    @Override
    public void play() {
        System.out.println("Radio FM");
    }
}
class VestiFM implements Station{
    @Override
    public void play() {
        System.out.println("vesti FM");
    }
}
interface Station{
    void play();
}

class Example1Runner{
    public static void main(String[] args) {
        Station fm = new RadioFM();
        Radio radio = new Radio();
        radio.setStation(fm);
        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}


