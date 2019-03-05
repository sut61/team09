import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {DiseaseAccidentDataService} from '../service/DiseaseAccidentData.Service'
import {Router} from '@angular/router';
import { MatSnackBar } from '@angular/material';

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
ownerDataA:Array<any>;


DiseaseAccidentData : any = {
dataNameAdd :''  ,typeIdSelect :'' ,levelIdSelect :'',medicalFeeIdSelect :'',ownerDataAdd :''
};
  constructor(private Service : DiseaseAccidentDataService ,private httpClient: HttpClient, private router:Router,private snackBar: MatSnackBar) { }

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

    if(this.DiseaseAccidentData.dataNameAdd === ''){
           /**    alert('กรุณากรอก ชื่อโรค/อุบัติเหตุ !'); */
             this.snackBar.open("กรุณากรอก ชื่อโรค/อุบัติเหตุ !", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

    }
    else if( this.DiseaseAccidentData.typeIdSelect === ''){

            /**   alert('กรุณาเลือก ชนิดสิทธิคุ้มครอง !'); */
              this.snackBar.open("กรุณาเลือก ชนิดสิทธิคุ้มครอง !", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

        }
    else if(this.DiseaseAccidentData.levelIdSelect === ''){
      /**         alert('กรุณาเลือก ระดับความรุนแรง !'); */
        this.snackBar.open("กรุณาเลือก ระดับความรุนแรง !", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


        }
    else if(this.DiseaseAccidentData.medicalFeeIdSelect === ''){
        /**       alert('กรุณาเลือก ค่ารักษารายวัน !'); */
          this.snackBar.open("กรุณาเลือก ค่ารักษารายวัน !", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


        }
     else if(this.DiseaseAccidentData.ownerDataAdd === ''){

                  this.snackBar.open("กรุณากรอก ชื่อผู้ใส่ข้อมูล !", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


                }
    else if(/[A-Za-z]+/.test(this.DiseaseAccidentData.dataNameAdd) === true){

              /**     alert('ไม่รองรับภาษาอังกฤษ กรุณา ชื่อโรค/อุบัติเหตุ เป็นภาษาไทย'); */
                this.snackBar.open("ไม่รองรับภาษาอังกฤษ กรุณา ชื่อโรค/อุบัติเหตุ เป็นภาษาไทย", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


        }

    else if(this.DiseaseAccidentData.dataNameAdd.length < 3){

              /**     alert('ข้อมูล ชื่อโรค/อุบัติเหตุ ! 3 อักขระขึ้นไป'); */
               this.snackBar.open("ข้อมูล ชื่อโรค/อุบัติเหตุ ! 3 อักขระขึ้นไป", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


        }
        else if(this.DiseaseAccidentData.dataNameAdd.length > 50){

               /**    alert('ข้อมูล ชื่อโรค/อุบัติเหตุ ! ยาวเกิน 50 อักขระ'); */
                           this.snackBar.open("ข้อมูล ชื่อโรค/อุบัติเหตุ ! ยาวเกิน 50 อักขระ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

        }

    else if(/[A-Za-z]+/.test(this.DiseaseAccidentData.ownerDataAdd) === true){

                  /**     alert('ไม่รองรับภาษาอังกฤษ กรุณา ชื่อผู้ใส่ข้อมูล เป็นภาษาไทย'); */
                    this.snackBar.open("ไม่รองรับภาษาอังกฤษ กรุณากรอก ชื่อผู้ใส่ข้อมูล เป็นภาษาไทย", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


            }



    else{

      this.httpClient.post('http://localhost:8080/DiseaseAccidentData/NEW/'
      + this.DiseaseAccidentData.dataNameAdd + '/'
      + this.DiseaseAccidentData.levelIdSelect + '/'
      + this.DiseaseAccidentData.typeIdSelect + '/'
      + this.DiseaseAccidentData.medicalFeeIdSelect + '/'
      + this.DiseaseAccidentData.ownerDataAdd + '/'
       ,this.DiseaseAccidentData)

      .subscribe(


        data => {

         console.log('PUT Request is successful', data);
        console.log(this.DiseaseAccidentData)
                               const DiseaseAccidentData  = this.DiseaseAccidentData
                               this.router.navigate(['ShowDiseaseAccidentDataResult',{
                               dataNameAdd:DiseaseAccidentData.dataNameAdd,
                               typeIdSelect:DiseaseAccidentData.levelIdSelect,
                               levelIdSelect:DiseaseAccidentData.typeIdSelect,
                               medicalFeeIdSelect:DiseaseAccidentData.medicalFeeIdSelect,
                               ownerDataAdd:DiseaseAccidentData.ownerDataAdd}])


              },

        error => {console.log('Error DiseaseAccidentData', error);
                      /** alert('ชื่อโรค/อุบัติเหตุ นี้มีในฐานข้อมูลแล้ว !!'); */
                       this.snackBar.open("ชื่อโรค/อุบัติเหตุ นี้มีในฐานข้อมูลแล้ว !!", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

        }
      );

    }
  }

}
