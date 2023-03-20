package microserviceapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import microserviceapplication.error.ErrorCodes;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {

    @NotBlank(message = "error.emptyName")
    private String name;

    @NotBlank(message = "error.emptySurname")
    private String surname;

    @NotBlank(message = "error.emptyGroupName")
    private String groupName;

}
