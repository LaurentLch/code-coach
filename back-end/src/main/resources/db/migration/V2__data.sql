INSERT INTO coach_info(id, "availability", "introduction")
values ('1', 'Every Day', 'Hi, i am a coach and this is my introduction');

INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('1', '3', 'Topic1', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('2', '4', 'Topic2', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('3', '5', 'Topic3', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('1', 'frederik.collignon@hotmail.com', 'Frederik', 'Collignon', 'P4ssword', 'Coach', '1');
