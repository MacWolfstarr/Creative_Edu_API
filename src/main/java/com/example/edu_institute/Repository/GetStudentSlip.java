package com.example.edu_institute.Repository;


import com.example.edu_institute.Entity.ForGetSlipName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GetStudentSlip extends JpaRepository<ForGetSlipName, Long> {
    @Query(value="SELECT * FROM `class_has_student` u WHERE u.`slip_name` =?1 ", nativeQuery = true)
    ForGetSlipName getpic(String slipname);

}
