package sut.se.G09.Backend.Controller;
import org.springframework.web.bind.annotation.*;
import sut.se.G09.Backend.Entity.AgentAppointment;
import sut.se.G09.Backend.Entity.CancelAppointmentHistory;
import sut.se.G09.Backend.Entity.CancelAppointmentReason;
import sut.se.G09.Backend.Entity.DateAppointment;
import sut.se.G09.Backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CancelAppointmentHistoryController {

    @Autowired private final CancelAppointmentHistoryRepository cancelAppointmentHistoryRepository;
    @Autowired private CancelAppointmentReasonRepository cancelAppointmentReasonRepository;
    @Autowired private AgentAppointmentRepository agentAppointmentRepository;
    @Autowired private DateAppointmentRepository dateAppointmentRepository;

    public CancelAppointmentHistoryController(CancelAppointmentHistoryRepository cancelAppointmentHistoryRepository) {
        this.cancelAppointmentHistoryRepository = cancelAppointmentHistoryRepository;
    }

    @GetMapping("/GetCancelAppointment") public Collection<CancelAppointmentHistory> CancelAppointmentHistory() {
        return cancelAppointmentHistoryRepository.findAll().stream().collect(Collectors.toList()); }

    @GetMapping("/GetCancelAppointmentReason") public Collection<CancelAppointmentReason> CancelAppointmentReason() {
        return cancelAppointmentReasonRepository.findAll().stream().collect(Collectors.toList()); }

    //curl -X DELETE http://localhost:8080/cancel/"1309902540177"/"others"
    @DeleteMapping ("/cancel/{idCardNum}/{reason}")
    public void cancelAppointment(@PathVariable String idCardNum ,@PathVariable String reason) {

        CancelAppointmentHistory newCanc = new CancelAppointmentHistory();
        AgentAppointment findApp = agentAppointmentRepository.findByIdCardNum(idCardNum);
        CancelAppointmentReason findReason = cancelAppointmentReasonRepository.findByReason(reason);

        String date = findApp.getDateAppointment().getDate();
        DateAppointment dateAp = dateAppointmentRepository.findByDate(date);

        newCanc.setIdCardNum(idCardNum);
        newCanc.setfName(findApp.getfName());
        newCanc.setlName(findApp.getlName());
        newCanc.setTelNum(findApp.getTelNum());
        newCanc.setEmail(findApp.getEmail());
        newCanc.setDate(new Date());
        newCanc.setCancelAppointmentReason(findReason);
        cancelAppointmentHistoryRepository.save(newCanc);

        Integer count = dateAp.getCount();
        count--;
        dateAp.setCount(count);

        if (dateAp.getCount() < 4) {
            dateAp.setStatus("available");
        }
        dateAppointmentRepository.save(dateAp);

        agentAppointmentRepository.deleteById(findApp.getAppointmentId());
    }

}