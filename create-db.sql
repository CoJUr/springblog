use spring_db;

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE IF NOT EXISTS `instructor` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    `instructor_detail_id` int(11) DEFAULT NULL,

    constraint `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    PRIMARY KEY (`id`)
);

INSERT INTO `instructor` (`id`, `first_name`, `last_name`, `instructor_detail_id`) VALUES
(1, 'John', 'Doe', '100'),
(2, 'Jane', 'Daughtery', '200');

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE IF NOT EXISTS `instructor_detail` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` varchar(128) DEFAULT NULL,
    `hobby` varchar(45) DEFAULT NULL,

    primary key (`id`)

);

