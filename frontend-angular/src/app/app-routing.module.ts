import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartmentComponent } from './department/department.component';
import { DesignationComponent } from './designation/designation.component';
import { LoggerComponent } from './logger/logger.component';

const routes: Routes = [
  { path:'', redirectTo:'department', pathMatch:'full' },
  { path:'department', component:DepartmentComponent },
  { path:'designation', component:DesignationComponent },
  { path:'logger', component:LoggerComponent },
  { path:'**', redirectTo:'department'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
