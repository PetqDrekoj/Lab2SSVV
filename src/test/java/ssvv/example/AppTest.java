package ssvv.example;

import static org.junit.Assert.assertTrue;

import domain.Student;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private StudentXMLRepo repositoryStudent;
    private NotaXMLRepo repositoryNote;
    private TemaXMLRepo repositoryTema;
    private Service service;
    private StudentValidator validatorStudent;
    private NotaValidator validatorNota;
    private TemaValidator validatorTema;

    @Test
    public void ec1_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);
        Student student = new Student("id1","id1",935,"id1@gmail.com");
        service.addStudent(student);
        assert(service.findStudent("id1") != null);
        service.deleteStudent("id1");
    }

    @Test
    public void ec2_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);

        Student student = new Student("id1","id1",-1,"id1@gmail.com");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void ec3_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);

        Student student = new Student("1","Ion",1,"ion@yahoo.com");
        service.addStudent(student);
        assert(service.findStudent("1") != null);
        service.deleteStudent("1");
    }

    @Test
    public void ec4_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);

        Student student = new Student("","",-1,"");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void ec5_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);

        Student student = new Student(null,null, 0,null);
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException | NullPointerException e){
            assert true;
        }
    }

    @Test
    public void bva1_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);

        Student student = new Student("1","Ion",(int)(Math.pow(2,31)-1),"ion@yahoo.com");
        service.addStudent(student);
        assert(service.findStudent("1") != null);
        service.deleteStudent("1");
    }

    @Test
    public void bva2_test()
    {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent,repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema  = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent,validatorStudent,repositoryTema,validatorTema,repositoryNote,validatorNota);

        Student student = new Student("1","Ion",(int)(Math.pow(2,31)-2),"ion@yahoo.com");
        service.addStudent(student);
        assert(service.findStudent("1") != null);
        service.deleteStudent("1");
    }
}
