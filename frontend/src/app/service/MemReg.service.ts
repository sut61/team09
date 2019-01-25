import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemRegService {

public API = '//localhost:8080';
constructor(private http: HttpClient) { }


  getCategory(): Observable<any> {
       return this.http.get(this.API + '/GetCategory');}

  getProvince(): Observable<any> {
       return this.http.get(this.API + '/GetProvince');}

    getAgent(): Observable<any> {
              return this.http.get(this.API + '/getAgentRegistration');}
}
