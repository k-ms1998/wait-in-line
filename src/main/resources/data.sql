insert into `place` (`place_type`, `place_name`, `address`, `phone_number`, `capacity`, `memo`)
values
('SPORTS', 'Seoul Badminton', 'Incheon Song-do 987', '010-9999-0000', 20, 'Is this true>'),
('RESTAURANT', 'FastCampus Restaurant', 'Seoul Songpa-gu 123', '010-1234-5678', 10, 'Test Memo'),
('SPORTS', 'Ski Resort', 'Incheon Chung-na', '010-1004-1004', 9000, null),
('COMMON', 'FastCampus HQ', '111, Gana-ro, Gangnam-gu, Seoul', '010-1111-1111', 50, 'Please show some gratitude'),
('PARTY', 'FastCampus Ball Room', 'Seoul Gangnam-gu DoSan', '010-1234-5678', 1, 'Everybody')
;

insert into `event` (`place_id`, `event_name`, `event_status`, `event_start_datetime`, `event_end_datetime`, `current_number_of_people`, `capacity`, `memo`)
values
(1, 'WorkOut1', 'OPENED', '2021-01-01 09:00:00', '2021-01-01 12:00:00', 0, 20, 'test memo1'),
(1, 'WorkOut2', 'OPENED', '2021-01-01 13:00:00', '2021-01-01 12:00:00', 0, 20, 'test memo2'),
(2, 'Event1', 'OPENED', '2021-01-02 09:00:00', '2021-01-02 12:00:00', 0, 30, 'test memo3'),
(2, 'Event2', 'OPENED', '2021-01-03 09:00:00', '2021-01-03 12:00:00', 0, 30, 'test memo4'),
(2, 'Event3', 'CLOSED', '2021-01-04 09:00:00', '2021-01-04 12:00:00', 0, 30, 'test memo5'),
(3, 'Morning Walk', 'OPENED', '2021-02-01 08:00:00', '2021-02-01 12:30:00', 12, 50, 'test memo6')
;

insert into `admin` (`email`, `nickname`, `password`, `phone_number`, `memo`)
values
('test@test.com', 'test_nickname', '{noop}1234', '010-0101-0101', 'Hello')
;

insert into `admin_place_map` (`admin_id`, `place_id`)
values
(1, 1),
(1, 2),
(1, 3)
;