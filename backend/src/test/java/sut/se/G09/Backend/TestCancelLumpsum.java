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

}
