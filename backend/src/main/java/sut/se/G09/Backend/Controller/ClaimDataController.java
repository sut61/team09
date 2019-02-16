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
  @Autowired  private       TreatmentStyleRepository treatmentStyleRepository;


  @Autowired
  public ClaimDataController(	ClaimDataRepository claimDataRepository,
								 		DiseaseAccidentDataRepository diseaseAccidentDataRepository,
										MemberDataRepository memberDataRepository,
										CategoryRepository categoryRepository,
										HospitalRepository hospitalRepository,
								 		TreatmentStyleRepository treatmentStyleRepository
										) 
	{
    this.claimDataRepository = claimDataRepository;
    this.memberDataRepository = memberDataRepository;
    this.diseaseAccidentDataRepository = diseaseAccidentDataRepository;
    this.categoryRepository = categoryRepository;
    this.hospitalRepository = hospitalRepository;
    this.treatmentStyleRepository = treatmentStyleRepository;
	}
	
	@GetMapping(path = "/getClaimData", produces = MediaType.APPLICATION_JSON_VALUE)
		private Collection<ClaimData> ClaimData()
		{
		return claimDataRepository.findAll().stream()
        .collect(Collectors.toList());
		}
	@GetMapping(path = "/getMemberData", produces = MediaType.APPLICATION_JSON_VALUE)
	private Collection<MemberData> MemberData()
	{
		return memberDataRepository.findAll().stream()
				.collect(Collectors.toList());
	}

	@GetMapping(path = "/getTreatmentStyle", produces = MediaType.APPLICATION_JSON_VALUE)
	private Collection<TreatmentStyle> TreatmentStyle()
	{
		return treatmentStyleRepository.findAll().stream()
				.collect(Collectors.toList());
	}

	//======  curl -X POST  http://localhost:8080/DiseaseAccidentData/NEW/"1,22222"/1/1/5
	@PostMapping(path ="/ClaimData/NEW/{memberData}/{diseaseAccidentData}/{category}/{hospital}/{treatmentStyle}/{cost}")
	public void ClaimData(
											@PathVariable long memberData,
											@PathVariable String diseaseAccidentData,
											@PathVariable String category,
											@PathVariable String hospital,
											@PathVariable String treatmentStyle,
											@PathVariable long cost
										)throws JsonParseException, IOException
	{
		MemberData member = memberDataRepository.findByID(memberData);
		DiseaseAccidentData DiseaseAccident = diseaseAccidentDataRepository.findByDataName(diseaseAccidentData);
		Hospital hos = hospitalRepository.findByHosName(hospital);
		Category cat = categoryRepository.findByTypeName(category);
		TreatmentStyle ts = treatmentStyleRepository.findByStyleName(treatmentStyle);

		ClaimData newData = new ClaimData();
		newData.setMemberData(member);
		newData.setDiseaseAccidentData(DiseaseAccident);
		newData.setHospital(hos);
		newData.setCategory(cat);
		newData.setTreatmentStyle(ts);
		newData.setCostClaimData(cost);

		claimDataRepository.save(newData);

	  
	}
}