package microserviceapplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microserviceapplication.dto.StudentResponse;
import microserviceapplication.dto.request.CreateStudentRequest;
import microserviceapplication.dto.request.UpdateStudentRequest;
import microserviceapplication.error.StudentNotFoundException;
import microserviceapplication.mapper.StudentMapper;
import microserviceapplication.repository.StudentRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final KafkaTemplate<String, StudentResponse> kafkaTemplate;

    public void createStudent(CreateStudentRequest request) {
        studentRepository.save(studentMapper.mapRequestToStudent(request));
    }

    public List<StudentResponse> getAllStudents() {
        var students =  studentRepository.findAll()
                .stream()
                .map(studentMapper::mapEntityToResponse)
                .collect(Collectors.toList());

        log.info("Students: {}", students);

        students
                .forEach(student -> kafkaTemplate.send("student-topic", student));

        return students;
    }

    public StudentResponse getStudent(Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(this::exStudentNotFound);

        return studentMapper.mapEntityToResponse(student);
    }

    public void updateStudent(Long id, UpdateStudentRequest request) {
        var student = studentRepository.findById(id)
                .orElseThrow(this::exStudentNotFound);

        studentMapper.mapUpdateRequestToEntity(student, request);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(this::exStudentNotFound);
        studentRepository.deleteById(student.getId());
    }

    public StudentNotFoundException exStudentNotFound() {
        throw new StudentNotFoundException();
    }
}
