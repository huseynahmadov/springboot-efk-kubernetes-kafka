package microserviceapplication.mapper;

import microserviceapplication.dto.StudentResponse;
import microserviceapplication.dto.request.CreateStudentRequest;
import microserviceapplication.dto.request.UpdateStudentRequest;
import microserviceapplication.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

    //this is test mapping
    @Mapping(target = "id", ignore = true)
    Student mapRequestToStudent(CreateStudentRequest request);

    StudentResponse mapEntityToResponse(Student student);

    Student mapUpdateRequestToEntity(@MappingTarget Student student, UpdateStudentRequest request);

}
