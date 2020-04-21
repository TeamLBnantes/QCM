import { __decorate } from "tslib";
import { Component } from '@angular/core';
let QcmPlayComponent = class QcmPlayComponent {
    constructor(route, qcmService) {
        this.route = route;
        this.qcmService = qcmService;
        this.lancer = false;
        this.thisIsTheEnd = false;
    }
    ngOnInit() {
        this.idqcm = this.route.snapshot.paramMap.get('id');
        console.log(this.idqcm);
        this.getQcm();
    }
    getQcm() {
        this.subscription = this.qcmService.getQcmPlayable(parseInt(this.idqcm)).subscribe((data) => {
            this.qcm = data;
        });
    }
    lancerQcm() {
        console.log(this.lancer);
        this.lancer = true;
        this.idQuestion = this.qcm.questionsId[this.qIndex];
        this.subscription = this.qcmService.getQuestion(this.idQuestion).subscribe((data) => {
            this.question = data;
        });
    }
    nextQuestion() {
        this.qIndex = (this.qIndex + 1);
        if (this.qIndex > this.qcm.questionsId.length) {
            this.thisIsTheEnd = true;
        }
        else {
            this.idQuestion = this.qcm.questionsId[this.qIndex];
            this.subscription = this.qcmService.getQuestion(this.idQuestion).subscribe((data) => {
                this.question = data;
            });
        }
    }
    ngOnDestroy() {
        // eviter les fuites de memoires
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }
};
QcmPlayComponent = __decorate([
    Component({
        selector: 'app-qcm-play',
        templateUrl: './qcm-play.component.html',
        styleUrls: ['./qcm-play.component.css']
    })
], QcmPlayComponent);
export { QcmPlayComponent };
//# sourceMappingURL=qcm-play.component.js.map