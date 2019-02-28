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
    private DiseaseAccidentDataRepository diseaseAccidentDataRepository;

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

    DiseaseAccidentLevel level = new DiseaseAccidentLevel();
    level.setId(1);
    level.setLevelText("1");
    level.getId();

    DiseaseAccidentType type = new DiseaseAccidentType();
    type.setId(1);
    type.setTypeText("1");
    type.getId();

    MedicalFee medicalFee = new MedicalFee();
    medicalFee.setId(1);
    medicalFee.setMedicalFee(10);
    medicalFee.getID();

    DiseaseAccidentData a1 = new DiseaseAccidentData();
    a1.setDiseaseAccidentData("โรคหัวใจนะ");
    a1.setDiseaseAccidentLevel(level);
    a1.setDiseaseAccidentType(type);
    a1.setMedicalFee(medicalFee);


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

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();

        a1.setDiseaseAccidentData(null);
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(medicalFee);




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
    public void testDiseaseAccidentLevelCannotBeNull() {

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("โรคหัวใจนะ");
        a1.setDiseaseAccidentLevel(null);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(medicalFee);



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
            System.out.println("DiseaseAccidentLevel Cannot Be Null");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDiseaseAccidentTypeCannotBeNull() {

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("โรคหัวใจนะ");
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(null);
        a1.setMedicalFee(medicalFee);



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
            System.out.println("DiseaseAccidentType Cannot Be Null");
            System.out.println("==========================");
        }
    }

    @Test
    public void testMedicalFeeCannotBeNull() {

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("โรคหัวใจนะ");
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(null);



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
            System.out.println("MedicalFee Cannot Be Null");
            System.out.println("==========================");
        }
    }





    @Test
    public void testDataNameDigitNotEnglish() {

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("โรค1AA");
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(medicalFee);



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
            System.out.println("DataNameDigitNotEnglish");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDataNameSizeLess() {

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("หส");
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(medicalFee);



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

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("นรดกี้ร่ดก้เรหน้นรเ้หน้เร้หนเดว้หส้ดเวห้กรเด้หน้เ้หำนพี้ัไรำ้ัไีำจพเีดก่ิอ่หืง");
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(medicalFee);



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

        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setId(1);
        level.setLevelText("1");
        level.getId();

        DiseaseAccidentType type = new DiseaseAccidentType();
        type.setId(1);
        type.setTypeText("1");
        type.getId();

        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setId(1);
        medicalFee.setMedicalFee(10);
        medicalFee.getID();

        DiseaseAccidentData a1 = new DiseaseAccidentData();
        a1.setDiseaseAccidentData("โดดดดดโดดด");
        a1.setDiseaseAccidentLevel(level);
        a1.setDiseaseAccidentType(type);
        a1.setMedicalFee(medicalFee);
        entityManager.persist(a1);

        DiseaseAccidentLevel level1 = new DiseaseAccidentLevel();
        level1.setId(1);
        level1.setLevelText("1");
        level1.getId();

        DiseaseAccidentType type1 = new DiseaseAccidentType();
        type1.setId(1);
        type1.setTypeText("1");
        type1.getId();

        MedicalFee medicalFee1 = new MedicalFee();
        medicalFee1.setId(1);
        medicalFee1.setMedicalFee(10);
        medicalFee1.getID();

        DiseaseAccidentData a2 = new DiseaseAccidentData();
        a2.setDiseaseAccidentData("โดดดดดโดดด");
        a2.setDiseaseAccidentLevel(level1);
        a2.setDiseaseAccidentType(type1);
        a2.setMedicalFee(medicalFee1);




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

    @Test
    public void test_levelTextCannotBeNull() {
         DiseaseAccidentLevel level = new DiseaseAccidentLevel();
           level.setLevelText(null);





        try {
            entityManager.persist(level);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("levelTextCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_levelTextPass() {
        DiseaseAccidentLevel level = new DiseaseAccidentLevel();
        level.setLevelText("leveltest");





        try {
            entityManager.persist(level);
            entityManager.flush();
            System.out.println("levelTextPuss");


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("levelTextCannotPuss");
            System.out.println("==========================");
        }
    }



    @Test
    public void test_typeTextCannotBeNull() {
        DiseaseAccidentType level = new DiseaseAccidentType();
        level.setTypeText(null);





        try {
            entityManager.persist(level);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("typeTextCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_typeTextPass() {
        DiseaseAccidentType level = new DiseaseAccidentType();
        level.setTypeText("typeText");





        try {
            entityManager.persist(level);
            entityManager.flush();
            System.out.println("typeTextPuss");


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("typeTextCannotPuss");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_medicalFeeCostOverRange() {
        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setMedicalFee(100000000);





        try {
            entityManager.persist(medicalFee);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("medicalFeeCostOverRange");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_medicalFeeCostPass() {
        MedicalFee medicalFee = new MedicalFee();
        medicalFee.setMedicalFee(10000);





        try {
            entityManager.persist(medicalFee);
            entityManager.flush();
            System.out.println("medicalFeePass");


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("medicalFeeNotPass");
            System.out.println("==========================");
        }
    }



//=============================================================================================


}
