package com.example.restapi.dao;

import com.example.restapi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface StudentDao {

    int insertStudent (UUID id, Student student);

    default int insertStudent(Student student){
        UUID id = UUID.randomUUID();
        return insertStudent(id,student);
    }

    List<Student> selectAllStudents ();

    Optional<Student> selectStudentbyId(UUID id);

    int deleteStudentById(UUID id);

    int updateStudentByID(UUID id,Student student);

}
