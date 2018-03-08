create table Category ( --1
	id				varchar(20)		primary key,
	name			varchar(30)		not null,
	parent			varchar(20)		not null,
	del				boolean			not null,
	types			integer			not null
);



create table Product ( --2
	id				varchar(20)		primary key,
	name			varchar(30)		not null,
	price			float			not null,
	content			varchar(5000)	not null,
	filename		varchar(500)	not null,
	comment			varchar(100)	not null,
	del				boolean			not null,
	regDate			date			not null
);



create table LinkInC ( --3
	id				varchar(20)		primary key,
	productId		varchar(20)		not null,
	categoryId		varchar(20)		not null,
	del				boolean			not null,
	
	CONSTRAINT linkInC_pid_FK
	FOREIGN KEY(productId) REFERENCES Product(id),
	
	CONSTRAINT linkInC_cid_FK
	FOREIGN KEY(categoryId) REFERENCES Category(id)
);



create table Options ( --4
	id				varchar(20)		primary key,
	optionName		varchar(100)	not null,
	del				boolean			not null,
	productId		varchar(20)		not null,
	
	CONSTRAINT Option_pid_FK
	FOREIGN KEY(productId) REFERENCES Product(id)
);




create table OptionValue ( --5
	id				varchar(20)		primary key,
	optionValue		varchar(100)	not null,
	addprice		float			not null,
	del				boolean			not null,
	optionId		varchar(20)		not null,
	
	CONSTRAINT Value_oid_FK
	FOREIGN KEY(optionId) REFERENCES Options(id)
);




create table Customer ( --8
	id				varchar(20)		primary key,
	admin			boolean			not null,
	sphinxId		varchar(50)		not null,
	password		varchar(50)		not null,
	del				boolean			not null,
	name			varchar(30)		not null,
	phoneNum		varchar(15)		not null,
	address			varchar(200)	not null,
	post			varchar(10)		not null,
	joinDate		date			not null,
	birthday		date			not null,
	email			varchar(50)		not null,
	points			INTEGER			not null,
	level			INTEGER			not null
);
insert into Customer (id, admin, sphinxId, password, del, name, phoneNum, address, post, joinDate, birthDay, email, points, level) 
values ('1', false, 'customer', 'customer', false, 'customer', 'customer', 'address', 'post', '2018-02-21', '2018-02-21', 'email', 0, 1);



create table Board ( --6
	id				varchar(20)		primary key,
	title			varchar(50)		not null,
	types			integer			not null,
	writeDate		date			not null,
	del				boolean			not null,
	fileName		varchar(100)	not null,
	content			varchar(5000)	not null,
	customerId		varchar(20)		not null,
	
	CONSTRAINT Board_cid_FK
	FOREIGN KEY(customerId) REFERENCES Customer(id)
);




create table LinkBnC ( --7
	id				varchar(20)		primary key,
	boardId			varchar(20)		not null,
	categoryId		varchar(20)		not null,
	del				boolean			not null,

	CONSTRAINT linkBnC_bid_FK
	FOREIGN KEY(boardId) REFERENCES Board(id),
	
	CONSTRAINT linkBnC_cid_FK
	FOREIGN KEY(categoryId) REFERENCES Category(id)
);




create table Orders ( --10
	id				varchar(20)		primary key,
	customerId		varchar(20)		not null,
	orderDate		date			not null,
	state			varchar(20)		not null,
	del				boolean			not null,
	totalPrice		float			not null,
	recipient		varchar(30)		not null,
	recipientAddr	varchar(200)	not null,
	memo			varchar(200)	not null,
	
	CONSTRAINT Order_cid_FK
	FOREIGN KEY(customerId) REFERENCES Customer(id)
);



create table OrderItem ( --9
	id				varchar(20)		primary key,
	quantity		integer			not null,
	productId		varchar(20)		not null,
	state			varchar(30)		not null,
	orderId			varchar(20)		not null,
	
	CONSTRAINT OrderItem_pid_FK
	FOREIGN KEY(productId) REFERENCES Product(id),
	
	CONSTRAINT OrderItem_oid_FK
	FOREIGN KEY(orderId) REFERENCES Orders(id)
);



