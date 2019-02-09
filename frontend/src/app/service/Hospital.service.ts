import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  public API = '//localhost:8080';
  constructor(private http : HttpClient) { }

getHospital(): Observable<any> {
    return this.http.get(this.API +'/getHospital');
  }
 getAgent(): Observable<any> {
    return this.http.get(this.API +'/getAgent');
  }
   getCate(): Observable<any> {
    return this.http.get(this.API +'/getCate');
  }
   getHosSize(): Observable<any> {
    return this.http.get(this.API +'/getHosSize');
  }
   getProvince(): Observable<any> {
    return this.http.get(this.API +'/getProvince');
  }

}
