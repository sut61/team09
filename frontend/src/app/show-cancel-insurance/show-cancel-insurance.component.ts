import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-show-cancel-insurance',
  templateUrl: './show-cancel-insurance.component.html',
  styleUrls: ['./show-cancel-insurance.component.css']
})
export class ShowCancelInsuranceComponent implements OnInit {

  cancelInsurances : any = {};
  constructor(private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
          this.cancelInsurances = prams
          console.log(prams)
  })
  }

}
