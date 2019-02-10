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
import sut.se.G09.Backend.Entity.MemberData;
import sut.se.G09.Backend.Repository.DiseaseAccidentDataRepository;

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
public class TestMemberData {

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
public void testMemberDataPass() {
    MemberData a1 = new MemberData();

    a1.setAddess("11aaa");
    a1.setAge(90L);
    a1.setFname("GGG");
    a1.setLname("CCCC");
    a1.setIdCard("1111111111110");


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
    public void testAddessCannotBeNull() {
        MemberData a1 = new MemberData();

        a1.setAddess(null);
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");


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
            System.out.println("AddessCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testFnameCannotBeNull() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname(null);
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");


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
            System.out.println("FnameCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testLnameCannotBeNull() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname(null);
        a1.setIdCard("1111111111110");


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
            System.out.println("LnameCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testIdCardCannotBeNull() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("CCCC");
        a1.setIdCard(null);



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
            System.out.println("testIdCardCannotBeNull");
            System.out.println("==========================");
        }
    }


    @Test
    public void testAgeCannotBeNull() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(null);
        a1.setFname("GGG");
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");



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
            System.out.println("testAgeCannotBeNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testIdCardUnique() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");
        entityManager.persist(a1);

        MemberData a2 = new MemberData();

        a2.setAddess("11aaa");
        a2.setAge(90L);
        a2.setFname("GGG");
        a2.setLname("CCCC");
        a2.setIdCard("1111111111110");


        try {
            entityManager.persist(a2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("IdCardUnique");
            System.out.println("==========================");
        }
    }

    @Test
    public void testIdCardSizenot13() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("CCCC");
        a1.setIdCard("11111111111100");



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
            System.out.println("IdCardSizenot13");
            System.out.println("==========================");
        }
    }

    @Test
    public void testFnameSizless() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("G");
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");



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
            System.out.println("FnameSizless");
            System.out.println("==========================");
        }
    }

    @Test
    public void testLnameSizless() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("C");
        a1.setIdCard("1111111111110");



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
            System.out.println("LnameSizless");
            System.out.println("==========================");
        }
    }

    @Test
    public void testFnameSizOver() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");



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
            System.out.println("FnameSizOver");
            System.out.println("==========================");
        }
    }

    @Test
    public void testLnameSizOver() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        a1.setIdCard("1111111111110");



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
            System.out.println("LnameSizOver");
            System.out.println("==========================");
        }
    }

    @Test
    public void testFnameNotNumber() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG123");
        a1.setLname("CCCC");
        a1.setIdCard("1111111111110");



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
            System.out.println("FnameNotNumber");
            System.out.println("==========================");
        }
    }
    @Test
    public void testLnameNotNumber() {
        MemberData a1 = new MemberData();

        a1.setAddess("11aaa");
        a1.setAge(90L);
        a1.setFname("GGG");
        a1.setLname("CCCC852");
        a1.setIdCard("1111111111110");



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
            System.out.println("LnameNotNumber");
            System.out.println("==========================");
        }
    }
//=============================================================================================


}
