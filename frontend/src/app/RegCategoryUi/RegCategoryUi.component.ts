import { OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import {Component} from '@angular/core';
import {RegCategoryUiService} from  '../service/RegCategoryUi.Service';


@Component({
  selector: 'app-RegCategoryUi',
  templateUrl: './RegCategoryUi.component.html',
  styleUrls: ['./RegCategoryUi.component.css']
}
)

export class RegCategoryUiComponent implements OnInit {
  insurancePremiums:Array<any>;
  lengths:Array<any>;
  moneyMaximums:Array<any>;

  categorys:any = {typeName: '', insuranceName: '', lengthName: '', moneyName: ''};


  constructor(private Service : RegCategoryUiService ,private httpClient: HttpClient,private router:Router ) { }

  ngOnInit() {
      this.Service.getCategorys().subscribe(dataMe => {
                    this.categorys = dataMe;
                    console.log(this.categorys);
      });
      this.Service.getInsurancePremiums().subscribe(dataA => {
              this.insurancePremiums = dataA;
              console.log(this.insurancePremiums);
      });
      this.Service.getLengths().subscribe(dataB => {
                          this.lengths = dataB;
                          console.log(this.lengths);
      });
      this.Service.getMoneyMaximums().subscribe(dataC => {
              this.moneyMaximums = dataC;
              console.log(this.moneyMaximums);
        });
      }
      save() {
      if(this.categorys.typeName === '' || this.categorys.insuranceName === ''||
      this.categorys.lengthName === ''  ||
      this.categorys.moneyName === ''){

      alert('กรุณใส่ข้อมูลให้ครบ');

      }
      else if(/^[A-z]*[ก-๐]|^[ก-๐]*[A-z]/.test(this.categorys.typeName) === false){
          alert('กรอกประเภทประกันชีวิตให้ถูกต้อง');

      }
      else if(this.categorys.typeName.length < 6){
          alert('ข้อมูลประเภทประกันต้องมีความยาว ไม่ต่ำกว่า 6 ตัว');
      }
      else if(this.categorys.typeName.length > 30){
          alert('ข้อมูลประเภทประกันต้องมีความยาว ห้ามเกิน 30 ตัว');
      }

      else {
        this.httpClient.post('http://localhost:8080/Category/' + this.categorys.typeName + '/'
        + this.categorys.insuranceName + '/'+ this.categorys.lengthName  + '/'
        +this.categorys.moneyName,
        this.categorys)
        .subscribe(
           data => {
              console.log('PUT Request is successful', data);
           },
           error => {
              console.log('Rrror', error);
            }
        );
         alert('บันทึกสำเร็จ');
     }
  }
}


