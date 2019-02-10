import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private signinURL = '//localhost:8080/login';

  constructor(private http: HttpClient) { }

  signin(form: any) {
    return this.http.post(this.signinURL, form);

      }

      saveUser(user){ localStorage.setItem('currentUser', user); }

                logout() {
                      // remove user from local storage to log user out
                      localStorage.removeItem('currentUser');
                  }
}
