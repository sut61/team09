import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-ShowDiseaseAccidentDataResult',
  templateUrl: './ShowDiseaseAccidentDataResult.component.html',
  styleUrls: ['./ShowDiseaseAccidentDataResult.component.css']
})
export class ShowDiseaseAccidentDataResultComponent implements OnInit {

  DiseaseAccidentData : any = {};
  constructor(private route:ActivatedRoute) { }

      ngOnInit() {
          this.route.params.subscribe(prams=>{
            this.DiseaseAccidentData = prams
            console.log(prams)
          })
      }

}
