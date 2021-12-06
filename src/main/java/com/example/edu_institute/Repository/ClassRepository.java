package com.example.edu_institute.Repository;

import com.example.edu_institute.Dto.StudentHasClassDto;
import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.ClassHasStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {



    @Query("SELECT u FROM ClassEntity u WHERE u.uniqueClassId=:UniqueClassId AND u.teacherId=:TeacherId")
    ClassEntity SearchByClassId( String UniqueClassId , String TeacherId);

    @Query("SELECT u FROM ClassEntity u WHERE u.classId=:ClassId")
    ClassEntity SearchByClassId(@Param("ClassId") String ClassId);

    @Query("SELECT u FROM ClassEntity u WHERE u.uniqueClassId=:UniqueClassId")
    ClassEntity SearchByUniqueClassId(String UniqueClassId);

    @Query(value="SELECT * FROM `class` u WHERE u.`TeacherId` =:TeacherId", nativeQuery = true)
    List<ClassEntity> SearchByTeacherId(@Param("TeacherId") String TeacherId);

    @Query(value="SELECT * FROM `class` u WHERE u.`TeacherId` =:TeacherId AND u.`Year` =:Year AND u.`Month` =:Month AND u.`Day` =:Day", nativeQuery = true)
    List<ClassEntity> SearchTodayClass(@Param("TeacherId") String TeacherId, String Year, String Month, String Day);

    @Query(value="SELECT class.Id, class_has_student.StudentId , class_has_student.ClassId , class_has_student.PaidStatus , class.TeacherId, class.ClassName, class.Institute, class.TimeFrom, class.TimeTo, class.Day, class.Month, class.ZoomLink, class.Access, class.Year FROM class_has_student INNER JOIN class ON class_has_student.ClassId = class.ClassId", nativeQuery = true)
    StudentHasClassDto SearchMyCLass();

//    @Query(value="DELETE FROM class WHERE UniqueClassId =:UniqueClassId", nativeQuery = true)
//    ClassEntity DeleteByUniqueClassId( String UniqueClassId );

}
