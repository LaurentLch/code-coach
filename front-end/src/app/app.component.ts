import {Component, OnInit} from '@angular/core';
import {HelloWorldService} from './hello-world.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'load';

  constructor(private helloWorldService: HelloWorldService) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.title = this.getTitle();
  }

  getTitle(): any {
    this.helloWorldService.getHelloWorld().subscribe(title => this.title = title);
  }
}
