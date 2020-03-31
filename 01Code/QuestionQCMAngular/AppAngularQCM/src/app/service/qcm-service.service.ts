import { Injectable } from '@angular/core';
import { Qcm } from '../classes/qcm';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { QcmPlayable } from '../classes/qcm-playable';
import { Question } from '../classes/question';
import { Correction } from 'src/app/classes/Correction';

@Injectable({
  providedIn: 'root'
})
export class QcmServiceService {

  private readonly URL = `http://localhost:8081`;
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
}
