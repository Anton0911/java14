package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManegerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Война и мир", 300, "Лев Толстой");
    Product book1 = new Book(2, "Евгений Онегин", 450, "Пушкин");
    Product smartphone = new Smartphonev(3, "One Plus 6", 25_000, "BBK Electronics");
    Product book3 = new Book(4, "Мертвые души", 0, "Гоголь");


    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
        manager.add(book3);

    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Евгений Онегин");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneName() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("One Plus 6");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotFindPhoneManufacturer() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Simens");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("рей бредбери");
        assertArrayEquals(expected, actual);
    }

}

