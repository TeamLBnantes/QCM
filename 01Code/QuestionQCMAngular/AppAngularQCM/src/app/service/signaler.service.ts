import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignalerService {

  private readonly URL = `http://localhost:8081`;
  constructor(private http: HttpClient) { }


  public postSignal(idQuestion: number, idQcm: number, cause: string): Observable<number> {

    // TODO

    return this.http.get<number>(`0`);
  }

}
