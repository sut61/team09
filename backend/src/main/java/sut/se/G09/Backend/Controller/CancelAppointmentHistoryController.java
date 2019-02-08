package sut.se.G09.Backend.Controller;
import org.springframework.web.bind.annotation.*;
import sut.se.G09.Backend.Entity.AgentAppointment;
import sut.se.G09.Backend.Entity.CancelAppointmentHistory;
import sut.se.G09.Backend.Entity.CancelAppointmentReason;
import sut.se.G09.Backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CancelAppointmentHistoryController {

    @Autowired private final CancelAppointmentHistoryRepository cancelAppointmentHistoryRepository;
    @Autowired private CancelAppointmentReasonRepository cancelAppointmentReasonRepository;
    @Autowired private AgentAppointmentRepository agentAppointmentRepository;

    public CancelAppointmentHistoryController(CancelAppointmentHistoryRepository cancelAppointmentHistoryRepository) {
        this.cancelAppointmentHistoryRepository = cancelAppointmentHistoryRepository;
    }

    //curl -X DELETE http://localhost:8080/cancel/"1309902540177"/"others"
    @DeleteMapping("/cancel/{idCardNum}/{reason}")
    public void cancelAppointment(@PathVariable String idCardNum ,@PathVariable String reason) {
        AgentAppointment findApp = agentAppointmentRepository.findByIdCardNum(idCardNum);
        CancelAppointmentHistory newCanc = new CancelAppointmentHistory();
        CancelAppointmentReason findReason = cancelAppointmentReasonRepository.findByReason(reason);
        newCanc.setIdCardNum(idCardNum);
        newCanc.setfName(findApp.getfName());
        newCanc.setlName(findApp.getlName());
        newCanc.setCancelAppointmentReason(findReason);
        cancelAppointmentHistoryRepository.save(newCanc);   //บันทึก Objcet ชื่อ newReg
        agentAppointmentRepository.deleteById(findApp.getAppointmentId());
    }
}