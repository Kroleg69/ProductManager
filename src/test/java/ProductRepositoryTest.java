import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Test
    public void testRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Harry Potter and Philosopher's Stone", 300, "J. K. Rowling");
        Book book2 = new Book(2, "Harry Potter and the Chamber of Secrets", 300, "J. K. Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Leo Tolstoy");
        Smartphone smartphone1 = new Smartphone(4, "iPhone 14",100000,"Apple");
        Smartphone smartphone2 = new Smartphone(5, "Galaxy A52",80000,"Samsung");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.removeByID(2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1,book3,smartphone1,smartphone2};

        Assertions.assertArrayEquals(expected,actual);
    }
}