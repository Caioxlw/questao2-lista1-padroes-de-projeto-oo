import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    private List<Integer> digits = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addDigit(int newDigit) {
        digits.add(newDigit);
        notifyObservers(newDigit);
    }

    private void notifyObservers(int newDigit) {
        for (Observer observer : observers) {
            observer.update(newDigit);
        }
    }

    public List<Integer> getDigits() {
        return digits;
    }
}
