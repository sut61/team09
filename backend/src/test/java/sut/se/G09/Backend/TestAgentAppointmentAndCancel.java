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
import sut.se.G09.Backend.Repository.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestAgentAppointmentAndCancel {

    @Autowired private TestEntityManager entityManager;
    @Autowired private AgentAppointmentRepository agentAppointmentRepository;
    @Autowired private CancelAppointmentReasonRepository cancelAppointmentReasonRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private DateAppointmentRepository dateAppointmentRepository;
    @Autowired private DurationAppointmentRepository durationAppointmentRepository;
    @Autowired private GenderRepository genderRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
//Sprint1---------------------------------------------------------------------------------------------------------------------------------------
    //(@Column unique [5], @NotNull [14], @Pattern [5], @Size [4], Range [2])

    //---------AgentAppointment---------

    @Test //CorrectData
    public void testFirstNameTrue() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
            entityManager.flush();
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println("First name is Correct");
            System.out.println("===========================================================================================================\n\n\n");

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
    public void testAppointmentIdMustBeUnique() {
        AgentAppointment a1 = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a1.setCategory(c);
        a1.setGender(g);
        a1.setProvince(p);
        a1.setDateAppointment(date);
        a1.setDurationAppointment(duration);
        a1.setAppointmentId(1L);    //<<<----- Test This Line
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("1234abcd@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setCategory(c);
        a2.setGender(g);
        a2.setProvince(p);
        a2.setDateAppointment(date);
        a2.setDurationAppointment(duration);
        a2.setAppointmentId(1L);    //<<<----- Test This Line
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234467");
        a2.setEmail("1234abcsd@gmail.com");
        a2.setIdCardNum("1300000000001");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected AppointmentIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("Appointment Id Must Be Unique");
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@NotNull
    public void testFirstNameCannotNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName(null);   //<<<----- Test This Line
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected FirstNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Size
    public void testFirstNameLengthMustMoreThan1Character() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("A");    //<<<----- Test This Line
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
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

    @Test //@Size
    public void testFirstNameLengthMustLessThan30Character() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");    //<<<----- Test This Line
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
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

    @Test //@NotNull
    public void testLastNameCannotNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Fffff");
        a.setlName(null);   //<<<----- Test This Line
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected LastNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Size
    public void testLastNameLengthMustMoreThan1Character() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("L");    //<<<----- Test This Line
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
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

    @Test //@Size
    public void testLastNameLengthMustLessThan30Character() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("Llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");   //<<<----- Test This Line
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
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

    @Test //@Column unique
    public void testIdCardNumMustBeUnique() {
        AgentAppointment a1 = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a1.setCategory(c);
        a1.setGender(g);
        a1.setProvince(p);
        a1.setDateAppointment(date);
        a1.setDurationAppointment(duration);
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("1234abcd@gmail.com");
        a1.setIdCardNum("1300000000000");   //<<<----- Test This Line

        AgentAppointment a2 = new AgentAppointment();
        a2.setCategory(c);
        a2.setGender(g);
        a2.setProvince(p);
        a2.setDateAppointment(date);
        a2.setDurationAppointment(duration);
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801235557");
        a2.setEmail("1234abcsdfg@gmail.com");
        a2.setIdCardNum("1300000000000");   //<<<----- Test This Line

        try {

            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected IdCardNumMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("IdCard Number Must Be Unique");
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@NotNull
    public void testIdCardNumberCannotBeNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum(null);   //<<<----- Test This Line

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected IdCardNumberCannotBeNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Pattern
    public void testIdCardNumberMustBeCorrectPattern() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234578");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1301234567899999"); //<<<----- Test This Line
        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected IdCardNumberNotMoreThan13Characters");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@NotNull
    public void testAgeCannotBeNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Fffff");
        a.setlName("Lllll");
        a.setAge(null);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");   //<<<----- Test This Line

        try {

            entityManager.persist(a);
            entityManager.flush();
            fail("expected AgeCannotBeNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Range
    public void testAgeMustBetween1to80YearsOld() {
        AgentAppointment a1 = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a1.setCategory(c);
        a1.setGender(g);
        a1.setProvince(p);
        a1.setDateAppointment(date);
        a1.setDurationAppointment(duration);
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(90);  //<<<----- Test This Line
        a1.setTelNum("0801234567");
        a1.setEmail("Abcdf.1234@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setCategory(c);
        a2.setGender(g);
        a2.setProvince(p);
        a2.setDateAppointment(date);
        a2.setDurationAppointment(duration);
        a2.setfName("Aaaaa");
        a2.setlName("Bbbbb");
        a2.setAge(0);   //<<<----- Test This Line
        a2.setTelNum("0801234567");
        a2.setEmail("Abcdf00000@gmail.com");
        a2.setIdCardNum("1300000000000");

        try {

            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            fail("expected AgeMustBetween1to80YearsOld");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Pattern
    public void testTelNumMustBeCorrectPattern() {
        AgentAppointment a1 = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a1.setCategory(c);
        a1.setGender(g);
        a1.setProvince(p);
        a1.setDateAppointment(date);
        a1.setDurationAppointment(duration);
        a1.setfName("Aaaaa");
        a1.setlName("Bbbbb");
        a1.setAge(50);
        a1.setTelNum("2801234567"); //<<<----- Test This Line
        a1.setEmail("Abcdf.1234@gmail.com");
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setCategory(c);
        a2.setGender(g);
        a2.setProvince(p);
        a2.setDateAppointment(date);
        a2.setDurationAppointment(duration);
        a2.setfName("Ccccc");
        a2.setlName("Ddddd");
        a2.setAge(40);
        a2.setTelNum("0101234567"); //<<<----- Test This Line
        a2.setEmail("Abcdf.1234@gmail.com");
        a2.setIdCardNum("1300000000001");

        AgentAppointment a3 = new AgentAppointment();
        a3.setCategory(c);
        a3.setGender(g);
        a3.setProvince(p);
        a3.setDateAppointment(date);
        a3.setDurationAppointment(duration);
        a3.setfName("Eeeee");
        a3.setlName("Fffff");
        a3.setAge(30);
        a3.setTelNum("1301234567"); //<<<----- Test This Line
        a3.setEmail("Abcdf.1234@gmail.com");
        a3.setIdCardNum("1300000000002");

        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            entityManager.persist(a3);
            entityManager.flush();

            fail("expected TelNumMustBeCorrectPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@Pattern
    public void testEmailMustBeCorrectPattern() {
        AgentAppointment a1 = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a1.setCategory(c);
        a1.setGender(g);
        a1.setProvince(p);
        a1.setDateAppointment(date);
        a1.setDurationAppointment(duration);
        a1.setfName("Fffff");
        a1.setlName("Lllll");
        a1.setAge(50);
        a1.setTelNum("0801234567");
        a1.setEmail("12+34_abc@gmail.com"); //<<<----- Test This Line
        a1.setIdCardNum("1300000000000");

        AgentAppointment a2 = new AgentAppointment();
        a2.setCategory(c);
        a2.setGender(g);
        a2.setProvince(p);
        a2.setDateAppointment(date);
        a2.setDurationAppointment(duration);
        a2.setfName("Allll");
        a2.setlName("Bbbbb");
        a2.setAge(40);
        a2.setTelNum("0801234567");
        a2.setEmail("123456abc@gmail_com"); //<<<----- Test This Line
        a2.setIdCardNum("1300000000001");

        AgentAppointment a3 = new AgentAppointment();
        a3.setCategory(c);
        a3.setGender(g);
        a3.setProvince(p);
        a3.setDateAppointment(date);
        a3.setDurationAppointment(duration);
        a3.setfName("Ddddd");
        a3.setlName("Ccccc");
        a3.setAge(50);
        a3.setTelNum("0801234567");
        a3.setEmail("123456abc@Gmail.com"); //<<<----- Test This Line
        a3.setIdCardNum("1300000000002");

        AgentAppointment a4 = new AgentAppointment();
        a4.setCategory(c);
        a4.setGender(g);
        a4.setProvince(p);
        a4.setDateAppointment(date);
        a4.setDurationAppointment(duration);
        a4.setfName("Eeeee");
        a4.setlName("Ttttt");
        a4.setAge(20);
        a4.setTelNum("0801234567");
        a4.setEmail("123456abc.Gmail.com"); //<<<----- Test This Line
        a4.setIdCardNum("1300000000002");
        try {
            entityManager.persist(a1);
            entityManager.flush();
            entityManager.persist(a2);
            entityManager.flush();
            entityManager.persist(a3);
            entityManager.flush();
            entityManager.persist(a4);
            entityManager.flush();

            fail("expected EmailMustBeCorrectPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //---------Gender---------
    @Test //@Column unique
    public void testGenderIdMustBeUnique() {
        Gender g1 = new Gender();
        g1.setGenderId(1L);     //<<<----- Test This Line
        g1.setGenderName("ชาย");

        Gender g2 = new Gender();
        g2.setGenderId(1L);     //<<<----- Test This Line
        g2.setGenderName("หญิง");

        try {

            entityManager.persist(g1);
            entityManager.flush();
            entityManager.persist(g2);
            entityManager.flush();
            fail("expected GenderIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@NotNull
    public void testGenderCannotNull() {
        Gender g = new Gender();
        g.setGenderName(null);  //<<<----- Test This Line

        try {

            entityManager.persist(g);
            entityManager.flush();
            fail("expected GenderCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //---------DateAppointment---------
    @Test //@Column unique
    public void testDateIdMustBeUnique() {
        DateAppointment d1 = new DateAppointment();
        d1.setDateId(1L);   //<<<----- Test This Line
        d1.setDate("1 พฤษภาคม 2562");
        d1.setCount(1);
        d1.setStatus("available");

        DateAppointment d2 = new DateAppointment();
        d2.setDateId(1L);   //<<<----- Test This Line
        d2.setDate("2 พฤษภาคม 2562");
        d2.setCount(2);
        d2.setStatus("available");
        try {

            entityManager.persist(d1);
            entityManager.flush();
            entityManager.persist(d2);
            entityManager.flush();
            fail("expected DateIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@NotNull
    public void testDateCannotNull() {
        DateAppointment d = new DateAppointment();
        d.setDate(null);    //<<<----- Test This Line
        d.setCount(2);
        d.setStatus("available");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@NotNull
    public void testDateCountCannotNull() {
        DateAppointment d = new DateAppointment();
        d.setDate("2 พฤษภาคม 2562");
        d.setCount(null);       //<<<----- Test This Line
        d.setStatus("available");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateCountCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Range
    public void testDateCountLimitAt4() {
        DateAppointment d = new DateAppointment();
        d.setDate("13 เมษายน 2562");
        d.setCount(5);  //<<<----- Test This Line
        d.setStatus("full");

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateCountLimitAt4");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@NotNull
    public void testDateStatusCannotNull() {
        DateAppointment d = new DateAppointment();
        d.setDate("13 เมษายน 2562");
        d.setCount(2);
        d.setStatus(null);  //<<<----- Test This Line

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateStatusCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Pattern
    public void testDateStatusMustBeLowCaseCharacter() {
        DateAppointment d = new DateAppointment();
        d.setDate("13 เมษายน 2562");
        d.setCount(2);
        d.setStatus("AvaiLaBLe");   //<<<----- Test This Line

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DateStatusMustBeLowCaseCharacter");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //---------DurationAppointment---------
    @Test //@Column unique
    public void testDurationIdMustBeUnique() {
        DurationAppointment d1 = new DurationAppointment();
        d1.setDurationId(1L);     //<<<----- Test This Line
        d1.setDuration("08.00-10.00 น.");

        DurationAppointment d2 = new DurationAppointment();
        d2.setDurationId(1L);     //<<<----- Test This Line
        d2.setDuration("10.00-12.00 น.");

        try {

            entityManager.persist(d1);
            entityManager.flush();
            entityManager.persist(d2);
            entityManager.flush();
            fail("expected DurationIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@NotNull
    public void testDurationCannotNull() {
        DurationAppointment d = new DurationAppointment();
        d.setDuration(null);    //<<<----- Test This Line

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DurationCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Pattern
    public void testDurationMustBeCorrectPattern() {
        DurationAppointment d = new DurationAppointment();
        d.setDuration("8 - 10 น."); //<<<----- Test This Line

        try {

            entityManager.persist(d);
            entityManager.flush();
            fail("expected DurationMustBeCorrectPattern");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //---------Mapping---------------------------------------------------------------------------------------------------------------
    @Test //@NotNull
    public void testCategoryMappingCannotNull() {
        AgentAppointment a = new AgentAppointment();
        //Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(null);   //<<<----- Test This Line
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected CategoryMappingCannotNull");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@NotNull
    public void testGenderMappingCannotNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        //Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(null);  //<<<----- Test This Line
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected GenderMappingCannotNull");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@NotNull
    public void testProvinceMappingCannotNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        //Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(null);    //<<<----- Test This Line
        a.setDateAppointment(date);
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected ProvinceMappingCannotNull");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@NotNull
    public void testDateAppointmentMappingCannotNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        //DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(null);     //<<<----- Test This Line
        a.setDurationAppointment(duration);
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected DateAppointmentMappingCannotNull");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@NotNull
    public void testDurationAppointmentMappingCannotNull() {
        AgentAppointment a = new AgentAppointment();
        Category c = categoryRepository.findByTypeName("ประกันวัยทอง");
        Gender g = genderRepository.findByGenderName("ชาย");
        Province p = provinceRepository.findByProvinceName("กรุงเทพมหานคร");
        DateAppointment date = dateAppointmentRepository.findByDate("1 เมษายน 2562");
        //DurationAppointment duration = durationAppointmentRepository.findByDuration("08.00-10.00 น.");

        a.setCategory(c);
        a.setGender(g);
        a.setProvince(p);
        a.setDateAppointment(date);
        a.setDurationAppointment(null);     //<<<----- Test This Line
        a.setfName("Aaaaa");
        a.setlName("Lllll");
        a.setAge(50);
        a.setTelNum("0801234567");
        a.setEmail("Abcdf.1234@gmail.com");
        a.setIdCardNum("1300000000000");

        try {
            entityManager.persist(a);
            entityManager.flush();

            fail("expected DurationAppointmentMappingCannotNull");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

//Sprint2=============================================================================================================================================
    //(@Column unique [2], @NotNull [4], @Pattern [1], @Size [3], @Length [1])

    //------CancelAppointmentHistory------

    @Test //@Column unique
    public void testCancelAppointmentHistoryIdMustBeUnique() {
        CancelAppointmentHistory c1 = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c1.setCancelAppointmentReason(r);
        c1.setCancelId(1L);     //<<<----- Test This Line
        c1.setIdCardNum("1300000000000");
        c1.setfName("Fffff");
        c1.setlName("Lllll");

        CancelAppointmentHistory c2 = new CancelAppointmentHistory();
        c2.setCancelAppointmentReason(r);
        c2.setCancelId(1L);     //<<<----- Test This Line
        c2.setIdCardNum("1300000000001");
        c2.setfName("Aaaaa");
        c2.setlName("Sssss");
        try {

            entityManager.persist(c1);
            entityManager.flush();
            entityManager.persist(c2);
            entityManager.flush();
            fail("expected CancelAppointmentHistoryIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("CancelAppointmentHistory Id Must Be Unique");
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@NotNull
    public void testCancelIdCardNumberCannotNull() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c.setCancelAppointmentReason(r);
        c.setIdCardNum(null);   //<<<----- Test This Line
        c.setfName("Fffff");
        c.setlName("Lllll");

        try {

            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelIdCardNumberCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Pattern
    public void testCancelIdCardNumberMustBeCorrectPattern() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c.setCancelAppointmentReason(r);
        c.setIdCardNum("13000000000000000");    //<<<----- Test This Line
        c.setfName("Fffff");
        c.setlName("Lllll");
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("expected CancelIdCardNumberMustBeCorrectPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@Notnull
    public void testCancelFirstNameCannotNull() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c.setCancelAppointmentReason(r);
        c.setIdCardNum("1300000000000");
        c.setfName(null);   //<<<----- Test This Line
        c.setlName("Lllll");
        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelFirstNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test //@Length
    public void testCancelFirstNameLengthMustBetween2to30Characters() {
        CancelAppointmentHistory c1 = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c1.setCancelAppointmentReason(r);
        c1.setIdCardNum("1300000000000");
        c1.setfName("Fffffffffffffffffffffffffffffffffffffffffffffff");     //<<<----- Test This Line
        c1.setlName("Lllll");

        CancelAppointmentHistory c2 = new CancelAppointmentHistory();
        c2.setCancelAppointmentReason(r);
        c2.setIdCardNum("1300000000001");
        c2.setfName("F");   //<<<----- Test This Line
        c1.setlName("Aaaaa");
        try {
            entityManager.persist(c1);
            entityManager.flush();
            entityManager.persist(c2);
            entityManager.flush();
            fail("expected CancelFirstNameLengthMustBetween2to30Characters");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@NotNull
    public void testCancelLastNameCannotNull() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c.setCancelAppointmentReason(r);
        c.setIdCardNum("1300000000000");
        c.setfName("Fffff");
        c.setlName(null);   //<<<----- Test This Line
        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("expected CancelLastNameCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Size
    public void testCancelLastNameLengthMustMoreThan1Character() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c.setCancelAppointmentReason(r);
        c.setIdCardNum("1300000000000");
        c.setfName("Fffff");
        c.setlName("L");    //<<<----- Test This Line
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("expected CancelLastNameLengthMustMoreThan1Character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test //@Size
    public void testCancelLastNameLengthMustLessThan30Characters() {
        CancelAppointmentHistory c = new CancelAppointmentHistory();
        CancelAppointmentReason r = cancelAppointmentReasonRepository.findByReason("ติดธุระด่วน");
        c.setCancelAppointmentReason(r);
        c.setIdCardNum("1300000000000");
        c.setfName("Fffff");
        c.setlName("Lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");  //<<<----- Test This Line
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("expected CancelLastNameLengthMustLessThan30Characters");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //-------------CancelAppointmentReason--------------
    @Test //@Column unique
    public void testCancelAppointmentReasonIdMustBeUnique() {
        CancelAppointmentReason r1 = new CancelAppointmentReason();
        r1.setReasonId(1L);     //<<<----- Test This Line
        r1.setReason("ไปไหนก็ได้");

        CancelAppointmentReason r2 = new CancelAppointmentReason();
        r2.setReasonId(1L);     //<<<----- Test This Line
        r2.setReason("ไปธุระที่ดาวอังคาร");
        try {

            entityManager.persist(r1);
            entityManager.flush();
            entityManager.persist(r2);
            entityManager.flush();
            fail("expected CancelAppointmentReasonIdMustBeUnique");

        } catch(javax.persistence.PersistenceException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("CancelAppointmentHistory Id Must Be Unique");
            System.out.println("===========================================================================================================\n\n\n");

        }
    }

    @Test //@Notnull
    public void testCancelReasonCannotNull() {
        CancelAppointmentReason r = new CancelAppointmentReason();
        r.setReason(null);  //<<<----- Test This Line

        try {

            entityManager.persist(r);
            entityManager.flush();
            fail("expected DurationCannotNull");

        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println("\n\n\n===========================================================================================================");
            System.out.println(e.getMessage());
            System.out.println("===========================================================================================================\n\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //@Size
    public void testCancelReasonLengthMustLessThan50Character() {
        CancelAppointmentReason r = new CancelAppointmentReason();
        r.setReason("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");  //<<<----- Test This Line

        try {

            entityManager.persist(r);
            entityManager.flush();
            fail("expected CancelReasonLengthMustLessThan50Character");

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