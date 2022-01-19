package com.example.edu_institute.Controller;
import com.example.edu_institute.Dto.ClassDto;
import com.example.edu_institute.Dto.StudentClassInnerJoinDto;
import com.example.edu_institute.Dto.StudentHasClassDto;
import com.example.edu_institute.Repository.StudentClassInnerJoinRepository;
import com.example.edu_institute.Service.ClassService;
import com.example.edu_institute.Service.StudentHasClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Class")
@CrossOrigin(origins = "*")
public class ClassController {

    @Autowired
    StudentClassInnerJoinRepository studentClassInnerJoinRepository;
    @Autowired
    ClassService classService;
    @Autowired
    StudentHasClassService studentHasClassService;

    @PostMapping(value = "/GetClassInfo")
    HttpEntity<Object> ClassInfo(@RequestBody ClassDto classDto) {
        return classService.GetClassInfo(classDto);
    }

    @PostMapping(value = "/GetAllClassInfo")
    HttpEntity<Object> AllClassInfo(@RequestBody ClassDto classDto) {
        return classService.GetAllClassInfo(classDto);
    }

    @PostMapping(value = "/SetClassInfo")
    HttpEntity<Object> CreateClass(@RequestBody ClassDto classDto) {
        return classService.SetClassInfo(classDto);
    }

    @PostMapping(value = "/UpdateClassInfo")
    HttpEntity<Object> UpdateClass(@RequestBody ClassDto classDto) {
        return classService.UpdateClassInfo(classDto);
    }

    @PostMapping(value = "/SetAccess")
    HttpEntity<Object> SetAccess(@RequestBody ClassDto classDto) { return classService.SetAccess(classDto);}

    @PostMapping(value = "/GetTodayClass")
    HttpEntity<Object> GetTodayClass(@RequestBody ClassDto classDto) {
        return classService.GetTodayClass(classDto);
    }

    @PostMapping(value = "/EnrollStudentsForClass")
    HttpEntity<Object> EnrollStudentsForClass(@RequestBody StudentHasClassDto studentHasClassDto) {
        return studentHasClassService.EnrollStudentsForClass(studentHasClassDto);
    }

    @PostMapping(value = "/CustomEnrollStudentsForClass")
    HttpEntity<Object> CustomEnrollStudentsForClass(@RequestBody StudentHasClassDto studentHasClassDto) {
        return studentHasClassService.CustomEnrollStudentsForClass(studentHasClassDto);
    }

    @PostMapping(value = "/GetMyClass")
    HttpEntity<Object> GetMyClass(@RequestBody StudentClassInnerJoinDto studentClassInnerJoinDto) {
        return studentHasClassService.GetMyClass(studentClassInnerJoinDto);
    }

    @PostMapping(value = "/DeleteClass")
    HttpEntity<Object> DeleteClass(@RequestBody StudentHasClassDto classDto) {
        return studentHasClassService.DeleteClass(classDto);
    }

    @PostMapping(value = "/SetPaymentStatus")
    HttpEntity<Object> SetPaymentStatus(@RequestBody StudentHasClassDto studentHasClassDto) {
        return studentHasClassService.SetPaymentStatus(studentHasClassDto);
    }

    @PostMapping(value = "/CheckAccess")
    HttpEntity<Object> CheckAccess(@RequestBody StudentHasClassDto studentHasClassDto) {
        return studentHasClassService.CheckAccess(studentHasClassDto);
    }

}
