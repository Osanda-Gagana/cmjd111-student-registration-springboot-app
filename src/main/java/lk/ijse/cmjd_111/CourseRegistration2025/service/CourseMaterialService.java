package lk.ijse.cmjd_111.CourseRegistration2025.service;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseMaterialDTO;

import java.util.List;

public interface CourseMaterialService {
    CourseMaterialDTO saveStudent(CourseMaterialDTO student);
    void deleteStudent(String studentId);
    void updateStudent(String studentId,CourseMaterialDTO student);
    CourseMaterialDTO getSelectedStudent(String studentId) throws Exception;
    List<CourseMaterialDTO> getAllStudents();
}