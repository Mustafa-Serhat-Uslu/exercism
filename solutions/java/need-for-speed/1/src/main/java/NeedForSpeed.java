class NeedForSpeed {

    private int speed;
    private int batteryDrain;

    private int amountOfDrives = 0;
    // private int batteryCurr = 100;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return amountOfDrives * batteryDrain + batteryDrain > 100;
    }

    public int distanceDriven() {
        return amountOfDrives * speed;
    }

    public void drive() {
        if(batteryDrained()) return;
        
        amountOfDrives += 1;
    }

    public int distanceLeft(){
        int remainingBattery = 100 - amountOfDrives * batteryDrain;

        return (remainingBattery / batteryDrain) * speed;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance;
    
    RaceTrack(int distance) {
       this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return car.distanceLeft() >= distance;
    }
}
