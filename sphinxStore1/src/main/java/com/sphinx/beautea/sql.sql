select * from category;
select * from Product;
select * from LinkInC;
select * from OptionS;
select * from OptionValue;
select * from Board;
select * from LinkBnC;
select * from Customer;
select * from OrderItem;
select * from Orders;

update Customer set admin = true;

delete from Product

drop table Category;
drop table Product;
drop table LinkInC;
drop table Options;
drop table OptionValue;
drop table Customer;
drop table Board;
drop table LinkBnC;
drop table Orders;
drop table OrderItem;

	컬럼 데이터 유형 변경
ALTER TABLE product ALTER COLUMN filename SET DATA TYPE VARCHAR(1000)
 	새로운 컬럼 추가
ALTER TABLE CUSTOMER ADD COLUMN level INTEGER NOT NULL DEFAULT 1
	내용 복사
UPDATE R_QUESTION SET R_NEW_DESCRIPTION = R_DESCRIPTION
	기존 칼럼 삭제
ALTER TABLE R_QUESTION DROP COLUMN R_DESCRIPTION
	칼럼 이름 바꾸기
RENAME COLUMN R_QUESTION.R_NEW_DESCRIPTION TO R_DESCRIPTION