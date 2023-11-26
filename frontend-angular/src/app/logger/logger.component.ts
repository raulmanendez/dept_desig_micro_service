import { Component, OnInit } from '@angular/core';
import { Logger } from '../model/logger.model';
import { LoggerService } from '../services/logger.service';

@Component({
  selector: 'app-logger',
  templateUrl: './logger.component.html',
  styleUrls: ['./logger.component.css']
})
export class LoggerComponent implements OnInit {

  logs:Logger[];
  constructor(private loggerService:LoggerService) { }

  ngOnInit(): void {
    this.getLogs()
  }

  getLogs() {
    this.loggerService.getAll().subscribe((data) => {
      this.logs=data;
    })
  }

}
