import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';



const appRoutes : Routes =[
{path :'home', component :MainComponent},

{path:'',redirectTo:"/home", pathMatch:'full'},

//gestion de la page not found
//'**' => "tout ce qui n'est pas ce qui est décrit ci dessus"
{path :'**', component:PageNotFoundComponent},



]



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports:[
    RouterModule
  ]
})
export class AppRoutingModule { }
