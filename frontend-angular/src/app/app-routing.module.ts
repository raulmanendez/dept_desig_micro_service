import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartmentComponent } from './department/department.component';
import { DesignationComponent } from './designation/designation.component';

const routes: Routes = [
  { path:'', redirectTo:'department', pathMatch:'full' },
  { path:'department', component:DepartmentComponent },
  { path:'designation', component:DesignationComponent },
  { path:'**', redirectTo:'department'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
