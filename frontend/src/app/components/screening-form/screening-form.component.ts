import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ScreeningService} from "../../services/screening.service";
import {validationHandler} from "../../utils/validation-handler";

@Component({
  selector: 'app-screening-form',
  templateUrl: './screening-form.component.html',
  styleUrls: ['./screening-form.component.css']
})
export class ScreeningFormComponent {

  screeningForm: FormGroup;


  constructor(private screeningService: ScreeningService
              , private formBuilder: FormBuilder) {
    this.screeningForm = formBuilder.group({
      title: ['', Validators.required],
      screeningDate: ['', Validators.required],
      totalSeats: [0, Validators.required],
      pictureUrl: ['']
    })
  }

  onSubmit() {
    const  data = this.screeningForm.value;
    console.log(data);
    this.screeningService.addScreening(data).subscribe({
      next: value => {},
      error: err => {console.log(err); validationHandler(err, this.screeningForm)},
      complete: () => console.log('Screening successfully added.')
    })
  }
}
