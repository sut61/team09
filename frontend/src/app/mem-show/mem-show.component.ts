import { Component, OnInit } from '@angular/core';
import { memShowService } from '../service/memShow.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
  selector: 'app-mem-show',
  templateUrl: './mem-show.component.html',
  styleUrls: ['./mem-show.component.css']
})
export class MemShowComponent implements OnInit {
Member : Array<any>;

  constructor(private memShowService : memShowService , private httpClient: HttpClient, private router:Router ) { }

  ngOnInit() {
   this.memShowService.getMem().subscribe(dataF => { this.Member = dataF; console.log(this.Member);});
  }

}
