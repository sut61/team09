import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-show-appointment-result',
  templateUrl: './show-appointment-result.component.html',
  styleUrls: ['./show-appointment-result.component.css']
})
export class ShowAppointmentResultComponent implements OnInit {

Appointment : any = {};
constructor(private route:ActivatedRoute) { }

    ngOnInit() {
        this.route.params.subscribe(prams=>{
          this.Appointment = prams
          console.log(prams)
        })
    }

}
