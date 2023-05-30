package com.info.service.impl;

import com.info.entities.IdProof;
import com.info.entities.Student;
import com.info.payload.IdProofDTO;
import com.info.payload.StudentDto;
import com.info.repositories.IdProofRepository;
import com.info.repositories.StudentRepository;
import com.info.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IdProofRepository idProofRepository;


    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        IdProof idProof = new IdProof();

        idProof.setPancardNumber(studentDto.getIdProof().getPancardnumber());
        idProof = idProofRepository.save(idProof);

        Student student = new Student();

        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
        student.setFee(studentDto.getFee());
        student.setIdProof(idProof);
        student = studentRepository.save(student);

        // Map the entities to DTOs return the result

        StudentDto resultDto = new StudentDto();

        resultDto.setId(student.getId());
        resultDto.setName(student.getName());
        resultDto.setCourse(student.getCourse());
        resultDto.setFee(student.getFee());

        IdProofDTO idProofDTO = new IdProofDTO();

        idProofDTO.setId(idProof.getId());
        idProofDTO.setPancardnumber(idProof.getPancardNumber());

        resultDto.setIdProof(idProofDTO);


        return resultDto;
    }
}
