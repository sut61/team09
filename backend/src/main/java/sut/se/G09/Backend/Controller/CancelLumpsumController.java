package sut.se.G09.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CancelLumpsumController {
    @Autowired
    private final CancelLumpsumRepository cancelLumpsumRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private LumpsumRepository lumpsumRepository;
    private GenderRepository genderRepository;
    private ProvinceRepository provinceRepository;


    public CancelLumpsumController(CancelLumpsumRepository cancelLumpsumRepository,LumpsumRepository lumpsumRepositorya,
                                   ContactRepository contactRepository,GenderRepository genderRepository,ProvinceRepository provinceRepository) {
        this.cancelLumpsumRepository = cancelLumpsumRepository;
        this.lumpsumRepository = lumpsumRepository;
        this.contactRepository = contactRepository;
        this.genderRepository = genderRepository;
        this.provinceRepository = provinceRepository;

    }

    @GetMapping(path = "/getCancelLumpsum", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<CancelLumpsum> CanaelLumpsum() {
        return cancelLumpsumRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getContact", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<Contact> Contact() {
        return contactRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/getLumpsum", produces = MediaType.APPLICATION_JSON_VALUE)
    private Collection<Lumpsum> Lumpsum() {
        return lumpsumRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    // curl -X DELETE  http://localhost:8080/cancelLumpsum/1/"aaaaaaaaa"/1    //ตัว test class
    @DeleteMapping("/cancelLumpsum/{companyID}/{contactID}/{comment}/{PROVINCE_ID}/{nameCan}/{ageCan}/{IDcardCan}")
    public void deleteLumpsum (@PathVariable Long companyID ,
                               @PathVariable Long contactID,
                               @PathVariable String comment,
                               @PathVariable String  PROVINCE_ID,
                               @PathVariable String nameCan,
                               @PathVariable Integer ageCan,
                               @PathVariable String IDcardCan) {

        Lumpsum findLumpsum = lumpsumRepository.findByID(companyID);
        Contact findContact = contactRepository.findByID(contactID);
        Province province = provinceRepository.findByProvinceName(PROVINCE_ID);
        CancelLumpsum newCancel = new CancelLumpsum();

        newCancel.setContactId(findContact);
        newCancel.setComment(comment);
        newCancel.setProvinceId(province);
        newCancel.setNameCan(nameCan);
        newCancel.setAgeCan(ageCan);
        newCancel.setIDcardCan(IDcardCan);

        Lumpsum l = this.lumpsumRepository.findByID(findLumpsum.getiD());
        this.lumpsumRepository.delete(l);
        newCancel.setDate(new Date());
        cancelLumpsumRepository.save(newCancel);

    }


}

