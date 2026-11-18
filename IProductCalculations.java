public interface IProductCalculations {
    double GetVat(double price);
    double GetCommission(double price);
    double GetTotal(double price);
}
