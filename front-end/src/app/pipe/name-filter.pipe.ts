import {Pipe, PipeTransform} from '@angular/core';
import {User} from '../model/user';

@Pipe({
  name: 'nameFilter'
})
export class NameFilterPipe implements PipeTransform {

  // @ts-ignore
  transform(userList: User[], searchText: string): any[] {
    if (searchText) {
      return userList.filter(
        user => {
          return user.firstName.toLowerCase().includes(searchText.toLowerCase())
            || user.lastName.toLowerCase().includes(searchText.toLowerCase())
            || user.email.toLowerCase().includes(searchText.toLowerCase());
        }
      );
    }
    return userList;
  }
}
