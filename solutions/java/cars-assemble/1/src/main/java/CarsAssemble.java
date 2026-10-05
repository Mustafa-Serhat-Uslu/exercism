public class CarsAssemble {

    public static double getSuccessRate(int speed){
        if(speed < 5){
            return 1;
        }
        else if(speed > 4 && speed < 9){
            return 0.9;
        }
        else if (speed == 9 ){
            return 0.8;
        }
        else if( speed == 10) {
            return 0.77;
        }

        return 1;
    }

    
    public double productionRatePerHour(int speed) {
       return (speed * 221) * getSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) this.productionRatePerHour(speed) / 60;
    }
}
