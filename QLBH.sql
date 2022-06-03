﻿CREATE DATABASE storemanagementdb;
USE storemanagementdb;

CREATE TABLE KHACHHANG(
	MAKH	char(4) not null ,	
	HOTEN	varchar(40),
	DCHI	varchar(50),
	SODT	varchar(20),
	NGSINH	date,
	NGDK	date,
	DOANHSO	decimal(15,2),
	primary key(MAKH)
);

CREATE TABLE NHANVIEN(
	MANV	char(4) not null,	
	HOTEN	varchar(40),
	SODT	varchar(20),
	NGVL	date,	
	primary key(MANV)
);

CREATE TABLE TAIKHOAN(
	MATK	char(4) not null,	
	TENTK	char(20),
	MATKHAU	char(10),
	CAPBAC int,	
    MANV char(4),
	primary key(MATK)
    
);



CREATE TABLE SANPHAM(
	MASP	char(5) not null,
	TENSP	varchar(60),
	DVT	varchar(20),
	GIA	decimal(15,2)  DEFAULT 0,
	SOLUONG INT,
	primary key(MASP)	
);

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


insert into SANPHAM values('SP01','Mì Hảo Hảo','goi',4000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP02','Mì Handy Hảo Hảo','ly',9000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP03','Hủ tiếu Nam Vang Như Ý','goi',5000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP04','Phở gà Vifon Hoàng Gia','goi',20000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP05','Cháo thịt gà Vifon','goi',5000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP06','Bánh Gạo Tobokki','goi',28000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP07','Dầu đậu nành nguyên chất Simply can 2 lít','chai',135000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP08','Dầu đậu nành nguyên chất Simply can 1 lít','chai',70000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP09','Đường Biên Hòa','Kg',27000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP10','Hạt nêm Knorr gói 1,2kg','goi',93000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP11','Bột ngọt Vedan','goi',60000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP12','Muối i ốt Vifon','goi',6000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP13','Muối Tây Ninh','Hu',15000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP14','Nước chấm Nam Ngư Đệ Nhị chai 900ml','chai',25000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP15','Nước mắm cao đạm Liên Thành nhãn vàng chai 300ml','chai',40000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP16','Nước tương đậm đặc Maggi chai 700ml','chai',30000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP17','Nước tương Tam Thái Tử Nhất ca chai 500ml','chai',19000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP18','Tương ớt Chinsu chai 250g','chai',14000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP19','Xốt mayonnaise Ottogi chai 130g','chai',20000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP20','Lốc 4 hộp sữa tươi ít đường Vinamilk Green Farm 180ml','loc',33000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP21','Lốc 4 hộp sữa tươi ít đường TH true MILK 110ml','loc',23000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP22','Lốc 4 hộp sữa tươi ít đường TH true MILK 110ml','loc',26000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP23','Bia Gubernija Royal Baltic 6.4% lon 500ml','chai',49000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP24','Bia Budweiser chai 330ml','chai',22000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP25','Bia Budweiser chai 330ml','chai',6000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP26','Nước ngọt Sprite chanh chai 1.5 lít','chai',20000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP27','Nước tăng lực Redbull 250ml','lon',12000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP28','Nước tăng lực Sting hương dâu 320ml','lon',10000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP29','Nước tinh khiết Aquafina 500ml','chai',5000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP30','Snack pho mát miếng Oishi gói 39g','goi',6000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP31','Snack khoai tây mực tẩm cay thái Lays Wavy','gói',19000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP32','Khăn ướt cồn Let-green','goi',36000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP33','Khăn giấy rút Let-green','gói',40000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP34','Tắm gội X-men 2 trong 1 630g sạch sâu','chai',166000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP35','Tắm gội Clear Men sạch nhanh 618g','chai',180000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP36','Dầu gội Sunsilk mềm mượt diệu kỳ 165ml','chai',43000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP37','Sữa tắm Olay dưỡng ẩm hạnh nhân 650ml','chai',182000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP38','Sữa tắm dưỡng thể Dove sáng mịn 527ml','chai',158000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP39','Sữa rửa mặt men Bioré sạch sâu 100g','chai',65000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP40','Bông tẩy trang đa dụng Niva','hop',35000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP41','Kem đánh răng Colgate Natural trà xanh 180g','hộp',52000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP42','Bộ 2 bàn chải Oral-Clean Diamond lông siêu mềm','cai',33000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP43','Nước súc miệng Colgate Plax Fresh Tea 500ml','chai',105000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP44','Băng vệ sinh Kotex Pro siêu mỏng có cánh 20 miếng','goi',42000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP45','Băng vệ sinh Diana Sensi Cool','goi',23000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP46','Bột giặt Ariel hương nắng mai túi 720g','túi',38000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP47','Nước giặt OMO Matic hoa hồng Ecuador túi 1.9 lít','túi',115000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP48','Nước xả Downy hương hoa oải hương túi 2.2 lít','tui',172000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP49','Nước rửa chén Sunlight Chanh 100 chai 386ml','chai',15000,500);
insert into SANPHAM (MASP,TENSP, DVT, GIA, SOLUONG) values('SP50','Nước rửa chén Sunlight thiên nhiên túi 725ml','tui',25000,500);


-- delete from SANPHAM where MASP >5;


-- select * from SANPHAM;

insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH01','Nguyen Van A','731 Tran Hung Dao, Q5, TpHCM','8823451','1999/10/22','2020/1/21');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH02','Tran Ngoc Han','23/5 Nguyen Trai, Q5, TpHCM','908256478','1998/03/04','2021/07/30');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH03','Tran Ngoc Linh','45 Nguyen Canh Chan, Q1, TpHCM','938776266','2001/06/12','2020/05/08');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH04','Tran Minh Long','50/34 Le Dai Hanh, Q10, TpHCM','917325476','2001/09/03','2022/04/12');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH05','Le Nhat Minh','34 Truong Dinh, Q3, TpHCM','8246108','2000/03/10','2021/10/28');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH06','Le Hoai Thuong','227 Nguyen Van Cu, Q5, TpHCM','8631738','1999/11/07','2021/02/14');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH07','Nguyen Van Tam','32/3 Tran Binh Trong, Q5, TpHCM','916783565','2002/04/06','2022/01/11');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH08','Phan Thi Thanh','45/2 An Duong Vuong, Q5, TpHCM','938435756','2001/01/10','2021/02/15');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH09','Le Ha Vinh','873 Le Hong Phong, Q5, TpHCM','8654763','2003/09/03','2022/01/14');
insert into KHACHHANG (MAKH, HOTEN, DCHI, SODT, NGSINH, NGDK)
values('KH10','Ha Duy Lap','34/34B Nguyen Trai, Q1, TpHCM','8768904','1999/02/05','2022/01/06');

select * from KHACHHANG;

insert into NHANVIEN values('NV01','Nguyen Nhu Nhut','927345678','202/01/14');
insert into NHANVIEN values('NV02','Le Thi Phi Yen','987567390','2022/01/14');
insert into NHANVIEN values('NV03','Nguyen Van Bao','997047382','2022/01/14');
insert into NHANVIEN values('NV04','Ngo Thanh Tuan','913758498','2022/01/14');
insert into NHANVIEN values('NV05','Nguyen Thi Truc Thanh','918590387','2022/01/14');

insert into TAIKHOAN values('TK01', 'admin', 'admin', 2, 'NV01');
insert into TAIKHOAN values('TK02', 'phiyen', '12345', 1, 'NV02');
insert into TAIKHOAN values('TK03', 'vanbao', '12345', 1, 'NV03');
insert into TAIKHOAN values('TK04', 'thanhtuan', '12345', 1, 'NV04');
insert into TAIKHOAN values('TK05', 'tructhanh', '12345', 1, 'NV05');

insert into HOADON (NGHD,MAKH,MANV) values(CURDATE(),'KH01','NV02');

insert into CTHD (SOHD, MASP, SL) values(1,1,2);
insert into CTHD (SOHD, MASP, SL) values(1,2,2);
select * from hoadon;
select * from cthd;






-- tổng giá trị hóa đơn
select   SUM( GIA * SL)   FROM 
SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
WHERE CTHD.SOHD = 1;

-- chi tiết hóa đơn

select  CTHD.MASP, TENSP, GIA, SL, ( GIA * SL) as TONG  FROM 
SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
WHERE CTHD.SOHD = 1




