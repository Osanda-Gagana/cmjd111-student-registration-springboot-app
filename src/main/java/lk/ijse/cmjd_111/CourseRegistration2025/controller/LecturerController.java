package lk.ijse.cmjd_111.CourseRegistration2025.controller;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/lecturer")
public class LecturerController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveLecturer(@RequestBody UserDTO lecturerData){
        System.out.println(lecturerData);
        return new ResponseEntity<>(lecturerData, HttpStatus.CREATED);
    }

    @GetMapping(value ="{lecturerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedLecturer(@PathVariable String lecturerID){
        System.out.println("Path Variable is: "+lecturerID);
        var lecturer01 = new UserDTO("STU01", "Kamal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.LECTURER);
        if(lecturerID == null || !lecturerID.equals(lecturer01.getUserId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(lecturer01,HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllLecturers(){
        List<UserDTO> lecturerList = Arrays.asList(
                new UserDTO("STU02", "Nimal",
                        "Fernando", "nimalf@mail.com",
                        "Lake Road", "Colombo 7",
                        "Colombo", "Colombo",
                        "abc123", Role.LECTURER),

                new UserDTO("STU03", "Sithara",
                        "Jayasinghe", "sithara.j@mail.com",
                        "Temple Lane", "Galle Fort",
                        "Galle", "Galle",
                        "pass456", Role.LECTURER),

                new UserDTO("STU04", "Ruwan",
                        "Silva", "ruwan.s@mail.com",
                        "Hill Street", "Kandy Central",
                        "Kandy", "Kandy",
                        "kandy321", Role.LECTURER),

                new UserDTO("STU05", "Dilani",
                        "Hettiarachchi", "dilani.h@mail.com",
                        "Marine Drive", "Negombo North",
                        "Negombo", "Negombo",
                        "negombo789", Role.LECTURER),

                new UserDTO("STU06", "Suresh",
                        "Wickramasinghe", "suresh.w@mail.com",
                        "Green Avenue", "Matara West",
                        "Matara", "Matara",
                        "matara123", Role.LECTURER)
        );

        return new ResponseEntity<>(lecturerList, HttpStatus.OK);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLecturer(@RequestParam String lecturerId,@RequestBody UserDTO lecturerUpdateData) {
        System.out.println("Lecturer id " + lecturerId);
        System.out.println(lecturerUpdateData);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLecturer(@RequestHeader("X-lecturerId") String lecturerId) {
        System.out.println("Lecturer id to be deleted :" + lecturerId);
    }

}







