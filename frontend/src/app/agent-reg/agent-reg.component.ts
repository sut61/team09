import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import {AgentRegService} from '../service/AgentReg.Service'
import {Router} from '@angular/router';

@Component({
  selector: 'app-agent-reg',
  templateUrl: './agent-reg.component.html',
  styleUrls: ['./agent-reg.component.css']
})
export class AgentRegComponent implements OnInit {
fName: Array<any>;
LName: Array<any>;
Category:Array<any>;
Education:Array<any>;
Province:Array<any>;

Agentregis : any = {
firstname: '',lastname: '',cattype: '',educational: '',aprovince: ''};



  constructor(private AgentRegService: AgentRegService,
              private httpClient: HttpClient,private router:Router) { }

  ngOnInit() {
this.AgentRegService.getCategory().subscribe(dataA => {
      this. Category = dataA;
      console.log(this. Category);
    });

this.AgentRegService.getEducational().subscribe(dataB => {
      this.  Education= dataB;
      console.log(this. Education);
    });
this.AgentRegService.getProvince().subscribe(dataC => {
      this.  Province= dataC;
      console.log(this. Province);
    });
}

 save() {
     if (this.Agentregis.firstname === ''|| this.Agentregis.lastname === '' ) {
       alert('กรุณากรอกข้อมูลให้ครบถ้วน');

        }  else if(this.Agentregis.firstname.length <= 1){

          alert('ชื่อสั้นเกินไป');

    }
          else if(this.Agentregis.lastname.length <= 1){

          alert('นามสกุลสั้นเกินไป');

    }

          else if(this.Agentregis.lastname.length > 30){

          alert('นามสกุลสยาวเกินไป');

    }
         else if(this.Agentregis.firstname.length > 30){

          alert('ชื่อยาวเกินไป');

    }

    else {
        this.httpClient.post('http://localhost:8080/AgentRegistration/' + this.Agentregis.firstname + '/' + this.Agentregis.lastname + '/'+ this.Agentregis.cattype + '/'+ this.Agentregis.educational + '/'+this.Agentregis.aprovince,
        this.Agentregis)
        .subscribe(
          data => {
           console.log(this.Agentregis)
              const Agentregis  = this.Agentregis
              this.router.navigate(['ShowagentRegisresultComponent',{firstname:Agentregis.firstname, lastname:Agentregis.lastname
              , cattype :this.Agentregis.cattype, educational :this.Agentregis.educational
              , aprovince :this.Agentregis.aprovince}])
              console.log('PUT Request is successful', data);
              {alert('ลงทะเบียนสำเร็จ!');}
                                        },
                                        error => {
                                            console.log('Rrror', error); {alert('ชื่อหรือนามสกุลมีอยู่แล้ว!');}
                                        }

                                    )

                                  }
                                }


}

