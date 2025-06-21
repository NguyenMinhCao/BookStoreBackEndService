package vn.phancao.bookstorebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.phancao.bookstorebackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
