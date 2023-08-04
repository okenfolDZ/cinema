import {Component, OnInit} from '@angular/core';
import {ScreeningListItemModel} from "../../models/screening-list-item-model";
import {ScreeningService} from "../../services/screening.service";

@Component({
  selector: 'app-screening-list',
  templateUrl: './screening-list.component.html',
  styleUrls: ['./screening-list.component.css']
})
export class ScreeningListComponent implements OnInit{

  screenings!: ScreeningListItemModel[] ;

  constructor(private screeningService: ScreeningService) {
  }

  ngOnInit(): void {
    this.screeningService.getAllScreenings().subscribe({
      next: value => {this.screenings=value; console.log(this.screenings)},
    });
  }

}
