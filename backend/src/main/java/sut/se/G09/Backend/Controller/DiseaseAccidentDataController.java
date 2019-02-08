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
public class DiseaseAccidentDataController {
	
  @Autowired private final 	DiseaseAccidentDataRepository diseaseAccidentDataRepository;

  @Autowired  private       DiseaseAccidentLevelRepository diseaseAccidentLevelRepository;
  @Autowired  private       DiseaseAccidentTypeRepository diseaseAccidentTypeRepository;
  @Autowired  private       MedicalFeeRepository medicalFeeRepository;


  @Autowired
  public DiseaseAccidentDataController(	DiseaseAccidentDataRepository diseaseAccidentDataRepository,
										DiseaseAccidentLevelRepository diseaseAccidentLevelRepository,
										DiseaseAccidentTypeRepository diseaseAccidentTypeRepository,
										MedicalFeeRepository medicalFeeRepository) 
	{
    this.diseaseAccidentDataRepository = diseaseAccidentDataRepository;
    this.diseaseAccidentLevelRepository = diseaseAccidentLevelRepository;
    this.diseaseAccidentTypeRepository = diseaseAccidentTypeRepository;
    this.medicalFeeRepository = medicalFeeRepository;
	}
	
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

	//======  curl -X POST  http://localhost:8080/DiseaseAccidentData/NEW/"1,22222"/1/1/5
	@PostMapping(path ="/DiseaseAccidentData/NEW/{dataName}/{levelId}/{typeId}/{medicalFeeId}")	
	public void diseaseAccidentData(
											@PathVariable String dataName,
											@PathVariable String levelId,
											@PathVariable String typeId,
											@PathVariable int medicalFeeId
										)throws JsonParseException, IOException
	{
		DiseaseAccidentLevel level = diseaseAccidentLevelRepository.findByLevelText(levelId);
		DiseaseAccidentType type = diseaseAccidentTypeRepository.findByTypeText(typeId);
		MedicalFee medicalFee = medicalFeeRepository.findByMedicalFeeCost(medicalFeeId);
		
		DiseaseAccidentData newData = new DiseaseAccidentData();
		newData.setDiseaseAccidentData(dataName);
		newData.setDiseaseAccidentLevel(level);
		newData.setDiseaseAccidentType(type);
		newData.setMedicalFee(medicalFee);
		
		 diseaseAccidentDataRepository.save(newData);

	  
	}
}