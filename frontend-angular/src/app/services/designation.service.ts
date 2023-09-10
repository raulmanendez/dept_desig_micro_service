import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Designation } from '../model/designation.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DesignationService {

  constructor(private http:HttpClient) { }

  public add(designation:any):Observable<Designation> {
    return this.http.post<Designation>(`${environment.endpoint}designation`,designation);
  }

  public delete(id:number):Observable<any> {
    return this.http.delete<Designation>(`${environment.endpoint}designation/${id}`);
  }

  public get(id:number):Observable<Designation> {
    return this.http.get<Designation>(`${environment.endpoint}designation/${id}`);
  }

  public getAll():Observable<Designation[]> {
    return this.http.get<Designation[]>(`${environment.endpoint}designation`);
  }
}
