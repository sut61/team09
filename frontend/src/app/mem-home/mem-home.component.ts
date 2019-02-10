import { Component, OnInit } from '@angular/core';
import {memHomeService} from '../service/memHome.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-mem-home',
  templateUrl: './mem-home.component.html',
  styleUrls: ['./mem-home.component.css']
})
export class MemHomeComponent implements OnInit {

 User : Array<any>;
 Paid : Array<any>;
 Cost : Array<any>;

 code : any = { code : '' } ;

  constructor(private memHomeService: memHomeService , private httpClient: HttpClient ) { }

  ngOnInit() {
  this.memHomeService.getUser(localStorage.getItem('currentUser')).subscribe(data => { this.User = data; console.log(this.memHomeService);});
  this.memHomeService.getCost(localStorage.getItem('currentUser')).subscribe(dataa => { this.Cost = dataa; console.log(this.memHomeService);});
   this.memHomeService.getPaid(localStorage.getItem('currentUser')).subscribe(datab => { this.Paid = datab; console.log(this.memHomeService);});
  }

  submit(){
         if (this.code.code == null) {alert('กรุณาใส่ข้อมูลให้ครบถ้วน');}

          else{
            this.httpClient.delete('http://localhost:8080/pay/' + this.code.code
            ,this.code)
              .subscribe(
                 data => {
                 console.log(this.code)
                  console.log('PUT Request is successful', data);
                  {alert('ชำระแล้ว');}

                 },
                 error => { console.log('Rrror', error); }
              );

            }
        }


}
