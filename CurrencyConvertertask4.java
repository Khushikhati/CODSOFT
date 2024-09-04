import java.util.Scanner;

public class CurrencyConvertertask4 {

    // Method to convert currency based on base and target currencies
    public static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double rate = getExchangeRate(baseCurrency, targetCurrency);
        return amount * rate;
    }

    // Method to get exchange rates between currencies
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Predefined exchange rates for simplicity (1 unit of base currency to target currency)
        double rate = 1.0;

        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            rate = 0.85; // 1 USD = 0.85 EUR
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("INR")) {
            rate = 74.5; // 1 USD = 74.5 INR
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            rate = 1.18; // 1 EUR = 1.18 USD
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("INR")) {
            rate = 88.0; // 1 EUR = 88.0 INR
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
            rate = 0.013; // 1 INR = 0.013 USD
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("EUR")) {
            rate = 0.011; // 1 INR = 0.011 EUR
        } else if (baseCurrency.equals(targetCurrency)) {
            rate = 1.0; // Same currency, rate is 1
        } else {
            System.out.println("Unsupported currency conversion.");
        }

        return rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for base currency
        System.out.println("Welcome to Currency Converter!");
        System.out.print("Enter the base currency (USD, EUR, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // User input for target currency
        System.out.print("Enter the target currency (USD, EUR, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // User input for the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform currency conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        // Display the result
        System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }
}
