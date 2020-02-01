import { Component } from '@angular/core';
import { SeriesService } from '../services/series.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  multi1: any[];
  multi2: any[];

  // options
  autoScale = true;
  showLabels: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  timeline: boolean = true;

  colorScheme = {
    domain: ['#E67E22 ', '#E44D25']
  };

  colorScheme2 = {
    domain: ['#2E86C1', '#CFC0BB']
  };

  constructor(seriesService: SeriesService) {
    seriesService.getSeries().subscribe(response => {
      this.multi1 = [response[0]]
      this.multi2 = [response[1]]
    });
  }

}
