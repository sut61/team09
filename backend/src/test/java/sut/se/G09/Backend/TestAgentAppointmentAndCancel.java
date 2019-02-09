package sut.se.G09.Backend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.sql.Types.NULL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.AgentAppointmentRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestAgentAppointmentAndCancel {

    @Autowired private AgentAppointmentRepository agentAppointmentRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //Sprint1---------------------------------------------------------------------------------------------------------------------------------------
    //---------AgentAppointment---------
    @Test
    public void testFirstNameTrue() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");
        try {

            entityManager.persist(a);
            entityManager.flush();
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println("First name is Correct");
            System.out.println("===========================================================================================================\n\n\n");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testAppointmentIdMustBeUnique() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setAppointmentId(1L);
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("1234abcd@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setAppointmentId(1L);
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234467");
        a2.setEmail("1234abcsd@gmail.com");
        a2.setIdCardNum("1300000000001");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected AppointmentIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test
    public void testFirstNameCannotNull() {
        AgentAppointment a = new AgentAppointment();
        a.setfName(null);
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected FirstNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testFirstNameLengthMustMoreThan1Character() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("A");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected FirstNameLengthMustMoreThan1Character");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testFirstNameLengthMustLessThan30Character() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a); entityManager.flush();
            fail("expected FirstNameLengthMustLessThan30Character");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testLastNameCannotNull() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName(null);
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected LastNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testLastNameLengthMustMoreThan1Character() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Aaaaa");
        a.setlName("L");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected LastNameLengthMustMoreThan1Character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testLastNameLengthMustLessThan30Character() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Aaaaa");
        a.setlName("Llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected LastNameLengthMustLessThan30Character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testIdCardNumberCannotBeNull() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum(null);

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected IdCardNumberCannotBeNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testIdCardNumberNotMoreThan13Characters() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234578");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1301234567899999");
        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected IdCardNumberNotMoreThan13Characters");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testAgeMustBetween1to80YearsOld() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(90);
        a1.setTelNum("0801234567");
        a1.setEmail("Abcdf.1234@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Aaaaa");
        a2.setlName("Bbbbb");
        a2.setAge(0);
        a2.setTelNum("0801234567");
        a2.setEmail("Abcdf00000@gmail.com");
        a2.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected AgeMustBetween1to80YearsOld");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testTelNumMustBeStartWith0Then2to9() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Aaaaa");
        a1.setlName("Bbbbb");
        a1.setAge(50);
        a1.setTelNum("2801234567");
        a1.setEmail("Abcdf.1234@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Ccccc");
        a2.setlName("Ddddd");
        a2.setAge(40);
        a2.setTelNum("0101234567");
        a2.setEmail("Abcdf.1234@gmail.com");
        a2.setIdCardNum("1300000000001");

        AgentAppointment a3 = new AgentAppointment();
        a3.setfName("Eeeee");
        a3.setlName("Fffff");
        a3.setAge(30);
        a3.setTelNum("1301234567");
        a3.setEmail("Abcdf.1234@gmail.com");
        a3.setIdCardNum("1300000000002");

        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            entityManager.persist(a3);
            entityManager.flush();

            fail("expected TelNumMustBeStartWith0Then2to9");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testEmailMustContainAlphabetOrNumberOrDot() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("12+34_abc@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234567");
        a2.setEmail("123456abc@gmail_com");
        a2.setIdCardNum("1300000000001");

        AgentAppointment a3 = new AgentAppointment();
        a3.setfName("Ddddd");
        a3.setlName("Ccccc");
        a3.setAge(50);
        a3.setTelNum("0801234567");
        a3.setEmail("123456abc@Gmail.com");
        a3.setIdCardNum("1300000000002");

        AgentAppointment a4 = new AgentAppointment();
        a4.setfName("Eeeee");
        a4.setlName("Ttttt");
        a4.setAge(20);
        a4.setTelNum("0801234567");
        a4.setEmail("123456abc.Gmail.com");
        a4.setIdCardNum("1300000000002");
        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            entityManager.persist(a3);
            entityManager.flush();
            entityManager.persist(a4);
            entityManager.flush();

            fail("expected EmailMustContainAlphabetOrNumberOrDot");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //---------Gender---------
    @Test
    public void testGenderIdMustBeUnique() {
        Gender g1 = new Gender();
        g1.setGenderId(1L);
        g1.setGenderName("ชาย");

        Gender g2 = new Gender();
        g2.setGenderId(1L);
        g2.setGenderName("หญิง");

        try {

            entityManager.persist(g1);
            entityManager.flush();
            entityManager.persist(g2);
            entityManager.flush();
            fail("expected GenderIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test
    public void testGenderCannotNull() {
        Gender g = new Gender();
        g.setGenderName(null);

        try {

            entityManager.persist(g);
            entityManager.flush();
            fail("expected GenderCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //---------DateAppointment---------
    @Test
    public void testDateCannotNull() {
        DateAppointment d = new DateAppointment();
        d.setDate(null);
        d.setCount(2);
        d.setStatus("available");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testDateCountLimitAt4() {
        DateAppointment d = new DateAppointment();
        d.setDate("13 เมษายน 2562");
        d.setCount(5);
        d.setStatus("full");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateCountLimitAt4");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testDateStatusCannotNull() {
        DateAppointment d = new DateAppointment();
        d.setDate("13 เมษายน 2562");
        d.setCount(2);
        d.setStatus(null);

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateStatusCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testDateStatusMustBeLowCaseCharacter() {
        DateAppointment d = new DateAppointment();
        d.setDate("13 เมษายน 2562");
        d.setCount(2);
        d.setStatus("AvaiLaBLe");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateStatusMustBeLowCaseCharacter");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    //---------DurationAppointment---------
    @Test
    public void testDurationCannotNull() {
        DurationAppointment d = new DurationAppointment();
        d.setDuration(null);

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DurationCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testDurationMustBeCorrectPattern() {
        DurationAppointment d = new DurationAppointment();
        d.setDuration("8 - 10 น.");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DurationMustBeCorrectPattern");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    //Sprint2---------------------------------------------------------------------------------------------------------------------------------------
    //CancelAppointmentHistory
    @Test
    public void testCancelAppointmentHistoryIdMustBeUnique() {
        CancelAppointmentHistory c1 = new CancelAppointmentHistory();
        c1.setCancelId(1L);
        c1.setIdCardNum("1300000000000");
        c1.setfName("Fffff");
        c1.setlName("Lllll");

        CancelAppointmentHistory c2 = new CancelAppointmentHistory();
        c2.setCancelId(1L);
        c2.setIdCardNum("1300000000001");
        c2.setfName("Aaaaa");
        c2.setlName("Sssss");
        try {

            entityManager.persist(c1);
            entityManager.flush();
            entityManager.persist(c2);
            entityManager.flush();
            fail("expected CancelAppointmentHistoryIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test
    public void testCancelIdCardNumberCannotNull() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        c.setIdCardNum(null);
        c.setfName("Fffff");
        c.setlName("Lllll");

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelIdCardNumberCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCancelIdCardNumberNotMoreThan13Characters() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        c.setIdCardNum("13000000000000000");
        c.setfName("Fffff");
        c.setlName("Lllll");
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("expected CancelIdCardNumberNotMoreThan13Characters");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCancelFirstNameCannotNull() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        c.setIdCardNum("1300000000000");
        c.setfName(null);
        c.setlName("Lllll");
        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelFirstNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCancelFirstNameLengthMustLessThan30Character() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        c.setIdCardNum("1300000000000");
        c.setfName("Fffffffffffffffffffffffffffffffffffffffffffffff");
        c.setlName("Lllll");
        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelFirstNameLengthMustLessThan30Character");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCancelLastNameCannotNull() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        c.setIdCardNum("1300000000000");
        c.setfName("Fffff");
        c.setlName(null);
        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelLastNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }


    @Test
    public void testCancelLastNameLengthMustLessThan30Character() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        c.setIdCardNum("1300000000000");
        c.setfName("Fffff");
        c.setlName("Lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("expected CancelLastNameLengthMustLessThan30Character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //CancelAppointmentReason
    @Test
    public void testCancelReasonCannotNull() {
        CancelAppointmentReason r = new CancelAppointmentReason();
        r.setReason(null);

        try {

            entityManager.persist(r);
            entityManager.flush();
            fail("expected DurationCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCancelReasonLengthMustLessThan50Character() {
        CancelAppointmentReason r = new CancelAppointmentReason();
        r.setReason("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        try {

            entityManager.persist(r);
            entityManager.flush();
            fail("expected CancelReasonLengthMustLessThan50Character");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
}