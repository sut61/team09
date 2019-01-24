package sut.se.G09.Backend;

import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(DiseaseAccidentDataRepository diseaseAccidentDataRepository,
						   DiseaseAccidentLevelRepository diseaseAccidentLevelRepository,
						   DiseaseAccidentTypeRepository diseaseAccidentTypeRepository,
						   MedicalFeeRepository medicalFeeRepository,CategoryRepository categoryRepository,
						   InsurancePremiumRepository insurancePremiumRepository,
						   LengthRepository lengthRepository,
						   MoneyMaximumRepository moneyMaximumRepository ,AgentRegistrationRepository agentRegistrationRepository, Educationalrepository educationalrepository,
						   DurationAppointmentRepository durationAppointmentRepository, DateAppointmentRepository dateAppointmentRepository, GenderRepository genderRepository
							) {
		return args -> {
			//================add DiseaseAccidentLevel : BY ISARA ====================
			DiseaseAccidentLevel leve1_1 = new DiseaseAccidentLevel();
			leve1_1.setLevelText("ความเสี่ยงต่อชีวิตต่ำ รักษาได้ในระยะสั้น");
			diseaseAccidentLevelRepository.save(leve1_1);

			DiseaseAccidentLevel leve1_2 = new DiseaseAccidentLevel();
			leve1_2.setLevelText("มีความเสี่ยงต่อชีวิต หากไม่รับการรักษา");
			diseaseAccidentLevelRepository.save(leve1_2);

			DiseaseAccidentLevel leve1_3 = new DiseaseAccidentLevel();
			leve1_3.setLevelText("เสี่ยงต่อชีวิตมาก รักษาได้ยาก หรือรักษาไม่ได้");
			diseaseAccidentLevelRepository.save(leve1_3);
			//=========================================================================

			//================add DiseaseAccidentType : BY ISARA ====================
			DiseaseAccidentType typeD00 = new DiseaseAccidentType();
			typeD00.setDiseaseAccidentType("โรค");
			diseaseAccidentTypeRepository.save(typeD00);

			DiseaseAccidentType typeA00 = new DiseaseAccidentType();
			typeA00.setDiseaseAccidentType("อุบัติเหตุ");
			diseaseAccidentTypeRepository.save(typeA00);
			//======================================================================

			//================add MedicalFee : BY ISARA ====================
			MedicalFee cost_01 = new MedicalFee();
			cost_01.setMedicalFee(500);
			medicalFeeRepository.save(cost_01);

			MedicalFee cost_02 = new MedicalFee();
			cost_02.setMedicalFee(800);
			medicalFeeRepository.save(cost_02);

			MedicalFee cost_03 = new MedicalFee();
			cost_03.setMedicalFee(1000);
			medicalFeeRepository.save(cost_01);

			MedicalFee cost_04 = new MedicalFee();
			cost_04.setMedicalFee(1200);
			medicalFeeRepository.save(cost_04);

			MedicalFee cost_05 = new MedicalFee();
			cost_05.setMedicalFee(1500);
			medicalFeeRepository.save(cost_05);

			MedicalFee cost_06 = new MedicalFee();
			cost_06.setMedicalFee(2000);
			medicalFeeRepository.save(cost_06);

			MedicalFee cost_07 = new MedicalFee();
			cost_07.setMedicalFee(2500);
			medicalFeeRepository.save(cost_07);

			MedicalFee cost_08 = new MedicalFee();
			cost_08.setMedicalFee(3000);
			medicalFeeRepository.save(cost_08);

			MedicalFee cost_09 = new MedicalFee();
			cost_09.setMedicalFee(5000);
			medicalFeeRepository.save(cost_09);

			MedicalFee cost_10 = new MedicalFee();
			cost_10.setMedicalFee(8000);
			medicalFeeRepository.save(cost_10);

			MedicalFee cost_11 = new MedicalFee();
			cost_11.setMedicalFee(10000);
			medicalFeeRepository.save(cost_11);
			//=========================================================
			// ======================= morn bap=======================================================
			InsurancePremium InsurancePremium1 = new InsurancePremium();  //เบี้ยประกัน
			InsurancePremium1.setInsuranceName("8 บาท ต่อหนึ่งวัน");
			insurancePremiumRepository.save(InsurancePremium1);
			InsurancePremium InsurancePremium2 = new InsurancePremium();
			InsurancePremium2.setInsuranceName("50 บาท ต่อหนึ่งอาทิตย์");
			insurancePremiumRepository.save(InsurancePremium2);
			InsurancePremium InsurancePremium3 = new InsurancePremium();
			InsurancePremium3.setInsuranceName("200 บาท ต่อหนึ่งเดือน");
			insurancePremiumRepository.save(InsurancePremium3);
			InsurancePremium InsurancePremium4 = new InsurancePremium();
			InsurancePremium4.setInsuranceName("1000 บาท ต่อครึ่งปี");
			insurancePremiumRepository.save(InsurancePremium4);
			InsurancePremium InsurancePremium5 = new InsurancePremium();
			InsurancePremium5.setInsuranceName("2000 บาท ต่อปี");
			insurancePremiumRepository.save(InsurancePremium5);

			Length Length1 = new Length();  //ชดเชยสูงสุด
			Length1.setlengthName("1 ปี");
			lengthRepository.save(Length1);
			Length Length2 = new Length();
			Length2.setlengthName("2 ปี");
			lengthRepository.save(Length2);
			Length Length3 = new Length();
			Length3.setlengthName("3 ปี");
			lengthRepository.save(Length3);
			Length Length4 = new Length();
			Length4.setlengthName("4 ปี");
			lengthRepository.save(Length4);
			Length Length5 = new Length();
			Length5.setlengthName("5 ปี");
			lengthRepository.save(Length5);

			MoneyMaximum MoneyMaximum1 = new MoneyMaximum();
			MoneyMaximum1.setmoneyName(100000L);
			moneyMaximumRepository.save(MoneyMaximum1);
			MoneyMaximum MoneyMaximum2 = new MoneyMaximum();
			MoneyMaximum2.setmoneyName(200000L);
			moneyMaximumRepository.save(MoneyMaximum2);
			MoneyMaximum MoneyMaximum3 = new MoneyMaximum();
			MoneyMaximum3.setmoneyName(400000L);
			moneyMaximumRepository.save(MoneyMaximum3);
			MoneyMaximum MoneyMaximum4 = new MoneyMaximum();
			MoneyMaximum4.setmoneyName(800000L);
			moneyMaximumRepository.save(MoneyMaximum4);
			MoneyMaximum MoneyMaximum5 = new MoneyMaximum();
			MoneyMaximum5.setmoneyName(1000000L);
			moneyMaximumRepository.save(MoneyMaximum5);

			//====================================================


					//==================Nattapon==========================
			Educational Educational =new Educational(); //ระดับการศึกษา
			Educational.setEduName("มัธยมศึกษาปีที่ 3");
			educationalrepository.save(Educational);
			Educational.setEduName("มัธยมศึกษาปีที่ 6");
			educationalrepository.save(Educational);
			Educational.setEduName("ประกาศนียบัตรวิชาชีพปี 3");
			educationalrepository.save(Educational);
			Educational.setEduName("ประกาศนียบัตรวิชาชีพชั้นสูงปี 2");
			educationalrepository.save(Educational);
			Educational.setEduName("ปริญญาตรี");
			educationalrepository.save(Educational);
			Educational.setEduName("ปริญญาโท");
			educationalrepository.save(Educational);
			Educational.setEduName("ปริญญาเอก");
			educationalrepository.save(Educational);


			Category Category = new Category(); //ประเภท
			Category.setId(1L);
			categoryRepository.save(Category);
			Category.setId(2L);
			categoryRepository.save(Category);
			Category.setId(3L);
			categoryRepository.save(Category);
			Category.setId(4L);
			categoryRepository.save(Category);
			Category.setId(5L);
			categoryRepository.save(Category);
			Category.setId(6L);
			categoryRepository.save(Category);
			Category.setId(7L);
			categoryRepository.save(Category);
			Category.setId(8L);
			categoryRepository.save(Category);
			//================================AgentAppointmentSystems=========================================
			DurationAppointment dur1 = new DurationAppointment(1L,"08.00-10.00 น.");
			DurationAppointment dur2 = new DurationAppointment(2L,"10.00-12.00 น.");
			DurationAppointment dur3 = new DurationAppointment(3L,"13.00-15.00 น.");
			DurationAppointment dur4 = new DurationAppointment(4L,"15.00-17.00 น.");
			durationAppointmentRepository.save(dur1);
			durationAppointmentRepository.save(dur2);
			durationAppointmentRepository.save(dur3);
			durationAppointmentRepository.save(dur4);

			Stream.of(1L, 2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,16L,17L,18L,19L,20L,21L,22L,23L,24L,25L
					,26L,27L,28L,29L,30L,31L,32L,33L,34L,35L,36L,37L,38L,39L,40L,41L,42L,43L,44L,45L,46L,47L,48L,49L,50L
					,51L,52L,53L,54L,55L,56L,57L,58L,59L).forEach(dateId -> {
				DateAppointment date = new DateAppointment();
				date.setDateId(dateId);
				if(dateId==1L){date.setDate("1 มกราคม 2562");}
				else if(dateId==2L){date.setDate("2 มกราคม 2562");}
				else if(dateId==3L){date.setDate("3 มกราคม 2562");}
				else if(dateId==4L){date.setDate("4 มกราคม 2562");}
				else if(dateId==5L){date.setDate("5 มกราคม 2562");}
				else if(dateId==6L){date.setDate("6 มกราคม 2562");}
				else if(dateId==7L){date.setDate("7 มกราคม 2562");}
				else if(dateId==8L){date.setDate("8 มกราคม 2562");}
				else if(dateId==9L){date.setDate("9 มกราคม 2562");}
				else if(dateId==10L){date.setDate("10 มกราคม 2562");}
				else if(dateId==11L){date.setDate("11 มกราคม 2562");}
				else if(dateId==12L){date.setDate("12 มกราคม 2562");}
				else if(dateId==13L){date.setDate("13 มกราคม 2562");}
				else if(dateId==14L){date.setDate("14 มกราคม 2562");}
				else if(dateId==15L){date.setDate("15 มกราคม 2562");}
				else if(dateId==16L){date.setDate("16 มกราคม 2562");}
				else if(dateId==17L){date.setDate("17 มกราคม 2562");}
				else if(dateId==18L){date.setDate("18 มกราคม 2562");}
				else if(dateId==19L){date.setDate("19 มกราคม 2562");}
				else if(dateId==20L){date.setDate("20 มกราคม 2562");}
				else if(dateId==21L){date.setDate("21 มกราคม 2562");}
				else if(dateId==22L){date.setDate("22 มกราคม 2562");}
				else if(dateId==23L){date.setDate("23 มกราคม 2562");}
				else if(dateId==24L){date.setDate("24 มกราคม 2562");}
				else if(dateId==25L){date.setDate("25 มกราคม 2562");}
				else if(dateId==26L){date.setDate("26 มกราคม 2562");}
				else if(dateId==27L){date.setDate("27 มกราคม 2562");}
				else if(dateId==28L){date.setDate("28 มกราคม 2562");}
				else if(dateId==29L){date.setDate("29 มกราคม 2562");}
				else if(dateId==30L){date.setDate("30 มกราคม 2562");}
				else if(dateId==31L){date.setDate("31 มกราคม 2562");}
				else if(dateId==32L){date.setDate("1 มกราคม 2562");}
				else if(dateId==33L){date.setDate("2 กุมภาพันธ์ 2562");}
				else if(dateId==34L){date.setDate("3 กุมภาพันธ์ 2562");}
				else if(dateId==35L){date.setDate("4 กุมภาพันธ์ 2562");}
				else if(dateId==36L){date.setDate("5 กุมภาพันธ์ 2562");}
				else if(dateId==37L){date.setDate("6 กุมภาพันธ์ 2562");}
				else if(dateId==38L){date.setDate("7 กุมภาพันธ์ 2562");}
				else if(dateId==39L){date.setDate("8 กุมภาพันธ์ 2562");}
				else if(dateId==40L){date.setDate("9 กุมภาพันธ์ 2562");}
				else if(dateId==41L){date.setDate("10 กุมภาพันธ์ 2562");}
				else if(dateId==42L){date.setDate("11 กุมภาพันธ์ 2562");}
				else if(dateId==43L){date.setDate("12 กุมภาพันธ์ 2562");}
				else if(dateId==44L){date.setDate("13 กุมภาพันธ์ 2562");}
				else if(dateId==45L){date.setDate("14 กุมภาพันธ์ 2562");}
				else if(dateId==46L){date.setDate("15 กุมภาพันธ์ 2562");}
				else if(dateId==47L){date.setDate("16 กุมภาพันธ์ 2562");}
				else if(dateId==48L){date.setDate("17 กุมภาพันธ์ 2562");}
				else if(dateId==49L){date.setDate("18 กุมภาพันธ์ 2562");}
				else if(dateId==50L){date.setDate("19 กุมภาพันธ์ 2562");}
				else if(dateId==51L){date.setDate("20 กุมภาพันธ์ 2562");}
				else if(dateId==52L){date.setDate("21 กุมภาพันธ์ 2562");}
				else if(dateId==53L){date.setDate("22 กุมภาพันธ์ 2562");}
				else if(dateId==54L){date.setDate("23 กุมภาพันธ์ 2562");}
				else if(dateId==55L){date.setDate("24 กุมภาพันธ์ 2562");}
				else if(dateId==56L){date.setDate("25 กุมภาพันธ์ 2562");}
				else if(dateId==57L){date.setDate("26 กุมภาพันธ์ 2562");}
				else if(dateId==58L){date.setDate("27 กุมภาพันธ์ 2562");}
				else if(dateId==59L){date.setDate("28 กุมภาพันธ์ 2562");}
				dateAppointmentRepository.save(date);
			});

			Stream.of(1L, 2L).forEach(genderId -> {
				Gender newGender = new Gender();
				newGender.setGenderId(genderId);
				if(genderId==1L){ newGender.setGenderName("ชาย"); }
				else if(genderId==2L){ newGender.setGenderName("หญิง"); }
				genderRepository.save(newGender);
			});

		};//<== ระวะันะคะ
	}
}

