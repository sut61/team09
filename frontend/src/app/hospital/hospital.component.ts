import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import {HospitalService} from '../service/Hospital.Service'
import {Router} from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hospitalname: Array<any>;
  ofname: Array<any>;
  olname: Array<any>;
  telphone: Array<any>;
  email: Array<any>;
  agentname: Array<any>;
  Category:Array<any>;
  placehos:Array<any>;
  hossize:Array<any>;

  Hospitalreg : any = {
    namehos:'',fname:'',lname:'',phone:'',mail: '',nameagent: '',catta: '',province: '',sizehos: ''};

  constructor(private HospitalService: HospitalService,
              private httpClient: HttpClient,private router:Router,private snackBar: MatSnackBar) { }

  ngOnInit() {
this.HospitalService.getAgent().subscribe(dataA => {
      this. agentname = dataA;
      console.log(this. agentname);
    });

this.HospitalService.getCate().subscribe(dataB => {
      this.  Category= dataB;
      console.log(this. Category);
    });
this.HospitalService.getProvince().subscribe(dataC => {
      this.  placehos= dataC;
      console.log(this. placehos);
    });
this.HospitalService.getHosSize().subscribe(dataD => {
      this.  hossize= dataD;
      console.log(this. hossize);
    });
}

 save() {
    if(this.Hospitalreg.namehos == "")
      { this.snackBar.open("กรุณากรอกชื่อโรงพยาบาล", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Hospitalreg.namehos.length > 30)
      { this.snackBar.open("ความยาวชื่อโรงพยาบาลไม่ควรเกิน 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Hospitalreg.namehos.length < 2)
      { this.snackBar.open("ความยาวชื่อโรงพยาบาลต้องมากกว่า 2 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

       else if(this.Hospitalreg.fname == "")
      { this.snackBar.open("กรุณากรอกชื่อ ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if(this.Hospitalreg.fname.length > 30)
      { this.snackBar.open("ความยาวชื่อต้องน้อยกว่า 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if(this.Hospitalreg.fname.length < 2)
      { this.snackBar.open("ความยาวชื่อต้องมากกว่า 1 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

       else if(this.Hospitalreg.lname == "")
      { this.snackBar.open("กรุณากรอกนามสกุล", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if(this.Hospitalreg.lname.length > 30)
      { this.snackBar.open("ความยาวนามสกุลต้องน้อยกว่า 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if(this.Hospitalreg.lname.length < 2)
      { this.snackBar.open("ความยาวชนามสกุลต้องมากกว่า 1 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

      else if(this.Hospitalreg.phone == "")
      { this.snackBar.open("กรุณากรอกเบอร์โทรศัพท์โรงพยาบาล", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[0]{1}[2-9]{1}[0-9]{7}/.test(this.Hospitalreg.phone) === false)
      { this.snackBar.open("รูปแบบเบอร์โทรศัพท์ไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

       else if(this.Hospitalreg.mail == "")
      { this.snackBar.open("กรุณากรอก email", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[A-Za-z0-9][A-Za-z0-9.]{7}[A-Za-z0-9.]*@[a-z]+.[a-z.]+/.test(this.Hospitalreg.mail) === false)
      { this.snackBar.open("รูปแบบ email ไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

       else if(this.Hospitalreg.nameagent == "")
      { this.snackBar.open("กรุณาเลือกตัวแทน", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

      else if(this.Hospitalreg.catta == "")
      { this.snackBar.open("กรุณาเลือกประเภท", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

      else if(this.Hospitalreg.province == "")
      { this.snackBar.open("กรุณาเลือกจังหวัด", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

      else if(this.Hospitalreg.sizehos == "")
      { this.snackBar.open("กรุณาเลือกขนาดโรงพยาบาล", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }




    else {
  this.httpClient.post('http://localhost:8080/Hospital/' + this.Hospitalreg.namehos + '/' + this.Hospitalreg.fname+ '/' + this.Hospitalreg.lname+ '/' + this.Hospitalreg.phone+ '/' + this.Hospitalreg.mail+ '/' + this.Hospitalreg.nameagent + '/'+ this.Hospitalreg.catta + '/'+ this.Hospitalreg.province + '/'+this.Hospitalreg.sizehos,
    this.Hospitalreg)
    .subscribe(
      data => {console.log(this.Hospitalreg)
        const Hospitalreg  = this.Hospitalreg
         this.router.navigate(['ShowHospitalResultComponent',{namehos:Hospitalreg.namehos
         , fname:Hospitalreg.fname, lname:Hospitalreg.lname
          , phone:Hospitalreg.phone, mail:Hospitalreg.mail
         , nameagent:Hospitalreg.nameagent
              , catta :this.Hospitalreg.catta, province :this.Hospitalreg.province
              , sizehos :this.Hospitalreg.sizehos}])
              console.log('PUT Request is successful', data);

                                      },
                                        error => {
                                            let snackBarRef = this.snackBar.open('ชื่อโรงพยาบาลมีแล้ว! กรุณากรอกใหม่', 'ตกลง',{
                    verticalPosition:"top", horizontalPosition: "center" });
                                        }

                                    );

                                  }
                                }


}

