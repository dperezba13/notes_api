package com.dperezba.notes_api.repository;

import com.dperezba.notes_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserEmailAndStatus(String email, short status);
    boolean existsByNickNameAndStatus(String nickName, short status);

    boolean existsByUserEmailAndStatusAndUserIdIsNot(String email, short status, Integer userId);
    boolean existsByNickNameAndStatusAndUserIdIsNot(String nickName, short status, Integer userId);

}
