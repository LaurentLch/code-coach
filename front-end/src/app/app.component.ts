import {Component, OnInit} from '@angular/core';
import {HelloWorldService} from "./hello-world.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Not Yet Loaded';

  constructor(private helloWorldService: HelloWorldService) {
  }

  ngOnInit(): void {
    this.title = this.helloWorldService.getHelloWorld();

  }
}
