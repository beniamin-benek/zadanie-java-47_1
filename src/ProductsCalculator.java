import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ProductsCalculator {

    static Product[] addProductsToArray (String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner scanner1 = new Scanner(file);
        int lines = 0;
        while (scanner1.hasNextLine()) {
            lines++;
            scanner1.nextLine(); //tyle ile linii w pliku, taki rozmiar tablicy produktow, zakladajac ze zawartosc jest poprawna
        }
        scanner1.close();

        Product[] products = new Product[lines];
        for (int i = 0; i < products.length; i++)
            products[i] = new Product();

        Scanner scanner2 = new Scanner(file);
        String[] productFields; //tablica, w której przechowywane będą poszczególne pola danego produktu
        for (int i = 0; i < products.length; i++) {
            productFields = scanner2.nextLine().split(";");
            products[i].setName(productFields[0]);
            products[i].setProducer(productFields[1]);
            products[i].setPrice(Double.parseDouble(productFields[2]));
        }

        return products;
    }

    static double sum(Product[] products) {
        double sum = 0;
        for (int i = 0; i < products.length; i++)
            sum = sum + products[i].getPrice();
        return sum;
    }

    static Product findMostExpensive(Product[] products) {

        Product mostExpensive = new Product();
        double maxx = products[0].getPrice();

        for (int i = 0; i < products.length; i++) {
            if (maxx <= products[i].getPrice()) {
                maxx = products[i].getPrice();
                mostExpensive = products[i];
            }
        }
        return mostExpensive;
    }

}