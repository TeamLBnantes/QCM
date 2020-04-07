import { __decorate } from "tslib";
import { Component } from '@angular/core';
let FancyComponent = class FancyComponent {
    constructor() { }
    ngOnInit() {
        $(".fancy").fancybox();
    }
};
FancyComponent = __decorate([
    Component({
        selector: 'app-fancy',
        templateUrl: './fancy.component.html',
        styleUrls: ['./fancy.component.css']
    })
], FancyComponent);
export { FancyComponent };
//# sourceMappingURL=fancy.component.js.map