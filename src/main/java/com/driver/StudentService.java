package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addPair(String studentName,String teacherName){
        studentRepository.addPair(studentName,teacherName);
    }

    public Student getStudent(String name){
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name){
        return studentRepository.getTeacher(name);
    }

    public List<String> getListOfStudents(String name){
        return studentRepository.getListOfStudents(name);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void removeTeacherByName(String name){
         studentRepository.removeTeacherByName(name);
    }

    public void removeAll(){
        studentRepository.removeAll();
    }

}
