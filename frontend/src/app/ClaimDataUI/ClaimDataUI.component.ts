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
memberDataS :''  ,diseaseAccidentDataS :'' ,categoryS :'',hospitalS :'',treatmentStyleS :'',costA :'',doctorNameAdd :'',dataOwnerAdd :'',dataOwnerPhoneAdd :''
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
   /**   alert('กรุณาเลือก ผู้ใช้สิทธิ์!'); */
      this.snackBar.open("กรุณาเลือก ผู้ใช้สิทธิ์!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

    }


     else if(this.ClaimData.diseaseAccidentDataS === ''){
    /**  alert('กรุณาเลือก ชื่อโรค/อุบัติเหตุ!'); */
      this.snackBar.open("กรุณาเลือก ชื่อโรค/อุบัติเหตุ!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                }
      else if(this.ClaimData.categoryS === ''){
    /**  alert('กรุณาเลือก ประกันที่ใช้!'); */
      this.snackBar.open("กรุณาเลือก ประกันที่ใช้!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                     }
      else if(this.ClaimData.hospitalS === ''){
    /**  alert('กรุณาเลือก โรงบาลที่รักษา!'); */
      this.snackBar.open("กรุณาเลือก โรงบาลที่รักษา!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                     }
      else if(this.ClaimData.treatmentStyleS === ''){

      this.snackBar.open("กรุณาเลือก รูปแบบการรักษา!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});



                     }
      else if(this.ClaimData.costA === ''){
    /**  alert('กรุณากรอก ค่ารักษาพยาบาล!'); */
      this.snackBar.open("กรุณากรอก ค่ารักษาพยาบาล!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                     }
     else if(this.ClaimData.doctorNameAdd === ''){
         /**  alert('กรุณากรอก ค่ารักษาพยาบาล!'); */
           this.snackBar.open("กรุณากรอก ชื่อผู้รักษา!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                          }
     else if(this.ClaimData.dataOwnerAdd === ''){
         /**  alert('กรุณากรอก ค่ารักษาพยาบาล!'); */
           this.snackBar.open("กรุณากรอก ชื่อผู้ใส่ข้อมูล!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                          }
     else if(this.ClaimData.dataOwnerPhoneAdd === ''){
         /**  alert('กรุณากรอก ค่ารักษาพยาบาล!'); */
           this.snackBar.open("กรุณากรอก เบอร์โทรผู้ใส่ข้อมูล!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                          }
      else if(/[^0-9]+/.test(this.ClaimData.costA) === true){
   /**   alert('กรอกค่ารักษาเฉพาตัวเลข และไม่ต้องใส่เครื่องหมายทุกชนิด'); */
      this.snackBar.open("กรอกค่ารักษาเฉพาตัวเลข และไม่ต้องใส่เครื่องหมายทุกชนิด", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                     }

       else if(this.ClaimData.costA < 100){
          /**  alert('จำนวนค่ารักษาน้อยกว่า 100 บาท ?! โปรดเช็คว่าได้กรอกค่ารักษาพยาบาลที่ถูกต้องแล้ว'); */
            this.snackBar.open("จำนวนค่ารักษาน้อยกว่า 100 บาท ?! โปรดเช็คว่าได้กรอกค่ารักษาพยาบาลที่ถูกต้องแล้ว", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});



          }

           else if(this.ClaimData.costA > 10000000){
           /** alert('จำนวนค่ารักษามากเกิน10,000,000 บาท ?! โปรดเช็คว่าได้กรอกค่ารักษาพยาบาลที่ถูกต้องแล้ว'); */
            this.snackBar.open("จำนวนค่ารักษามากเกิน10,000,000 บาท ?! โปรดเช็คว่าได้กรอกค่ารักษาพยาบาลที่ถูกต้องแล้ว", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

                   }


     else if(/[^0-9]+/.test(this.ClaimData.dataOwnerPhoneAdd) === true){
        /**   alert('กรอกค่ารักษาเฉพาตัวเลข และไม่ต้องใส่เครื่องหมายทุกชนิด'); */
           this.snackBar.open("กรอกเบอร์โทรผู้ใส่ข้อมูลเฉพาตัวเลข เท่านั้น", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                          }
     else if(this.ClaimData.dataOwnerPhoneAdd.length < 10 ||this.ClaimData.dataOwnerPhoneAdd.length > 10){

              /**     alert('ข้อมูล ชื่อโรค/อุบัติเหตุ ! 3 อักขระขึ้นไป'); */
               this.snackBar.open("กรอกเบอร์โทรผู้ใส่ข้อมูล 10 ตัวเลขเท่านั้น", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


        }
     else if(/[A-Za-z]+/.test(this.ClaimData.doctorNameAdd) === true){

                      /**     alert('ไม่รองรับภาษาอังกฤษ กรุณา ชื่อผู้ใส่ข้อมูล เป็นภาษาไทย'); */
                        this.snackBar.open("ไม่รองรับภาษาอังกฤษ กรุณากรอก ชื่อผู้รักษา เป็นภาษาไทย", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                }
      else if(/[A-Za-z]+/.test(this.ClaimData.dataOwnerAdd) === true){

                       /**     alert('ไม่รองรับภาษาอังกฤษ กรุณา ชื่อผู้ใส่ข้อมูล เป็นภาษาไทย'); */
                         this.snackBar.open("ไม่รองรับภาษาอังกฤษ กรุณากรอก ชื่อผู้ใส่ข้อมูล เป็นภาษาไทย", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                 }



    else  {

      this.httpClient.post('http://localhost:8080/ClaimData/NEW/'
      + this.ClaimData.memberDataS + '/'
      + this.ClaimData.diseaseAccidentDataS + '/'
      + this.ClaimData.categoryS + '/'
      + this.ClaimData.hospitalS + '/'
      + this.ClaimData.treatmentStyleS + '/'
      + this.ClaimData.costA + '/'
      + this.ClaimData.doctorNameAdd + '/'
      + this.ClaimData.dataOwnerAdd + '/'
      + this.ClaimData.dataOwnerPhoneAdd + '/'
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
                               costA:ClaimData.costA,
                               doctorNameAdd:ClaimData.doctorNameAdd,
                               dataOwnerAdd:ClaimData.dataOwnerAdd,
                               dataOwnerPhoneAdd:ClaimData.dataOwnerPhoneAdd
                               }])


              },

        error => {console.log('Error ', error);
               /** alert('เกิดข้อผิดพลาด!!!'); */
               this.snackBar.open("เกิดข้อผิดพลาด!!!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

        }
      );

    }

  }

}
