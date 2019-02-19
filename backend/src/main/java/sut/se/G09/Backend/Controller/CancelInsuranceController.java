package sut.se.G09.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class CancelInsuranceController {
    @Autowired
    private final CancelInsuranceRepository cancelInsuranceRepository;
    @Autowired
    private ReasonMemberRepository reasonMemberRepository;
    @Autowired
    private MemberDataRepository memberDataRepository;
    @Autowired
    private MLDataRepository mlDataRepository;

    public CancelInsuranceController(CancelInsuranceRepository cancelInsuranceRepository,
                              ReasonMemberRepository reasonMemberRepository,
                                     MemberDataRepository memberDataRepository,
                                     MLDataRepository mlDataRepository){
        this.cancelInsuranceRepository=cancelInsuranceRepository;
        this.reasonMemberRepository = reasonMemberRepository;
        this.memberDataRepository = memberDataRepository;
        this.mlDataRepository = mlDataRepository;

    }
    @GetMapping(path = "/CancelInsurance",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CancelInsurance> CancelInsurance() {
        return cancelInsuranceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/ReasonMember",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ReasonMember> ReasonMember() {
        return reasonMemberRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/CancelInsurance",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CancelInsurance postTreatmentHistory(@RequestBody CancelInsurance dataTreatmentHistory){
        return  cancelInsuranceRepository.save(dataTreatmentHistory);

    }

    @DeleteMapping("/CancelInsurance/{user}/{idCard}/{fName}/{lName}/{eMail}/{tlePhone}/{reasonMemberName}")
    public void cancelAppointment(@PathVariable long user,
                                  @PathVariable String idCard,
                                  @PathVariable String fName,
                                  @PathVariable String lName,
                                  @PathVariable String eMail,
                                  @PathVariable String tlePhone,
                                  @PathVariable Long reasonMemberName) {
        MLData mem = mlDataRepository.findById(user);
        MemberData findApp = memberDataRepository.findByIdCard(idCard);
        ReasonMember reasonMember = reasonMemberRepository.findByID(reasonMemberName);
        CancelInsurance newCancelInsurance = new CancelInsurance();
        newCancelInsurance.setIdCard(idCard);
        newCancelInsurance.setfName(fName);
        newCancelInsurance.setlName(lName);
        newCancelInsurance.seteMail(eMail);
        newCancelInsurance.setTlePhone(tlePhone);
        newCancelInsurance.setDate(new Date());
        newCancelInsurance.setReasonMember(reasonMember);
        cancelInsuranceRepository.save(newCancelInsurance);
        mlDataRepository.deleteById(mem.getID());
        memberDataRepository.deleteById(findApp.getID());
    }


    //curl -X DELETE http://localhost:8080/CancelInsurance/"1230200145957" ตัว Test โดยไม่เชื่อม UI

}















