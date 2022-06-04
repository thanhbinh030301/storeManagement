﻿﻿CREATE DATABASE storemanagementdb;
USE storemanagementdb;

-- TAO BANG KHACH HANG
CREATE TABLE KHACHHANG(
	MAKH	char(4) not null DEFAULT '0' ,	
	HOTEN	varchar(40),
	GIOITINH	varchar(3),
	TONGCHITIEU	decimal(15,2)  DEFAULT 0, 
	TICHDIEM float DEFAULT 0,
	primary key(MAKH)
);
CREATE TABLE KHACHHANG_SEQ
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);
DELIMITER $$
CREATE TRIGGER tg_khachhang_insert
BEFORE INSERT ON KHACHHANG
FOR EACH ROW
BEGIN
  INSERT INTO  KHACHHANG_SEQ VALUES (NULL);
  SET NEW.MAKH = CONCAT('KH', LPAD(LAST_INSERT_ID(), 2, '0'));
END$$


CREATE TABLE NHANVIEN(
	MANV	char(4) not null DEFAULT '0',	
	HOTEN	varchar(40),
	SODT	varchar(20),
	NGVL	date,	
	primary key(MANV)
);
CREATE TABLE NHANVIEN_SEQ
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);
DELIMITER $$
CREATE TRIGGER tg_nhanvien_insert
BEFORE INSERT ON NHANVIEN
FOR EACH ROW
BEGIN
  INSERT INTO  NHANVIEN_SEQ VALUES (NULL);
  SET NEW.MANV = CONCAT('NV', LPAD(LAST_INSERT_ID(), 2, '0'));
END$$
DELIMITER ;

-- TAO BANG TAI KHAON
CREATE TABLE TAIKHOAN(
	MATK	char(4) not null,	
	TENTK	char(20),
	MATKHAU	char(10),
	CAPBAC int,	
    MANV char(4),
	primary key(MATK)
    
);
CREATE TABLE TAIKHOAN_SEQ
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);
DELIMITER $$
CREATE TRIGGER tg_taikhoan_insert
BEFORE INSERT ON TAIKHOAN
FOR EACH ROW
BEGIN
  INSERT INTO  TAIKHOAN_SEQ VALUES (NULL);
  SET NEW.MATK = CONCAT('TK', LPAD(LAST_INSERT_ID(), 2, '0'));
END$$
DELIMITER ;



-- TAO BANG SAN PHAM
CREATE TABLE SANPHAM(
	MASP	char(5) not null DEFAULT '0',
	TENSP	varchar(60),
	DVT	varchar(20),
	GIA	decimal(15,2)  DEFAULT 0,
	SOLUONG INT,
	primary key(MASP)	
);
CREATE TABLE SANPHAM_SEQ
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);
DELIMITER $$
CREATE TRIGGER tg_sanpham_insert
BEFORE INSERT ON SANPHAM
FOR EACH ROW
BEGIN
  INSERT INTO  SANPHAM_SEQ VALUES (NULL);
  SET NEW.MASP = CONCAT('SP', LPAD(LAST_INSERT_ID(), 3, '0'));
END$$
DELIMITER ;


CREATE TABLE HOADON(
	SOHD	int not null AUTO_INCREMENT,
	NGHD 	date,
	MAKH 	char(4),
	MANV 	char(4),
	TRIGIA	decimal(15,2)  DEFAULT 0,
	primary key(SOHD)
);


   CREATE TABLE CTHD(
	SOHD	int,
	MASP	char(5),
	SL	int,
	primary key(SOHD,MASP)
);

-- Khoa ngoai cho bang HOADON
ALTER TABLE HOADON ADD FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH);
ALTER TABLE HOADON ADD FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV);
ALTER TABLE TAIKHOAN ADD FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV);
-- Khoa ngoai cho bang CTHD
ALTER TABLE CTHD ADD FOREIGN KEY(SOHD) REFERENCES HOADON(SOHD);
ALTER TABLE CTHD ADD FOREIGN KEY(MASP) REFERENCES SANPHAM(MASP);


insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Mì Hảo Hảo','goi',4000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Mì Handy Hảo Hảo','ly',9000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Hủ tiếu Nam Vang Như Ý','goi',5000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Phở gà Vifon Hoàng Gia','goi',20000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Cháo thịt gà Vifon','goi',5000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bánh Gạo Tobokki','goi',28000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Dầu đậu nành nguyên chất Simply can 2 lít','chai',135000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Dầu đậu nành nguyên chất Simply can 1 lít','chai',70000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Đường Biên Hòa','Kg',27000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Hạt nêm Knorr gói 1,2kg','goi',93000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bột ngọt Vedan','goi',60000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Muối i ốt Vifon','goi',6000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Muối Tây Ninh','Hu',15000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước chấm Nam Ngư Đệ Nhị chai 900ml','chai',25000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước mắm cao đạm Liên Thành nhãn vàng chai 300ml','chai',40000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước tương đậm đặc Maggi chai 700ml','chai',30000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước tương Tam Thái Tử Nhất ca chai 500ml','chai',19000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Tương ớt Chinsu chai 250g','chai',14000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Xốt mayonnaise Ottogi chai 130g','chai',20000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Lốc 4 hộp sữa tươi ít đường Vinamilk Green Farm 180ml','loc',33000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Lốc 4 hộp sữa tươi ít đường TH true MILK 110ml','loc',23000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Lốc 4 hộp sữa tươi ít đường TH true MILK 110ml','loc',26000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bia Gubernija Royal Baltic 6.4% lon 500ml','chai',49000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bia Budweiser chai 330ml','chai',22000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bia Budweiser chai 330ml','chai',6000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước ngọt Sprite chanh chai 1.5 lít','chai',20000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước tăng lực Redbull 250ml','lon',12000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước tăng lực Sting hương dâu 320ml','lon',10000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước tinh khiết Aquafina 500ml','chai',5000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Snack pho mát miếng Oishi gói 39g','goi',6000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Snack khoai tây mực tẩm cay thái Lays Wavy','gói',19000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Khăn ướt cồn Let-green','goi',36000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Khăn giấy rút Let-green','gói',40000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Tắm gội X-men 2 trong 1 630g sạch sâu','chai',166000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Tắm gội Clear Men sạch nhanh 618g','chai',180000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Dầu gội Sunsilk mềm mượt diệu kỳ 165ml','chai',43000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Sữa tắm Olay dưỡng ẩm hạnh nhân 650ml','chai',182000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Sữa tắm dưỡng thể Dove sáng mịn 527ml','chai',158000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Sữa rửa mặt men Bioré sạch sâu 100g','chai',65000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bông tẩy trang đa dụng Niva','hop',35000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Kem đánh răng Colgate Natural trà xanh 180g','hộp',52000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bộ 2 bàn chải Oral-Clean Diamond lông siêu mềm','cai',33000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước súc miệng Colgate Plax Fresh Tea 500ml','chai',105000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Băng vệ sinh Kotex Pro siêu mỏng có cánh 20 miếng','goi',42000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Băng vệ sinh Diana Sensi Cool','goi',23000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Bột giặt Ariel hương nắng mai túi 720g','túi',38000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước giặt OMO Matic hoa hồng Ecuador túi 1.9 lít','túi',115000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước xả Downy hương hoa oải hương túi 2.2 lít','tui',172000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước rửa chén Sunlight Chanh 100 chai 386ml','chai',15000,500);
insert into SANPHAM (TENSP, DVT, GIA, SOLUONG) values('Nước rửa chén Sunlight thiên nhiên túi 725ml','tui',25000,500);


-- delete from SANPHAM where MASP >5;


-- select * from SANPHAM;

insert into KHACHHANG (HOTEN, GIOITINH)
values('Nguyen Van Thanh', 'Nam');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Tran Ngoc Han','Nu');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Tran Ngoc Linh','Nu');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Tran Minh Long','Nam');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Le Nhat Minh','Nam');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Le Hoai Thuong','Nu');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Nguyen Van Tam','Nam');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Phan Thi Thanh','Nu');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Le Ha Vinh','Nam');
insert into KHACHHANG (HOTEN, GIOITINH)
values('Ha Duy Lap','Nam');

select * from NHANVIEN;

insert into NHANVIEN (HOTEN,SODT,NGVL) values('Nguyen Nhu Nhut','927345678','202/01/14');
insert into NHANVIEN (HOTEN,SODT,NGVL) values('Le Thi Phi Yen','987567390','2022/01/14');
insert into NHANVIEN (HOTEN,SODT,NGVL) values('Nguyen Van Bao','997047382','2022/01/14');
insert into NHANVIEN (HOTEN,SODT,NGVL) values('Ngo Thanh Tuan','913758498','2022/01/14');
insert into NHANVIEN (HOTEN,SODT,NGVL) values('Nguyen Thi Truc Thanh','918590387','2022/01/14');

insert into TAIKHOAN (TENTK,MATKHAU,CAPBAC,MANV) values( 'admin', 'admin', 2, 'NV01');
insert into TAIKHOAN (TENTK,MATKHAU,CAPBAC,MANV) values( 'phiyen', '12345', 1, 'NV02');
insert into TAIKHOAN (TENTK,MATKHAU,CAPBAC,MANV) values( 'vanbao', '12345', 1, 'NV03');
insert into TAIKHOAN (TENTK,MATKHAU,CAPBAC,MANV) values( 'thanhtuan', '12345', 1, 'NV04');
insert into TAIKHOAN (TENTK,MATKHAU,CAPBAC,MANV) values( 'tructhanh', '12345', 1, 'NV05');


insert into HOADON (NGHD,MAKH,MANV) values(CURDATE(),'KH01','NV02');

insert into CTHD (SOHD, MASP, SL) values(1,'SP001',2);
insert into CTHD (SOHD, MASP, SL) values(1,'SP002',2);
select * from khachhang;
select * from cthd;






-- tổng giá trị hóa đơn
select   SUM( GIA * SL)   FROM 
SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
WHERE CTHD.SOHD = 1;

-- chi tiết hóa đơn

select  CTHD.MASP, TENSP, GIA, SL, ( GIA * SL) as TONG  FROM 
SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
WHERE CTHD.SOHD = 1




