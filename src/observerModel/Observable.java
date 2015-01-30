package observerModel;

import java.util.ArrayList;

public interface Observable {
    ArrayList<Observer> obsvrCollection  = new ArrayList<Observer>();
    void register(Observer obsvr);
    void deRegister(Observer obsvr);
    void notifyObservers();
}
