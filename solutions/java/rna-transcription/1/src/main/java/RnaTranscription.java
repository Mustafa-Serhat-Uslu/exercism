class RnaTranscription {

    String transcribe(String dnaStrand) {
        StringBuilder builder = new StringBuilder();

        for(char c : dnaStrand.toCharArray()){
            switch (c){
                        case 'G' -> builder.append('C');
            case 'C' -> builder.append('G');
        case 'T' -> builder.append('A');
        case 'A' -> builder.append('U');
            }
        }

        return builder.toString();
    }

}
