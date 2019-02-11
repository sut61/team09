package sut.se.G09.Backend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestCategory {

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
    public void testDataPass() {
        Category a1 = new Category();

        a1.setTypeName("fitrorkdienid");

        try {
            entityManager.persist(a1);
            entityManager.flush();
            System.out.println("\n\n\n\n\n====================================================================");
            System.out.println("Test Pass very good...");
            System.out.println("====================================================================\n\n\n\n\n");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testDataNameCannotBeNull() {
        Category a1 = new Category();

        a1.setTypeName(null);

        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n\n\n====================================================================");
            System.out.println(e.getMessage());
            System.out.println("====================================================================\n\n\n\n\n");



            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testDataNameFirstNotNumber() {
        Category a1 = new Category();
        a1.setTypeName("2konkmuhngtfr");

        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n\n\n====================================================================");
            System.out.println(e.getMessage());
            System.out.println("====================================================================\n\n\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSizeMax() {
        Category a1 = new Category();
        a1.setTypeName("qwertyuioplkjhgfdsazxcvbnmnbvcxzasdfghjklpooiuuuuuuuuuuuuuuuuuuuuuuuuuu");

        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n\n\n====================================================================");
            System.out.println(e.getMessage());
            System.out.println("====================================================================\n\n\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testSizeMin() {
        Category a1 = new Category();
        a1.setTypeName("rewq");

        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n\n\n====================================================================");
            System.out.println(e.getMessage());
            System.out.println("====================================================================\n\n\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test//(expected=javax.persistence.PersistenceException.class)
    public void testDataNameUnique() {
        Category a1 = new Category();
        a1.setTypeName("ประกันภัยบา");
        entityManager.persist(a1);

        Category a2 = new Category();
        a2.setTypeName("ประกันภัยบา");

        try {
            entityManager.persist(a2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n\n\n====================================================================");
            System.out.println("DataName not Unique");
            System.out.println("====================================================================\n\n\n\n\n");
        }
    }
}