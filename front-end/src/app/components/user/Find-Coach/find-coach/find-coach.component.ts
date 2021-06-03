import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../../service/user.service';
import {User} from '../../../../model/user';
import {ActivatedRoute} from '@angular/router';
import {IDropdownSettings} from 'ng-multiselect-dropdown';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AuthenticationService} from '../../../../service/authentication.service';


@Component({
  selector: 'app-find-coach',
  templateUrl: './find-coach.component.html',
  styleUrls: ['./find-coach.component.css']
})
export class FindCoachComponent implements OnInit {
  userList: any;
  id: number | undefined;
  email: any;
  searchText: any;
  disabled = false;
  ShowFilter = false;
  limitSelection = false;
  topics: Array<any> = [];
  selectedItems: Array<any> = [];
  dropdownSettings: any = {};

  constructor(private userService: UserService, private fb: FormBuilder, public authenticationService: AuthenticationService) {
    this.searchText = '';
    this.topics = [
      {topic_id: 1, topic: 'Javascript'},
      {topic_id: 2, topic: 'Java'},
      {topic_id: 3, topic: 'HTML'},
      {topic_id: 4, topic: 'CSS'},
      {topic_id: 5, topic: 'Angular'},
      {topic_id: 6, topic: 'Maven'}
    ];
    this.selectedItems = [];
    this.dropdownSettings = {
      singleSelection: false,
      textField: 'topic',
      idField: 'topic_id',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 10,
      allowSearchFilter: true
    };
  }

  ngOnInit(): void {
    this.getUserList();
  }

  getUserList(): void {
    // @ts-ignore
    this.userService.getUserList().subscribe(data => {
      this.userList = data;
    });
  }

  selectUser(user: User) {
    this.id = user.id;
  }

  onItemSelect(item: any) {
    console.log('onItemSelect', item);
  }

  onSelectAll(items: any) {
    console.log('onSelectAll', items);
  }

  toogleShowFilter() {
    this.ShowFilter = !this.ShowFilter;
    this.dropdownSettings = Object.assign({}, this.dropdownSettings, {allowSearchFilter: this.ShowFilter});
  }

  handleLimitSelection() {
    if (this.limitSelection) {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, {limitSelection: 2});
    } else {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, {limitSelection: null});
    }
  }
}
