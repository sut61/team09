import { Component, OnInit } from '@angular/core';
import { LumpsumserviceService } from '../service/lumpsumservice.service';
import { HttpClient } from '@angular/common/http';


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

constructor(private LumpsumserviceService : LumpsumserviceService ,private httpClient: HttpClient) { }
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

    this.LumpsumserviceService.getProvince().subscribe(dataD => {
     this.Lumpsums = dataD;
     console.log(this.Lumpsums);});
    }

save() {
     if (this.Lumpsums.companyName == null  )
        {alert('กรุณากรอกข้อมูลให้ครบถ้วน');}

      else{
        this.httpClient.post('http://localhost:8080/Lumpsum/NEW/' + this.Lumpsums.companyName + '/'
        + this.Lumpsums.amoungEmp + '/' + this.Lumpsums.address + '/' + this.Lumpsums.zipCode + '/'
        + this.Lumpsums.BUSINESS_ID + '/' + this.Lumpsums.CATEGORY_ID + '/' + this.Lumpsums.ESTABLISHMENT_ID + '/'+ this.Lumpsums.PROVINCE_ID + '/'
        ,this.Lumpsums)
          .subscribe(
             data => {

              {alert('ลงทะเบียนสำเร็จ!');}

             },
             error => { console.log('Rrror', error); }
          );               alert('ลงทะเบียนสำเร็จ!');

        }
    }


}

