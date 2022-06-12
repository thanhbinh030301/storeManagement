﻿﻿CREATE DATABASE storemanagementdb;
USE storemanagementdb;

-- TAO BANG KHACH HANG
CREATE TABLE KHACHHANG(
	MAKH	char(4) not null DEFAULT '0' ,	
	HOTEN	varchar(40),
	GIOITINH	varchar(3),
    SODT 		varchar(10),
	TONGCHITIEU	decimal(15,2)  DEFAULT 0, 
	TICHDIEM float DEFAULT 0,
    TONTAI boolean default TRUE,
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
END$$;
DELIMITER ;

CREATE TABLE NHANVIEN(
	MANV	char(4) not null DEFAULT '0',	
	HOTEN	varchar(40),
    GIOITINH VARCHAR(3),
	SODT	varchar(20),
    TONTAI boolean default TRUE,
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
	TENDANGNHAP	char(20),
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
	DONVITINH	varchar(20),
	DONGIA	decimal(15,2)  DEFAULT 0,
	SOLUONG INT,
    TONTAI boolean default TRUE,
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
	MAHD	char(5) not null DEFAULT '0',
	NGAYLAP 	date,
	MAKH 	char(4),
	MANV 	char(4),
	TONGTIEN	decimal(15,2)  DEFAULT 0,
	primary key(MAHD)
);
CREATE TABLE HOADON_SEQ
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);
DELIMITER $$
CREATE TRIGGER tg_hoadon_insert
BEFORE INSERT ON HOADON
FOR EACH ROW
BEGIN
  INSERT INTO  HOADON_SEQ VALUES (NULL);
  SET NEW.MAHD = CONCAT('HD', LPAD(LAST_INSERT_ID(), 3, '0'));
END$$
DELIMITER ;

   CREATE TABLE CTHD(
	MAHD	char(5),
	MASP	char(5),
	SOLUONG	int,
    DONGIA decimal(15,2)  DEFAULT 0,
    THANHTIEN decimal(15,2)  DEFAULT 0,
	primary key(MAHD,MASP)
);

-- Khoa ngoai cho bang HOADON
ALTER TABLE HOADON ADD FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH);
ALTER TABLE HOADON ADD FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV);
ALTER TABLE TAIKHOAN ADD FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV);
-- Khoa ngoai cho bang CTHD
ALTER TABLE CTHD ADD FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD);
ALTER TABLE CTHD ADD FOREIGN KEY(MASP) REFERENCES SANPHAM(MASP);

-- Trigger bang cthd
DELIMITER $$
CREATE TRIGGER tg_cthd_insert_before
before INSERT ON cthd
FOR EACH ROW
BEGIN
    
    SELECT   max(DONGIA) into @dongia
    FROM SANPHAM
    WHERE MASP = new.masp;
    SET NEW.DONGIA = @DONGIA;
    SET NEW.THANHTIEN = @DONGIA * NEW.SOLUONG;
    
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tg_cthd_insert
after INSERT ON cthd
FOR EACH ROW
BEGIN
	select   SUM( SANPHAM.DONGIA * CTHD.SOLUONG) INTO @TONG   FROM 
	SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
	WHERE CTHD.MAHD = NEW.MAHD;
	update hoadon set TONGTIEN = @TONG
    WHERE HOADON.MAHD = NEW.MAHD;
    
END$$
DELIMITER ;

-- Them trigger hoa don

DELIMITER $$
CREATE TRIGGER tg_hoadon_update
after update ON hoadon
FOR EACH ROW
BEGIN
	SELECT SUM(TONGTIEN) INTO @TONGCHITIEU FROM HOADON where MAKH =new.MAKH ORDER BY MAKH;
	update khachhang set TONGCHITIEU = @TONGCHITIEU, TICHDIEM = @TONGCHITIEU*0.1
    WHERE KHACHHANG.MAKH = NEW.MAKH;
END$$
DELIMITER ;
-- Them du lieu


insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Mì Hảo Hảo','goi',4000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Mì Handy Hảo Hảo','ly',9000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Hủ tiếu Nam Vang Như Ý','goi',5000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Phở gà Vifon Hoàng Gia','goi',20000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Cháo thịt gà Vifon','goi',5000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bánh Gạo Tobokki','goi',28000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Dầu đậu nành nguyên chất Simply can 2 lít','chai',135000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Dầu đậu nành nguyên chất Simply can 1 lít','chai',70000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Đường Biên Hòa','Kg',27000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Hạt nêm Knorr gói 1,2kg','goi',93000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bột ngọt Vedan','goi',60000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Muối i ốt Vifon','goi',6000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Muối Tây Ninh','Hu',15000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước chấm Nam Ngư Đệ Nhị chai 900ml','chai',25000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước mắm cao đạm Liên Thành nhãn vàng chai 300ml','chai',40000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước tương đậm đặc Maggi chai 700ml','chai',30000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước tương Tam Thái Tử Nhất ca chai 500ml','chai',19000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Tương ớt Chinsu chai 250g','chai',14000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Xốt mayonnaise Ottogi chai 130g','chai',20000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Lốc 4 hộp sữa tươi ít đường Vinamilk Green Farm 180ml','loc',33000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Lốc 4 hộp sữa tươi ít đường TH true MILK 110ml','loc',23000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Lốc 4 hộp sữa tươi ít đường TH true MILK 110ml','loc',26000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bia Gubernija Royal Baltic 6.4% lon 500ml','chai',49000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bia Budweiser chai 330ml','chai',22000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bia Budweiser chai 330ml','chai',6000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước ngọt Sprite chanh chai 1.5 lít','chai',20000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước tăng lực Redbull 250ml','lon',12000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước tăng lực Sting hương dâu 320ml','lon',10000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước tinh khiết Aquafina 500ml','chai',5000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Snack pho mát miếng Oishi gói 39g','goi',6000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Snack khoai tây mực tẩm cay thái Lays Wavy','gói',19000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Khăn ướt cồn Let-green','goi',36000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Khăn giấy rút Let-green','gói',40000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Tắm gội X-men 2 trong 1 630g sạch sâu','chai',166000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Tắm gội Clear Men sạch nhanh 618g','chai',180000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Dầu gội Sunsilk mềm mượt diệu kỳ 165ml','chai',43000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Sữa tắm Olay dưỡng ẩm hạnh nhân 650ml','chai',182000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Sữa tắm dưỡng thể Dove sáng mịn 527ml','chai',158000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Sữa rửa mặt men Bioré sạch sâu 100g','chai',65000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bông tẩy trang đa dụng Niva','hop',35000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Kem đánh răng Colgate Natural trà xanh 180g','hộp',52000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bộ 2 bàn chải Oral-Clean Diamond lông siêu mềm','cai',33000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước súc miệng Colgate Plax Fresh Tea 500ml','chai',105000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Băng vệ sinh Kotex Pro siêu mỏng có cánh 20 miếng','goi',42000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Băng vệ sinh Diana Sensi Cool','goi',23000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Bột giặt Ariel hương nắng mai túi 720g','túi',38000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước giặt OMO Matic hoa hồng Ecuador túi 1.9 lít','túi',115000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước xả Downy hương hoa oải hương túi 2.2 lít','tui',172000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước rửa chén Sunlight Chanh 100 chai 386ml','chai',15000,500);
insert into SANPHAM (TENSP, DONVITINH, DONGIA, SOLUONG) values('Nước rửa chén Sunlight thiên nhiên túi 725ml','tui',25000,500);


-- delete from SANPHAM where MASP >5;


-- select * from SANPHAM;

insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Nguyễn Văn Thành', 'Nam','0952116854');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Trần Ngọc Hân','Nữ','0554662358');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Tran Ngoc Linh','Nữ','0781054669');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Trần Minh Long','Nam','0500474447');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Lê Nhật Minh','Nam','0546854225');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Lê Hoài Thương','Nữ','0457456589');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Nguyễn Văn Tâm','Nam','0456158256');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Phan Thị Thanh','Nữ','0568004056');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Lê Hà Vinh','Nam','0451258156');
insert into KHACHHANG (HOTEN, GIOITINH,SODT) values('Hà Duy Lập','Nam','0458147145');

select * from NHANVIEN;

insert into NHANVIEN (HOTEN,SODT,GIOITINH) values('Nguyễn Như Nhật','927345678','Nữ');
insert into NHANVIEN (HOTEN,SODT,GIOITINH) values('Lê Thị Phi Yến','987567390','Nữ');
insert into NHANVIEN (HOTEN,SODT,GIOITINH) values('Nguyễn Văn Bảo','997047382','Nam');
insert into NHANVIEN (HOTEN,SODT,GIOITINH) values('Ngô Thanh Tuấn','913758498','Nam');
insert into NHANVIEN (HOTEN,SODT,GIOITINH) values('Nguyễn Thị Trúc Thanh','918590387','Nữ');

insert into TAIKHOAN (TENDANGNHAP,MATKHAU,CAPBAC,MANV) values( 'admin', 'admin', 2, 'NV01');
insert into TAIKHOAN (TENDANGNHAP,MATKHAU,CAPBAC,MANV) values( 'phiyen', '12345', 1, 'NV02');
insert into TAIKHOAN (TENDANGNHAP,MATKHAU,CAPBAC,MANV) values( 'vanbao', '12345', 1, 'NV03');
insert into TAIKHOAN (TENDANGNHAP,MATKHAU,CAPBAC,MANV) values( 'thanhtuan', '12345', 1, 'NV04');
insert into TAIKHOAN (TENDANGNHAP,MATKHAU,CAPBAC,MANV) values( 'tructhanh', '12345', 1, 'NV05');


insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH01','NV01');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH02','NV02');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH03','NV03');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH04','NV04');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH05','NV05');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH06','NV01');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH07','NV02');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH08','NV03');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH09','NV04');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH10','NV05');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH01','NV01');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH02','NV02');
insert into HOADON (NGAYLAP,MAKH,MANV) values(CURDATE(),'KH03','NV03');

insert into CTHD (MAHD, MASP, SOLUONG) values('HD001','SP001',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD001','SP002',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD001','SP004',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD002','SP005',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD002','SP006',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD002','SP007',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD002','SP008',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD003','SP009',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD003','SP010',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD003','SP011',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD003','SP012',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD004','SP013',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD004','SP014',1);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD004','SP015',3);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD004','SP016',4);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD005','SP017',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD005','SP018',6);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD005','SP019',5);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD005','SP020',1);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD006','SP021',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD006','SP022',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD006','SP026',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD006','SP024',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD007','SP025',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD007','SP013',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD007','SP022',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD007','SP047',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD008','SP011',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD008','SP006',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD008','SP012',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD008','SP030',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD009','SP031',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD009','SP033',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD009','SP040',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD009','SP014',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD010','SP026',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD010','SP039',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD010','SP040',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD010','SP041',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD011','SP015',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD011','SP024',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD011','SP046',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD011','SP048',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD012','SP015',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD012','SP024',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD012','SP046',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD012','SP048',2);

insert into CTHD (MAHD, MASP, SOLUONG) values('HD013','SP025',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD013','SP013',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD013','SP022',2);
insert into CTHD (MAHD, MASP, SOLUONG) values('HD013','SP047',2);




