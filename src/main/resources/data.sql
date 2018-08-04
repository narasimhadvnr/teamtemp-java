
DELETE FROM user;
DELETE FROM team;
DELETE FROM rating_link;
DELETE FROM team_instance;
DELETE FROM instance_rating;


INSERT INTO `user` (`id`,`name`) VALUES (1111, 'venkat narasimha');

INSERT INTO `user` (`id`, `name`) VALUES (1112, 'srikanth');


INSERT INTO `team` (`id`,`name`, `roll_type`, `creator`) VALUES (2001, 'Architecture', `All`, 1112);

INSERT INTO `team` (`id`,`name`, `roll_type`, `creator`) VALUES (2002, 'Core Team', `All`, 1112);

INSERT INTO `rating_link` (`id`,`link`, `status`, `valid_from`, `valid_till`, `team_id`) VALUES (5001, `andfjdser`, TRUE, 2342342342, 2342432234, 2001);
INSERT INTO `rating_link` (`id`,`link`, `status`, `valid_from`, `valid_till`, `team_id`) VALUES (5002, `sdfjks`, TRUE, 2342342342, 2342432234], 2001);


INSERT INTO `team_instance` (`id`,`link_id`, `team_id`) VALUES (3001, `5001`, 2001);
INSERT INTO `team_instance` (`id`,`link_id`, `team_id`) VALUES (3001, `5002`, 2001);

INSERT INTO `instance_rating` (`id`,`browser_id`, `rating`, `timestamp`, `word`, `team_link`) VALUES (6001, `andfjdser`, TRUE, 2342342342, 2342432234, 2001);

