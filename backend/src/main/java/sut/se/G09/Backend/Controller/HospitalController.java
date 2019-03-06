package sut.se.G09.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;


/*import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;*/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {
  @Autowired
  private  HospitalRepository hospitalRepository;
  @Autowired
  private  AgentRegistrationRepository agentRegistrationRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ProvinceRepository provinceRepository;
  @Autowired
  private HospitalSizeRepository hospitalSizeRepository;

  @Autowired
  public HospitalController(HospitalRepository hospitalRepository,AgentRegistrationRepository agentRegistrationRepository,
                            CategoryRepository categoryRepository, ProvinceRepository provinceRepository
                            ,HospitalSizeRepository hospitalSizeRepository) {

    this.hospitalRepository = hospitalRepository;
    this.agentRegistrationRepository = agentRegistrationRepository;
    this.categoryRepository = categoryRepository;
    this.provinceRepository = provinceRepository;
    this.hospitalSizeRepository = hospitalSizeRepository;

}
  @GetMapping(path = "/getHospital", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<Hospital> Hospital() {
    return hospitalRepository.findAll().stream()
            .collect(Collectors.toList());
  }
  @GetMapping(path = "/getAgent", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<AgentRegistration> AgentRegistration() {
    return agentRegistrationRepository.findAll().stream()
            .collect(Collectors.toList());
  }
  @GetMapping(path = "/getCate", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<Category> Category() {
    return categoryRepository.findAll().stream()
            .collect(Collectors.toList());
  }


    @GetMapping(path = "/getHosSize", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<HospitalSize> Hospitalsize() {
      return hospitalSizeRepository.findAll().stream()
              .collect(Collectors.toList());




  }
  @PostMapping(path ="/Hospital/{hosName}/{ownerfName}/{ownerlName}/{phoneNum}/{email}/{ag}/{typeInsurance}/{Province}/{hosSize}")
  public Hospital hospital(@PathVariable String hosName
          , @PathVariable String ownerfName
          , @PathVariable String ownerlName
          , @PathVariable String phoneNum
          , @PathVariable String email
          , @PathVariable String ag
          , @PathVariable String typeInsurance
          , @PathVariable String Province
          , @PathVariable String hosSize)throws JsonParseException, IOException {

    AgentRegistration agentName = agentRegistrationRepository.findByFName(ag);
    Category category = categoryRepository.findByTypeName(typeInsurance);
    Province province = provinceRepository.findByProvinceName(Province);
    HospitalSize hospiSize = hospitalSizeRepository.findByHosSize(hosSize);

    Hospital hospital = new Hospital();

    hospital.setHospital(hosName,ownerfName,ownerlName,phoneNum,email);
    hospital.setAgentRegistration(agentName);
    hospital.setCategory(category);
    hospital.setProvince(province);
    hospital.setHospitalSize(hospiSize);

    return hospitalRepository.save(hospital);
  }


}



