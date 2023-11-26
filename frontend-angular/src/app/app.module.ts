import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DepartmentComponent } from './department/department.component';
import { DesignationComponent } from './designation/designation.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoggerComponent } from './logger/logger.component';

@NgModule({
  declarations: [
    AppComponent,
    DepartmentComponent,
    DesignationComponent,
    LoggerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
