package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book = new Book(1, "Война и мир", 300, "Лев Толстой");
    Product smartphone = new Smartphonev (2, "One Plus 6", 25_000, "BBK Electronics");
    Product book1 = new Book(3, "Евгений Онегин", 450, "Пушкин");
    @BeforeEach
    public void SetUp() {
        repository.save(book1);
        repository.save(book);
        repository.save(smartphone);
}

@Test
    public void shouldSave(){
    Product[] expected = {book1,book,smartphone};
    Product[] actual = repository.getProducts();
    assertArrayEquals(expected, actual);
}
@Test
    public void shouldRemoveById(){
        repository.removeById(2);
    Product[] expected = {book1,book};
    Product[] actual = repository.getProducts();
    assertArrayEquals(expected, actual);
}
}
