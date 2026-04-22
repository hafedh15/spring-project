package tn.esprit.tpgestiondesinscriptionsuniversitaires.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data

public class EnrollmentDTO {

        @NotNull(message = "Student ID is required")
        private Long studentId;

        @NotNull(message = "Course ID is required")
        private Long courseId;


}
