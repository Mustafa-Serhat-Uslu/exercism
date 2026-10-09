class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

            int total = 0;
            char[] arr = String.valueOf(numberToCheck).toCharArray();
            
            for(char digit: arr){
                total += (int) Math.pow(Character.getNumericValue(digit), arr.length);
            }

            return total == numberToCheck;
    }
}
