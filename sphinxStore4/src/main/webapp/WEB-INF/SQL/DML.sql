select * from Customer
select customer_id, id, password from Customer where id = 'qweqwe'
select * from CATEGORY
select count (order_id) from orders
select * from CATEGORY where category_id='CAT000002'
select * from category where super_id = ''
update category set super_id='' where category_id = 'CAT000003'
select category_id, category_name, super_id from Category where category_name = '소주'
select * from OPTIONS
select * from OPTIONVALUE
select * from OPTIONS_LINK
select max(product_id), count(*) from PRODUCT

update ORDERS set del=false

insert into CATEGORY (category_id,category_name) values('CAT000001','한국공예품' );
insert into CATEGORY (category_id,category_name) values('CAT000002','국산주류' );
insert into CATEGORY (category_id,category_name) values('CAT000003','식품' );
insert into CATEGORY (category_id,category_name) values('CAT000016','여행상품' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000004','도자기','CAT000001' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000005','나전','CAT000001' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000006','식기','CAT000001' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000007','풍속화','CAT000001' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000008','한지','CAT000001' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000009','막걸리','CAT000002' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000010','소주','CAT000002' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000011','한과/다과','CAT000003' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000012','된장/고추장','CAT000003' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000013','김','CAT000003' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000014','간장','CAT000003' );
insert into CATEGORY (category_id,category_name,super_id) values('CAT000015','참기름','CAT000003' );

insert into category_table(cid, title) values('C000001','reading');
insert into category_table(cid, title) values('C000002','writing');
insert into category_table(cid, title) values('C000003','grammar');
insert into category_table(cid, parent_cid, title) values('C000004','C000001','intermediate');
insert into category_table(cid, parent_cid, title) values('C000005','C000001','pre-intermediate');
insert into category_table(cid, parent_cid, title) values('C000006','C000004','diary');
insert into category_table(cid, parent_cid, title) values('C000007','C000004','article');
insert into category_table(cid, parent_cid, title) values('C000008','C000004','sentence order');
insert into category_table(cid, title) values('C000009','vocabulary');
insert into category_table(cid, parent_cid, title) values('C000010','C000009','pre-intermediate');
insert into category_table(cid, parent_cid, title) values('C000011','C000010','basic');
insert into category_table(cid, title) values('C000012','conversation');
insert into category_table(cid, parent_cid, title) values('C000013','C000012','pre-intermediate');
insert into category_table(cid, parent_cid, title) values('C000014','C000013','basic expression');
insert into category_table(cid, parent_cid, title) values('C000015','C000013','contextual dialogue');
insert into category_table(cid, parent_cid, title) values('C000016','C000013','acting expression');
insert into category_table(cid, parent_cid, title) values('C000017','C000012','intermediate');
insert into category_table(cid, parent_cid, title) values('C000018','C000017','finding main point');
insert into category_table(cid, parent_cid, title) values('C000019','C000005','basic sentence');
insert into category_table(cid, parent_cid, title) values('C000020','C000003','pre-intermediate');
insert into category_table(cid, parent_cid, title) values('C000021','C000020','adverb&&verbs,present');
insert into category_table(cid, parent_cid, title) values('C000022','C000020','verbs,past');
insert into category_table(cid, parent_cid, title) values('C000023','C000017','test');


insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000001','참이슬',300.0,'','상품설명','알코올~', DATE	('2018-02-08'));

insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000002','CAT000010');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000002','처음처럼',400.0,'','상품설명2','알코올~2', DATE	('2018-02-08'));

insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000003','CAT000010');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000003','순하리',500.0,'','상품설명3','알코올~3', DATE('2018-02-08'));

insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000004','CAT000010');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000004','한라산',600.0,'','상품설명4','알코올~4', DATE('2018-02-08'));
	
insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000005','CAT000009');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000005','밤막걸리',650.0,'','상품설명5','알코올~5', DATE('2018-02-08'));
	
insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000006','CAT000009');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000006','옥수수막걸리',670.0,'','상품설명6','알코올~6', DATE('2018-02-08'));
	
insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000007','CAT000009');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000007','바나나막걸리',690.0,'','상품설명7','알코올~7', DATE('2018-02-08'));
	
insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000008','CAT000009');
insert into PRODUCT (product_id, product_name, price, file_name, content, comment, regDate) 
	values('PRODUCT000008','국산막걸리',710.0,'','상품설명8','알코올~8', DATE('2018-02-08'));
	
insert into member ()
	


insert into PRODUCT_CATEGORY_LINK (product_id, category_id) values('PRODUCT000001','CAT000010')


insert into OptionValue(optionvalue_id, name, add_price, option_id)  values(?, ?, ?, ?);

delete from Category where category_id = 'CAT000017';