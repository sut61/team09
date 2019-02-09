package sut.se.G09.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClaimDataController {
	
  @Autowired private final 	ClaimDataRepository claimDataRepository;


  @Autowired  private       MemberDataRepository memberDataRepository;
  @Autowired  private       DiseaseAccidentDataRepository diseaseAccidentDataRepository;
  @Autowired  private       CategoryRepository categoryRepository;
  @Autowired  private       HospitalRepository hospitalRepository;


  @Autowired
  public ClaimDataController(	ClaimDataRepository claimDataRepository,
								 		DiseaseAccidentDataRepository diseaseAccidentDataRepository,
										MemberDataRepository memberDataRepository,
										CategoryRepository categoryRepository,
										HospitalRepository hospitalRepository
										) 
	{
    this.claimDataRepository = claimDataRepository;
    this.memberDataRepository = memberDataRepository;
    this.diseaseAccidentDataRepository = diseaseAccidentDataRepository;
    this.categoryRepository = categoryRepository;
    this.hospitalRepository = hospitalRepository;
	}
	
	@GetMapping(path = "/getClaimData", produces = MediaType.APPLICATION_JSON_VALUE)
		private Collection<ClaimData> ClaimData()
		{
		return claimDataRepository.findAll().stream()
        .collect(Collectors.toList());
		}

	/*
	@GetMapping(path = "/getDiseaseAccidentData", produces = MediaType.APPLICATION_JSON_VALUE)
		private Collection<DiseaseAccidentData> DiseaseAccidentData() 
		{
		return diseaseAccidentDataRepository.findAll().stream()
        .collect(Collectors.toList());
		}
		
	@GetMapping(path = "/getDiseaseAccidentLevel", produces = MediaType.APPLICATION_JSON_VALUE)
		private Collection<DiseaseAccidentLevel> DiseaseAccidentLevel() 
		{
		return diseaseAccidentLevelRepository.findAll().stream()
        .collect(Collectors.toList());
		}
	
	@GetMapping(path = "/getDiseaseAccidentType", produces = MediaType.APPLICATION_JSON_VALUE)
		private Collection<DiseaseAccidentType> DiseaseAccidentType() 
		{
		return diseaseAccidentTypeRepository.findAll().stream()
        .collect(Collectors.toList());
		}
		
	@GetMapping(path = "/getMedicalFee", produces = MediaType.APPLICATION_JSON_VALUE)
		private Collection<MedicalFee> MedicalFee() 
		{
		return medicalFeeRepository.findAll().stream()
        .collect(Collectors.toList());
		}
*/
	//======  curl -X POST  http://localhost:8080/DiseaseAccidentData/NEW/"1,22222"/1/1/5
	@PostMapping(path ="/ClaimData/NEW/{memberData}/{diseaseAccidentData}/{category}/{hospital}/{cost}")
	public void ClaimData(
											@PathVariable long memberData,
											@PathVariable String diseaseAccidentData,
											@PathVariable String category,
											@PathVariable String hospital,
											@PathVariable String cost
										)throws JsonParseException, IOException
	{
		MemberData member = memberDataRepository.findByID(memberData);
		DiseaseAccidentData DiseaseAccident = diseaseAccidentDataRepository.findByDataName(diseaseAccidentData);
		Hospital hos = hospitalRepository.findByHosName(hospital);
		Category cat = categoryRepository.findByTypeName(category);

		ClaimData newData = new ClaimData();
		newData.setMemberData(member);
		newData.setDiseaseAccidentData(DiseaseAccident);
		newData.setHospital(hos);
		newData.setCategory(cat);
		newData.setCostClaimData(cost);

		claimDataRepository.save(newData);

	  
	}
}