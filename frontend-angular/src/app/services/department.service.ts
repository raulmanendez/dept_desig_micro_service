import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Department } from '../model/department.model'


@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private http:HttpClient) { }

  public add(department:any):Observable<Department> {
    return this.http.post<Department>(`${environment.endpoint}department`,department);
  }

  public delete(id:number):Observable<any> {
    return this.http.delete<Department>(`${environment.endpoint}department/${id}`);
  }

  public get(id:number):Observable<Department> {
    return this.http.get<Department>(`${environment.endpoint}department/${id}`);
  }

  public getAll():Observable<Department[]> {
    return this.http.get<Department[]>(`${environment.endpoint}department`);
  }
}
