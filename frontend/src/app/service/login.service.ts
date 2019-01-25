import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private signinURL = '//localhost:8080/login';

  constructor(private http: HttpClient) { }

  signin(form: any) {
    return this.http.post(this.signinURL, form);
  }

}
