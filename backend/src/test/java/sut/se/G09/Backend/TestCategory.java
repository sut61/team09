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

    @Autowired private TestEntityManager entityManager;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private InsurancePremiumRepository insurancePremiumRepository;
    @Autowired private LengthRepository lengthRepository;
    @Autowired private MoneyMaximumRepository moneyMaximumRepository;



    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
//Sprint1

    //DataPass
    @Test
    public void testDataPass() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");
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

    //typeName
    @Test //@NotNull
    public void testTypeNameNotnull() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName(null);
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected TypeNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@SizeMin
    public void testTypeNameMin() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประ");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected TypeNameMin");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@SizeMax
    public void testTypeNameMax() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกันประกัน");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected TypeNameMax");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@Column unique
    public void testTypeNameUnique() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันโรงเรียนจีน");   //<<<----- Test This Line
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        Category a2 = new Category();
        a2.setInsurancePremium(I);
        a2.setLength(L);
        a2.setMoneyMaximum(M);
        a2.setTypeName("ประกันโรงเรียนจีน");   //<<<----- Test This Line
        a2.setoFName("ประยุทธิ์");
        a2.setoLName("จันโอชา");
        a2.setoTlePhone("0927373056");
        a2.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected TypeNameUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("TypeNameUnique Id Must Be Unique");
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    //oFName
    @Test //@NotNull
    public void testoFNamenull() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName(null);
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oFNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@SizeMin
    public void testoFNameMin() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ป");     //<<<----- Test This Line
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oFNameMin");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@SizeMax
    public void testoFNameMax() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์ประยุทธิ์");   //<<<----- Test This Line
        a1.setoLName("จันโอชา");
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oFNameMax");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //oLName
    @Test //@NotNull
    public void testoLNamenull() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName(null);      //<<<----- Test This Line
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oLNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@SizeMin
    public void testoLNameMin() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จ");            //<<<----- Test This Line
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oLNameMin");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@SizeMax
    public void testoLNameMax() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชาจันโอชา");            //<<<----- Test This Line
        a1.setoTlePhone("0927373056");
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oLNameMax");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //oTlePhone
    @Test //@NotNull
    public void testoTlePhonenull() {
        Category a1 = new Category();
        InsurancePremium I = insurancePremiumRepository.findByID(1L);
        Length L = lengthRepository.findByID(1L);
        MoneyMaximum M = moneyMaximumRepository.findByID(1L);

        a1.setInsurancePremium(I);
        a1.setLength(L);
        a1.setMoneyMaximum(M);
        a1.setTypeName("ประกันผู้ใช้โทรศัพท์");
        a1.setoFName("ประยุทธิ์");
        a1.setoLName("จันโอชา");
        a1.setoTlePhone(null);      //<<<----- Test This Line
        a1.setTypeNameReason("เฉพาะผู้สูงอายุเท่านั้น");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            fail("expected oTlePhoneCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }


    //Test 3 Entity
    @Test
    public void testInsurancePremiumNotNull() {

        InsurancePremium a1 = new InsurancePremium();
        a1.setInsuranceName(null);



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
            System.out.println("InsurancePremiumNotNull");
            System.out.println("==========================");
        }
    }
    @Test
    public void testLengthNotNull() {

        Length a1 = new Length();
        a1.setlengthName(null);



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
            System.out.println("LengthNotNull");
            System.out.println("==========================");
        }
    }
    @Test
    public void testMoneyMaximumNotNull() {

        MoneyMaximum a1 = new MoneyMaximum();
        a1.setmoneyName(null);



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
            System.out.println("MoneyMaximumNotNull");
            System.out.println("==========================");
        }
    }
    @Test
    public void testInsurancePremiumPass() {

        InsurancePremium a1 = new InsurancePremium();
        a1.setInsuranceName("8 บาท ต่อหนึ่งวัน");



        try {
            entityManager.persist(a1);
            entityManager.flush();

            System.out.println("InsurancePremiumPass");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            //System.out.println("styleNameDigitNotEnglish");
            System.out.println("==========================");
        }
    }
    @Test
    public void testLengthPass() {

        Length a1 = new Length();
        a1.setlengthName("1 ปี");



        try {
            entityManager.persist(a1);
            entityManager.flush();

            System.out.println("LengthPass");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            //System.out.println("styleNameDigitNotEnglish");
            System.out.println("==========================");
        }
    }
    @Test
    public void testMoneyMaximumPass() {

        MoneyMaximum a1 = new MoneyMaximum();
        a1.setmoneyName(100000L);



        try {
            entityManager.persist(a1);
            entityManager.flush();

            System.out.println("MoneyMaximumPass");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            //System.out.println("styleNameDigitNotEnglish");
            System.out.println("==========================");
        }
    }


}