INSERT INTO user_types VALUES (1, 'Employee');
INSERT INTO user_types VALUES (2, 'Manager');

INSERT INTO users VALUES (1, 2,  '1234', 'Kingshuk_Saha@Persistent.com', 1);
INSERT INTO users VALUES (2, NULL,  '1234', 'Yogesh_Pitale@Persistent.com', 2);

INSERT INTO tasks VALUES (1, to_date('15/06/2021', 'DD/MM/YYYY'), 0, 'Task Description 1', 6, 'Task Name 1', 10,  1);
INSERT INTO tasks VALUES (2, to_date('15/06/2021', 'DD/MM/YYYY'), 0, 'Task Description 2', 5, 'Task Name 2', 9,  1);
INSERT INTO tasks VALUES (3, to_date('15/06/2021', 'DD/MM/YYYY'), 0, 'Task Description 3', 7, 'Task Name 3', 8,  1);
INSERT INTO tasks VALUES (4, to_date('15/06/2021', 'DD/MM/YYYY'), 20, 'Task Description 4', 8, 'Task Name 4', 7,  3);
INSERT INTO tasks VALUES (5, to_date('15/06/2021', 'DD/MM/YYYY'), 30, 'Task Description 5', 6, 'Task Name 5', 6,  4);

INSERT INTO TASK_TYPES VALUES (1, 'Project Task');
INSERT INTO TASK_TYPES VALUES (2, 'Learning & Development');
INSERT INTO TASK_TYPES VALUES (3, 'Conducting Interview');
INSERT INTO TASK_TYPES VALUES (4, 'Conducting Training');


INSERT INTO TASK_ASSIGNMENT VALUES (1, '', false, 1);
INSERT INTO TASK_ASSIGNMENT VALUES (2, '', false, 1);
INSERT INTO TASK_ASSIGNMENT VALUES (3, '', false, 1);
INSERT INTO TASK_ASSIGNMENT VALUES (4, 'Block Reason 1', true, 1);
INSERT INTO TASK_ASSIGNMENT VALUES (5, 'Block Reason 2', true, 1);



