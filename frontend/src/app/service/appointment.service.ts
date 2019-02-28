import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

public API = '//localhost:8080';
constructor(private http: HttpClient) { }

  getAppointment(): Observable<any> {
        return this.http.get(this.API + '/GetAgentAppointment');}

  getDateAppointment(): Observable<any> {
      return this.http.get(this.API + '/GetDateAppointment');}

  getDurationAppointment(): Observable<any> {
      return this.http.get(this.API + '/GetDurationAppointment');}

  getGender(): Observable<any> {
       return this.http.get(this.API + '/GetGender');}

  getCategory(): Observable<any> {
       return this.http.get(this.API + '/GetCategory');}

  getProvince(): Observable<any> {
       return this.http.get(this.API + '/GetProvince');}

  getDateCount(date): Observable<any> {
      return this.http.get(this.API + '/getDateCount/' + date);}
}
