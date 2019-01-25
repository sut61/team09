import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';   /** npm i rxjs-compat@6.1.0 --save */
@Injectable({
  providedIn: 'root'
})
export class DiseaseAccidentDataService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getDiseaseAccidentLevel(): Observable<any> {
      return this.http.get(this.API +'/getDiseaseAccidentLevel');
    }
  getDiseaseAccidentType(): Observable<any> {
        return this.http.get(this.API +'/getDiseaseAccidentType');
     }
    getMedicalFee(): Observable<any> {
        return this.http.get(this.API +'/getMedicalFee');
      }
getDiseaseAccidentData(): Observable<any> {
        return this.http.get(this.API +'/getDiseaseAccidentData');
      }




}
