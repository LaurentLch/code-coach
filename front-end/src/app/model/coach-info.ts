import {CoachTopic} from './coach-topic';

export interface CoachInfo {
  id: number,
  introduction: string,
  availability: string,
  coachTopicListDTO: CoachTopic[]
}

