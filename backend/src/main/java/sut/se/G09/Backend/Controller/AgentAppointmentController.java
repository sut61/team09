package sut.se.G09.Backend.Controller;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AgentAppointmentController {

    @Autowired private final AgentAppointmentRepository agentAppointmentRepository;
    @Autowired private DateAppointmentRepository dateAppointmentRepository;
    @Autowired private DurationAppointmentRepository durationAppointmentRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private GenderRepository genderRepository;


    public AgentAppointmentController(AgentAppointmentRepository agentAppointmentRepository){
        this.agentAppointmentRepository = agentAppointmentRepository; }


    // ทดสอบโดย ใช้คำสั่ง curl -X POST  http://localhost:8080/GoldCardRegs/new/1309902550177/22-01-1998/Pitchakorn/Norkhuntod/Universal-Coverage-Scheme(UCS)/Bankok-Thonburi/N
  @PostMapping("/MakeAppointment/{insuranceId}/{fName}/{lName}/{genderId}/{age}/{telNum}/{email}/{provinceId}/{dateId}/{durationId}")
    public AgentAppointment newAppointment (
           AgentAppointment newAppointment, @PathVariable String fName , @PathVariable String lName
            ,@PathVariable Long insuranceId, @PathVariable Long genderId,@PathVariable Long dateId
           ,@PathVariable Long durationId, @PathVariable Long provinceId, @PathVariable int age
            ,@PathVariable String telNum, @PathVariable String email/*@PathVariable Long dateId*/
            ) {

            AgentAppointment newAp = new AgentAppointment();

            Category insuCat = categoryRepository.findByID(insuranceId);
            Gender gender = genderRepository.findByGenderId(genderId);
            Province province = provinceRepository.findByID(provinceId);
            DateAppointment dateAp = dateAppointmentRepository.findByDateId(dateId);
            DurationAppointment durAp = durationAppointmentRepository.findByDurationId(durationId);

            newAp.setCategory(insuCat);
            newAp.setfName(fName);
            newAp.setlName(lName);
            newAp.setGender(gender);
            newAp.setAge(age);
            newAp.setTelNum(telNum);
            newAp.setEmail(email);
            newAp.setProvince(province);
            newAp.setDateAppointment(dateAp);
            newAp.setDurationAppointment(durAp);

      return agentAppointmentRepository.save(newAp);   //บันทึก Objcet ชื่อ newReg

      }

    @GetMapping("/GetAgentAppointment") public Collection<AgentAppointment> AgentAppointment() {
        return agentAppointmentRepository.findAll().stream().collect(Collectors.toList()); }

    @GetMapping("/GetCategory") public Collection<Category> Category() {
        return categoryRepository.findAll().stream().collect(Collectors.toList()); }

    //http://localhost:8080/GetTypesOfRightsData
    @GetMapping("/GetDateAppointment") public Collection<DateAppointment> DateAppointment() {
        return dateAppointmentRepository.findAll().stream().collect(Collectors.toList()); }

    @GetMapping("/GetDurationAppointment") public Collection<DurationAppointment> DurationAppointment() {
        return durationAppointmentRepository.findAll().stream().collect(Collectors.toList()); }

    @GetMapping("/GetGender") public Collection<Gender> Gender() {
        return genderRepository.findAll().stream().collect(Collectors.toList()); }

    @GetMapping("/GetProvince") public Collection<Province> Province() {
        return provinceRepository.findAll().stream().collect(Collectors.toList()); }


}
