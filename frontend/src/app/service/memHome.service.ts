import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class memHomeService {

public API = '//localhost:8080';
constructor(private http: HttpClient) { }

getUser(user): Observable<any> {
    return this.http.get(this.API + '/user/' + user);
  }

  getCost(user): Observable<any> {
      return this.http.get(this.API + '/cost/' + user);
    }

    getPaid(user): Observable<any> {
        return this.http.get(this.API + '/paid/' + user);
      }

}
