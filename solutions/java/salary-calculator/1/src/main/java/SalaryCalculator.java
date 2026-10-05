public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        boolean isPenalized = daysSkipped > 4;

        return isPenalized ? 0.85 : 1;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold > 19 ? 13 : 10; 
    }

    public double bonusForProductsSold(int productsSold) {
        return this.bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        return Math.min(2000, 1000.00 * this.salaryMultiplier(daysSkipped) + this.bonusForProductsSold(productsSold));
    } 
}
