import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-show-category-result',
  templateUrl: './show-category-result.component.html',
  styleUrls: ['./show-category-result.component.css']
})
export class ShowCategoryResultComponent implements OnInit {

  categorys : any = {};
  constructor(private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
          this.categorys = prams
          console.log(prams)
  })
  }

}
