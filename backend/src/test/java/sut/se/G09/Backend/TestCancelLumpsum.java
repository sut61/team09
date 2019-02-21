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
import sut.se.G09.Backend.Repository.CancelLumpsumRepository;
import sut.se.G09.Backend.Repository.LumpsumRepository;


@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest

public class TestCancelLumpsum {

    @Autowired
    private CancelLumpsumRepository cancelLumpsumRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //Sprint2---------------------------------------------------------------------------------------------------------------------------------------
    //---------CancelLumpsum---------

    @Test
    public void testCancelLumpsumPass() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("1234567890123");


        try {
            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            System.out.println("\n\n\n\n\n\n");
            System.out.println("==========================");
            System.out.println("Test Not Fail");
            System.out.println("==========================");
            System.out.println("\n\n\n\n\n\n");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCommentCannotBeNull() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment(null);
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("1234567890123");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected CommentCannotBeNull");
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
    public void testNameCanCannotBeNull() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan(null);
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("1234567890123");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected NameCanCannotBeNull");
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
    public void testNameCanMustBeLengthLessThan50() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQqqqqqqqqqqqqqqqq");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("1234567890123");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected NameCanMustBeLengthLessThan50");
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
    public void testAgeCanCannotBeNull() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(null);
        cancelLumpsum.setIDcardCan("1234567890123");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected AgeCanCannotBeNull");
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
    public void testAgeCanOverSize() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(90);
        cancelLumpsum.setIDcardCan("1234567890123");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected Age Must between 20-80 years old");
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
    public void testAgeCanLessSize() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(10);
        cancelLumpsum.setIDcardCan("1234567890123");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected Age Must between 20-80 years old ");
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
    public void testIDcardCanCannotBeNull() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan(null);

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected IDcardCanCannotBeNull");
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
    public void testIDcardCanAlphabetWrong() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("156fd12589412");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected IDcardCanAlphabetWrong");
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
    public void testIDcardCanOverSize() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("123456789012345");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected IDcardCanCannotBeNull");
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
    public void testIDcardCanLessSize() {

        CancelLumpsum cancelLumpsum = new CancelLumpsum();
        cancelLumpsum.setComment("test Comment");
        cancelLumpsum.setNameCan("นายหนึ่ง สอง");
        cancelLumpsum.setAgeCan(30);
        cancelLumpsum.setIDcardCan("1234567890");

        try {

            entityManager.persist(cancelLumpsum);
            entityManager.flush();
            fail("expected IDcardCanCannotBeNull");
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
