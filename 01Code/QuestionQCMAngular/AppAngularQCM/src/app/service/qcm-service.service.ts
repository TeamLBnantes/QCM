import { Injectable } from '@angular/core';
import { Qcm } from '../classes/qcm';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';


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
  /*
  public getPlayableQcm(id): Observable<Qcm> {
    return this.http.get<Qcm>(`${this.URL}/qcm/${id}`).pipe();
  }
  */
/*
  public getPlayableQuestion(id): Observable<Question> {
    // get, put post renvoient tjs un observable
    // pipe de rx.js => observables
    return this.http.get<Qcm>(`${this.URL}/qcm/${id}`).pipe(
      // map permet de faire des opérations sur la listes
      map((qcm: Qcm) => {
          return new Qcm(qcm);
        }));
  }
  */



}
