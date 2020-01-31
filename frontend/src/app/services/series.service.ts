import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { BaseURL } from '../services/baseURL';
import { ErrorResponseService } from '../services/error-response.service';

@Injectable({
  providedIn: 'root'
})
export class SeriesService {

  private BASEURL: string;

  constructor(private baseURL: BaseURL, private http: HttpClient, private errorResponseService: ErrorResponseService) {
    this.BASEURL = baseURL.getBaseURL() + 'sensors/data/series';
  }

  getSeries(): Observable<any[]> {
    return this.http.get<any[]>(this.BASEURL)
      .pipe(catchError(this.errorResponseService.handleError));
  }

}
