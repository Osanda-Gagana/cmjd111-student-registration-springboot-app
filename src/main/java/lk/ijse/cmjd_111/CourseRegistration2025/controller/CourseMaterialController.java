package lk.ijse.cmjd_111.CourseRegistration2025.controller;
//Hi My name is Osanda
import lk.ijse.cmjd_111.CourseRegistration2025.dto.CourseMaterialDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.CourseMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping(value = "material")
@RequiredArgsConstructor
public class CourseMaterialController {

    private final CourseMaterialService courseMaterialService; // ✅ properly injected

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseMaterialDTO> saveMaterial(
            @RequestParam String materialId,
            @RequestParam String fileName,
            @RequestParam String materialType,
            @RequestParam MultipartFile material,
            @RequestParam(required = false) String uploadAt,
            @RequestParam String courseId) {

        try {
            byte[] materialBytes = material.getBytes();
            String materialString = Base64.getEncoder().encodeToString(materialBytes);
            String uploadTime = uploadAt != null
                    ? uploadAt
                    : LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);

            CourseMaterialDTO materialDTO = new CourseMaterialDTO(
                    materialId,
                    fileName,
                    materialType,
                    materialString,
                    uploadTime,
                    courseId
            );

            // ✅ Use the injected service
            CourseMaterialDTO savedMaterial = courseMaterialService.saveCourseMaterial(materialDTO);
            return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "{materialId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseMaterialDTO> getSelectedMaterial(@PathVariable String materialId) {
        if (materialId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(
                    courseMaterialService.getSelectedCourseMaterial(materialId),
                    HttpStatus.OK
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CourseMaterialDTO>> getAllMaterials() {
        List<CourseMaterialDTO> allMaterials = courseMaterialService.getAllCourseMaterials();
        return new ResponseEntity<>(allMaterials, HttpStatus.OK);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateMaterial(@RequestParam String materialId,
                               @RequestBody CourseMaterialDTO materialUpdateData) {
        System.out.println("Material ID to update: " + materialId);
        System.out.println(materialUpdateData);
    }

    @DeleteMapping
    public void deleteMaterial(@RequestHeader("X-materialId") String materialId) {
        System.out.println("Material ID to be deleted: " + materialId);
    }
}
