import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import {DiseaseAccidentDataService} from '../service/DiseaseAccidentData.Service'
import {Router} from '@angular/router';

@Component({
  selector: 'app-DiseaseAccidentDataUI',
  templateUrl: './DiseaseAccidentDataUI.component.html',
  styleUrls: ['./DiseaseAccidentDataUI.component.css']
})
export class DiseaseAccidentDataUIComponent implements OnInit {

dataNameA:Array<any>;
typeIdA:Array<any>;
levelIdA:Array<any>;
medicalFeeIdA:Array<any>;


DiseaseAccidentData : any = {
dataNameAdd :''  ,typeIdSelect :'' ,levelIdSelect :'',medicalFeeIdSelect :''
};
  constructor(private Service : DiseaseAccidentDataService ,private httpClient: HttpClient) { }

  ngOnInit() {
   this.Service.getDiseaseAccidentLevel().subscribe(data1 => {
          this.levelIdA = data1;
          console.log(this.levelIdA);
        });

   this.Service.getDiseaseAccidentType().subscribe(data2 => {
             this.typeIdA = data2;
             console.log(this.typeIdA);
           });

   this.Service.getMedicalFee().subscribe(data3 => {
                this.medicalFeeIdA = data3;
                console.log(this.medicalFeeIdA);
              });

  }

  /**====SAVE====*/
  save(){
    if(this.DiseaseAccidentData.dataNameAdd === ''||this.DiseaseAccidentData.levelIdSelect === ''||
    this.DiseaseAccidentData.typeIdSelect === ''||this.DiseaseAccidentData.medicalFeeIdSelect === ''){

      alert('กรุณาเลือกข้อมูลให้ครบ');

    }else{

      this.httpClient.post('http://localhost:8080/DiseaseAccidentData/NEW/'
      + this.DiseaseAccidentData.dataNameAdd + '/'
      + this.DiseaseAccidentData.levelIdSelect + '/'
      + this.DiseaseAccidentData.typeIdSelect + '/'
      + this.DiseaseAccidentData.medicalFeeIdSelect
       ,this.DiseaseAccidentData)

      .subscribe(

        data => {

        console.log('PUT Request is successful' , data);

        },

        error => {

        console.log('Error ' , error);

        }
      );
       alert('บันทึกสำเร็จ');
    }
  }

}
