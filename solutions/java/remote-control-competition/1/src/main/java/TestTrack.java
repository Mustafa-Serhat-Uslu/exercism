import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    
public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        // Create a copy so we don't mutate the original list, then sort it
        List<ProductionRemoteControlCar> rankedCars = new ArrayList<>(cars);
        Collections.sort(rankedCars);
        return rankedCars;
    }
}