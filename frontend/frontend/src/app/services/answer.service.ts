import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Answer } from '../models/answer';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  private http = inject(HttpClient);

  postQuestion(question: string): Observable<Answer> {
    return this.http.post<Answer>(
      environment.apiUrl,
      { question }
    );
  }
}
