import java.io.FileNotFoundException;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {

        Product[] products = new Product[0];
        try {
            products = ProductsCalculator.addProductsToArray("produkty.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Lista produktów: \n" + Arrays.toString(products));
        System.out.println("Łączna cena wszystkich produktów: " + ProductsCalculator.sum(products));
        System.out.println("Najdroższy produkt: " + ProductsCalculator.findMostExpensive(products));

    }

}