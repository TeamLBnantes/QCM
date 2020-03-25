import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { QcmListComponent } from './components/qcm-list/qcm-list.component';
import { HomeComponent } from './components/home/home.component';
import { QcmPlayComponent } from './components/qcm-play/qcm-play.component';




const appRoutes: Routes = [
{path : 'index', component : MainComponent},
{path : 'qcmList', component : QcmListComponent},
{path : 'play/:id', component : QcmPlayComponent},

{path : 'home', component : HomeComponent},


{path: '', redirectTo: '/home', pathMatch: 'full'},

// gestion de la page not found
// '**' => "tout ce qui n'est pas ce qui est décrit ci dessus"
{path : '**', component: PageNotFoundComponent},



];



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
