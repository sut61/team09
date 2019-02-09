import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-showagent-regisresult',
  templateUrl: './showagent-regisresult.component.html',
  styleUrls: ['./showagent-regisresult.component.css']
})
export class ShowagentRegisresultComponent implements OnInit {

Agentregis : any = {};
constructor(private route:ActivatedRoute) { }

  ngOnInit() {
   this.route.params.subscribe(prams=>{
          this.Agentregis = prams
          console.log(prams)
  })
  }

}
