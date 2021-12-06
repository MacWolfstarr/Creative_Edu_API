package com.example.edu_institute.Repository;

import com.example.edu_institute.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <StudentEntity, Long> {

    @Query("SELECT u FROM StudentEntity u WHERE u.studentId=:StudentId")
    StudentEntity SearchByStudentId(@Param("StudentId") String StudentId);

    @Query("SELECT u FROM StudentEntity u WHERE u.studentId=:StudentId AND u.password=:Password")
    StudentEntity LoginStudent(String StudentId, String Password);

    @Query("SELECT u FROM StudentEntity u WHERE u.classId=:ClassId")
    List<StudentEntity> SearchStudentByClassId( String ClassId);

    @Query("SELECT u FROM StudentEntity u WHERE  u.firstName=:FirstName AND u.lastName=:LastName AND u.contact=:Contact")
    StudentEntity CheckStudentExist(String FirstName, String LastName, String Contact);

}