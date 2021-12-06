package com.example.edu_institute.Repository;

import com.example.edu_institute.Entity.ClassHasStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentHasClassRepository extends JpaRepository <ClassHasStudentEntity, Long> {

    @Query(value="SELECT * FROM class_has_student WHERE StudentId =:StudentId", nativeQuery = true)
    List< ClassHasStudentEntity> SearchMyCLass(String StudentId);

    @Query(value="SELECT * FROM class_has_student WHERE StudentId =:StudentId AND UniqueClassId =:UniqueClassId", nativeQuery = true)
    ClassHasStudentEntity CheckStudentExist(String StudentId, String UniqueClassId);

    @Query(value="SELECT * FROM class_has_student as std WHERE UniqueClassId =:UniqueClassId", nativeQuery = true)
    List<ClassHasStudentEntity> SearchByUniqueClassId(String UniqueClassId);

    @Query(value="SELECT COUNT(*) as count FROM class_has_student WHERE UniqueClassId =:UniqueClassId AND PaidStatus=:PaidStatus", nativeQuery = true)
    ClassHasStudentEntity GetCountOfPaidStatus(String UniqueClassId, String PaidStatus);

    @Query(value="SELECT *  FROM class_has_student WHERE UniqueClassId =:UniqueClassId AND StudentId=:StudentId", nativeQuery = true)
    ClassHasStudentEntity SelectAccess(String UniqueClassId, String StudentId);

}
