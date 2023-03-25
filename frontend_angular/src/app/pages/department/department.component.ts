import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Department } from 'src/app/components/models/department.model';
import { DepartmentService } from 'src/app/services/department.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.scss']
})
export class DepartmentComponent implements OnInit {

  submitted:boolean;
  department:Department;
  departments:Department[];
  departmentForm:FormGroup;

  constructor(private departmentService:DepartmentService,
              private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.departmentService.getAll().subscribe((data) => {
      this.departments=data;
    })
    this.initForm(null);
    this.submitted=false;
  }

  initForm(department:Department){
    if(!department)
      this.department=new Department();
    else
      this.department=department;

    this.departmentForm=this.formBuilder.group({
      id: [this.department.id],
      name: [this.department.name, Validators.required],
    });
  }

  add(){
    this.submitted=true;
    if(this.departmentForm.invalid)
      return;

    let department=this.departmentForm.value
    this.departmentService.add(department).subscribe((data) => {
      this.ngOnInit();
    })
  }

  update(id:number){
    this.departmentService.get(id).subscribe((data) => {
      this.initForm(data);
    })
  }

  delete(id:number){
    this.departmentService.delete(id).subscribe((data) => {
      this.ngOnInit();
    })
  }

}
