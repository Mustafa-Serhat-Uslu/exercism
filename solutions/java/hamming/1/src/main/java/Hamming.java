public class Hamming {

    int distance = 0;
    
    public Hamming(String leftStrand, String rightStrand) {


        if(leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("strands must be of equal length");
        } 

        char[] chars1 = leftStrand.toCharArray();
        char[] chars2 = rightStrand.toCharArray();

        for(int i = 0 ; i < chars1.length ; i++){
            if(chars1[i] != chars2[i]){
                distance++;
            }
        }
        
    }

    public int getHammingDistance() {
        return distance;
    }
}
