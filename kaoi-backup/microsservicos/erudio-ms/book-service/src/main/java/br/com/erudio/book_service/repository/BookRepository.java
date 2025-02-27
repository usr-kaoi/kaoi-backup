package br.com.erudio.book_service.repository;

import br.com.erudio.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
