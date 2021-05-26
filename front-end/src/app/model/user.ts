import {CoachInfo} from './coach-info';

export interface User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  role: string;
  coachInfoDTO: CoachInfo;
}
