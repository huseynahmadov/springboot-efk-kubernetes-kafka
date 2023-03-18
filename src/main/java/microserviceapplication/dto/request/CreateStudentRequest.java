package microserviceapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {

    @NotBlank(message = "Name must not be null")
    private String name;

    @NotBlank(message = "Surname must not be null")
    private String surname;

    @NotBlank(message = "Group name must not be null")
    private String groupName;

}
