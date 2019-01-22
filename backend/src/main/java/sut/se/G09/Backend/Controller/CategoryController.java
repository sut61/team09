package sut.se.G09.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import sut.se.G09.Backend.Entity.Category;
import sut.se.G09.Backend.Entity.InsurancePremium;
import sut.se.G09.Backend.Entity.Length;
import sut.se.G09.Backend.Entity.MoneyMaximum;
import sut.se.G09.Backend.Repository.CategoryRepository;
import sut.se.G09.Backend.Repository.InsurancePremiumRepository;
import sut.se.G09.Backend.Repository.LengthRepository;
import sut.se.G09.Backend.Repository.MoneyMaximumRepository;
import sut.se.G09.Backend.Entity.*;
import sut.se.G09.Backend.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class CategoryController {
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private InsurancePremiumRepository insurancePremiumRepository;
    @Autowired
    private LengthRepository lengthRepository;
    @Autowired
    private MoneyMaximumRepository moneyMaximumRepository;

    public CategoryController(CategoryRepository categoryRepository,
                              InsurancePremiumRepository insurancePremiumRepository,
                            LengthRepository lengthRepository,MoneyMaximumRepository moneyMaximumRepository){
        this.categoryRepository=categoryRepository;
        this.insurancePremiumRepository = insurancePremiumRepository;
        this.lengthRepository=lengthRepository;
        this.moneyMaximumRepository=moneyMaximumRepository;

    }
    @GetMapping(path = "/Category",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Category> Category() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/InsurancePremium",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<InsurancePremium> InsurancePremium() {
        return insurancePremiumRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Length",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Length> Length() {
        return lengthRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/MoneyMaximum",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MoneyMaximum> MoneyMaximum() {
        return moneyMaximumRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/Category",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Category postTreatmentHistory(@RequestBody Category dataTreatmentHistory){
        return  categoryRepository.save(dataTreatmentHistory);

    }
    // curl -X POST  http://localhost:8080/Category/"GGtypename"/1/1/4    //ตัว test class
    @PostMapping("/Category/{typeName}/{insuranceName}/{lengthName}/{moneyName}")
//@RequestMapping(path="Reg", method=RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Category category(@PathVariable String typeName, @PathVariable Long insuranceName,
                    @PathVariable Long lengthName,@PathVariable Long moneyName){

        InsurancePremium insurancePremiums = insurancePremiumRepository.findByID(insuranceName);
        Length lengthnames = lengthRepository.findByID(lengthName);
        MoneyMaximum moneynames = moneyMaximumRepository.findByID(moneyName);
        Category newCategory = new Category();
        newCategory.setTypeName(typeName);
        newCategory.setDate(new Date());
        newCategory.setInsurancePremium(insurancePremiums);
        newCategory.setLength(lengthnames);
        newCategory.setMoneyMaximum(moneynames);
        return categoryRepository.save(newCategory);
    }

}















