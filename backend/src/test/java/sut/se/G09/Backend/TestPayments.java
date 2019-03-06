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
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestPayments {

   @Autowired
   PaymentMethodRepository paymentMethodRepository;

   @Autowired
   PaymentHistoryRepository paymentHistoryRepository;

   @Autowired
   MemberDataRepository memberDataRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testPaymentPass() {
        PaymentHistory pay = new PaymentHistory();
        pay.setCode("ABC12345");
        pay.setCardEXP("03");
        pay.setCardNumber("1234567885");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));


        try {
            entityManager.persist(pay);
            entityManager.flush();
            System.out.println("==========================");
            System.out.println("Test Not Fail");
            System.out.println("==========================");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test
    public void testOverSizeCardNumber() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("ABC12345");
        pay.setCardEXP("03");
        pay.setCardNumber("12345678859");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testOverSizeCardNumber");
            System.out.println("==========================");
        }
    }

    @Test
    public void testLowerSizeCardNumber() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("ABC12345");
        pay.setCardEXP("03");
        pay.setCardNumber("123456785");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testLowerSizeCardNumber");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCardNumberNotBeNum() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("ABC12345");
        pay.setCardEXP("03");
        pay.setCardNumber("12345678A8");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testLowerSizeCardNumber");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCardEXPNotBeNum() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("CS12345L");
        pay.setCardEXP("BC");
        pay.setCardNumber("1234567828");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testLowerSizeCardNumber");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDateNotbeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("ABC12345");
        pay.setCardEXP("03");
        pay.setCardNumber("1234567828");
        pay.setDate(null);
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testDateNotbeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCodeNotbeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode(null);
        pay.setCardEXP("03");
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCodeNotbeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCardEXPNotbeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP(null);
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCardEXPNotbeNull");
            System.out.println("==========================");
        }
    }
    @Test
    public void testCardNotbeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("02");
        pay.setCardNumber(null);
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCardNotbeNull");
            System.out.println("==========================");
        }
    }
    @Test
    public void testAmountNotBeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("02");
        pay.setCardNumber("9912345653");
        pay.setDate(new Date());
        pay.setAmount(null);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testAmountNotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testPaymentMethodNotBeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("02");
        pay.setCardNumber("9912345653");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(null);
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testPaymentMethodNotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testMemberDataNotBeNull() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("02");
        pay.setCardNumber("9912345653");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(null);



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testMemberDataNotBeNull");
            System.out.println("==========================");
        }
    }



    @Test
    public void testCardEXPNotOverSize() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("023");
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCardEXPNotbeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCardEXPNotLowerSize() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("1");
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCardEXPNotLowerSize");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCodeNotLowerSize() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("1234567");
        pay.setCardEXP("01");
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCodeNotLowerSize");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCodeNotOverSize() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("123456789");
        pay.setCardEXP("01");
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCodeNotOverSize");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCodeNotUniq() {

        PaymentHistory pay = new PaymentHistory();
        pay.setCode("12345678");
        pay.setCardEXP("01");
        pay.setCardNumber("1234567818");
        pay.setDate(new Date());
        pay.setAmount(1800L);
        pay.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay.setMemberData(memberDataRepository.findByID(2L));
        entityManager.persist(pay);

        PaymentHistory pay1 = new PaymentHistory();
        pay1.setCode("12345678");
        pay1.setCardEXP("01");
        pay1.setCardNumber("1234567818");
        pay1.setDate(new Date());
        pay1.setAmount(1800L);
        pay1.setPaymentMethod(paymentMethodRepository.findById(2L));
        pay1.setMemberData(memberDataRepository.findByID(2L));



        try {
            entityManager.persist(pay1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("testCodeNotUniq");
            System.out.println("==========================");
        }
    }



//=============================================================================================


}
