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
						   MedicalFeeRepository medicalFeeRepository,AgentRegistrationRepository agentRegistrationRepository,
						   CategoryRepository categoryRepository,
						   ReasonMemberRepository reasonMemberRepository,Educationalrepository educationalrepository,
						   ProvinceRepository provinceRepository, InsurancePremiumRepository insurancePremiumRepository,
						   LengthRepository lengthRepository, MoneyMaximumRepository moneyMaximumRepository,
						   BusinessSizeRepository businessSizeRepository, EstablishmentRepository establishmentRepository,
						   DurationAppointmentRepository durationAppointmentRepository, DateAppointmentRepository dateAppointmentRepository,
						   GenderRepository genderRepository,CancelAppointmentReasonRepository cancelAppointmentReasonRepository,HospitalRepository hospitalRepository,
						   HospitalSizeRepository hospitalSizeRepository ,EMDataRepository emDataRepository,TreatmentStyleRepository treatmentStyleRepository,
						   ContactRepository contactRepository,LumpsumRepository lumpsumRepository) {
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

			//================add treatmentStyle : BY ISARA ====================
			String ts[]={
					"ผ่าตัด","เข้าเฝือก","เย็บแผล","กายภาพ","ให้คลีโม","ฟอกไต","ดามกระดูก","นอนพักที่โรงพยาบาล",
					"ฉายรังสี","ใช้ยาแผนปัจจุบัน","ใช้ยาแผนโบราณ",
			};
			for(int i=0;i<ts.length;i++) {
				TreatmentStyle treatmentStyle = new TreatmentStyle();
				treatmentStyle.setStyleName(ts[i]);
				treatmentStyleRepository.save(treatmentStyle);
			}

			//=========================================================================


			//================add DiseaseAccidentType : BY ISARA ====================
			DiseaseAccidentType typeD00 = new DiseaseAccidentType();
			typeD00.setDiseaseAccidentType("โรค");
			diseaseAccidentTypeRepository.save(typeD00);

			DiseaseAccidentType typeA00 = new DiseaseAccidentType();
			typeA00.setDiseaseAccidentType("อุบัติเหตุ");
			diseaseAccidentTypeRepository.save(typeA00);
			//======================================================================

			String emU[]={
					"tt","admin"
			};

			String emP[]={
					"t","1234"
			};

			for(int i=0;i<emU.length;i++) {
				EMData em = new EMData();
				em.setUserName(emU[i]);
				em.setPassword(emP[i]);
				emDataRepository.save(em);
			}
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

			//==================Morn====================================
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

			ReasonMember ReasonMember1 = new ReasonMember();  //เหตุผลในการยกเลิก
			ReasonMember1.setReasonMemberName("ไม่จำเป็น");
			reasonMemberRepository.save(ReasonMember1);
			ReasonMember ReasonMember2 = new ReasonMember();  //เหตุผลในการยกเลิก
			ReasonMember2.setReasonMemberName("ค่าใช้จ่ายสูงเกินไป");
			reasonMemberRepository.save(ReasonMember2);
			ReasonMember ReasonMember3 = new ReasonMember();  //เหตุผลในการยกเลิก
			ReasonMember3.setReasonMemberName("ตกงาน ทำให้ไม่มีตังจ่าย");
			reasonMemberRepository.save(ReasonMember3);
			ReasonMember ReasonMember4 = new ReasonMember();  //เหตุผลในการยกเลิก
			ReasonMember4.setReasonMemberName("เสียชีวิต");
			reasonMemberRepository.save(ReasonMember4);
			ReasonMember ReasonMember5 = new ReasonMember();  //เหตุผลในการยกเลิก
			ReasonMember5.setReasonMemberName("ไม่ขอระบุ");
			reasonMemberRepository.save(ReasonMember5);
			
			String typeName[] = {"ประกันผู้สูงอายุ","ประกันนักเรียน","ประกันนักศึกษา","ประกันวัยทอง"};
				long insuranceName[]  = {1,2,3,4};
				long lengthName[] = {4,3,2,1};
				long moneyName[] = {3,2,1,4};


			for (int i=0;i<s.length;i++) {
				InsurancePremium insurancePremiums = insurancePremiumRepository.findByID(insuranceName[i]);
				Length lengthnames = lengthRepository.findByID(lengthName[i]);
				MoneyMaximum moneynames = moneyMaximumRepository.findByID(moneyName[i]);
				Category newCategory = new Category();
				newCategory.setTypeName(typeName[i]);
				newCategory.setDate(new Date());
				newCategory.setInsurancePremium(insurancePremiums);
				newCategory.setLength(lengthnames);
				newCategory.setMoneyMaximum(moneynames);
				categoryRepository.save(newCategory);
			}
			//====================================morn=============================
			Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร", "ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี",
					"ชัยนาท","ชัยภูมิ", "ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม",
					"นครพนม","นครราชสีมา","นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์",
					"ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก",
					"เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน","ยะลา","ยโสธร",
					"ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา",
					"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี",
					"สุราษฎร์ธานี","สุรินทร์","หนองคาย","หนองบัวลำภู","อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์",
					"อุบลราชธานี","อำนาจเจริญ").forEach(NameProvince ->{

				Province province = new Province();
				province.setProvinceName(NameProvince);
				provinceRepository.save(province);
			});

			Stream.of("ธุรกิจขนาดเล็ก","ธุรกิจขนาดกลาง","ธุรกิจขนาดใหญ่").forEach(Size ->{
				BusinessSize businessSize = new BusinessSize();
				businessSize.setSize(Size);
				businessSizeRepository.save(businessSize);
			});

			Stream.of("ส่วนบุคคล","ห้างหุ้นส่วนสามัญนิติบุคคลหรือห้างหุ้นส่วนจำกัด","บริษัทจำกัดหรือบริษัทจำกัด (มหาชน)","ส่วนราชการหรือรัฐวิสาหกิจ","สหกรณ์").forEach(EstabName ->{
				Establishment establishment = new Establishment();
				establishment.setEstabName(EstabName);
				establishmentRepository.save(establishment);
			});
//================================================== AgentAppointment & Cancel ============================================================
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
				if(dateId==1L){date.setDate("1 มีนาคม 2562");}
				else if(dateId==2L){date.setDate("2 มีนาคม 2562");date.setCount(4);date.setStatus("full");}
				else if(dateId==3L){date.setDate("3 มีนาคม 2562");date.setCount(3);}
				else if(dateId==4L){date.setDate("4 มีนาคม 2562");date.setCount(3);}
				else if(dateId==5L){date.setDate("5 มีนาคม 2562");date.setCount(4);date.setStatus("full");}
				else if(dateId==6L){date.setDate("6 มีนาคม 2562");date.setCount(4);date.setStatus("full");}
				else if(dateId==7L){date.setDate("7 มีนาคม 2562");}
				else if(dateId==8L){date.setDate("8 มีนาคม 2562");}
				else if(dateId==9L){date.setDate("9 มีนาคม 2562");}
				else if(dateId==10L){date.setDate("10 มีนาคม 2562");}
				else if(dateId==11L){date.setDate("11 มีนาคม 2562");}
				else if(dateId==12L){date.setDate("12 มีนาคม 2562");}
				else if(dateId==13L){date.setDate("13 มีนาคม 2562");}
				else if(dateId==14L){date.setDate("14 มีนาคม 2562");}
				else if(dateId==15L){date.setDate("15 มีนาคม 2562");}
				else if(dateId==16L){date.setDate("16 มีนาคม 2562");}
				else if(dateId==17L){date.setDate("17 มีนาคม 2562");}
				else if(dateId==18L){date.setDate("18 มีนาคม 2562");}
				else if(dateId==19L){date.setDate("19 มีนาคม 2562");}
				else if(dateId==20L){date.setDate("20 มีนาคม 2562");}
				else if(dateId==21L){date.setDate("21 มีนาคม 2562");}
				else if(dateId==22L){date.setDate("22 มีนาคม 2562");}
				else if(dateId==23L){date.setDate("23 มีนาคม 2562");}
				else if(dateId==24L){date.setDate("24 มีนาคม 2562");}
				else if(dateId==25L){date.setDate("25 มีนาคม 2562");}
				else if(dateId==26L){date.setDate("26 มีนาคม 2562");}
				else if(dateId==27L){date.setDate("27 มีนาคม 2562");}
				else if(dateId==28L){date.setDate("28 มีนาคม 2562");}
				else if(dateId==29L){date.setDate("29 มีนาคม 2562");}
				else if(dateId==30L){date.setDate("30 มีนาคม 2562");}
				else if(dateId==31L){date.setDate("31 มีนาคม 2562");}
				else if(dateId==32L){date.setDate("1 เมษายน 2562");}
				else if(dateId==33L){date.setDate("2 เมษายน 2562");}
				else if(dateId==34L){date.setDate("3 เมษายน 2562");}
				else if(dateId==35L){date.setDate("4 เมษายน 2562");}
				else if(dateId==36L){date.setDate("5 เมษายน 2562");}
				else if(dateId==37L){date.setDate("6 เมษายน 2562");}
				else if(dateId==38L){date.setDate("7 เมษายน 2562");}
				else if(dateId==39L){date.setDate("8 เมษายน 2562");}
				else if(dateId==40L){date.setDate("9 เมษายน 2562");}
				else if(dateId==41L){date.setDate("10 เมษายน 2562");}
				else if(dateId==42L){date.setDate("11 เมษายน 2562");}
				else if(dateId==43L){date.setDate("12 เมษายน 2562");}
				else if(dateId==44L){date.setDate("13 เมษายน 2562");}
				else if(dateId==45L){date.setDate("14 เมษายน 2562");}
				else if(dateId==46L){date.setDate("15 เมษายน 2562");}
				else if(dateId==47L){date.setDate("16 เมษายน 2562");}
				else if(dateId==48L){date.setDate("17 เมษายน 2562");}
				else if(dateId==49L){date.setDate("18 เมษายน 2562");}
				else if(dateId==50L){date.setDate("19 เมษายน 2562");}
				else if(dateId==51L){date.setDate("20 เมษายน 2562");}
				else if(dateId==52L){date.setDate("21 เมษายน 2562");}
				else if(dateId==53L){date.setDate("22 เมษายน 2562");}
				else if(dateId==54L){date.setDate("23 เมษายน 2562");}
				else if(dateId==55L){date.setDate("24 เมษายน 2562");}
				else if(dateId==56L){date.setDate("25 เมษายน 2562");}
				else if(dateId==57L){date.setDate("26 เมษายน 2562");}
				else if(dateId==58L){date.setDate("27 เมษายน 2562");}
				else if(dateId==59L){date.setDate("28 เมษายน 2562");}
				else if(dateId==60L){date.setDate("29 เมษายน 2562");}
				else if(dateId==61L){date.setDate("30 เมษายน 2562");}
				dateAppointmentRepository.save(date);
			});

			Stream.of(1L, 2L).forEach(genderId -> {
				Gender newGender = new Gender();
				newGender.setGenderId(genderId);
				if(genderId==1L){ newGender.setGenderName("ชาย"); }
				else if(genderId==2L){ newGender.setGenderName("หญิง"); }
				genderRepository.save(newGender);
			});

			Stream.of(1L, 2L, 3L, 4L, 5L).forEach(reasonId -> {
				CancelAppointmentReason newReason = new CancelAppointmentReason();
				newReason.setReasonId(reasonId);
				if(reasonId==1L){ newReason.setReason("ติดธุระด่วน"); }
				else if(reasonId==2L){ newReason.setReason("สมัครประกันเรียบร้อยแล้ว"); }
				else if(reasonId==3L){ newReason.setReason("จะไปเรียนแต่งหน้านั่งสมาธิดำน้ำ"); }
				else if(reasonId==4L){ newReason.setReason("จะไปเที่ยวตลาดน้ำเรียนถ่ายรูป"); }
				else if(reasonId==5L){ newReason.setReason("อื่นๆ"); }
				cancelAppointmentReasonRepository.save(newReason);
			});
			//=====================================================================================================================
			Stream.of(1L, 2L,3L).forEach(hosSizeId -> {                  //***define type of status detail***
				HospitalSize newSize = new HospitalSize();
				newSize.sethosSizeId(hosSizeId);

				if(hosSizeId ==1L){
					newSize.setHosSize("ขนาดเล็ก");
				}
				else if(hosSizeId ==2L){
					newSize.setHosSize("ขนาดกลาง");
				}
				else if(hosSizeId ==3L){
					newSize.setHosSize("ขนาดใหญ่");
				}
				hospitalSizeRepository.save(newSize);
			});
			Stream.of("มายกเลิกด้วยตัวเอง","ยกเลิกผ่านทางโทรศัพท์","ยกเลิกผ่านทาง e-mail","ยกเลิกผ่านทางไรษณีย์").forEach(NameContact ->{
				Contact contact = new Contact();
				contact.setContactName(NameContact);
				contactRepository.save(contact);
			});
			//-----------------------------------------------------------

			//----------------------------------------------
			String firstname[] ={"พอเพียง","พอใจ","พอที"};
			String lastname[] ={"คนเดิม","หรือยัง","ก็ได้"};
			long edu[] = {1,3,2};
			long vince[] = {5,6,9};
			long cat[] = {1,1,1,};
			//--------------------------------------------------------
			if(firstname.length == edu.length && firstname.length == vince.length&& firstname.length == cat.length ) {
				for (int i=0;i<firstname.length;i++) {
					AgentRegistration data1 = new AgentRegistration();

					data1.setfName(firstname[i]);
					data1.setlName(lastname[i]);

					Educational e = educationalrepository.findByID(edu[i]);
					data1.setEducational(e);

					Province p = provinceRepository.findByID(vince[i]);
					data1.setProvince(p);

					Category g = categoryRepository.findByID(cat[i]);
					data1.setCategory(g);



					agentRegistrationRepository.save(data1);
				}
			}
			//-------------------------------------------------
			String name[] ={"โรงพยาบาลศิริราช","โรงพยาบาลกรุงเทพ","โรงพยาบาลสุรนารี"};
			long agent[] = {1,1,2};
			long cat2[] = {1,1,2};
			long pro[] = {1,1,21};
			long size[] = {3,3,3};
			//--------------------------------------------------------
			if(name.length == agent.length && name.length == cat2.length && name.length == pro.length && name.length == size.length ) {
				for (int i=0;i<name.length;i++) {
					Hospital data1 = new Hospital();

					data1.setHosName(name[i]);

					AgentRegistration a = agentRegistrationRepository.findByID(agent[i]);
					data1.setAgentRegistration(a);

					Category c = categoryRepository.findByID(cat2[i]);
					data1.setCategory(c);

					Province p = provinceRepository.findByID(pro[i]);
					data1.setProvince(p);

					HospitalSize g = hospitalSizeRepository.findByID(size[i]);
					data1.setHospitalSize(g);



					hospitalRepository.save(data1);
				}
			}
			//-------------------------------------------------

			String CName[] ={"AA company","AS Company","BB company"};
			int Am[] = {100,20,3000};
			String Add[] ={"100 ต.สุรนารี อ.เมือง","151 ต.สุรนารี อ.เมือง","90 ต.สุรนารี อ.เมือง"};
			String zip[] = {"30000","30000","30000"};
			long bu[] = {1,3,2};
			long Est[] = {5,6,1};
			long Ca[] = {1,1,1,};
			//--------------------------------------------------------

				for (int i=0;i<CName.length;i++) {

					Lumpsum lumpsum = new Lumpsum();
					BusinessSize businessSize = businessSizeRepository.findByID(bu[i]);
					Category category = categoryRepository.findByID(Ca[i]);
					Establishment establishment = establishmentRepository.findByID(Est[i]);
					Province p = provinceRepository.findByID(vince[i]);

					lumpsum.setLumpsum(CName[i],Am[i],Add[i],zip[i]);
					lumpsum.setBusinessSizeId(businessSize);
					lumpsum.setCategoryId(category);
					lumpsum.setEstablishmentId(establishment);
					lumpsum.setProvinceId(p);
					lumpsum.setDate(new Date());

					lumpsumRepository.save(lumpsum);

			}


		};
	}
}