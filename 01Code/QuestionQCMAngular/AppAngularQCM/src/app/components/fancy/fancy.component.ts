import { Component, OnInit } from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-fancy',
  templateUrl: './fancy.component.html',
  styleUrls: ['./fancy.component.css']
})
export class FancyComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  	$(".fancy").fancybox();
  }

}
