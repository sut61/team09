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
public class TestDiseaseAccidentData {

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

//========================================================================================
@Test
public void testDataNamePass() {
    DiseaseAccidentData a1 = new DiseaseAccidentData();

    a1.setDiseaseAccidentData("โรคหัวใจนะ");



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
    public void testDataNameCannotBeNull() {
        DiseaseAccidentData a1 = new DiseaseAccidentData();

        a1.setDiseaseAccidentData(null);



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
            System.out.println("DataName Cannot Be Null");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDataNameFirstDigitNotNumber() {
        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("0โรค");


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
            System.out.println("DataName First Digit Not Number");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDataNameSizeLess() {
        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("หส");


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
            System.out.println("DataName Size is Less");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDataNameSizeOver() {
        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("นรดกี้ร่ดก้เรหน้นรเ้หน้เร้หนเดว้หส้ดเวห้กรเด้หน้เ้หำนพี้ัไรำ้ัไีำจพเีดก่ิอ่หืง");


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
            System.out.println("DataName Size is Over ");
            System.out.println("==========================");
        }
    }

    @Test//(expected=javax.persistence.PersistenceException.class)
    public void testDataNameUnique() {
        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("โดดดดดโดดด");
        entityManager.persist(a1);

        DiseaseAccidentData a2 = new DiseaseAccidentData();
        a2.setDiseaseAccidentData("โดดดดดโดดด");



        try {
            entityManager.persist(a2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("DataName not Unique");
            System.out.println("==========================");
        }
    }



//=============================================================================================


}
