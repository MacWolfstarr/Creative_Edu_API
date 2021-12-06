package com.example.edu_institute.Repository;



import com.example.edu_institute.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <CourseEntity, Long>  {
    @Query(value="SELECT * FROM `teacher_has_class` u WHERE u.`TeacherId` =:TeacherId AND u.`InstituteId` =:InstituteId", nativeQuery = true)
    List<CourseEntity> SearchCoursesByTeacherId(@Param("TeacherId") String TeacherId, String InstituteId);

}
