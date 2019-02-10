import { Component, OnInit } from '@angular/core';
import { MemRegService } from '../service/memReg.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
  selector: 'app-member-registion',
  templateUrl: './member-registion.component.html',
  styleUrls: ['./member-registion.component.css']
})
export class MemberRegistionComponent implements OnInit {
Categories : Array<any>;
Provinces : Array<any>;
Agent : Array<any>;

Member : any ={ fName: '', lName: '', olds: '',PID: '' ,username: '' ,password: '',typeName: '',povin: '' , agnt: '' , addes: '' };

  constructor(private MemRegService : MemRegService , private httpClient: HttpClient, private router:Router) {}

  ngOnInit() {
   this.MemRegService.getCategory().subscribe(dataF => { this.Categories = dataF; console.log(this.Categories);});
   this.MemRegService.getProvince().subscribe(dataE => { this.Provinces = dataE; console.log(this.Provinces);});
   this.MemRegService.getAgent().subscribe(dataG => { this.Agent = dataG; console.log(this.Agent);});

  }


   save() {
       if (this.Member.fName == null || this.Member.lName == null ||
          this.Member.Olds == null || this.Member.PID == null ||
          this.Member.username == null || this.Member.password == null)
          {alert('กรุณากรอกข้อมูลให้ครบถ้วน');}

        else{
          this.httpClient.post('http://localhost:8080/Regmem/' +
           this.Member.fName + '/' + this.Member.lName + '/' + this.Member.Olds + '/'
           + this.Member.PID + '/' + this.Member.username + '/' + this.Member.password + '/' + this.Member.povin  + '/' +
           this.Member.agnt + '/' + this.Member.typeName +'/' + this.Member.addes
          ,this.Member)
            .subscribe(
               data => {

               },
               error => { console.log('Rrror', error); alert('ล้มเหลว!'); }


            );               alert('ลงทะเบียนสำเร็จ!');

          }
      }

}
