import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CancelAppointmentService {

public API = '//localhost:8080';
constructor(private http: HttpClient) {}

  getDateAppointment(): Observable<any> {
        return this.http.get(this.API + '/GetDateAppointment');}

  getCancelAppointment(): Observable<any> {
        return this.http.get(this.API + '/GetCancelAppointment');}

  getCancelReason(): Observable<any> {
        return this.http.get(this.API + '/GetCancelAppointmentReason');}

}
