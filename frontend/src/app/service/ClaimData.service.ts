import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';   /** npm i rxjs-compat@6.1.0 --save */
@Injectable({
  providedIn: 'root'
})
export class ClaimDataService {
  public API = '//localhost:8080';

 constructor(private http: HttpClient) { }

getCategory(): Observable<any> {
      return this.http.get(this.API +'/Category');
    }
  getClaimData(): Observable<any> {
        return this.http.get(this.API +'/getClaimData');
     }
    getMemberData(): Observable<any> {
        return this.http.get(this.API +'/getMemberData');
      }
getDiseaseAccidentData(): Observable<any> {
        return this.http.get(this.API +'/getDiseaseAccidentData');
      }

getHospital(): Observable<any> {
        return this.http.get(this.API +'/getHospital');
      }

getTreatmentStyle(): Observable<any> {
        return this.http.get(this.API +'/getTreatmentStyle');
      }


}
