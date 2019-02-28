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
import javax.validation.constraints.Null;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
//-Dmaven.test.failure.ignore=true
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestClaimData {

    @Autowired
    private ClaimDataRepository claimDataRepository;
    @Autowired
    private MemberDataRepository memberDataRepository;
    @Autowired
    private DiseaseAccidentDataRepository diseaseAccidentDataRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private TreatmentStyleRepository treatmentStyleRepository;


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
public void testCostPass() {
    MemberData memberData = new MemberData();
    memberData = memberDataRepository.findByID(1);

    DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
    diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

    Category category = new Category();
    category = categoryRepository.findByID(1L);

    Hospital hospital = new Hospital();
    hospital =hospitalRepository.findByID(1);

    TreatmentStyle treatmentStyle =new TreatmentStyle();
    treatmentStyle = treatmentStyleRepository.findById(1);

    ClaimData a1 = new ClaimData();

        a1.setCostClaimData(100);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(category);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(treatmentStyle);




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
    public void testCostOverRange() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);

        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(1111111111);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(category);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(treatmentStyle);



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
            System.out.println("CostOverRange");
            System.out.println("==========================");
        }
    }
    @Test
    public void testCostLessRange() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);

        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(9);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(category);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(treatmentStyle);



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
            System.out.println("CostOverRange");
            System.out.println("==========================");
        }
    }

    @Test
    public void testMemberDataCannotNull() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);


        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(900);
        a1.setMemberData(null);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(category);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(treatmentStyle);



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
            System.out.println("MemberDataCannotNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testDiseaseAccidentDataCannotNull() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);


        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(900);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(null);
        a1.setCategory(category);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(treatmentStyle);



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
            System.out.println("DiseaseAccidentDataCannotNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testCategoryCannotNull() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);


        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(900);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(null);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(treatmentStyle);



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
            System.out.println("CategoryCannotNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testHospitalCannotNull() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);


        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(900);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(category);
        a1.setHospital(null);
        a1.setTreatmentStyle(treatmentStyle);



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
            System.out.println("HospitalCannotNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void testTreatmentStyleCannotNull() {

        MemberData memberData = new MemberData();
        memberData = memberDataRepository.findByID(1);


        DiseaseAccidentData diseaseAccidentData = new DiseaseAccidentData();
        diseaseAccidentData = diseaseAccidentDataRepository.findById(1);

        Category category = new Category();
        category = categoryRepository.findByID(1L);

        Hospital hospital = new Hospital();
        hospital =hospitalRepository.findByID(1);

        TreatmentStyle treatmentStyle =new TreatmentStyle();
        treatmentStyle = treatmentStyleRepository.findById(1);

        ClaimData a1 = new ClaimData();

        a1.setCostClaimData(900);
        a1.setMemberData(memberData);
        a1.setDiseaseAccidentData(diseaseAccidentData);
        a1.setCategory(category);
        a1.setHospital(hospital);
        a1.setTreatmentStyle(null);



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
            System.out.println("TreatmentStyleCannotNull ");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_styleNameDigitNotEnglish() {

      TreatmentStyle a1 = new TreatmentStyle();
      a1.setStyleName("sgsdf");



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
            System.out.println("styleNameDigitNotEnglish");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_styleNameNotNull() {

        TreatmentStyle a1 = new TreatmentStyle();
        a1.setStyleName(null);



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
            System.out.println("styleNameNotNull");
            System.out.println("==========================");
        }
    }

    @Test
    public void test_styleNameDigitPass() {

        TreatmentStyle a1 = new TreatmentStyle();
        a1.setStyleName("เทส");



        try {
            entityManager.persist(a1);
            entityManager.flush();

            System.out.println("styleNameDigitPass");
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


//=============================================================================================


}
