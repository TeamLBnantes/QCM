import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
import { Qcm } from '../classes/qcm';
import { map } from 'rxjs/operators';
let QcmServiceService = class QcmServiceService {
    constructor(http) {
        this.http = http;
        this.URL = `http://localhost:8081`;
    }
    getAllQcm() {
        // get, put post renvoient tjs un observable
        // pipe de rx.js => observables
        return this.http.get(`${this.URL}/qcm`).pipe(
        // map permet de faire des opérations sur la listes
        map((qcmList) => {
            return qcmList.map((qcm) => {
                return new Qcm(qcm);
            });
        }));
    }
    getQcmPlayable(id) {
        return this.http.get(`${this.URL}/qcm/${id}`);
    }
    getQuestion(id) {
        return this.http.get(`${this.URL}/question/${id}`);
    }
};
QcmServiceService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], QcmServiceService);
export { QcmServiceService };
//# sourceMappingURL=qcm-service.service.js.map