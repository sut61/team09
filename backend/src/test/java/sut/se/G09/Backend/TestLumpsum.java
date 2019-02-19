package sut.se.G09.Backend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.sql.Types.NULL;
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
import sut.se.G09.Backend.Repository.LumpsumRepository;


@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestLumpsum {
    @Autowired private LumpsumRepository lumpsumRepository;
    @Autowired private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //Sprint1---------------------------------------------------------------------------------------------------------------------------------------
    //---------Lumpsum---------

    @Test
    public void testLumpsumPass() {

        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        try {
            entityManager.persist(lumpsum);
            entityManager.flush();
            System.out.println("\n\n\n\n\n\n");
            System.out.println("==========================");
            System.out.println("Test Not Fail");
            System.out.println("==========================");
            System.out.println("\n\n\n\n\n\n");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCompanyNameCannotBeNull() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum(null,100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected CompanyNameCannotBeNull");
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
    public void testAmoungEmpCannotBeNull() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",null,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected AmoungEmpCannotBeNull");
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
    public void testAddressCannotBeNull() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",100,null,"30000");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected AddressCannotBeNull");
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
    public void testZipCodeCannotBeNull() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง",null);

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected ZipCodeCannotBeNull");
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
    public void testCompanyNameMustBeUnique() {
        Lumpsum lumpsum1 = new Lumpsum();
        lumpsum1.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        Lumpsum lumpsum2 = new Lumpsum();
        lumpsum2.setLumpsum("A company",200,"101 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","40000");

        try {

            entityManager.persist(lumpsum1);
            entityManager.flush();
            entityManager.persist(lumpsum2);
            entityManager.flush();

            fail("expected CompanyNameMustBeUnique");
        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("CompanyNameMustBeUnique");
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test
    public void testAmoungEmpLessSize() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",2,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected AmoungEmpLessSize");
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
    public void testAmoungEmpOverSize() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",20000000,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected AmoungEmpOversizeSize");
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
    public void testAddressFirstAlphabetNotInt() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",100,"Ab100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected AddressFirstAlphabetNotInt");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("AddressFirstAlphabetNotInt");
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testZipCodeOversizeSize() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","123456");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected testZipCodeOverSize");
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
    public void testZipCodeLessSize() {
        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","1234");

        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected testZipCodeLessSize");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
