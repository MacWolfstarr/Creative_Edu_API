package com.example.edu_institute.Repository;

import com.example.edu_institute.Entity.AuthenticationEntity;
import com.example.edu_institute.Entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationEntity, Long> {

    @Query(value = "SELECT * FROM authentication WHERE GUID=:GUID", nativeQuery = true)
    AuthenticationEntity SearchByGUID(String GUID);
}
