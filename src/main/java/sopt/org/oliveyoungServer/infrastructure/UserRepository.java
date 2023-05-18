package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);
}
