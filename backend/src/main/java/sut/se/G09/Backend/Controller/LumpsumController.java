package sut.se.G09.Backend.Controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class LumpsumController {

    private LumpsumRepository lumpsumRepository;
    private BusinessSizeRepository businessSizeRepository;
    private CategoryRepository categoryRepository;
    private AgentRegistrationRepository agentRegistrationRepository;
    private ProvinceRepository provinceRepository;
    private EstablishmentRepository establishmentRepository;

    public LumpsumController(LumpsumRepository lumpsumRepository, BusinessSizeRepository businessSizeRepository, CategoryRepository categoryRepository,
                             AgentRegistrationRepository agentRegistrationRepository, ProvinceRepository provinceRepository, EstablishmentRepository establishmentRepository) {

        this.lumpsumRepository = lumpsumRepository;
        this.businessSizeRepository = businessSizeRepository;
        this.categoryRepository = categoryRepository;
        this.agentRegistrationRepository = agentRegistrationRepository;
        this.provinceRepository = provinceRepository;
        this.establishmentRepository = establishmentRepository;
    }

    @GetMapping(path = "/getBusinessSize", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<BusinessSize> BusinessSize() {
        return businessSizeRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<Category> Category() {
        return categoryRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getEstablishment", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<Establishment> Establishment() {
        return establishmentRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getAgentRegistration", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<AgentRegistration> AgentRegistration() {
        return agentRegistrationRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getProvince", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<Province> Province() {
        return provinceRepository.findAll().stream()
                .collect(Collectors.toList());
    }


    @GetMapping("/Lumpsum")
    public List<Lumpsum> Lumpsum() {
        return lumpsumRepository.findAll().stream()
                .collect(Collectors.toList());
    }


    @PostMapping(path = "/Lumpsum/NEW/{companyName}/{amoungEmp}/{address}/{zipCode}/{BUSINESS_ID}/{CATEGORY_ID}/{ESTABLISHMENT_ID}/{AGENTREGISTRATION_ID}/{PROVINCE_ID}")
    public Lumpsum addLumpsum(
            @PathVariable String companyName,
            @PathVariable int amoungEmp,
            @PathVariable String  address,
            @PathVariable String zipCode,
            @PathVariable Long BUSINESS_ID,
            @PathVariable Long CATEGORY_ID,
            @PathVariable Long ESTABLISHMENT_ID,
            @PathVariable Long AGENTREGISTRATION_ID,
            @PathVariable Long PROVINCE_ID) {
        BusinessSize size = businessSizeRepository.findByID(BUSINESS_ID);
        Category category = categoryRepository.findByID(CATEGORY_ID);
        Establishment establishment = establishmentRepository.findByID(ESTABLISHMENT_ID);
        AgentRegistration agentRegistration = agentRegistrationRepository.findByRegId(AGENTREGISTRATION_ID);
        Province province = provinceRepository.findByID(PROVINCE_ID);

        Lumpsum newLumpsum = new Lumpsum();

        newLumpsum.setBusinessSizeId(size);
        newLumpsum.setCategoryId(category);
        newLumpsum.setEstablishmentId(establishment);
        newLumpsum.setAgentRegistrationId(agentRegistration);
        newLumpsum.setProvinceId(province);
        newLumpsum.setLumpsum(companyName,amoungEmp,address,zipCode);
        newLumpsum.setDate(new Date());



        return lumpsumRepository.save(newLumpsum);
    }

}

