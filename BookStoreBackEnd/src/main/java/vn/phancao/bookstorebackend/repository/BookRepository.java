package vn.phancao.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.phancao.bookstorebackend.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
