INSERT INTO coach_info(id, "availability", "introduction")
values ('1', 'Every Day', 'Hi, i am a coach and this is my introduction');

INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('1', 1, 'Javascript', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('2', 1, 'Java', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('3', 1, 'HTML', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('4', 1, 'CSS', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('5', 1, 'PHP', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('6', 1, 'SQL', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('7', 1, '.NET', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('8', 1, 'Python', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('9', 1, 'CSS', '1');
INSERT INTO coach_topic(id, experience_level, "topic_name", fk_coach_info_id)
values ('10', 1, 'C#', '1');

INSERT INTO users(id, "email", "first_name", "last_name", "password", "role", coach_info_id)
values ('1', 'frederik.collignon@hotmail.com', 'Frederik', 'Collignon', 'P4ssword', 'Coach', '1');
