import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class memShowService {
public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

getMem(): Observable<any> {
       return this.http.get(this.API + '/member');}
}
