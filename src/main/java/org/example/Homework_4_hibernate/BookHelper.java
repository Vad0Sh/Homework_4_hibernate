package org.example.Homework_4_hibernate;

import org.example.Homework_4_hibernate.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BookHelper {
    EntityManagerFactory emf;
    EntityManager em;

    public BookHelper(){
        emf = Persistence.createEntityManagerFactory("emf1");
        em = emf.createEntityManager();
    }
    public Book getById(int id) {
        em.getTransaction().begin();
        Book book = em.find(Book.class,id);
        em.getTransaction().commit();
        emf.close();
        return book;
    }
    public void add(Book b){
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        emf.close();
    }
    public void remove(Book b){
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
        emf.close();
    }
    public List<Book> getAll(){
        em.getTransaction().begin();
        Query query = em.createQuery("select books from Book books");
        List<Book> books = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return books;

    }

}
