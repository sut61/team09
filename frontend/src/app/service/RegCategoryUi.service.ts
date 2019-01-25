import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable(
{
  providedIn: 'root'
})export class RegCategoryUiService
{
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getCategorys(): Observable<any> {
      return this.http.get(this.API +'/Category');
  }
  getInsurancePremiums(): Observable<any> {
        return this.http.get(this.API +'/InsurancePremium');
  }
    getLengths(): Observable<any> {
        return this.http.get(this.API +'/Length');
    }
    getMoneyMaximums(): Observable<any> {
        return this.http.get(this.API +'/MoneyMaximum');
    }

}
