package microserviceapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;
    private String name;
    private String surname;
    private String groupName;

}
