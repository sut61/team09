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
public class TestCancelInsurance {

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
    public void testDataPass() {  //ข้อมูลผ่าน
        CancelInsurance a1 = new CancelInsurance();

        a1.setIdCard("1202000068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัตยา");
        a1.seteMail("mornblackboom@gmail.com");
        a1.setTlePhone("0927373056");

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

    /*BeNull*/
    @Test
    public void testDataIdCardCannotBeNull() { ///รหัสประจำตัวประชาชนห้ามเป็นค่าว่าง
        CancelInsurance a1 = new CancelInsurance();

        a1.setIdCard(null);
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัตยา");
        a1.seteMail("mornblackboom@gmail.com");
        a1.setTlePhone("0927373056");

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
    public void testDataFristNameCannotBeNull() {
        CancelInsurance a1 = new CancelInsurance();

        a1.setIdCard("1230200068195");
        a1.setfName(null);
        a1.setlName("สัตยา");
        a1.seteMail("mornblackboom@gmail.com");
        a1.setTlePhone("0927373056");

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
    public void testDataLastNameCannotBeNull() {
        CancelInsurance a1 = new CancelInsurance();

        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName(null);
        a1.seteMail("mornblackboom@gmail.com");
        a1.setTlePhone("0927373056");

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
    public void testDataEmailCannotBeNull() {
        CancelInsurance a1 = new CancelInsurance();

        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail(null);
        a1.setTlePhone("0927373056");

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

    /*Beunique*/
    @Test
    public void testCancelInsuranceIdCardBeUnique() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setTlePhone("0927373056");
        a1.seteMail("1234abcd@gmail.com");

        CancelInsurance a2 = new CancelInsurance();
        a2.setIdCard("1230200068195");
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setTlePhone("0801234467");
        a2.seteMail("9874abcsd@gmail.com");

        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected testCancelInsuranceIdCardBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }
    @Test
    public void testCancelInsuranceEmailBeUnique() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setTlePhone("0927373056");
        a1.seteMail("1234abcd@gmail.com");
        entityManager.persist(a1);

        CancelInsurance a2 = new CancelInsurance();
        a2.setIdCard("1230200078962");
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setTlePhone("0836096779");
        a2.seteMail("1234abcd@gmail.com");
        try {
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected testCancelInsuranceTlePhoneBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n============================================================================");
            System.out.println(e.getMessage());
            System.out.println("=============================================================================\n\n\n");
        }
    }
    @Test
    public void testCancelInsuranceTlePhoneBeUnique() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setTlePhone("0927373056");
        a1.seteMail("1234abcd@gmail.com");
        entityManager.persist(a1);

        CancelInsurance a2 = new CancelInsurance();
        a2.setIdCard("1230200078962");
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setTlePhone("0927373056");
        a2.seteMail("9876abcd@gmail.com");
        try {
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected testCancelInsuranceTlePhoneBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n============================================================================");
            System.out.println(e.getMessage());
            System.out.println("============================================================================\n\n\n");

        }
    }

    /*NotNumber*/
    @Test
    public void testDataFirstNameFirstNotNumber() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("1นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmai.com");
        a1.setTlePhone("0927373056");

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
    public void testDataLastNameFirstNotNumber() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("1สัยยา");
        a1.seteMail("abcdef@gmai.com");
        a1.setTlePhone("0927373056");

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

    /*CannotConsonant*/
    @Test
    public void testDataTlePhoneCannotConsonant() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("123a2v0068r95");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmai.com");
        a1.setTlePhone("0927373056");

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
    public void testDataIdCardCannotConsonant() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("123a2v0068r95");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmai.com");
        a1.setTlePhone("0923trew053");

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
            assertEquals(violations.size(), 3);
        }
    }

    /*CannotConsonant*/
    @Test
    public void testIdCardSizeMaxHave13() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("123020006819567890123456789");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927373056");
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
    public void testIdCardSizeMinHave13() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("12302000");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927373056");
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
    public void testFirstNameSizeMaxHave20() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์พดพพดพดพดพดพพพพพพดพดพดพดพดพดพดพดพดพพดพด");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927373056");
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
    public void testFirstNameSizeMinHave2() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("น");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927373056");
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
    public void testLastNameSizeMaxHave20() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยายสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยสยส");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927373056");
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
    public void testLastNameSizeMinHave2() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("ส");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927373056");
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
    public void testTlePhoneSizeMinHave10() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัตยา");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("0927");
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
    public void testTlePhoneSizeMaxHave10() {
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัตยา");
        a1.seteMail("abcdef@gmail.com");
        a1.setTlePhone("09273730567890123456789");
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
}