import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-show-hospital-result',
  templateUrl: './show-hospital-result.component.html',
  styleUrls: ['./show-hospital-result.component.css']
})
export class ShowHospitalResultComponent implements OnInit {

  Hospitalreg : any = {};
constructor(private route:ActivatedRoute) { }

  ngOnInit() {
   this.route.params.subscribe(prams=>{
          this.Hospitalreg = prams
          console.log(prams)
  })
  }

}
