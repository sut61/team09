import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable(
{
  providedIn: 'root'
})export class RegCancelInsuranceService
{
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getCancelInsurances(): Observable<any> {
      return this.http.get(this.API +'/CancelInsurance');
  }
  getReasonMembers(): Observable<any> {
        return this.http.get(this.API +'/ReasonMember');
  }


}
