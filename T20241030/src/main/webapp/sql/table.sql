create table product_tbl (
 prd_code char(4) primary key, -- P001, P002
 prd_name varchar2(100) not null, --상품명.
 prd_desc varchar2(1000) not null, --상품의 설명.
 origin_price number, --원가격.
 sale_price number, --할인가격.
 star_point number, --별점.
 prod_image varchar2(100), --상품이미지명.
 creation_date date default sysdate --생성일자.
);

insert into product_tbl (prd_code, prd_name, prd_desc, origin_price, sale_price, star_point, prod_image)
values('P001', '과테말라 안티구아', '아주 맛있는 과테말라 안티구아 입니다', 3000, 2500, 5, '과테말라 안티구아.jpg');
insert into product_tbl (prd_code, prd_name, prd_desc, origin_price, sale_price, star_point, prod_image)
values('P002', '니카라구아 더치', '아주 맛있는 니카라구아 더치 입니다', 4000, 3500, 4, '니카라구아 더치.jpg');
insert into product_tbl (prd_code, prd_name, prd_desc, origin_price, sale_price, star_point, prod_image)
values('P003', '브라질산토스', '아주 맛있는 브라질산토스 입니다', 6000, 5500, 3, '브라질산토스.jpg');
insert into product_tbl (prd_code, prd_name, prd_desc, origin_price, sale_price, star_point, prod_image)
values('P004', '에티오피아 예가체프', '아주 맛있는 에티오피아 예가체프 입니다', 7000, 6500, 2, '에티오피아 예가체프.jpg');
insert into product_tbl (prd_code, prd_name, prd_desc, origin_price, sale_price, star_point, prod_image)
values('P005', '케냐 오크라톡신', '아주 맛있는 케냐 오크라톡신 입니다', 3500, 2800, 1, '케냐 오크라톡신.jpg');
insert into product_tbl (prd_code, prd_name, prd_desc, origin_price, sale_price, star_point, prod_image)
values('P006', '코스타리카 따라주', '아주 맛있는 코스타리카 따라주 입니다', 4500, 3200, 3, '코스타리카 따라주.jpg');
