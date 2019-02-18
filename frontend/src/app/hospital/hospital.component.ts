import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import {HospitalService} from '../service/Hospital.Service'
import {Router} from '@angular/router';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hospitalname: Array<any>;
  agentname: Array<any>;
  Category:Array<any>;
  placehos:Array<any>;
  hossize:Array<any>;

  Hospitalreg : any = {
    namehos: '',nameagent: '',catta: '',province: '',sizehos: ''};

  constructor(private HospitalService: HospitalService,
              private httpClient: HttpClient,private router:Router) { }

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
 if (this.Hospitalreg.namehos === '') {
 alert('กรุณากรอกข้อมูลให้ครบถ้วน');
  }


    else if(this.Hospitalreg.namehos.length < 3){

          alert('ชื่อโรงพยาบาลสั้นเกินไป');

    }
    else if(this.Hospitalreg.namehos.length > 30){

          alert('ชื่อโรงพยาบาลยาวเกินไป');

    }


    else {
  this.httpClient.post('http://localhost:8080/Hospital/' + this.Hospitalreg.namehos + '/' + this.Hospitalreg.nameagent + '/'+ this.Hospitalreg.catta + '/'+ this.Hospitalreg.province + '/'+this.Hospitalreg.sizehos,
    this.Hospitalreg)
    .subscribe(
      data => {console.log(this.Hospitalreg)
        const Hospitalreg  = this.Hospitalreg
         this.router.navigate(['ShowHospitalResultComponent',{namehos:Hospitalreg.namehos, nameagent:Hospitalreg.nameagent
              , catta :this.Hospitalreg.catta, province :this.Hospitalreg.province
              , sizehos :this.Hospitalreg.sizehos}])
              console.log('PUT Request is successful', data);

                                      },
                                        error => {
                                            console.log('Rrror', error); {alert('ชื่อโรงพยาบาลซ้ำ!');}
                                        }

                                    );

                                  }
                                }


}

