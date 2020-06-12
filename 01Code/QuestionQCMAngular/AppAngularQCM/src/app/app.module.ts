import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { MatButtonModule } from '@angular/material/button';
import { registerLocaleData } from '@angular/common';
// Import de la locale
import localeFr from '@angular/common/locales/fr';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { QcmListComponent } from './components/qcm-list/qcm-list.component';
import { QcmPlayComponent } from './components/qcm-play/qcm-play.component';
import { MainComponent } from './components/main/main.component';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { AppRoutingModule } from './app-routing.module';
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatRadioModule} from '@angular/material/radio';
import { MatButtonModule } from "@angular/material/button";

import { FancyComponent } from './components/fancy/fancy.component';
import { PopupmediaComponent } from './components/popupmedia/popupmedia.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { TemplateComponent } from './template/template.component';
import { FiltreQCMPipe } from './pipes/filtre-qcm.pipe';


registerLocaleData(localeFr);


@NgModule({
  declarations: [
    AppComponent,
    QcmListComponent,
    QcmPlayComponent,
    MainComponent,
    HomeComponent,

    PageNotFoundComponent,

    FancyComponent,

    PopupmediaComponent,

    TemplateComponent,

    FiltreQCMPipe,



  ],
  imports: [
    BrowserModule,
    // pour tt formulaire
    FormsModule,
    // pour formulaire réactif
    ReactiveFormsModule,
    // pour Material
    BrowserAnimationsModule,
    // pour etre à l'écoute d'une API
    HttpClientModule,


    // pour le routing
    AppRoutingModule,

    MatSnackBarModule,
    MatButtonModule,
    MatRadioModule,
    MatProgressBarModule,
    MatDialogModule,
    MatProgressSpinnerModule,
    FontAwesomeModule


  ],
  providers: [{provide: LOCALE_ID, useValue: 'fr'}],
  bootstrap: [MainComponent],
})
export class AppModule { }
