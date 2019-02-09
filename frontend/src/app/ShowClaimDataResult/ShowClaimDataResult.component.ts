import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-ShowClaimDataResult',
  templateUrl: './ShowClaimDataResult.component.html',
  styleUrls: ['./ShowClaimDataResult.component.css']
})
export class ShowClaimDataResultComponent implements OnInit {

   ClaimData : any = {};
    constructor(private route:ActivatedRoute) { }

        ngOnInit() {
            this.route.params.subscribe(prams=>{
              this.ClaimData = prams
              console.log(prams)
            })
        }

}
