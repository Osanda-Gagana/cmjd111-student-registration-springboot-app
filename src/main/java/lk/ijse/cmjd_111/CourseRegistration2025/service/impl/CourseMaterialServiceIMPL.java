package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseMaterialDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.CourseMaterialService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseMaterialServiceIMPL implements CourseMaterialService {

    @Override
    public CourseMaterialDTO saveCourseMaterial(CourseMaterialDTO material) {

        return material;
    }

    @Override
    public void deleteCourseMaterial(String materialId) {

    }

    @Override
    public void updateCourseMaterial(String materialId, CourseMaterialDTO material) {

    }

    @Override
    public CourseMaterialDTO getSelectedCourseMaterial(String materialId) throws Exception {

        var sampleMaterial = new CourseMaterialDTO(
                "MAT01",
                "SpringBootGuide.pdf",
                "PDF",
                "base64encodedstring",
                "2025-07-20",
                "COURSE01"
        );

        if (materialId.equals(sampleMaterial.getMaterialId())) {
            return sampleMaterial;
        }

        throw new Exception("Course Material Not Found");
    }

    @Override
    public List<CourseMaterialDTO> getAllCourseMaterials() {
        return Arrays.asList(
                new CourseMaterialDTO(
                        "MAT01",
                        "SpringBootGuide.pdf",
                        "PDF",
                        "base64string1",
                        "2025-07-20",
                        "COURSE01"
                ),
                new CourseMaterialDTO(
                        "MAT02",
                        "JavaBasics.pptx",
                        "PPT",
                        "base64string2",
                        "2025-07-15",
                        "COURSE02"
                ),
                new CourseMaterialDTO(
                        "MAT03",
                        "DatabaseDesign.docx",
                        "DOCX",
                        "base64string3",
                        "2025-07-10",
                        "COURSE03"
                )
        );
    }
}
