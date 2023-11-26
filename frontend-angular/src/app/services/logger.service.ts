import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Logger } from '../model/logger.model';


@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  constructor(private http:HttpClient) { }

  public getAll():Observable<Logger[]> {
    return this.http.get<Logger[]>(`${environment.endpoint}logger`);
  }
}
