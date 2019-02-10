package sut.se.G09.Backend.Controller;


import org.springframework.http.MediaType;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PaymentController
{

    @Autowired
    private  MemberDataRepository memberDataRepository;
    @Autowired
    private MLDataRepository mlDataRepository;
    @Autowired
    private  PaymentHistoryRepository paymentHistoryRepository;
    @Autowired
    private  PaymentCostRepository paymentCostRepository;




    public PaymentController( MLDataRepository mlDataRepository , MemberDataRepository memberDataRepository) {
        this.mlDataRepository = mlDataRepository;
        this.memberDataRepository = memberDataRepository;

    }

    @GetMapping(path ="/user/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MemberData gerMember (@PathVariable String user){
        MLData mem = mlDataRepository.findByUserName(user);
        MemberData username = memberDataRepository.findByID(mem.getMemberData().getID());
        return username;
    }

    @GetMapping(path ="/cost/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentCost cost (@PathVariable String user){
        MLData mem = mlDataRepository.findByUserName(user);
        PaymentCost po = paymentCostRepository.findByMemberData(mem.getMemberData());

        return po;
    }

    @GetMapping(path ="/paid/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentHistoty paid (@PathVariable String user){
        MLData mem = mlDataRepository.findByUserName(user);
        PaymentHistoty p = paymentHistoryRepository.findByMemberData(mem.getMemberData());
        return p;
    }

    @DeleteMapping ("/pay/{code}")
    public void Pay(@PathVariable String code){
        PaymentCost po = paymentCostRepository.findByCode(code);
        PaymentHistoty p = new PaymentHistoty();
        p.setAmount(po.getAmount());
        p.setCode(po.getCode());
        p.setDate(new Date());
        p.setMemberData(po.getMemberData());
        paymentHistoryRepository.save(p);
        paymentCostRepository.deleteById(po.getID());
    }


}