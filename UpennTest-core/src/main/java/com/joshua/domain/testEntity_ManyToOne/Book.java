package com.joshua.domain.testEntity_ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name = "book")
public class Book {

    @Id
    @Column (name = "no")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column (name = "title", nullable = false, length = 200)
    private String title;

    @ManyToOne
    @JoinColumn (name = "category_no")
    private Category category;

    public static void insertAndFind (EntityManager em) {
        Category category = new Category();
        category.setName("IT");
        em.persist(category);

        Book book = new Book();
        book.setTitle("Operation System");
        book.setCategory(category);
        book.getCategory().getBooks().add(book);
        em.persist(book);

        List<Book> bookList = category.getBooks();
        for(Book item : bookList) {
            System.out.println("출력 ? "+item.getTitle());

        }
    }

}
