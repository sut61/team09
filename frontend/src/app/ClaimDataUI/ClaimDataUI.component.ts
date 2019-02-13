import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {ClaimDataService} from '../service/ClaimData.Service'
import {Router} from '@angular/router';

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
costAA:Array<any>;

ClaimData : any = {
memberDataS :''  ,diseaseAccidentDataS :'' ,categoryS :'',hospitalS :'',costA :''
};
  constructor(private Service : ClaimDataService ,private httpClient: HttpClient, private router:Router) { }

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

  }

  /**====SAVE====*/

  save(){

    if(this.ClaimData.memberDataS === ''|| this.ClaimData.diseaseAccidentDataS === ''||
    this.ClaimData.categoryS === ''|| this.ClaimData.costA === ''|| this.ClaimData.hospitalS === ''){

     alert('กรุณาเลือกข้อมูลให้ครบ!');
    }


     else if(/[^0-9]+/.test(this.ClaimData.costA) === true){

                      alert('กรอกค่ารักษาเฉพาตัวเลข');

                }
    else if(this.ClaimData.costA < 100){

          alert('จำนวนค่ารักษาน้อยกว่า 100  โปรดเช็คว่าค่ารักษาท่านว่าได้กรอกถูกแล้ว');

    }

     else if(this.ClaimData.costA > 100000000){

                   alert('จำนวนค่ารักษามากเกิน100,000,000 โปรดเช็คว่าค่ารักษาท่านว่าได้กรอกถูกแล้ว');

             }

    else  {

      this.httpClient.post('http://localhost:8080/ClaimData/NEW/'
      + this.ClaimData.memberDataS + '/'
      + this.ClaimData.diseaseAccidentDataS + '/'
      + this.ClaimData.categoryS + '/'
      + this.ClaimData.hospitalS + '/'
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
                               costA:ClaimData.costA}])

                               {alert('บันทึกสำเร็จ!');}
              },

        error => {console.log('Error', error);
            alert('ห้ามกรอก0 นำหน้า');
        }
      );

    }

  }

}
