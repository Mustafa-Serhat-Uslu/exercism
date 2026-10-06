public class JedliksToyCar {
 
    private int distanceDriven;
    public int battery = 100;
    
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distanceDriven);
    }

    public String batteryDisplay() {

        if(battery == 0) return "Battery empty";
        
        return String.format("Battery at %d", battery) + "%";
    }

    public void drive() {
        if(battery < 1 ) return;
        
        distanceDriven += 20;
        battery -= 1;
        this.distanceDisplay();
    }
}
