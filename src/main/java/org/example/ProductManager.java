package org.example;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (product.getName().contains(search)) {
                return true;
            }
            return book.getAuthor().contains(search);
        }
        if (product instanceof Smartphonev) {
            Smartphonev smartphone = (Smartphonev) product;
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return smartphone.getManufacturer().equalsIgnoreCase(search);
        }
        return false;
    }

}

