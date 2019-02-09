package sut.se.G09.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.G09.Backend.Repository.*;
import sut.se.G09.Backend.Entity.*;


import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


/*import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;*/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AgentRegistrationController {
  @Autowired
  private final AgentRegistrationRepository agentRegistrationRepository;
  @Autowired
  private Educationalrepository educationalrepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ProvinceRepository provinceRepository;

  @Autowired
  public AgentRegistrationController(AgentRegistrationRepository agentRegistrationRepository,Educationalrepository educationalrepository,
                                     CategoryRepository categoryRepository,ProvinceRepository provinceRepository) {
    this.agentRegistrationRepository = agentRegistrationRepository;
    this.educationalrepository = educationalrepository;
    this.categoryRepository = categoryRepository;
    this.provinceRepository = provinceRepository;
  }
  @GetMapping(path = "/getAgentRegistration", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<AgentRegistration> AgentRegistration() {
    return agentRegistrationRepository.findAll().stream()
            .collect(Collectors.toList());
  }
  @GetMapping(path = "/getCategory", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<Category> Category() {
    return categoryRepository.findAll().stream()
            .collect(Collectors.toList());
  }
  @GetMapping(path = "/getEducational", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<Educational> Educational() {
    return educationalrepository.findAll().stream()
            .collect(Collectors.toList());
  }
  @GetMapping(path = "/getProvince", produces = MediaType.APPLICATION_JSON_VALUE)
  private Collection<Province> Province() {
    return provinceRepository.findAll().stream()
            .collect(Collectors.toList());


  }
  @PostMapping(path ="/AgentRegistration/{fName}/{lName}/{typeInsurance}/{Education}/{Province}")
  /*==TEST==)))
  http://localhost:8080/MedicineSystem/NEW/id=1/id=1/id=1/id=1,id=2,id=3
  */
  // @RequestMapping(path="Reg", method=RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
  public AgentRegistration agentRegistration(@PathVariable String fName,@PathVariable String lName,@PathVariable String typeInsurance
          ,@PathVariable String Education
          ,@PathVariable String Province)throws JsonParseException, IOException {


    Category category = categoryRepository.findByTypeName(typeInsurance);
    Educational educational = educationalrepository.findByeduName(Education);
    Province province = provinceRepository.findByProvinceName(Province);

    AgentRegistration agent = new AgentRegistration();

    agent.setAgentRegistration(fName, lName);
    agent.setCategory(category);
    agent.setEducational(educational);
    agent.setProvince(province);

    return agentRegistrationRepository.save(agent);
  }


}



