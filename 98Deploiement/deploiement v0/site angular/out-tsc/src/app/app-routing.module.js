import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { QcmListComponent } from './components/qcm-list/qcm-list.component';
import { HomeComponent } from './components/home/home.component';
import { QcmPlayComponent } from './components/qcm-play/qcm-play.component';
const appRoutes = [
    { path: 'index', component: MainComponent },
    { path: 'qcmList', component: QcmListComponent },
    { path: 'play/:id', component: QcmPlayComponent },
    { path: 'home', component: HomeComponent },
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    // gestion de la page not found
    // '**' => "tout ce qui n'est pas ce qui est décrit ci dessus"
    { path: '**', component: PageNotFoundComponent },
];
let AppRoutingModule = class AppRoutingModule {
};
AppRoutingModule = __decorate([
    NgModule({
        declarations: [],
        imports: [
            CommonModule,
            RouterModule.forRoot(appRoutes)
        ],
        exports: [
            RouterModule
        ]
    })
], AppRoutingModule);
export { AppRoutingModule };
//# sourceMappingURL=app-routing.module.js.map