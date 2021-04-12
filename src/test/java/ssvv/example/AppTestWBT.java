package ssvv.example;

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

public class AppTestWBT {
    private StudentXMLRepo repositoryStudent;
    private NotaXMLRepo repositoryNote;
    private TemaXMLRepo repositoryTema;
    private Service service;
    private StudentValidator validatorStudent;
    private NotaValidator validatorNota;
    private TemaValidator validatorTema;

    @Test
    public void wbt_1() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);
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
    public void wbt_2() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);

        Tema tema = new Tema("", "d", 1, 1);
        try {
            service.addTema(tema);
            assert false;
        } catch (ValidationException e) {
            assert true;
        }
    }

    @Test
    public void wbt_3() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);

        Tema tema = new Tema("1", "", 1, 1);
        try {
            service.addTema(tema);
            assert false;
        } catch (ValidationException e) {
            assert true;
        }
    }

    @Test
    public void wbt_4() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);

        Tema tema = new Tema("1", "d", 0, 1);
        try {
            service.addTema(tema);
            assert false;
        } catch (ValidationException e) {
            assert true;
        }
    }

    @Test
    public void wbt_5() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);

        Tema tema = new Tema("1", "d", 1, 0);
        try {
            service.addTema(tema);
            assert false;
        } catch (ValidationException e) {
            assert true;
        }
    }

    @Test
    public void wbt_6() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        validatorStudent = new StudentValidator();
        repositoryStudent = new StudentXMLRepo(filenameStudent);
        validatorNota = new NotaValidator(repositoryStudent, repositoryTema);
        repositoryNote = new NotaXMLRepo(filenameNota);
        validatorTema = new TemaValidator();
        repositoryTema = new TemaXMLRepo(filenameTema);
        service = new Service(repositoryStudent, validatorStudent, repositoryTema, validatorTema, repositoryNote, validatorNota);

        Tema tema1 = new Tema("1", "d", 1, 1);
        Tema tema2 = new Tema("1", "d", 1, 1);
        try {
            service.addTema(tema1);
        } catch (Exception e) {
            assert false;
        }
        try {
            Tema tema = service.addTema(tema2);
            assert (tema != null);
        } catch (Exception e) {
            assert false;
        }
        service.deleteTema("1");
    }
}
