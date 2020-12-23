import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RxStompService} from "@stomp/ng2-stompjs";
import {Message} from '@stomp/stompjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'webui';
  messages : String[] = [];
  constructor(private httpClient: HttpClient, private rxStompService: RxStompService) {}
  connect() {
    this.httpClient.get("/api/connect").subscribe(data => {
      this.rxStompService.watch('/topic/data').subscribe((message: Message) => {
        console.log(message.body);
        this.messages.push(message.body);
      });
      console.log(data);});
  }

  disconnect() {
    this.httpClient.get("/api/disconnect").subscribe(data => {
      console.log(data);});
  }
}
