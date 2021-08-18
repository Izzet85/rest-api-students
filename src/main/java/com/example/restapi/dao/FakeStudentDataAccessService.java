package com.example.restapi.dao;

import com.example.restapi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakedao")
public class FakeStudentDataAccessService implements StudentDao {

    private static List<Student> DB = new ArrayList<>();

    @Override
    public int insertStudent(UUID id, Student student) {
        DB.add(new Student(id,student.getName(),student.getAge(),student.getEmail()));
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return DB;
    }

    @Override
    public Optional<Student> selectStudentbyId( UUID id) {
        return DB.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteStudentById(UUID id) {
           Optional<Student> studentMaybe  = selectStudentbyId(id);

           if (studentMaybe.isEmpty()){
               return 0;
           }
           DB.remove(studentMaybe.get());
        return 1;

    }

    @Override
    public int updateStudentByID(UUID id, Student update) {
     return   selectStudentbyId(id)
             .map(student -> {
                 int indexOfStudentToUpdate = DB.indexOf(student);
                 if (indexOfStudentToUpdate >=0){
                     DB.set(indexOfStudentToUpdate,new Student(id,update.getName(),update.getAge(),update.getEmail()) );
                     return 1;
                 }

               return 0;
             } )
             .orElse(0);



    }


}
