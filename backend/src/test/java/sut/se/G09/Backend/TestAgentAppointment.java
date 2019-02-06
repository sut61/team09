package sut.se.G09.Backend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
import sut.se.G09.Backend.Entity.AgentAppointment;
import sut.se.G09.Backend.Repository.AgentAppointmentRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestAgentAppointment {

    @Autowired private AgentAppointmentRepository agentAppointmentRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testFirstName() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");

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
    public void testFirstNameCannotBeNull() {
        AgentAppointment a = new AgentAppointment();
        a.setfName(null);
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected FirstNameCannotBeNull");
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

        try {
            entityManager.persist(a);
            entityManager.flush();

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
    public void testAgeMustBetween1to80YearsOld() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(90);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");

        try {
            entityManager.persist(a);
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
    public void testAppointmentIdMustBeUnique() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setAppointmentId(1L);
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("1234abcd@gmail.com");

        AgentAppointment a2 = new AgentAppointment();
        a2.setAppointmentId(1L);
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234467");
        a2.setEmail("1234abcsd@gmail.com");

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
    public void testLastNameLengthMustMoreThan1Character() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Aaaaa");
        a.setlName("L");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");

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
    public void testLastNameCannotBeNull() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName(null);
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected LastNameCannotBeNull");
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
    public void testTelNumMustBeNumber() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801ABC567");
        a.setEmail("Abcdf.1234@gmail.com");
        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected TelNumMustBeNumber");
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
    public void testTelNumMustBeStartWith0Then689() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Aaaaa");
        a1.setlName("Bbbbb");
        a1.setAge(50);
        a1.setTelNum("2801234567");
        a1.setEmail("Abcdf.1234@gmail.com");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Ccccc");
        a2.setlName("Ddddd");
        a2.setAge(40);
        a2.setTelNum("0101234567");
        a2.setEmail("Abcdf.1234@gmail.com");

        AgentAppointment a3 = new AgentAppointment();
        a3.setfName("Eeeee");
        a3.setlName("Fffff");
        a3.setAge(30);
        a3.setTelNum("1301234567");
        a3.setEmail("Abcdf.1234@gmail.com");

        try {
            entityManager.persist(a1);
            entityManager.persist(a2);
            entityManager.persist(a3);
            entityManager.flush();

            fail("expected TelNumMustBeStartWith0Then689");
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
    public void testEmailStartWithAlphabetOrNumber() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail(".1234abc@gmail.com");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234567");
        a2.setEmail("_1234abc@gmail.com");
        try {
            entityManager.persist(a1);
            entityManager.persist(a2);
            entityManager.flush();

            fail("expected EmailStartWithAlphabetOrNumber");
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
        a1.setEmail("1234_abc@gmail.com");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234567");
        a2.setEmail("123*4ab+c@gmail.com");
        try {
            entityManager.persist(a1);
            entityManager.persist(a2);
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

    @Test
    public void testUserNameLengthOfEmailNotLessThan8() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("123bc@gmail.com");
        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected UserNameLengthOfEmailNotLessThan8");
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
    public void testEmailMustHaveAtSign() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("12356abc-gmail.com");
        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected EmailMustHaveAtSign");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("EmailNotHaveAtSign");
        }
    }

    @Test
    public void testDomainNameOfEmailMustBeOnlyLowercaseLetter() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("12356abc@gMAil.com");
        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected DomainNameOfEmailMustBeOnlyLowercaseLetter");
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
    public void testDomainNameOfEmailMustBeOnlyLowercaseLetterOrDot() {
        AgentAppointment a1 = new AgentAppointment();
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("123456abc@gMAil.com");

        AgentAppointment a2 = new AgentAppointment();
        a2.setfName("Fffff");
        a2.setlName("Lllll");
        a2.setAge(50);
        a2.setTelNum("0801234567");
        a2.setEmail("123456abc@gmail_com");
        try {
            entityManager.persist(a1);
            entityManager.persist(a2);
            entityManager.flush();

            fail("expected DomainNameOfEmailMustBeOnlyLowercaseLetterOrDot");
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