public class QuickSort {
    public static void sortProductPrices(int[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            sortProductPrices(prices, low, pi - 1);
            sortProductPrices(prices, pi + 1, high);
        }
    }

    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] productPrices = {799, 299, 1499, 499, 999, 1200};
        sortProductPrices(productPrices, 0, productPrices.length - 1);

        System.out.print("Sorted Product Prices: ");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
    }
}
