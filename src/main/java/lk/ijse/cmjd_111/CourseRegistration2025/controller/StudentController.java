package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    //@PostMapping
    //public String saveStudent(){
        //return "Student Registration Successfully";
    //}

    @PostMapping
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
