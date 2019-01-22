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
						   MoneyMaximumRepository moneyMaximumRepository) {
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


		};//<== ระวะันะคะ
	}
}

