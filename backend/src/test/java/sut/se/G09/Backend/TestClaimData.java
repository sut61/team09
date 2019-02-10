package sut.se.G09.Backend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.G09.Backend.Entity.ClaimData;
import sut.se.G09.Backend.Entity.DiseaseAccidentData;
import sut.se.G09.Backend.Repository.ClaimDataRepository;
import sut.se.G09.Backend.Repository.DiseaseAccidentDataRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Null;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestClaimData {

    @Autowired
    private ClaimDataRepository claimDataRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

//========================================================================================
@Test
public void testCostPass() {
    ClaimData a1 = new ClaimData();

    a1.setCostClaimData("100");



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
    public void testCostCannotBeNull() {
        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(null);



        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCostCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCostOverSize() {
        ClaimData a1 = new ClaimData();

        a1.setCostClaimData("1111111111");



        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("CostOverSize");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCostFirstDigitNotZero() {
        ClaimData a1 = new ClaimData();

        a1.setCostClaimData("05");



        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("Cost First Digit Not is Zero");
            System.out.println("==========================");
        }
    }
//=============================================================================================


}
