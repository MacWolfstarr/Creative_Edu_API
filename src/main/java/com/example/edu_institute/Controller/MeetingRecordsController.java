package com.example.edu_institute.Controller;

import com.example.edu_institute.Dto.MeetingRecordsDto;
import com.example.edu_institute.Dto.StudentHasClassDto;
import com.example.edu_institute.Service.MeetingRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Meetings")
@CrossOrigin(origins = "*")
public class MeetingRecordsController {

    @Autowired
    MeetingRecordsService meetingRecordsService;


    @PostMapping(value = "/SaveMeetingRecords")
    HttpEntity<Object> SaveMeetingRecords(@RequestBody MeetingRecordsDto meetingRecordsDto) {
        return meetingRecordsService.SetMeetingRecordsInfo(meetingRecordsDto);
    }

    @PostMapping(value = "/GetMeetingRecords")
    HttpEntity<Object> GetMeetingRecords(@RequestBody StudentHasClassDto studentHasClassDto) {
        return meetingRecordsService.GetMeetingRecordsInfo(studentHasClassDto);
    }

    @PostMapping(value = "/DeleteMeetingRecords")
    HttpEntity<Object> DeleteMeetingRecords(@RequestBody MeetingRecordsDto meetingRecordsDto) {
        return meetingRecordsService.DeleteMeetingRecordsInfo(meetingRecordsDto);
    }

    @PostMapping(value = "/UpdateMeetingRecords")
    HttpEntity<Object> UpdateMeetingRecords(@RequestBody MeetingRecordsDto meetingRecordsDto) {
        return meetingRecordsService.UpdateMeetingRecordsInfo(meetingRecordsDto);
    }

}
