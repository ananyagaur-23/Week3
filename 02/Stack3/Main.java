public class Main {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};  // Example stock prices

        int[] span = StockSpan.calculateSpan(prices);

        System.out.println("Stock Span for each day:");
        StockSpan.printSpan(span);
    }
}
