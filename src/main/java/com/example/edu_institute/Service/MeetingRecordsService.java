package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.MeetingRecordsDto;
import com.example.edu_institute.Dto.StudentHasClassDto;
import org.springframework.http.ResponseEntity;

public interface MeetingRecordsService {

    ResponseEntity<Object> SetMeetingRecordsInfo(MeetingRecordsDto meetingRecordsDto);
    ResponseEntity<Object> GetMeetingRecordsInfo(StudentHasClassDto studentHasClassDto);
    ResponseEntity<Object> DeleteMeetingRecordsInfo(MeetingRecordsDto meetingRecordsDto);
    ResponseEntity<Object> UpdateMeetingRecordsInfo(MeetingRecordsDto meetingRecordsDto);
}
