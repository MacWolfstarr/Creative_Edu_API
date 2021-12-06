package com.example.edu_institute.Repository;

import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.MeetingRecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRecordsRepository extends JpaRepository <MeetingRecordsEntity, Long>
{
    @Query(value="SELECT * FROM `meeting_records` u WHERE u.`UniqueClassId` =:UniqueClassId", nativeQuery = true)
    List<MeetingRecordsEntity> SearchByUniqueClassId(String UniqueClassId);

    @Query(value="SELECT * FROM `meeting_records` u WHERE u.`UniqueClassId` =:UniqueClassId AND RecordLink =:RecordLink", nativeQuery = true)
    MeetingRecordsEntity SearchByRecordLink(String UniqueClassId, String RecordLink);
}
