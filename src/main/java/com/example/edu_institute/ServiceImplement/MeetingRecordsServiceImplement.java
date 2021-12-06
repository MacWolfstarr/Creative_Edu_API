package com.example.edu_institute.ServiceImplement;

import com.example.edu_institute.Dto.MeetingRecordsDto;
import com.example.edu_institute.Dto.StudentHasClassDto;
import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.ClassHasStudentEntity;
import com.example.edu_institute.Entity.MeetingRecordsEntity;
import com.example.edu_institute.Repository.ClassRepository;
import com.example.edu_institute.Repository.MeetingRecordsRepository;
import com.example.edu_institute.Repository.StudentHasClassRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.MeetingRecordsService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRecordsServiceImplement implements MeetingRecordsService {
    @Autowired
    MeetingRecordsRepository meetingRecordsRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    StudentHasClassRepository studentHasClassRepository;

    @Override
    public ResponseEntity<Object> SetMeetingRecordsInfo(MeetingRecordsDto meetingRecordsDto) {

        MeetingRecordsEntity CheckMeetingRecordsExist = meetingRecordsRepository.SearchByRecordLink(meetingRecordsDto.getUniqueClassId(), meetingRecordsDto.getRecordLink());

        if (CheckMeetingRecordsExist == null) {
            MeetingRecordsEntity meetingRecordsEntity = new MeetingRecordsEntity();
            try {
                meetingRecordsEntity.setTeacherId(meetingRecordsDto.getTeacherId());
                meetingRecordsEntity.setUniqueClassId(meetingRecordsDto.getUniqueClassId());
                meetingRecordsEntity.setInstitute(meetingRecordsDto.getInstitute());
                meetingRecordsEntity.setClassId(meetingRecordsDto.getClassId());
                meetingRecordsEntity.setClassName(meetingRecordsDto.getClassName());
                meetingRecordsEntity.setDate(meetingRecordsDto.getDate());
                meetingRecordsEntity.setTimeFrom(meetingRecordsDto.getTimeFrom());
                meetingRecordsEntity.setTimeTo(meetingRecordsDto.getTimeTo());
                meetingRecordsEntity.setRecordLink(meetingRecordsDto.getRecordLink());
                meetingRecordsEntity.setRemarks(meetingRecordsDto.getRemarks());
                meetingRecordsRepository.save(meetingRecordsEntity);

                return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);

            } catch (Exception Ex) {
                return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
            }
        } else {
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<Object> GetMeetingRecordsInfo(StudentHasClassDto studentHasClassDto) {

        ClassEntity classEntity = classRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
        ClassHasStudentEntity classHasStudentEntity = studentHasClassRepository.SelectAccess(studentHasClassDto.getUniqueClassId(), studentHasClassDto.getStudentId());

        List<MeetingRecordsEntity> meetingRecordsEntities = meetingRecordsRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
        try {
            if (classEntity.getAccess().equals("1")) {
                return ResponseHandler.generateResponse(HttpStatus.OK, meetingRecordsEntities, Constants.SUCCESS);
            } else if (classEntity.getAccess().equals("0") && classHasStudentEntity.getPaidStatus().equals("1")) {
                return ResponseHandler.generateResponse(HttpStatus.OK, meetingRecordsEntities, Constants.SUCCESS);
            } else {
                return ResponseHandler.generateResponse(HttpStatus.OK, Constants.FAILURE);
            }
        } catch (Exception Ex) {
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
        }
    }


    @Override
    public ResponseEntity<Object> DeleteMeetingRecordsInfo(MeetingRecordsDto meetingRecordsDto) throws NullPointerException {
        MeetingRecordsEntity meetingRecordsEntity = meetingRecordsRepository.SearchByRecordLink(meetingRecordsDto.getUniqueClassId(), meetingRecordsDto.getRecordLink());
        String Status;
        if (meetingRecordsEntity != null) {
            try {
                meetingRecordsRepository.delete(meetingRecordsEntity);
                Status = "Success";
            } catch (Exception Ex) {
                Ex.printStackTrace();
                Status = "Failure";
            }
        } else {
            Status = "Failure";
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, Status);
    }


    @Override
    public ResponseEntity<Object> UpdateMeetingRecordsInfo(MeetingRecordsDto meetingRecordsDto) {

        MeetingRecordsEntity meetingRecordsEntity = meetingRecordsRepository.SearchByRecordLink(meetingRecordsDto.getUniqueClassId(), meetingRecordsDto.getRecordLink());

        try {
            meetingRecordsEntity.setRecordLink(meetingRecordsDto.getRecordLink());
            meetingRecordsEntity.setRemarks(meetingRecordsDto.getRemarks());
            meetingRecordsRepository.save(meetingRecordsEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);

        } catch (Exception Ex) {
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
        }
    }


}
