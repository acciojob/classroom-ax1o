package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> dbstudent = new HashMap<>();
    HashMap<String,Teacher> dbTeacher = new HashMap<>();
    HashMap<String,List<String>> dbpair = new HashMap<String, List<String>>();

    public void addStudent(Student student){
        dbstudent.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        dbTeacher.put(teacher.getName(),teacher);
    }

    public void addPair(String studentName , String teacherName){
        List<String> list = new LinkedList<>();

        if(dbpair.containsKey(teacherName)){
            list = dbpair.get(teacherName);
            list.add(studentName);
            dbpair.put(teacherName,list);
        }else{
            list.add(studentName);
            dbpair.put(teacherName,list);
        }

    }

    public Student getStudent(String name){
       return dbstudent.get(name);
    }

    public Teacher getTeacher(String name){
        return dbTeacher.get(name);
    }

    public List<String> getListOfStudents(String name){
        return dbpair.get(name);
    }

    public List<String> getAllStudents(){
        List<String> list = new LinkedList<>();
        for(String student : dbstudent.keySet()){
            list.add(student);
        }
        return list;

    }

    public void removeTeacherByName(String teacherName){
        List<String> students = dbpair.get(teacherName);

        dbpair.remove(teacherName);
        dbTeacher.remove(teacherName);
        for(String student : students){
            dbstudent.remove(student);
        }

    }

    public void removeAll(){
        dbpair.clear();
        dbstudent.clear();
        dbTeacher.clear();
    }

}
