import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DepartmentComponent } from '../pages/department/department.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    NgbModule,
    ReactiveFormsModule
  ],
  declarations: [
    FooterComponent,
    NavbarComponent,
    SidebarComponent,
    DepartmentComponent
  ],
  exports: [
    FooterComponent,
    NavbarComponent,
    SidebarComponent,
    DepartmentComponent
  ]
})
export class ComponentsModule { }
