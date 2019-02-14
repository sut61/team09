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


  @PostMapping("/MakeAppointment/{typeName}/{fName}/{lName}/{idCardNum}/{genderName}/{age}/{telNum}/{email}/{provinceName}/{date}/{duration}")
    public AgentAppointment newAppointment (
           AgentAppointment newAppointment, @PathVariable String fName , @PathVariable String lName
          , @PathVariable String idCardNum,@PathVariable String typeName, @PathVariable String genderName
          , @PathVariable String date ,@PathVariable String duration, @PathVariable String provinceName
          , @PathVariable int age ,@PathVariable String telNum, @PathVariable String email
            ) {

            sut.se.G09.Backend.Entity.AgentAppointment newAp = new AgentAppointment();

            Category cate = categoryRepository.findByTypeName(typeName);
            Gender gender = genderRepository.findByGenderName(genderName);
            Province province = provinceRepository.findByProvinceName(provinceName);
            DateAppointment dateAp = dateAppointmentRepository.findByDate(date);
            DurationAppointment durAp = durationAppointmentRepository.findByDuration(duration);

                if (dateAp.getCount() < 4) {

                    newAp.setCategory(cate);
                    newAp.setfName(fName);
                    newAp.setlName(lName);
                    newAp.setIdCardNum(idCardNum);
                    newAp.setGender(gender);
                    newAp.setAge(age);
                    newAp.setTelNum(telNum);
                    newAp.setEmail(email);
                    newAp.setProvince(province);
                    newAp.setDateAppointment(dateAp);
                    newAp.setDurationAppointment(durAp);

                    int count = dateAp.getCount();
                    count++;
                    dateAp.setCount(count);

                        if (dateAp.getCount() == 4) {
                            dateAp.setStatus("full");
                        }
                    dateAppointmentRepository.save(dateAp);
                }

      return agentAppointmentRepository.save(newAp);

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
