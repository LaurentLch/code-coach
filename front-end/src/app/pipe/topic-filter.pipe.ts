import {Pipe, PipeTransform} from '@angular/core';
import {User} from '../model/user';
import {element} from 'protractor';
import has = Reflect.has;

@Pipe({
  name: 'topicFilter'
})
export class TopicFilterPipe implements PipeTransform {

  // @ts-ignore
  transform(userList: User[], selectedItems: Array<any>[]): any[] {
    console.log(selectedItems);
    if (selectedItems.length > 0) {
      return userList.filter(
        user => {
// @ts-ignore
          // tslint:disable-next-line:no-shadowed-variable
          // selectedItems.every(element => user.coachInfoDTO.coachTopicListDTO.includes(element));
          let hasAllElems = true;


          const topicNames: Array<any> = [];
          user.coachInfoDTO.coachTopicListDTO.forEach(elementt => topicNames.push(elementt.topicName));

          // @ts-ignore
          console.log(topicNames);
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < selectedItems.length; i++) {

            // @ts-ignore
            if (topicNames.indexOf(selectedItems[i].topic) === -1) {
              hasAllElems = false;
            }
          }
          return hasAllElems;
        });
    }
    return userList;
  }
}

