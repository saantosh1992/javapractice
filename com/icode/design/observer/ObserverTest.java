package com.icode.design.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);
    void unRegisterObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(int run, int over);

}

class CricketData implements Subject {

    private int run;
    private int over;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(run, over));
    }

    public void updateData(int run, int over) {
        this.run = run;
        this.over = over;
        notifyObservers();
    }
}
class StarSport implements Observer {

    @Override
    public void update(int run, int over) {
        System.out.println("Start Sport: cricket score run:"+run+"in Over:"+over);
    }
}

class CrickBuzz implements Observer {
    @Override
    public void update(int run, int over) {
        System.out.println("CrickBuzz cricket score run:"+run+"in Over:"+over);
    }
}

public class ObserverTest {

    public static void main(String[] args) {

        CricketData cricketData = new CricketData();

        StarSport starSport = new StarSport();
        CrickBuzz crickBuzz = new CrickBuzz();
        cricketData.registerObserver(starSport);
        cricketData.registerObserver(crickBuzz);
        cricketData.updateData(1, 1);
        cricketData.unRegisterObserver(crickBuzz);
        cricketData.updateData(10,2);

    }
}
