package se.lexicon.service;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;
import java.util.Scanner;
@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private final UserInputService scannerService;
    private final StudentDao studentDao;
    private final Scanner scanner;

    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao, Scanner scanner) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
        this.scanner = scanner;
    }


    @Override
    public Student create() {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return new Student(id, name);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = find(id);
        studentDao.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();

    }

    @Override
    public Student edit(Student student) {

        studentDao.find(student.getId()).setName(student.getName());
        return student;
    }
}
