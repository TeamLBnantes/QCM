import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignalerService {

  //private readonly URL = `http://192.168.1.21:8081`;
  private readonly URL = `http://ratiatum.iguane.org:8081`;
  constructor(private http: HttpClient) { }


 // public postSignal(idQuestion: number, idQcm: number, cause: string): Observable<number> {
  public postSignal(idQuestion: number, idQcm: number, cause: string) {
    // TODO
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
       // 'Authorization': this.jwt
      })
    };
    //data={"idQuestion": idQuestion, "idQcm": idQcm, "cause": cause};   (int, int, string)

    return this.http.post(this.URL+'/signaler',{"idQuestion": idQuestion, "idQcm": idQcm, "cause": cause},httpOptions);
  //  return this.http.get<number>(`0`);
  }

}
