package com.example.edu_institute.Repository;

import com.example.edu_institute.Entity.ForGetSlipName;
import com.example.edu_institute.Entity.ForGetUpdateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


    @Repository
    public interface SlipUpdate extends JpaRepository<ForGetUpdateData, Long> {
        @Query(value="select * FROM class_has_student WHERE StudentId=?1 and UniqueClassId=?2", nativeQuery = true)
        ForGetUpdateData getid( String StudentID, String UniqueClassID);

//        @Query(value="UPDATE class_has_student SET slip_name =?1 WHERE StudentId=?2 and UniqueClassId=?3", nativeQuery = true)
//        void getid(String name, String StudentID, String UniqueClassID);

    }


