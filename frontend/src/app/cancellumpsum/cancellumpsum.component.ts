import { Component, OnInit } from '@angular/core';
import { CancellumpsumService } from '../service/cancellumpsum.service';
import { LumpsumserviceService } from '../service/lumpsumservice.service';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-cancellumpsum',
templateUrl: './cancellumpsum.component.html',
  styleUrls: ['./cancellumpsum.component.css']
})
export class CancellumpsumComponent implements OnInit {

  Lumpsums : Array<any>;

  displayedColumns: string[] = ['iD','companyName','address','provinceId','zipCode','businessSizeId','establishmentId','categoryId','amoungEmp'];
  Contacts : Array<any>;
  Cancellumpsum : any = {
  LUMPSUM_ID: '' ,CONTACT_ID: '' , comment: ''};

  constructor(private cancellumpsumService : CancellumpsumService ,private httpClient: HttpClient) { }

  ngOnInit() {

    this.cancellumpsumService.getContact().subscribe(dataA => {
    this.Contacts = dataA;
    console.log(this.Contacts);});

    this.cancellumpsumService.getLumpsum().subscribe(dataF => {
    this.Lumpsums = dataF;
    console.log(this.Lumpsums);});

  }
save() {
      if(this.Cancellumpsum.LUMPSUM_ID === '' || this.Cancellumpsum.CONTACT_ID === ''||
      this.Cancellumpsum.comment === '' ){
      alert('กรุณใส่ข้อมูลให้ครบ');


      }else {
        this.httpClient.delete('http://localhost:8080/cancelLumpsum/' + this.Cancellumpsum.LUMPSUM_ID + '/'
        + this.Cancellumpsum.CONTACT_ID + '/'+ this.Cancellumpsum.comment,
        this.Cancellumpsum)
        .subscribe(
           data => {
              console.log('PUT Request is successful', data);
           },
           error => {
              console.log('Rrror', error);
            }
        );
         alert('ยกเลิกสำเร็จ');
     }
  }

}
