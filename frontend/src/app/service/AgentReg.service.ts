import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgentRegService {

  public API = '//localhost:8080';
  constructor(private http : HttpClient) { }


 getAgentRegistration(): Observable<any> {
    return this.http.get(this.API +'/getAgentRegistration');
  }
   getCategory(): Observable<any> {
    return this.http.get(this.API +'/getCategory');
  }
   getEducational(): Observable<any> {
    return this.http.get(this.API +'/getEducational');
  }
   getProvince(): Observable<any> {
    return this.http.get(this.API +'/getProvince');
  }

}
