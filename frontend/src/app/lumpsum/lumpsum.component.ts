import { Component, OnInit } from '@angular/core';
import { LumpsumserviceService } from '../service/lumpsumservice.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';
import { MatSnackBar } from '@angular/material';


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

constructor(private LumpsumserviceService : LumpsumserviceService ,private httpClient: HttpClient, private router:Router, private snackBar: MatSnackBar) { }
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

      if(this.Lumpsums.companyName == '')
      { this.snackBar.open("กรุณากรอกชื่อบริษัท", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Lumpsums.amoungEmp == '')
      { this.snackBar.open("กรุณาจำนวนพนักงาน", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Lumpsums.zipCode == '')
      { this.snackBar.open("กรุณากรอกรหัสไปรณีย์", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Lumpsums.address == '')
      { this.snackBar.open("กรุณากรอกที่อยู่", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[0-9\d]{1,3}\W.{1,20}\W.{1,20}/.test(this.Lumpsums.address) === false)
      { this.snackBar.open("ที่อยู่ไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Lumpsums.amoungEmp < 5 || this.Lumpsums.amoungEmp > 10000000)
      { this.snackBar.open("จำนวนพนักงานต้องมากกว่าเท่ากับ 5 หรือน้อยกว่าเท่ากับ 10,000,000", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Lumpsums.zipCode.length != 5)
      { this.snackBar.open("รหัสไปรษณีย์ไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

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
                  let snackBarRef = this.snackBar.open('บันทึกสำเร็จ', 'ตกลง',{
                    verticalPosition:"top", horizontalPosition: "center" });

             },
             error => { console.log('Rrror', error);
                let snackBarRef = this.snackBar.open('ข้อมูลไม่ถูกต้องหรืออาจมีชื่อบริษัทนี้แล้ว', 'ตกลง',{
                    verticalPosition:"top", horizontalPosition: "center" });
             }

          );

        }
    }


}

