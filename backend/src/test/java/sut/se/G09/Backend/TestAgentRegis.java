package sut.se.G09.Backend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
import sut.se.G09.Backend.Entity.AgentRegistration;
import sut.se.G09.Backend.Entity.Category;
import sut.se.G09.Backend.Entity.Educational;
import sut.se.G09.Backend.Entity.Province;
import sut.se.G09.Backend.Repository.AgentRegistrationRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest

public class TestAgentRegis {
    @Autowired private AgentRegistrationRepository agentRegistrationRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDataNamePass() {
        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setlName("พงสุวรรณ");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);




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
    public void testFirstNameCannotBeNull() {


        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName(null);
        a1.setlName("พงสุวรรณ");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected FirstNameCannotBeNull");
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
    public void testFirstNameLengthMustMoreThan1Character() {
        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("A");
        a1.setlName("พงสุวรรณ");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected FirstNameLengthMustMoreThan1Character");
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
    public void testFirstNameLengthMustLessThan30Character() {



        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        a1.setlName("พงสุวรรณ");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected FirstNameLengthMustLessThan30Character");
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
    public void testFirstNameLastNameMustBeUnique() {



        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setiD(1L);
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);

        AgentRegistration a2 = new AgentRegistration();
        a2.setiD(2L);
        a2.setfName("Fffff");
        a2.setlName("Lllll");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);


        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected FirstNameLastNameMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
        }
    }

    @Test
    public void testLastNameLengthMustMoreThan1Character() {
        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setlName("L");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected LastNameLengthMustMoreThan1Character");
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
    public void testLastNameLengthMustLessThan30Character() {
        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);
        a1.setlName("Llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected LastNameLengthMustLessThan30Character");
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
    public void testLastNameCannotBeNull() {
        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setlName(null);
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(cat);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected LastNameCannotBeNull");
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
    public void testEducationCannotBeNull() {

        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setlName("พงสุวรรณ");
        a1.setEducational(null);
        a1.setProvince(pro);
        a1.setCategory(cat);



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
            System.out.println("Education Cannot Be Null");
            System.out.println("==========================");
        }
    }

    @Test
    public void testProvinceCannotBeNull() {

        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setlName("พงสุวรรณ");
        a1.setEducational(edu);
        a1.setProvince(null);
        a1.setCategory(cat);



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
            System.out.println("Provonce Cannot Be Null");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCategoryCannotBeNull() {

        Educational edu = new Educational();
        edu.setID(1L);
        edu.setEduName(".มัธยมศึกษาปีที่ 3");
        edu.getID();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        AgentRegistration a1 = new AgentRegistration();
        a1.setfName("พงศักดิ์");
        a1.setlName("พงสุวรรณ");
        a1.setEducational(edu);
        a1.setProvince(pro);
        a1.setCategory(null);



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
            System.out.println("Category Cannot Be Null");
            System.out.println("==========================");
        }
    }



}
