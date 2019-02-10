import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private signinURL = '//localhost:8080/loginEM';

  constructor(private http: HttpClient) { }

  signin(form: any) {
    return this.http.post(this.signinURL, form);
  }

}

