import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import {AgentRegService} from '../service/AgentReg.Service'
import {Router} from '@angular/router';
import { MatSnackBar } from '@angular/material';

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
              private httpClient: HttpClient, private router:Router,private snackBar: MatSnackBar ) { }

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

       if(this.Agentregis.firstname == null)
      { this.snackBar.open("กรุณากรอกชื่อจริง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Agentregis.firstname.length > 30)
      { this.snackBar.open("ความยาวชื่อจริงไม่ควรเกิน 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Agentregis.firstname.length < 2)
      { this.snackBar.open("ความยาวชื่อจริงต้องมากกว่า 2 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Agentregis.lastname == null)
      { this.snackBar.open("กรุณากรอกนามสกุล", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Agentregis.lastname.length > 30)
      { this.snackBar.open("ความยาวนามสกุลไม่ควรเกิน 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Agentregis.lastname.length < 2)
      { this.snackBar.open("ความยาวนามสกุลต้องมากกว่า 2 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }


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

                                        },
                                        error => {
 let snackBarRef = this.snackBar.open('ชื่อหรือนามสกุลมีแล้ว! กรุณากรอกใหม่', 'ตกลง',{
                    verticalPosition:"top", horizontalPosition: "center" });

                                        }

                                    )

                                  }
                                }


}

