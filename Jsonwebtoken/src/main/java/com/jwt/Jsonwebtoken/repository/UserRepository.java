package com.jwt.Jsonwebtoken.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jwt.Jsonwebtoken.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password); 

}
