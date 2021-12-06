package com.example.edu_institute.Repository;

import com.example.edu_institute.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository <TeacherEntity, Long>{

    @Query("SELECT u FROM TeacherEntity u WHERE u.teacherId=:TeacherId AND u.teacherId=:TeacherId")
    TeacherEntity SearchByTeacherId(@Param("TeacherId") String TeacherId);

    @Query("SELECT u FROM TeacherEntity u WHERE u.teacherId=:TeacherId AND u.password=:Password")
    TeacherEntity LoginTeacher(String TeacherId, String Password);

}
