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

    @Autowired
    private AgentAppointmentRepository agentAppointmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testAgeMustBetween2and3Digit() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(1000);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testEmailMustHaveAddressSign() {
        AgentAppointment a = new AgentAppointment();
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("12356abc-gmail.com");
        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
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

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
