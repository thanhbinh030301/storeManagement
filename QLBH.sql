CREATE DATABASE QLBH
USE QLBH
-- KHACHANG
CREATE TABLE KHACHHANG(
	MAKH	char(4) not null,	
	HOTEN	varchar(40),
	DCHI	varchar(50),
	SODT	varchar(20),
	NGSINH	smalldatetime,
	NGDK	smalldatetime,
	DOANHSO	money,
	constraint pk_kh primary key(MAKH)
)
---------------------------------------------
-- NHANVIEN
CREATE TABLE NHANVIEN(
	MANV	char(4) not null,	
	HOTEN	varchar(40),
	SODT	varchar(20),
	NGVL	smalldatetime	
	constraint pk_nv primary key(MANV)
)
---------------------------------------------
-- SANPHAM
CREATE TABLE SANPHAM(
	MASP	char(4) not null,
	TENSP	varchar(40),
	DVT	varchar(20),
	NUOCSX	varchar(40),
	GIA	money,
	SOLUONG INT,
	constraint pk_sp primary key(MASP)	
)
---------------------------------------------
-- HOADON
CREATE TABLE HOADON(
	SOHD	int not null,
	NGHD 	smalldatetime,
	MAKH 	char(4),
	MANV 	char(4),
	TRIGIA	money,
	constraint pk_hd primary key(SOHD)
)
---------------------------------------------
-- CTHD
   CREATE TABLE CTHD(
	SOHD	int,
	MASP	char(4),
	SL	int,
	constraint pk_cthd primary key(SOHD,MASP)
)

-- Khoa ngoai cho bang HOADON
ALTER TABLE HOADON ADD CONSTRAINT fk01_HD FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH)
ALTER TABLE HOADON ADD CONSTRAINT fk02_HD FOREIGN KEY(MANV) REFERENCES NHANVIEN(MANV)
-- Khoa ngoai cho bang CTHD
ALTER TABLE CTHD ADD CONSTRAINT fk01_CTHD FOREIGN KEY(SOHD) REFERENCES HOADON(SOHD)
ALTER TABLE CTHD ADD CONSTRAINT fk02_CTHD FOREIGN KEY(MASP) REFERENCES SANPHAM(MASP)

set dateformat dmy

insert into SANPHAM values('BC01','But chi','cay','Singapore',3000,100)
insert into SANPHAM values('BC02','But chi','cay','Singapore',5000,100)
insert into SANPHAM values('BC03','But chi','cay','Viet Nam',3500,100)
insert into SANPHAM values('BC04','But chi','hop','Viet Nam',30000,100)
insert into SANPHAM values('BB01','But bi','cay','Viet Nam',5000,100)
insert into SANPHAM values('BB02','But bi','cay','Trung Quoc',7000,100)
insert into SANPHAM values('BB03','But bi','hop','Thai Lan',100000,100)
insert into SANPHAM values('TV01','Tap 100 giay mong','quyen','Trung Quoc',2500,100)
insert into SANPHAM values('TV02','Tap 200 giay mong','quyen','Trung Quoc',4500,100)
insert into SANPHAM values('TV03','Tap 100 giay tot','quyen','Viet Nam',3000,100)
insert into SANPHAM values('TV04','Tap 200 giay tot','quyen','Viet Nam',5500,100)
insert into SANPHAM values('TV05','Tap 100 trang','chuc','Viet Nam',23000,100)
insert into SANPHAM values('TV06','Tap 200 trang','chuc','Viet Nam',53000,100)
insert into SANPHAM values('TV07','Tap 100 trang','chuc','Trung Quoc',34000,100)
insert into SANPHAM values('ST01','So tay 500 trang','quyen','Trung Quoc',40000,100)
insert into SANPHAM values('ST02','So tay loai 1','quyen','Viet Nam',55000,100)
insert into SANPHAM values('ST03','So tay loai 2','quyen','Viet Nam',51000,100)
insert into SANPHAM values('ST04','So tay','quyen','Thai Lan',55000,100)
insert into SANPHAM values('ST05','So tay mong','quyen','Thai Lan',20000,100)
insert into SANPHAM values('ST06','Phan viet bang','hop','Viet Nam',5000,100)
insert into SANPHAM values('ST07','Phan khong bui','hop','Viet Nam',7000,100)
insert into SANPHAM values('ST08','Bong bang','cai','Viet Nam',1000,100)
insert into SANPHAM values('ST09','But long','cay','Viet Nam',5000,100)
insert into SANPHAM values('ST10','But long','cay','Trung Quoc',7000,100)

--The khach hang

insert into KHACHHANG values('KH01','Nguyen Van A','731 Tran Hung Dao, Q5, TpHCM','8823451','22/10/1999','22/07/2020',13060000)
insert into KHACHHANG values('KH02','Tran Ngoc Han','23/5 Nguyen Trai, Q5, TpHCM','908256478','03/04/1998','30/07/2021',280000)
insert into KHACHHANG values('KH03','Tran Ngoc Linh','45 Nguyen Canh Chan, Q1, TpHCM','938776266','12/06/2001','08/05/2020',3860000)
insert into KHACHHANG values('KH04','Tran Minh Long','50/34 Le Dai Hanh, Q10, TpHCM','917325476','09/03/2001','10/02/2022',250000)
insert into KHACHHANG values('KH05','Le Nhat Minh','34 Truong Dinh, Q3, TpHCM','8246108','10/03/2000','28/10/2021',21000)
insert into KHACHHANG values('KH06','Le Hoai Thuong','227 Nguyen Van Cu, Q5, TpHCM','8631738','31/12/1999','24/11/2021',915000)
insert into KHACHHANG values('KH07','Nguyen Van Tam','32/3 Tran Binh Trong, Q5, TpHCM','916783565','06/04/2002','12/01/2022',12500)
insert into KHACHHANG values('KH08','Phan Thi Thanh','45/2 An Duong Vuong, Q5, TpHCM','938435756','10/01/2001','13/12/2021',365000)
insert into KHACHHANG values('KH09','Le Ha Vinh','873 Le Hong Phong, Q5, TpHCM','8654763','03/09/2003','14/01/2022',70000)
insert into KHACHHANG values('KH10','Ha Duy Lap','34/34B Nguyen Trai, Q1, TpHCM','8768904','02/05/1999','16/01/2022',67500)


insert into NHANVIEN values('NV01','Nguyen Nhu Nhut','927345678','13/04/2006')
insert into NHANVIEN values('NV02','Le Thi Phi Yen','987567390','21/04/2006')
insert into NHANVIEN values('NV03','Nguyen Van B','997047382','27/04/2006')
insert into NHANVIEN values('NV04','Ngo Thanh Tuan','913758498','24/06/2006')
insert into NHANVIEN values('NV05','Nguyen Thi Truc Thanh','918590387','20/07/2006')


insert into HOADON values(1001,'12/01/2022','KH01','NV01',320000)
insert into HOADON values(1002,'12/01/2022','KH01','NV02',840000)
insert into HOADON values(1003,'12/01/2022','KH02','NV01',100000)
insert into HOADON values(1004,'12/01/2022','KH02','NV01',180000)
insert into HOADON values(1005,'12/01/2022','KH01','NV02',3800000)
insert into HOADON values(1006,'12/01/2022','KH01','NV03',2430000)
insert into HOADON values(1007,'12/01/2022','KH03','NV03',510000)
insert into HOADON values(1008,'12/01/2022','KH01','NV03',440000)
insert into HOADON values(1009,'12/01/2022','KH03','NV04',200000)
insert into HOADON values(1010,'12/01/2022','KH01','NV01',5200000)
insert into HOADON values(1011,'12/01/2022','KH04','NV03',250000)
insert into HOADON values(1012,'12/01/2022','KH05','NV03',21000)
insert into HOADON values(1013,'12/01/2022','KH06','NV01',5000)
insert into HOADON values(1014,'12/01/2022','KH03','NV02',3150000)
insert into HOADON values(1015,'12/01/2022','KH06','NV01',910000)
insert into HOADON values(1016,'12/01/2022','KH07','NV02',12500)
insert into HOADON values(1017,'12/01/2022','KH08','NV03',35000)
insert into HOADON values(1018,'13/01/2007','KH08','NV03',330000)
insert into HOADON values(1019,'12/01/2022','KH01','NV03',30000)
insert into HOADON values(1020,'12/01/2022','KH09','NV04',70000)
insert into HOADON values(1021,'12/01/2022','KH10','NV03',67500)
insert into HOADON values(1022,'12/01/2022',Null,'NV03',7000)
insert into HOADON values(1023,'12/01/2022',Null,'NV01',330000)


insert into CTHD values(1001,'TV02',10)
insert into CTHD values(1001,'ST01',5)
insert into CTHD values(1001,'BC01',5)
insert into CTHD values(1001,'BC02',10)
insert into CTHD values(1001,'ST08',10)
insert into CTHD values(1002,'BC04',20)
insert into CTHD values(1002,'BB01',20)
insert into CTHD values(1002,'BB02',20)
insert into CTHD values(1003,'BB03',10)
insert into CTHD values(1004,'TV01',20)
insert into CTHD values(1004,'TV02',10)
insert into CTHD values(1004,'TV03',10)
insert into CTHD values(1004,'TV04',10)
insert into CTHD values(1005,'TV05',50)
insert into CTHD values(1005,'TV06',50)
insert into CTHD values(1006,'TV07',20)
insert into CTHD values(1006,'ST01',30)
insert into CTHD values(1006,'ST02',10)
insert into CTHD values(1007,'ST03',10)
insert into CTHD values(1008,'ST04',8)
insert into CTHD values(1009,'ST05',10)
insert into CTHD values(1010,'TV07',50)
insert into CTHD values(1010,'ST07',50)
insert into CTHD values(1010,'ST08',100)
insert into CTHD values(1010,'ST04',50)
insert into CTHD values(1010,'TV03',100)
insert into CTHD values(1011,'ST06',50)
insert into CTHD values(1012,'ST07',3)
insert into CTHD values(1013,'ST08',5)
insert into CTHD values(1014,'BC02',80)
insert into CTHD values(1014,'BB02',100)
insert into CTHD values(1014,'BC04',60)
insert into CTHD values(1014,'BB01',50)
insert into CTHD values(1015,'BB02',30)
insert into CTHD values(1015,'BB03',7)
insert into CTHD values(1016,'TV01',5)
insert into CTHD values(1017,'TV02',1)
insert into CTHD values(1017,'TV03',1)
insert into CTHD values(1017,'TV04',5)
insert into CTHD values(1018,'ST04',6)
insert into CTHD values(1019,'ST05',1)
insert into CTHD values(1019,'ST06',2)
insert into CTHD values(1020,'ST07',10)
insert into CTHD values(1021,'ST08',5)
insert into CTHD values(1021,'TV01',7)
insert into CTHD values(1021,'TV02',10)
insert into CTHD values(1022,'ST07',1)
insert into CTHD values(1023,'ST04',6)



-- tổng giá trị hóa đơn
select   SUM( GIA * SL)   FROM 
SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
WHERE CTHD.SOHD = 1001

-- chi tiết hóa đơn

select  CTHD.MASP, TENSP, GIA, SL, TONG =( GIA * SL)   FROM 
SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
WHERE CTHD.SOHD = 1001

--Trigger tinh gia tri hoa don


CREATE TRIGGER tr_them_cthd 
ON CTHD
AFTER INSERT
AS 
BEGIN
	DECLARE @TRIGIA  AS MONEY;
	DECLARE @SOHD INT
	SELECT @SOHD=SOHD
	FROM  INSERTED

	select @TRIGIA = SUM( GIA * SL)   FROM 
	SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
	WHERE CTHD.SOHD = @SOHD

	UPDATE HOADON SET TRIGIA = @TRIGIA WHERE SOHD = @SOHD
END

CREATE TRIGGER tr_xoa_cthd 
ON CTHD
AFTER DELETE
AS 
BEGIN
	DECLARE @TRIGIA  AS MONEY;
	DECLARE @SOHD INT
	SELECT @SOHD=SOHD
	FROM  DELETED

	select @TRIGIA = SUM( GIA * SL)   FROM 
	SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
	WHERE CTHD.SOHD = @SOHD

	UPDATE HOADON SET TRIGIA = @TRIGIA WHERE SOHD = @SOHD
END

CREATE TRIGGER tr_sua_cthd 
ON CTHD
AFTER update
AS 
BEGIN
	DECLARE @TRIGIA  AS MONEY;
	DECLARE @SOHD INT
	SELECT @SOHD=SOHD
	FROM  DELETED

	select @TRIGIA = SUM( GIA * SL)   FROM 
	SANPHAM INNER JOIN  CTHD  ON SANPHAM.MASP = CTHD.MASP 
	WHERE CTHD.SOHD = @SOHD

	UPDATE HOADON SET TRIGIA = @TRIGIA WHERE SOHD = @SOHD
END

--In ra danh sách các sản phẩm (MASP,TENSP) có mã sản phẩm bắt đầu là “B” và kết thúc là “01”.

SELECT MASP, TENSP
FROM SANPHAM
WHERE MASP LIKE'B%01'

