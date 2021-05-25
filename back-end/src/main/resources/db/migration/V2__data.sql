INSERT INTO coach_info(id, "availability", "introduction")
values ('1', 'Every Day', 'Hi, i am a coach and this is my introduction');

INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('1', '3', 'Topic1', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('2', '4', 'Topic2', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('3', '5', 'Topic3', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('1', 'frederik.collignon@hotmail.com', 'Frederik', 'Collignon', 'P4ssword', 'Coachee', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('2', 'coachee1@codecoach.org', 'Coachee1', 'testCoachee1', 'YouC0ach', 'Coachee', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('3', 'coachee2@codecoach.org', 'Coachee2', 'testCoachee2', 'YouC0ach', 'Coache', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('4', 'coach1@codecoach.org', 'Coach1', 'testCoach1', 'YouC0ach', 'Coach', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('5', 'coach2@codecoach.org', 'Coach2', 'testCoach2', 'YouC0ach', 'Coach', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('6', 'admin1@codecoach.org', 'Admin1', 'testAdmin1', 'YouC0ach', 'Admin', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('7', 'admin2@codecoach.org', 'Admin2', 'testAdmin2', 'YouC0ach', 'Admin', '1');

--coachee	           coachee1@codecoach.org	                  YouC0ach
