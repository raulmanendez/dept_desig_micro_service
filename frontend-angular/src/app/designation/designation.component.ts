import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Designation } from '../model/designation.model';
import { DesignationService } from '../services/designation.service';
import { DepartmentService } from '../services/department.service';
import { Department } from '../model/department.model';

@Component({
  selector: 'app-designation',
  templateUrl: './designation.component.html',
  styleUrls: ['./designation.component.css']
})
export class DesignationComponent implements OnInit {

  submitted:boolean;
  designation:Designation;
  designations:any[];
  departments:Department[];
  designationForm:FormGroup;

  constructor(private designationService:DesignationService,
              private departmentService:DepartmentService,
              private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.initForm();
    this.submitted=false;

    this.getDepartments()
    this.getDesignations()
  }

  getDepartments() {
    this.departmentService.getAll().subscribe((data) => {
      this.departments=data;
    })
  }

  getDesignations() {
    this.designationService.getAll().subscribe((data) => {
      this.designations=data;
    })
  }

  initForm(designation?:Designation){
    if(!designation)
      this.designation=new Designation();
    else
      this.designation=designation;

    this.designationForm=this.formBuilder.group({
      id: [this.designation.id],
      deptId: [this.designation.deptId, Validators.required],
      name: [this.designation.name, Validators.required],
    });
  }

  add(){
    this.submitted=true;
    if(this.designationForm.invalid)
      return;

    let designation=this.designationForm.value
    this.designationService.add(designation).subscribe((data) => {
      this.ngOnInit();
    })
  }

  update(id:number){
    this.designationService.get(id).subscribe((data) => {
      this.initForm(data);
    })
  }

  delete(id:number){
    this.designationService.delete(id).subscribe((data) => {
      this.ngOnInit();
    })
  }


}
