import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';   /** npm i rxjs-compat@6.1.0 --save */

@Injectable({
  providedIn: 'root'
})
export class CancellumpsumService {
public API = '//localhost:8080';

constructor(private http: HttpClient) { }

  getCancelLumpsum(): Observable<any> {
      return this.http.get(this.API +'/getCancelLumpsum');
    }
  getContact(): Observable<any> {
      return this.http.get(this.API +'/getContact');
    }
getLumpsum(): Observable<any> {
      return this.http.get(this.API +'/getLumpsum');
    }
 getProvince(): Observable<any> {
       return this.http.get(this.API + '/getProvince');}

}
