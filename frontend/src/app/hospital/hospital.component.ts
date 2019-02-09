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
                                  if (this.Hospitalreg.firstname === '') {
                                    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
                                  } else {
                                    this.httpClient.post('http://localhost:8080/Hospital/' + this.Hospitalreg.namehos + '/' + this.Hospitalreg.nameagent + '/'+ this.Hospitalreg.catta + '/'+ this.Hospitalreg.province + '/'+this.Hospitalreg.sizehos,
                                    this.Hospitalreg)
                                    .subscribe(
                                        data => {alert('บันทึกสำเร็จ');

                                        },
                                        error => {
                                            console.log('Rrror', error);
                                        }

                                    );

                                  }
                                }


}

