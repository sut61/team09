import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LumpsumserviceService {

  public API = '//localhost:8080';
constructor(private http: HttpClient) { }

  getBusinessSize(): Observable<any> {
        return this.http.get(this.API + '/getBusinessSize');}

  getCategory(): Observable<any> {
      return this.http.get(this.API + '/Category');}

  getEstablishment(): Observable<any> {
      return this.http.get(this.API + '/getEstablishment');}

  getAgentRegistration(): Observable<any> {
       return this.http.get(this.API + '/getAgentRegistration');}

 getProvince(): Observable<any> {
       return this.http.get(this.API + '/getProvince');}

  getLumpsum(): Observable<any> {
       return this.http.get(this.API + '/getLumpsum');}

}
