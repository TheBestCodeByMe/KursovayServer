package calculation_salaries;

import constants.Constants;

public class CalculationSalaries {
    public static double commSystemPercentage(double profitability) {
        return profitability * Constants.PERCENTAGE / 100;
    }

    public static double commSystemPercentageLeastFixed(double profitability) {
        double salary = commSystemPercentage(profitability);
        return Math.max(salary, Constants.FIXED_SALARY);
    }

    public static double commSystemPercentageFixed(double profitability) {
        return profitability * Constants.PERCENTAGE / 100 + Constants.FIXED_SALARY;
    }

    public static double directPiecework(int quantityOfProducts) {
        return quantityOfProducts * Constants.PIECE_RATE_PROGRAMMING;
    }

    public static double indirectlyPiecework(int quantityOfProducts) {
        return Constants.INDIRECT_PIECE_RATE * quantityOfProducts;
    }

    public static double timeBasedDaily(int days) {
        return days * Constants.DAILY_RATE;
    }

    public static double timeBasedHourly(int hours) {
        return hours * Constants.HOURLY_RATE;
    }
}
