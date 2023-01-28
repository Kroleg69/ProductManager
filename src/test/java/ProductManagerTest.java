import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void testAdd() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter and Philosopher's Stone", 300, "J. K. Rowling");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets", 300, "J. K. Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Leo Tolstoy");
        Smartphone smartphone1 = new Smartphone(4, "iPhone 14",100000,"Apple");
        Smartphone smartphone2 = new Smartphone(5, "Galaxy A52",80000,"Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3,smartphone1,smartphone2};

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void testSearchMany() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter and Philosopher's Stone", 300, "J. K. Rowling");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets", 300, "J. K. Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Leo Tolstoy");
        Smartphone smartphone1 = new Smartphone(4, "iPhone 14",100000,"Apple");
        Smartphone smartphone2 = new Smartphone(5, "Galaxy A52",80000,"Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = {book1,book2};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void testSearchOne() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter and Philosopher's Stone", 300, "J. K. Rowling");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets", 300, "J. K. Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Leo Tolstoy");
        Smartphone smartphone1 = new Smartphone(4, "iPhone 14",100000,"Apple");
        Smartphone smartphone2 = new Smartphone(5, "Galaxy A52",80000,"Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected,actual);
    }
    @Test
    public void testSearchNone() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter and Philosopher's Stone", 300, "J. K. Rowling");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets", 300, "J. K. Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Leo Tolstoy");
        Smartphone smartphone1 = new Smartphone(4, "iPhone 14",100000,"Apple");
        Smartphone smartphone2 = new Smartphone(5, "Galaxy A52",80000,"Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("1984");
        Product[] expected = {};

        assertArrayEquals(expected,actual);
    }
}