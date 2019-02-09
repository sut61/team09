import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-show-lumpsum-result',
  templateUrl: './show-lumpsum-result.component.html',
  styleUrls: ['./show-lumpsum-result.component.css']
})
export class ShowLumpsumResultComponent implements OnInit {

  Lumpsums : any = {};
  constructor(private route:ActivatedRoute) { }

  ngOnInit() {
        this.route.params.subscribe(prams=>{
          this.Lumpsums = prams
          console.log(prams)
        })
    }

}
