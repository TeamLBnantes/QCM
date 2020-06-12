import { Injectable } from '@angular/core';
import { Qcm } from '../classes/qcm';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { QcmPlayable } from '../classes/qcm-playable';
import { Question } from '../classes/question';
import { Correction } from 'src/app/classes/Correction';

@Injectable({
  providedIn: 'root'
})
export class QcmServiceService {

  private readonly URL = `http://ratiatum.iguane.org:8081`;
  //private readonly URL = `http://localhost:8081`;
  constructor(private http: HttpClient) { }

  public getAllQcm(): Observable<Qcm[]> {
    // get, put post renvoient tjs un observable
    // pipe de rx.js => observables
    return this.http.get<Qcm[]>(`${this.URL}/qcm`).pipe(
      // map permet de faire des opérations sur la listes
      map((qcmList: Qcm[]) => {
        return qcmList.map((qcm: Qcm) => {
          return new Qcm(qcm);
        });

      })

    );
  }
  public getQcmPlayable(id: number): Observable<QcmPlayable> {
    return this.http.get<QcmPlayable>(`${this.URL}/qcm/${id}`);
}

public getQuestion(id: number): Observable<Question> {
  return this.http.get<Question>(`${this.URL}/question/${id}`);
}

public getCorrection(id: number): Observable<Correction>{
  return this.http.get<Correction>(`${this.URL}/question/${id}/correction`);
}


 // envoi le resultat suite correction d'une question
  public updateResult(idQuestion: number, idMCQpassed: number, correction: boolean) {
    // TODO
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
       // 'Authorization': this.jwt
      })
    };
    return this.http.post(this.URL+'/updateResult',{"idQuestion": idQuestion, "idMCQpassed": idMCQpassed, "correction": correction},httpOptions);
  }





//sur demande de l'utilisateur, demande à Spring d'envoyer le resultat des qcm ref dans idQCMpassed, 
// à l'adresse mail indiquée
public mailResult(idMCQpassed: number, mail:string) {
  // TODO
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     // 'Authorization': this.jwt
    })
  };
  return this.http.post(this.URL+'/qcm/mailResult',{"idMCQpassed": idMCQpassed, "mail": mail},httpOptions);
}

//sur demande de l'utilisateur, demande à Spring d'envoyer le resultat des qcm ref dans idQCMpassed, 
// à l'adresse mail indiquée
public mailToDesigner(idMCQpassed: number, mail: string, sujet: string, corp: string) {
  // TODO
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
     // 'Authorization': this.jwt
    })
  };
  return this.http.post(this.URL+'/qcm/mailToDesigner',{"idMCQpassed": idMCQpassed, "mail": mail, "sujet": sujet, "corp":corp},httpOptions);
}



}
