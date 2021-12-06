package com.example.edu_institute.Repository;


import com.example.edu_institute.Entity.StudentClassInnerJoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentClassInnerJoinRepository extends JpaRepository<StudentClassInnerJoinEntity,String> {



    @Query(value="SELECT * FROM class_has_student as std INNER JOIN class as class1 ON std.UniqueClassId = class1.UniqueClassId where StudentId=:StudentId and Month=:Month and Year=:Year", nativeQuery = true)
    List<StudentClassInnerJoinEntity> GetAllDataByStudentId(String StudentId, String Month, String Year);
}

