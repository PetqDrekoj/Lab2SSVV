package ssvv.example;

import static org.junit.Assert.assertTrue;

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
    public void test_case1()
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

        Student student = new Student("1", "Ion",0,"ion@yahoo.com");
        service.addStudent(student);
        assert(service.findStudent("1") != null);
        service.deleteStudent("1");
    }

    @Test
    public void test_case2()
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

        Student student = new Student( "1","Ion",-1,"ion@yahoo.com");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case3()
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

        Student student = new Student( null, "Ion",1, "ion@yahoo.com");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case4()
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

        Student student = new Student("", "Ion",1,"ion@yahoo.com");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case5()
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

        Student student = new Student("1", null,1,"ion@yahoo.com");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case6()
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

        Student student = new Student("1", "",1,"ion@yahoo.com");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case7()
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

        Student student = new Student("1", "Ion",1,null );
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case8()
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

        Student student = new Student("1", "Ion",1,"");
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case9()
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

        Student student = new Student(null,null,-1,null);
        try {
            service.addStudent(student);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void test_case10()
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
    public void test_case11()
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
    public void test_case12()
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

    @Test
    public void wbt_1()
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

        Tema tema = new Tema("", "d", 1,1);
        try {
            service.addTema(tema);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }

    @Test
    public void wbt_2()
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

        Tema tema = new Tema("1", "", 1,1);
        try {
            service.addTema(tema);
            assert false;
        }
        catch (ValidationException e){
            assert true;
        }
    }
}
