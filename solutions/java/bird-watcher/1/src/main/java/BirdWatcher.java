
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return new int[]{0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] = this.getToday() + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int count: birdsPerDay){
            if (count == 0) return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {

        int numOfDys = numberOfDays > 7 ? 7 : numberOfDays;
        
        int total = 0;
        for (int i = 0; i < numOfDys; i++){
            total += birdsPerDay[i];
        }

        return total;
    }

    public int getBusyDays() {
        int total = 0;
        for (int i = 0; i < birdsPerDay.length; i++){
            if(birdsPerDay[i] > 4){
                total += 1;
            }
        }

        return total;    
    }
}
