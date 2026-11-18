public class Product implements IProduct {
    
    @Override
    public int GetTotalProductsSold(int[][] salesData) {
        int total = 0;
        for (int[] row : salesData) {
            for (int sale : row) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold(int[][] salesData) {
        int total = GetTotalProductsSold(salesData);
        // 3 products * 3 months = 9
        int totalMonths = salesData.length * salesData[0].length; 
        return (double) total / totalMonths;
    }

    @Override
    public String GetMostPopularProduct(String[] productNames, int[][] salesData) {
        int maxIndex = 0;
        int highestTotal = 0;
        
        for (int i = 0; i < salesData.length; i++) {
            int rowTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                rowTotal += salesData[i][j];
            }
            if (rowTotal > highestTotal) {
                highestTotal = rowTotal;
                maxIndex = i;
            }
        }
        return productNames[maxIndex] + " (" + highestTotal + ")";
    }
}
