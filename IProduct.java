public interface IProduct {
    // Pass the 2D array to calculate totals and averages
    int GetTotalProductsSold(int[][] salesData);
    double GetAverageProductSold(int[][] salesData);
    
    // Pass BOTH the names array and the 2D array to find the popular product
    String GetMostPopularProduct(String[] productNames, int[][] salesData);
}
