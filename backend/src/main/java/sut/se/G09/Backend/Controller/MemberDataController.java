package sut.se.G09.Backend.Controller;


import org.springframework.http.MediaType;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class MemberDataController
{
    @Autowired
    private final MemberDataRepository memberDataRepository;
    @Autowired
    private MLDataRepository mlDataRepository;
    @Autowired
    private AgentRegistrationRepository agentRegistrationRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    public MemberDataController(MemberDataRepository memberDataRepository , MLDataRepository mlDataRepository ) {
        this.memberDataRepository = memberDataRepository;
        this.mlDataRepository = mlDataRepository;
    }

    @PostMapping("/Regmem/{fname}/{lname}/{age}/{PID}/{username}/{password}/{povin}/{ag}/{cate}/{addes}")
    //@RequestMapping(path="Reg", method=RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MLData NewMemberData(
            @PathVariable String fname,
            @PathVariable String lname,
            @PathVariable Long age,
            @PathVariable String PID,
            @PathVariable String username,
            @PathVariable String password,
            @PathVariable Long povin,
            @PathVariable Long ag,
            @PathVariable Long cate,
            @PathVariable String addes
    ){

        Province po = provinceRepository.findByID(povin);
        AgentRegistration agent = agentRegistrationRepository.findByID(ag);
        Category ca = categoryRepository.findByID(cate);
        MemberData member = new MemberData();
        member.setFname(fname);
        member.setLname(lname);
        member.setAge(age);
        member.setIdCard(PID);
        member.setProvince(po);
        member.setCategory(ca);
        member.setAddess(addes);
        member.setAgentRegistration(agent);
        memberDataRepository.save(member);
        MemberData mem = memberDataRepository.findByIdCard(PID);

        MLData login = new MLData();
        login.setUserName(username);
        login.setPassword(password);
        login.setMemberData(mem);
        return mlDataRepository.save(login);
    }

    @GetMapping(path = "/member",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MemberData> CancelInsurance() {
        return memberDataRepository.findAll().stream().collect(Collectors.toList());
    }

}