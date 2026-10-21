

class Darts {
    int score(double xOfDart, double yOfDart) {

         double result = Math.pow(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2), 0.5);

         if(result > 10) return 0;
         if(result > 5) return 1;
         if(result > 1) return 5;

         return 10;
    }
}
