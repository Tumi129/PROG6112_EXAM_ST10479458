import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] productNames = {
            "Cozy Nights Monarch Mattress", 
            "Restonic Barbados Mattress", 
            "Sealy Phuket Mattress"
        };
        int[][] salesData = new int[3][3]; // 3 products, 3 months

        // 1. TO GET USER INPUT
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("Enter number of sales for month " + (col + 1) + " for " + productNames[row] + ": ");
                salesData[row][col] = scanner.nextInt();
            }
        }

        // 2. CALCULATE LOGIC
        Product logic = new Product();
        int total = logic.GetTotalProductsSold(salesData);
        double average = logic.GetAverageProductSold(salesData);
        String popular = logic.GetMostPopularProduct(productNames, salesData);

        // 3. PRINT REPORT
        System.out.println("\nPRODUCT REPORT SALES - 2026");
        System.out.println("******************************");
        PrintProduct printer = new PrintProduct();
        printer.PrintTotal(total);
        printer.PrintAverage(average);
        printer.PrintMostPopular(popular);
        
        scanner.close();
    }
}
