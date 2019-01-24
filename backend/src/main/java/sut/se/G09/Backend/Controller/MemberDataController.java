package sut.se.G09.Backend.Controller;

import org.springframework.web.bind.annotation.*;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

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



    public MemberDataController(MemberDataRepository memberDataRepository ) {
        this.memberDataRepository = memberDataRepository;
    }

    @PostMapping("/Regmem/{fname}/{lname}/{age}/{PID}/{username}/{password}/{povin}/{ag}/{cate}")
    //@RequestMapping(path="Reg", method=RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MemberData NewMemberData(
            @PathVariable String fname,
            @PathVariable String lname,
            @PathVariable Long age,
            @PathVariable String PID,
            @PathVariable String username,
            @PathVariable String password,
            @PathVariable Long povin,
            @PathVariable Long ag,
            @PathVariable Long cate
            ){
        MLData login = new MLData();
        login.setUserName(username);
        login.setPassword(password);
        mlDataRepository.save(login);
        MLData mlog = mlDataRepository.findByUserName(username);
        Province po = provinceRepository.findByID(povin);
        AgentRegistration agent = agentRegistrationRepository.findByID(ag);
        Category ca = categoryRepository.findByID(cate);
        MemberData member = new MemberData();
        member.setFname(fname);
        member.setLname(lname);
        member.setAge(age);
        member.setIDCard(PID);
        member.setMLData(mlog);
        member.setProvince(po);
        member.setCategory(ca);
        member.setAgentRegistration(agent);

        return memberDataRepository.save(member);
    }
    
  

}