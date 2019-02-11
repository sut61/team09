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
    public void testDataFristNameCannotBeNull() { ///รหัสประจำตัวประชาชนห้ามเป็นค่าว่าง
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
    public void testDataLastNameCannotBeNull() { ///รหัสประจำตัวประชาชนห้ามเป็นค่าว่าง
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
    public void testDataEmailCannotBeNull() { ///รหัสประจำตัวประชาชนห้ามเป็นค่าว่าง
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
    @Test
    public void testDataTlephoneNumberCannotBeNull() { ///รหัสประจำตัวประชาชนห้ามเป็นค่าว่าง
        CancelInsurance a1 = new CancelInsurance();

        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmai.com");
        a1.setTlePhone(null);

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
    public void testDataPhoneNumberCannotConsonant() { ///เบอร์โทรศัพท์
        CancelInsurance a1 = new CancelInsurance();
        a1.setIdCard("1230200068195");
        a1.setfName("นันทวัฒน์");
        a1.setlName("สัยยา");
        a1.seteMail("abcdef@gmai.com");
        a1.setTlePhone("092957abxd");

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
        CancelInsurance a1 = new CancelInsurance();
        a1.setfName("5นันทวัฒน์");
        a1.setlName("สัตยา");

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
    
}