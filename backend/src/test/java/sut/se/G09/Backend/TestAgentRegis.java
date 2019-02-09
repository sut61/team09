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
import sut.se.G09.Backend.Entity.AgentRegistration;
import sut.se.G09.Backend.Repository.AgentRegistrationRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest

public class TestAgentRegis {
    @Autowired private AgentRegistrationRepository agentRegistrationRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDataNamePass() {
        AgentRegistration a1 = new AgentRegistration();

        a1.setfName("AAAAAA");
        a1.setlName("Lllll");




        try {
            entityManager.persist(a1);
            entityManager.flush();
            System.out.println("==========================");
            System.out.println("Test Not Fail");
            System.out.println("==========================");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test
    public void testFirstNameCannotBeNull() {
        AgentRegistration a = new AgentRegistration();
        a.setfName(null);
        a.setlName("Lllll");


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
        AgentRegistration a = new AgentRegistration();
        a.setfName("A");
        a.setlName("Lllll");


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
    public void testFirstNameLengthMustLessThan30Character() {
        AgentRegistration a = new AgentRegistration();
        a.setfName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        a.setlName("Lllll");


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
    public void testAppointmentIdMustBeUnique() {
        AgentRegistration a1 = new AgentRegistration();
        a1.setiD(1L);
        a1.setfName("Fffff");
        a1.setlName("Lllll");


        AgentRegistration a2 = new AgentRegistration();
        a2.setiD(1L);
        a2.setfName("Allll");
        a2.setlName("Bbbbb");


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
        AgentRegistration a = new AgentRegistration();
        a.setfName("Aaaaa");
        a.setlName("L");


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
        AgentRegistration a = new AgentRegistration();
        a.setfName("Aaaaa");
        a.setlName("Llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");


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
        AgentRegistration a = new AgentRegistration();
        a.setfName("Fffff");
        a.setlName(null);


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

}
