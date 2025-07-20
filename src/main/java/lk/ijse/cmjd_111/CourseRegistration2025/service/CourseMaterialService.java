package lk.ijse.cmjd_111.CourseRegistration2025.service;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseMaterialDTO;

import java.util.List;

public interface CourseMaterialService {

    CourseMaterialDTO saveCourseMaterial(CourseMaterialDTO material);

    void deleteCourseMaterial(String materialId);

    void updateCourseMaterial(String materialId, CourseMaterialDTO material);

    CourseMaterialDTO getSelectedCourseMaterial(String materialId) throws Exception;

    List<CourseMaterialDTO> getAllCourseMaterials();

}
