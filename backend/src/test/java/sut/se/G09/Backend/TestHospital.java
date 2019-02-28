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
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.HospitalRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest

public class TestHospital {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testHosNamePass() {

        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("โรงพยาบาลพระ");
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(size);


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
    public void testHosNameCannotBeNull() {
        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName(null);
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(size);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected HosNameCannotBeNull");
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
    public void testHosNameLengthMustMoreThan1Character() {
        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("A");
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(size);


        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected HosNameLengthMustMoreThan1Character");
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
    public void testHosNameLengthMustLessThan30Character() {
        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(size);

        try {
            entityManager.persist(a1);
            entityManager.flush();

            fail("expected HosNameLengthMustLessThan30Character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test//(expected=javax.persistence.PersistenceException.class)
    public void testHosNameUnique() {
        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("โรงพยาบาลยันฮอย");
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(size);



        Hospital a2 = new Hospital();
        a2.setHosName("โรงพยาบาลยันฮอย");
        a2.setAgentRegistration(ag);
        a2.setCategory(cat);
        a2.setProvince(pro);
        a2.setHospitalSize(size);



        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
            System.out.println("Hospital not Unique");
            System.out.println("==========================");
        }
    }
    @Test
    public void testAgentregistrationCannotBeNull() {

        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("โรงพยาบาลยันฮอย");
        a1.setAgentRegistration(null);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(size);



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
            System.out.println("Agent Cannot Be Null");
            System.out.println("==========================");
        }
    }
    @Test
    public void testCategoryCannotBeNull() {

        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("โรงพยาบาลยันฮอย");
        a1.setAgentRegistration(ag);
        a1.setCategory(null);
        a1.setProvince(pro);
        a1.setHospitalSize(size);



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
    @Test
    public void testProvinceCannotBeNull() {

        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("โรงพยาบาลยันฮอย");
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(null);
        a1.setHospitalSize(size);


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
            System.out.println("Province Cannot Be Null");
            System.out.println("==========================");
        }
    }
    @Test
    public void testHospitalSizeCannotBeNull() {

        AgentRegistration ag = new AgentRegistration();
        ag.setiD(1L);
        ag.setfName("พอเพียง");
        ag.setlName("คนเดิม");
        ag.getID();

        Category cat = new Category();
        cat.setId(1L);
        cat.setTypeName("ประกันผู้สูงอายุ");
        cat.getId();

        Province pro = new Province();
        pro.setID(1L);
        pro.setProvinceName("กรุงเทพมหานคร");
        pro.getID();

        HospitalSize size = new HospitalSize();
        size.setID(1L);
        size.setHosSize("ขนาดเล็ก");
        size.getID();

        Hospital a1 = new Hospital();
        a1.setHosName("โรงพยาบาลยันฮอย");
        a1.setAgentRegistration(ag);
        a1.setCategory(cat);
        a1.setProvince(pro);
        a1.setHospitalSize(null);


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

}
