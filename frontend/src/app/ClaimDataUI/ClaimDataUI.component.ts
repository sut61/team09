import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {ClaimDataService} from '../service/ClaimData.Service'
import {Router} from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-claim-data',
  templateUrl: './ClaimDataUI.component.html',
  styleUrls: ['./ClaimDataUI.component.css']
})
export class ClaimDataUIComponent implements OnInit {

memberDataSS:Array<any>;
diseaseAccidentDataSS:Array<any>;
categorySS:Array<any>;
hospitalSS:Array<any>;
treatmentStyleSS:Array<any>;
costAA:Array<any>;

ClaimData : any = {
memberDataS :''  ,diseaseAccidentDataS :'' ,categoryS :'',hospitalS :'',treatmentStyleS :'',costA :''
};
  constructor(private Service : ClaimDataService ,private httpClient: HttpClient, private router:Router,private snackBar: MatSnackBar) { }

  ngOnInit() {

   this.Service.getMemberData().subscribe(data1 => {
            this.memberDataSS = data1;
            console.log(this.memberDataSS);
          });

   this.Service.getDiseaseAccidentData().subscribe(data2 => {
               this.diseaseAccidentDataSS = data2;
               console.log(this.diseaseAccidentDataSS);
             });

   this.Service.getCategory().subscribe(data3 => {
                  this.categorySS = data3;
                  console.log(this.categorySS);
                });


   this.Service.getHospital().subscribe(data4 => {
                     this.hospitalSS = data4;
                     console.log(this.hospitalSS);
                   });

   this.Service.getTreatmentStyle().subscribe(data5 => {
                        this.treatmentStyleSS = data5;
                        console.log(this.treatmentStyleSS);
                      });

  }

  /**====SAVE====*/

 /** this.snackBar.open("กรุณาเลือก ผู้ใช้สิทธิ์!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});  */

  save(){

    if(this.ClaimData.memberDataS === ''){
      alert('กรุณาเลือก ผู้ใช้สิทธิ์!');

    }


     else if(this.ClaimData.diseaseAccidentDataS === ''){
      alert('กรุณาเลือก ชื่อโรค/อุบัติเหตุ!');


                }
      else if(this.ClaimData.categoryS === ''){
      alert('กรุณาเลือก ประกันที่ใช้!');


                     }
      else if(this.ClaimData.hospitalS === ''){
      alert('กรุณาเลือก โรงบาลที่รักษา!');


                     }
      else if(this.ClaimData.treatmentStyleSS === ''){
      alert('กรุณาเลือก รูปแบบการรักษา!');



                     }
      else if(this.ClaimData.costA === ''){
      alert('กรุณากรอก ค่ารักษาพยาบาล!');


                     }
      else if(/[^0-9]+/.test(this.ClaimData.costA) === true){
      alert('กรอกค่ารักษาเฉพาตัวเลข และไม่ต้องใส่เครื่องหมายทุกชนิด');


                     }

    else if(this.ClaimData.costA < 100){
      alert('จำนวนค่ารักษาน้อยกว่า 100 บาท ?! โปรดเช็คว่าได้กรอกค่ารักษาพยาบาลที่ถูกต้องแล้ว');



    }

     else if(this.ClaimData.costA > 10000000){
      alert('จำนวนค่ารักษามากเกิน10,000,000 บาท ?! โปรดเช็คว่าได้กรอกค่ารักษาพยาบาลที่ถูกต้องแล้ว');

             }

    else  {

      this.httpClient.post('http://localhost:8080/ClaimData/NEW/'
      + this.ClaimData.memberDataS + '/'
      + this.ClaimData.diseaseAccidentDataS + '/'
      + this.ClaimData.categoryS + '/'
      + this.ClaimData.hospitalS + '/'
      + this.ClaimData.treatmentStyleS + '/'
      + this.ClaimData.costA
       ,this.ClaimData)

      .subscribe(


        data => {

        console.log('PUT Request is successful', data);

        console.log(this.ClaimData)
                               const ClaimData  = this.ClaimData
                               this.router.navigate(['ShowClaimDataResult',{
                               memberDataS:ClaimData.memberDataS,
                               diseaseAccidentDataS:ClaimData.diseaseAccidentDataS,
                               categoryS:ClaimData.categoryS,
                               hospitalS:ClaimData.hospitalS,
                               treatmentStyleS:ClaimData.treatmentStyleS,
                               costA:ClaimData.costA}])


              },

        error => {console.log('Error', error);
                alert('เกิดข้อผิดพลาด!!!');

        }
      );

    }

  }

}
