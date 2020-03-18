import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { MatButtonModule } from '@angular/material/button';
import { registerLocaleData } from '@angular/common';
// Import de la locale
import localeFr from '@angular/common/locales/fr';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { QcmListComponent } from './components/qcm-list/qcm-list.component';
import { QcmPlayComponent } from './components/qcm-play/qcm-play.component';
import { MainComponent } from './components/main/main.component';
import { HomeComponent } from './components/home/home.component';


registerLocaleData(localeFr);


@NgModule({
  declarations: [
    AppComponent,
    QcmListComponent,
    QcmPlayComponent,
    MainComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    //pour tt formulaire
    FormsModule,
    //pour formulaire réactif
    ReactiveFormsModule,
    //pour Material
    BrowserAnimationsModule,
    // 1 outil Material
    //MatButtonModule,
    //pour etre à l'écoute d'une API
    HttpClientModule,


    //pour le routing
    //AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
