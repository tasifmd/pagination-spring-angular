import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';
import { HttpService } from 'src/app/service/http.service';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  message: any;
  employees: any[];
  displayedColumns: string[] = ['Name', 'Email', 'Mobile', 'Age', 'Salary'];
  pageEvent: PageEvent;
  length = 100;
  pageSizeOptions: number[] = [5, 10, 20, 50];
  constructor(private dataService: DataService, private httpService: HttpService) { }

  ngOnInit() {
    this.dataService.currentMessage.subscribe(
      (response: any) => {
        this.message = response;
        this.getEmployee();
      }
    );
  }

  getEmployee() {
    console.log("Inside Get Employee");
    this.httpService.getRequest("employee?pageNo="+this.pageEvent.pageIndex+"&pageSize="+this.pageEvent.pageSize).subscribe(
      (response: any) => {
        this.employees = response;
      }
    );
  }
}
