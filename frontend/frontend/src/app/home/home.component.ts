import { Component, inject } from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AnswerService } from '../services/answer.service';
import { Answer } from '../models/answer';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  question: string = '';
  answer?: Answer;
  isLoading: Boolean = false;

  private answerService =
    inject(AnswerService);

  sendQuestion() {
    this.isLoading = true;
    this.answerService
      .postQuestion(this.question)
      .subscribe({
        next: (response:any) => {
          this.answer = response;
        },

        error: (err:any) => {
          console.error(err);
        },

        complete: () => {
          this.isLoading = false;
        },
      });
  }
}
