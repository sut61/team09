import { Component, OnInit } from '@angular/core';
import { LumpsumserviceService } from '../service/lumpsumservice.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';


@Component({
  selector: 'app-lumpsum',
  templateUrl: './lumpsum.component.html',
  styleUrls: ['./lumpsum.component.css']
})
export class LumpsumComponent implements OnInit {
BusinessSizes : Array<any>;
Categories: Array<any>;
Establishmentes : Array<any>;
Agents : Array<any>;
Provinces : Array<any>;
Lumpsums : any = {
companyName: '', amoungEmp: '', address: '', zipCode: '', BUSINESS_ID: '', CATEGORY_ID: ''
,ESTABLISHMENT_ID: '' , AGENTREGISTRATION_ID: '', PROVINCE_ID: ''};

constructor(private LumpsumserviceService : LumpsumserviceService ,private httpClient: HttpClient, private router:Router) { }
  ngOnInit() {
    this.LumpsumserviceService.getBusinessSize().subscribe(dataA => {
    this.BusinessSizes = dataA;
    console.log(this.BusinessSizes);});

    this.LumpsumserviceService.getCategory().subscribe(dataF => {
    this.Categories = dataF;
    console.log(this.Categories);});

    this.LumpsumserviceService.getEstablishment().subscribe(dataB => {
    this.Establishmentes = dataB;
    console.log(this.Establishmentes);});

    this.LumpsumserviceService.getAgentRegistration().subscribe(dataC =>{
    this.Agents = dataC;
    console.log(this.Agents);});

    this.LumpsumserviceService.getProvince().subscribe(dataD => {
    this.Provinces = dataD;
    console.log(this.Provinces);});
    }


save() {
     if (this.Lumpsums.companyName == null || this.Lumpsums.amoungEmp == null  || this.Lumpsums.address == null  || this.Lumpsums.zipCode == null
      || this.Lumpsums.BUSINESS_ID == null  || this.Lumpsums.CATEGORY_ID == null  || this.Lumpsums.ESTABLISHMENT_ID == null  || this.Lumpsums.PROVINCE_ID == null )
        {alert('กรุณากรอกข้อมูลให้ครบถ้วน');}

        else if(this.Lumpsums.zipCode.length != 5)
        {alert('รหัสไปรษณีย์ไม่ถูกต้อง');}

      else{
        this.httpClient.post('http://localhost:8080/Lumpsum/NEW/' + this.Lumpsums.companyName + '/'
        + this.Lumpsums.amoungEmp + '/' + this.Lumpsums.address + '/' + this.Lumpsums.zipCode + '/'
        + this.Lumpsums.BUSINESS_ID + '/' + this.Lumpsums.CATEGORY_ID + '/' + this.Lumpsums.ESTABLISHMENT_ID + '/'
        + this.Lumpsums.PROVINCE_ID ,this.Lumpsums)
          .subscribe(
             data => {
                console.log(this.Lumpsums)
                  const Lumpsums  = this.Lumpsums
                  this.router.navigate(['ShowLumpsumResultComponent',{companyName:Lumpsums.companyName, amoungEmp:Lumpsums.amoungEmp
                  , address:Lumpsums.address, zipCode :this.Lumpsums.zipCode, BUSINESS_ID:Lumpsums.BUSINESS_ID , CATEGORY_ID:Lumpsums.CATEGORY_ID
                  , ESTABLISHMENT_ID:Lumpsums.ESTABLISHMENT_ID, PROVINCE_ID:Lumpsums.PROVINCE_ID}])
                  console.log('PUT Request is successful', data);
                  {alert('บันทึกสำเร็จ!');}

             },
             error => { console.log('Rrror', error); }
          );

        }
    }


}

