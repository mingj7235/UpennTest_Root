package com.joshua.domain.testEntity_ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name = "category")
public class Category {

    @Id
    @Column (name = "no")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany (mappedBy = "category")
    private List<Book> books = new ArrayList<Book>();

    public static void insertAndFind (EntityManager em) {
        Category category = new Category();
        category.setName("IT");
        em.persist(category);

        Book book = new Book();
        book.setTitle("Operation System");
        book.setCategory(category);
        em.persist(book);

        List<Book> bookList = category.getBooks();
        for(Book item : bookList) {
            System.out.println("출력 ? "+item.getTitle());

        }
    }

}




