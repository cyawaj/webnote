CREATE TABLE t_role (
	id INT NOT NULL PRIMARY KEY,
	roleName VARCHAR (20) NOT NULL,
	createTime VARCHAR (20),
	updateTime VARCHAR (20)
);

INSERT INTO t_role (id, roleName)
VALUES
	(0, "userLevel");

INSERT INTO t_role (id, roleName)
VALUES
	(1, "adminLevel");

CREATE TABLE t_user (
	username VARCHAR (50) NOT NULL PRIMARY KEY,
	PASSWORD VARCHAR (50) NOT NULL,
	nickname VARCHAR (20),
	userType INT,
	createTime VARCHAR (20),
	updateTime VARCHAR (20)
);

CREATE TABLE t_directory (
	id INT NOT NULL PRIMARY KEY auto_increment,
	dirName VARCHAR (50) NOT NULL,
	parentId INT,
	hasChild INT,
	username VARCHAR (50),
	isAbandoned INT,
	createTime VARCHAR (20),
	updateTime VARCHAR (20)
);

CREATE TABLE t_content (
	id INT NOT NULL PRIMARY KEY auto_increment,
	username VARCHAR (50),
	title VARCHAR (50),
	detail LONGTEXT,
	dirId INT,
	createTime VARCHAR (20),
	updateTime VARCHAR (20)
);