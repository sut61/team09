package sut.se.G09.Backend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.sql.Types.NULL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.Date;
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
import sut.se.G09.Backend.Repository.*;


@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestLumpsum {

    @Autowired
    private BusinessSizeRepository businessSizeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private EstablishmentRepository establishmentRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private LumpsumRepository lumpsumRepository;
    @Autowired
    private TestEntityManager entityManager;

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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum(null,100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",null,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,null,"30000");
        lumpsum.setDate(new Date());



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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง",null);
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);

        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());

        Lumpsum lumpsum2 = new Lumpsum();
        lumpsum2.setBusinessSizeId(businessSize);
        lumpsum2.setCategoryId(category);
        lumpsum2.setEstablishmentId(establishment);
        lumpsum2.setProvinceId(province);
        lumpsum2.setLumpsum("A company",200,"101 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","40000");
        lumpsum2.setDate(new Date());


        try {

            entityManager.persist(lumpsum);
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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",2,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",20000000,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"Ab100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","30000");
        lumpsum.setDate(new Date());



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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","123456");
        lumpsum.setDate(new Date());


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

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","1234");
        lumpsum.setDate(new Date());


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


    @Test
    public void BusinessSizeCanBeNull() {

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(null);

        Category category = new Category();
        category = categoryRepository.findByID(2L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","12345");
        lumpsum.setDate(new Date());


        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected BusinessSizeCanBeNull");
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
    public void CategoryCanBeNull() {

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(1L);

        Category category = new Category();
        category = categoryRepository.findByID(null);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(2L);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","12345");
        lumpsum.setDate(new Date());


        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected CategoryCanBeNull");
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
    public void EstablishmentCanBeNull() {

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(2L);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(null);

        Province province = new Province();
        province = provinceRepository.findByID(1L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","12345");
        lumpsum.setDate(new Date());


        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected EstablishmentCanBeNull");
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
    public void ProvinceCanBeNull() {

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(2L);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(3L);

        Province province = new Province();
        province = provinceRepository.findByID(null);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","12345");
        lumpsum.setDate(new Date());


        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected EstablishmentCanBeNull");
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
    public void DateCanBeNull() {

        BusinessSize businessSize = new BusinessSize();
        businessSize = businessSizeRepository.findByID(2L);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Establishment establishment = new Establishment();
        establishment = establishmentRepository.findByID(3L);

        Province province = new Province();
        province = provinceRepository.findByID(21L);



        Lumpsum lumpsum = new Lumpsum();
        lumpsum.setBusinessSizeId(businessSize);
        lumpsum.setCategoryId(category);
        lumpsum.setEstablishmentId(establishment);
        lumpsum.setProvinceId(province);
        lumpsum.setLumpsum("A company",100,"100 หมู่บ้านสุรสวัสดิ์ ต.สุรนารี อ.เมือง","12345");
        lumpsum.setDate(null);


        try {

            entityManager.persist(lumpsum);
            entityManager.flush();
            fail("expected DateCanBeNull");
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
