public class ProductCalculations implements IProductCalculations {

    @Override
    public double GetVat(double price) {
        return price * 0.15; // 15% VAT
    }

    @Override
    public double GetCommission(double price) {
        return price * 0.05; // 5% Commission
    }

    @Override
    public double GetTotal(double price) {
        // Total = Price + VAT + Commission
        return price + GetVat(price) + GetCommission(price);
    }
}
