import { Component, OnInit } from '@angular/core';
import { multi } from '../data';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  ngOnInit() {
  }

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

  constructor() {
    this.multi1 = [multi[0]];
    this.multi2 = [multi[1]];
  }

}
