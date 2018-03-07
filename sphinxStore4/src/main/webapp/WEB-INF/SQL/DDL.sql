drop table Customer;
drop table Product;
drop table Orders;
drop table OrderItem;
drop table Category;
drop table Options;
drop table OptionValue;
drop table Options_Link;
drop table Point_Log

create table Member (
	customer_id		varchar(50)	Primary key,
	id				varchar(50),
	password		varchar(50),
	name			varchar(50),
	nick_name		varchar(50),
	email			varchar(50),
	addr			varchar(200),
	national_code	varchar(10),
	phone_num		varchar(15),
	joinDate 		Date,
	point			integer,
	level 			varchar(50) DEFAULT 'Level 1',
	EXP 			integer 	DEFAULT 0,
	del 			boolean 	default false not null
);

CREATE TABLE PointLog(
	point_Id 		INTEGER  primary key GENERATED ALWAYS AS IDENTITY,
	customer_Id		VARCHAR(50),
	add_point	 	INTEGER,
	reduce_point	INTEGER,
	total_Point 	INTEGER,
	changed_Date	TIMESTAMP
);

CREATE TABLE Product (
	product_id 		varchar(50) PRIMARY KEY,
	product_name 	varchar(100),
	price 			double,
	file_name 		varchar(75),
	content 		varchar(200),
	comment 		varchar(200),
	regDate 		Date
);

CREATE TABLE Orders(
	order_Id 		varchar(50) PRIMARY KEY,
	customer_Id 	varchar(50),
	recipient 		varchar(50),
	recipient_Addr 	varchar(50),
	memo 			varchar(2000),
	total_Price 	float,
	order_Date		date,
	state 			varchar(50),
	del 			boolean 	default false not null
);

CREATE TABLE OrderItem(
	orderItem_Id 	varchar(50) PRIMARY KEY,
	order_Id		varchar(50),
	product_Id 		varchar(50),
	quantity 		integer,
	del 			boolean 	default false not null
);

CREATE TABLE Category(
	category_id		varchar(50) PRIMARY KEY,
	category_name	varchar(50),
	super_id		varchar(50),
	del 			boolean 	default false not null
);

CREATE TABLE Options(
	option_id		varchar(50) PRIMARY KEY,
	option_name		varchar(50),	--옵션이름 ex)신발사이크, 크기
	product_id		varchar(50),	--해당하는 상품
	del				boolean 	default false not null
);

CREATE TABLE OptionValue(
	optionvalue_id		varchar(50) PRIMARY KEY,
	map_key				varchar(50),	--옵션상세이름 ex)265, S, M
	map_value			double,			--옵션추가가격 
	option_id			varchar(50),	--해당하는 옵션
	del					boolean 	default false not null
);

CREATE TABLE Product_Category_Link(
	category_id		varchar(50),
	product_id		varchar(50)
);

CREATE TABLE Options_Link(
	option_id			varchar(50),
	optionvalue_id		varchar(50)
);

create table Category_Table (
	cid					varchar(50) PRIMARY KEY,
	parent_cid			varchar(50),
	title				varchar(50)
);

create table Category (
	category_id			varchar(50) PRIMARY KEY,
	category_name		varchar(50),
	super_id			varchar(50)
);

create table Question (
	qid					varchar(50) PRIMARY KEY,
	text				varchar(2000),
	score				float,
	file_Url			varchar(200),
	file_Type			varchar(10),
	Q_type				varchar(1),
	num_Of_Dis			integer,
	source				varchar(50),
	jongryu				varchar(50),
	yeongyoeck			varchar(50),
	yoohyong			varchar(50),
	completed			varchar(50)
);

create table Question_Cat_Table (
	qid					varchar(50),
	cid					varchar(50)
);

create table Distractor (
	did					varchar(50) PRIMARY KEY,
	text				varchar(2000),
	qid					varchar(50)
);

create table Group_Question (
	gid					varchar(50) PRIMARY KEY,
	jongryu				varchar(10),
	yeongyoeck			varchar(10),
	yoohyong			varchar(10),
	file_url			varchar(50),
	num_of_question		integer,
	text				varchar(2000)
);

create table sheet_question_table (
	sid					varchar(50),
	qid					varchar(50)
);

create table Solution (
	solid				varchar(50) PRIMARY KEY,
	qid					varchar(50),
	sub_Answer			varchar(50),
	S_type				varchar(1),	
	num_Of_Answer		integer,
	did_list			varchar(50)
);

create table answer (
	aid					varchar(50) PRIMARY KEY,
	asid				varchar(50),
	question_num		integer,
	answer				varchar(200),
	is_correct			boolean
);

create table answersheet (
	asid				varchar(50) PRIMARY KEY,
	sid					varchar(50),
	id					varchar(50),
	total_score			float,
	test_date			date
);

create table sheet (
	sid					varchar(50) PRIMARY KEY,
	title				varchar(200),
	grade				varchar(10),
	num_of_question		integer,
	examiner			varchar(50),
	create_sheet_date	date,
	limit_time			integer,
	completed			boolean,
	formal				varchar(1)
);

create table sheet_form_link_table (
	sid					varchar(50),
	fid					varchar(50)
);

create table exam_form (
	eid					varchar(50) PRIMARY KEY,
	jongryu				varchar(50),
	cover_url			varchar(200)
);

