package sut.se.G09.Backend;

import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(DiseaseAccidentDataRepository diseaseAccidentDataRepository,
						   DiseaseAccidentLevelRepository diseaseAccidentLevelRepository,
						   DiseaseAccidentTypeRepository diseaseAccidentTypeRepository,
						   MedicalFeeRepository medicalFeeRepository,AgentRegistrationRepository agentRegistrationRepository,
						   CategoryRepository categoryRepository, Educationalrepository educationalrepository
			,ProvinceRepository provinceRepository) {
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
			medicalFeeRepository.save(cost_03);

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

			//================add DiseaseAccidentData : BY ISARA ====================
			//-----DATA------------------------------------
			String s[] ={"โรคหัวใจ","หกล้ม","ไตวาย","แขนขาด"};
			long ty[] = {1,2,1,2};
			long lev[] = {2,1,3,3};
			long mee[] = {5,1,10,11};
			//--------------------------------------------------------
			if(s.length == ty.length && s.length == lev.length && s.length == mee.length) {
				for (int i=0;i<s.length;i++) {
					DiseaseAccidentData data1 = new DiseaseAccidentData();

					data1.setDiseaseAccidentData(s[i]);

					DiseaseAccidentType t = diseaseAccidentTypeRepository.findById(ty[i]);
					data1.setDiseaseAccidentType(t);

					DiseaseAccidentLevel l = diseaseAccidentLevelRepository.findById(lev[i]);
					data1.setDiseaseAccidentLevel(l);

					MedicalFee m = medicalFeeRepository.findById(mee[i]);
					data1.setMedicalFee(m);

					diseaseAccidentDataRepository.save(data1);
				}
			}

			//======================================================================
			//====================By Nattapon=======================================


			Educational Educational =new Educational(); //ระดับการศึกษา
			Educational.setEduName(".มัธยมศึกษาปีที่ 3");
			educationalrepository.save(Educational);
			Educational Educational1 =new Educational();
			Educational1.setEduName(".มัธยมศึกษาปีที่ 6");
			educationalrepository.save(Educational1);
			Educational Educational11 =new Educational();
			Educational11.setEduName(".ประกาศนียบัตรวิชาชีพปี 3");
			educationalrepository.save(Educational11);
			Educational Educational111 =new Educational();
			Educational111.setEduName(".ประกาศนียบัตรวิชาชีพชั้นสูงปี 2");
			educationalrepository.save(Educational111);
			Educational Educational1111 =new Educational();
			Educational1111.setEduName(".ปริญญาตรี");
			educationalrepository.save(Educational1111);
			Educational Educational2 =new Educational();
			Educational2.setEduName(".ปริญญาโท");
			educationalrepository.save(Educational2);
			Educational Educational3 =new Educational();
			Educational3.setEduName(".ปริญญาเอก");
			educationalrepository.save(Educational3);
			//==========================================================

		};
	}
}