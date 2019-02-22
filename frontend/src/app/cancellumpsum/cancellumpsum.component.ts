import { Component, OnInit } from '@angular/core';
import { CancellumpsumService } from '../service/cancellumpsum.service';
import { LumpsumserviceService } from '../service/lumpsumservice.service';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';
import { Router} from '@angular/router';




@Component({
  selector: 'app-cancellumpsum',
templateUrl: './cancellumpsum.component.html',
  styleUrls: ['./cancellumpsum.component.css']
})
export class CancellumpsumComponent implements OnInit {

  Lumpsums : Array<any>;

  displayedColumns: string[] = ['iD','companyName','address','provinceId','zipCode','businessSizeId','establishmentId','categoryId','amoungEmp'];
  Contacts : Array<any>;
  Provinces : Array<any>;
  Cancellumpsum : any = {
  LUMPSUM_ID: '' ,CONTACT_ID: '' , comment: '',PROVINCE_ID: '' ,nameCan: '' , ageCan: '', IDcardCan: ''};

  constructor(private cancellumpsumService : CancellumpsumService ,private httpClient: HttpClient, private router:Router, private snackBar: MatSnackBar) { }

  ngOnInit() {

    this.cancellumpsumService.getContact().subscribe(dataA => {
    this.Contacts = dataA;
    console.log(this.Contacts);});

    this.cancellumpsumService.getLumpsum().subscribe(dataF => {
    this.Lumpsums = dataF;
    console.log(this.Lumpsums);});

    this.cancellumpsumService.getProvince().subscribe(dataC => {
    this.Provinces = dataC;
    console.log(this.Provinces);});

  }
save() {

      if(this.Cancellumpsum.LUMPSUM_ID == '')
      { this.snackBar.open("กรุณากรอกIDบริษัท", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Cancellumpsum.comment == '')
      { this.snackBar.open("กรุณากรอกความคิดเห็น", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Cancellumpsum.nameCan == '')
      { this.snackBar.open("กรุณากรอกชื่อผู้มายกเลิก", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Cancellumpsum.ageCan == '')
      { this.snackBar.open("กรุณากรอกอายุ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Cancellumpsum.IDcardCan == '')
      { this.snackBar.open("กรุณากรอกเลขประจำตัวประชาชน", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[0-9]{13}/.test(this.Cancellumpsum.IDcardCan) === false)
      { this.snackBar.open("รูปแบบเลขประจำตัวประชาชนไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Cancellumpsum.ageCan < 20 || this.Cancellumpsum.ageCan > 80)
      { this.snackBar.open("ต้องมีอายุระหว่าง 20 ถึง 80 ปี", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Cancellumpsum.nameCan.length > 50)
      { this.snackBar.open("ความยาวชื่อต้องน้อยกว่า50ตัว", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

      else {
        this.httpClient.delete('http://localhost:8080/cancelLumpsum/' + this.Cancellumpsum.LUMPSUM_ID + '/'
        + this.Cancellumpsum.CONTACT_ID + '/'+ this.Cancellumpsum.comment + '/'+ this.Cancellumpsum.PROVINCE_ID
        + '/'+ this.Cancellumpsum.nameCan + '/'+ this.Cancellumpsum.ageCan + '/'+ this.Cancellumpsum.IDcardCan ,
        this.Cancellumpsum)
        .subscribe(
           data => {
              console.log('PUT Request is successful', data);
              let snackBarRef = this.snackBar.open('ยกเลิกสำเร็จ', 'ตกลง',{
                    verticalPosition:"top", horizontalPosition: "center" });

           },
           error => {
              console.log('Rrror', error);
              let snackBarRef = this.snackBar.open('ข้อมูลไม่ถูกต้องหรืออาจไม่มี ID บริษัทนี้', 'ตกลง',{
                    verticalPosition:"top", horizontalPosition: "center" });
            }
        );

     }
  }

}
