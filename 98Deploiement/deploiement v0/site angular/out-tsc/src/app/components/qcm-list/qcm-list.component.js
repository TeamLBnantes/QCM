import { __decorate } from "tslib";
import { Component } from '@angular/core';
let QcmListComponent = class QcmListComponent {
    constructor(qcmService) {
        this.qcmService = qcmService;
    }
    ngOnInit() {
        this.getAllQcm();
    }
    getAllQcm() {
        this.subscription = this.qcmService.getAllQcm().subscribe((data) => {
            this.qcms$ = data;
        });
    }
    ngOnDestroy() {
        // eviter les fuites de memoires
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }
};
QcmListComponent = __decorate([
    Component({
        selector: 'app-qcm-list',
        templateUrl: './qcm-list.component.html',
        styleUrls: ['./qcm-list.component.css']
    })
], QcmListComponent);
export { QcmListComponent };
//# sourceMappingURL=qcm-list.component.js.map