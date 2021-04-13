package ssvv.example;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.time.LocalDate;

public class AppTestIntegration {

    private StudentXMLRepo repositoryStudent;
    private NotaXMLRepo repositoryNote;
    private TemaXMLRepo repositoryTema;
    private Service service;
    private StudentValidator validatorStudent;
    private NotaValidator validatorNota;
    private TemaValidator validatorTema;

    public void build(){
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);

    }

    @Test
    public void test_addStudent(){
       build();
       Student student = new Student("1", "d", 1, "email");
        try {
            Student student1 = service.addStudent(student);
            assert (student1 == null);
            service.deleteStudent("1");
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void test_addAssignment(){
        build();
        Tema tema = new Tema("1", "d", 1, 1);
        try {
            Tema tema1 = service.addTema(tema);
            assert (tema1 == null);
            service.deleteTema("1");
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void test_addGrade(){
        build();
        Nota nota = new Nota("1", "101", "101", 10, LocalDate.now());
        try {
            double good = service.addNota(nota, "good");
            assert (good==10.0);
            service.deleteNota("1");
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void test_add(){
        build();
        Student student = new Student("1", "d", 1, "email");
        Tema tema = new Tema("1", "d", 1, 1);
        Nota nota = new Nota("1", "101", "101", 10, LocalDate.now());
        try {
            Student student1 = service.addStudent(student);
            Tema tema1 = service.addTema(tema);
            double good = service.addNota(nota, "good");
            assert (student1 == null);
            assert (tema1 == null);
            assert (good==10.0);
            service.deleteNota("1");
            service.deleteTema("1");
            service.deleteStudent("1");
        } catch (Exception e) {
            assert false;
        }
    }
}
