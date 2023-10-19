create database BanHangThitTuoi3
go
use BanHangThitTuoi3
go
create table GiaSuc(	
	ID uniqueidentifier primary key,
	Ma varchar(10) unique,
	Ten nvarchar(50)
)
insert into GiaSuc values (NEWID(),'GS01',N'Gà')
insert into GiaSuc values (NEWID(),'GS02',N'Bò')
insert into GiaSuc values (NEWID(),'GS03',N'Heo')

create table BoPhanThit(
    ID uniqueidentifier primary key,
	Ten nvarchar(50),
	Ma varchar(10) unique
)
insert into BoPhanThit values (NEWID(),N'Mông','BP01')
insert into BoPhanThit values (NEWID(),N'Đùi','BP02')
insert into BoPhanThit values (NEWID(),N'Cánh','BP03')
insert into BoPhanThit values (NEWID(),N'Bắp','BP05')
insert into BoPhanThit values (NEWID(),N'Ba Chỉ','BP06')

create table DonViTinh(
    ID uniqueidentifier primary key,
	TenDonVi nvarchar(50),
	QuyDoi float
)
insert into DonViTinh values(NEWID(),N'Gram',1)
insert into DonViTinh values(NEWID(),N'Kilogram',1000)

create table LoaiThit(
    ID uniqueidentifier primary key,
    Ma varchar(10) unique,
	IDGiaSuc uniqueidentifier,
	IDBoPhanThit uniqueidentifier,
	IDDonViTinh uniqueidentifier,
	GiaTien float,
	Foreign key (IDGiaSuc) references GiaSuc(ID),
	Foreign key (IDDonViTinh) references DonViTinh(ID),
	Foreign key (IDBoPhanThit) references BoPhanThit(ID)
)
insert into LoaiThit values(NEWID(),'LT01',(Select ID from GiaSuc where Ma = 'GS01'),(Select ID from BoPhanThit where Ma = 'BP01'),(Select ID from DonViTinh where TenDonVi = 'Kilogram' ),80000)
insert into LoaiThit values(NEWID(),'LT02',(Select ID from GiaSuc where Ma = 'GS02'),(Select ID from BoPhanThit where Ma = 'BP02'),(Select ID from DonViTinh where TenDonVi = 'Kilogram' ),250000)
insert into LoaiThit values(NEWID(),'LT03',(Select ID from GiaSuc where Ma = 'GS03'),(Select ID from BoPhanThit where Ma = 'BP03'),(Select ID from DonViTinh where TenDonVi = 'Kilogram' ),140000)

create table GiamGiaTheoHSD(
	ID uniqueidentifier primary key,
	PhanTramHSDConLai float unique,
	PhanTramGiamGia float
)
insert into GiamGiaTheoHSD values(NEWID(),20,50)
insert into GiamGiaTheoHSD values(NEWID(),40,30)
insert into GiamGiaTheoHSD values(NEWID(),50,10)
create table HopThit(
    ID uniqueidentifier primary key,
	Ma varchar(10) unique,
	IDLoaiThit uniqueidentifier,
	Foreign key (IDLoaiThit) references LoaiThit(ID),
	KhoiLuong float,
	IDDonViTinh uniqueidentifier,
	Foreign key (IDDonViTinh) references DonViTinh(ID),
	NSX date,
	HSD date,
)
insert into HopThit values (NEWID(),'HT01',(Select ID from LoaiThit where Ma = 'LT01'),1000,(Select ID from DonViTinh where TenDonVi = 'Kilogram'),'2023-4-1','2023-4-8')
insert into HopThit values (NEWID(),'HT02',(Select ID from LoaiThit where Ma = 'LT02'),1000,(Select ID from DonViTinh where TenDonVi = 'Gram'),'2023-4-30','2023-5-1')
insert into HopThit values (NEWID(),'HT03',(Select ID from LoaiThit where Ma = 'LT03'),1000,(Select ID from DonViTinh where TenDonVi = 'Gram'),'2023-4-11','2023-4-18')

create table HangThanhVien(
	ID uniqueidentifier primary key,
	Ten nvarchar(100),
	SoTienDatHang float,
	PhamTramGiamGiaHD float
)
insert into HangThanhVien values (NEWID(),N'Vàng',2000000,20)
insert into HangThanhVien values (NEWID(),N'Bạc',1000000,10)
insert into HangThanhVien values (NEWID(),N'Kim Cương',5000000,30)

create table ThanhVien(
ID uniqueidentifier primary key,
MaTV varchar(10) unique,
IDHangThanhVien uniqueidentifier,
Foreign key (IDHangThanhVien) references HangThanhVien(ID)
)
insert into ThanhVien values (NEWID(),'TV01',(Select ID from HangThanhVien where Ten = 'Vàng'))
insert into ThanhVien values (NEWID(),'TV02',(Select ID from HangThanhVien where Ten = 'Bạc'))
insert into ThanhVien values (NEWID(),'TV03',(Select ID from HangThanhVien where Ten = 'Kim Cương'))

create table KhachHang(
	ID uniqueidentifier primary key,
	MaKH varchar(10) not null unique,
	HoTen nvarchar(50),
	SDT varchar(12) unique,
	GioiTinh bit,
	DiaChi nvarchar(200),
	NgaySinh date,
	IDThanhVien uniqueidentifier,
	Foreign key (IDThanhVien) references ThanhVien(ID)
)
insert into KhachHang values (NEWID(),'KH01',N'Nguyễn Ngọc Hiếu','0986553564',1,N'Bắc Từ Liêm','2002-2-26',(Select ID from ThanhVien where MaTV = 'TV01'))
insert into KhachHang values (NEWID(),'KH02',N'Hồ Tiến Việt','0986553555',1,N'Đông Anh','2000-6-30',(Select ID from ThanhVien where MaTV = 'TV02'))
insert into KhachHang values (NEWID(),'KH03',N'Hoàng Văn Toàn','0986123456',1,N'Bắc Giang','2002-10-10',(Select ID from ThanhVien where MaTV = 'TV03'))

create table NhanVien(
	Id uniqueidentifier primary key,
	MaNV varchar(10) unique,
	HoTen nvarchar(50),
	SDT varchar(12),
	GioiTinh bit,
	DiaChi nvarchar(100),
	NgaySinh date,
	TrangThai nvarchar(100)
)
insert into NhanVien values (NEWID(),'NV01',N'Nguyễn Khánh Tùng','0312345678',1,N'Bắc Giang','2002-2-20',N'Nghỉ làm')
insert into NhanVien values (NEWID(),'NV02',N'Nguyễn Minh Châu','0975581397',2,N'Hà Đông','1997-05-03',N'Nghỉ làm')
insert into NhanVien values (NEWID(),'NV03',N'Cao Tiến Cường','0123456789',1,N'Hà Nội','2002-8-25',N'Tạm nghỉ')
insert into NhanVien values (NEWID(),'NV04',N'Nguyễn Ngọc Minh Vâu','0312345678',2,N'Hà Nội','1999-1-1',N'Đi làm')
create table ChucVu(
    ID uniqueidentifier primary key,
	Ten nvarchar(100),
	Ma varchar(10) unique
)
insert into ChucVu values (NEWID(),N'Quản Lý','CV01')
insert into ChucVu values (NEWID(),N'Nhân Viên','CV02')
create table TaiKhoanDangNhap(
    ID uniqueidentifier primary key,
	TenTK varchar(10) unique,
	MatKhau varchar(20),
	IDChucVu uniqueidentifier,
	IDNhanVien uniqueidentifier,
	foreign key (IDChucVU) references ChucVu(ID),
	foreign key (IDNhanVien) references NhanVien(ID)
)
insert into TaiKhoanDangNhap values (NEWID(),'nhanvien01','hieu123',(Select ID from ChucVu where Ma = 'CV01'),(Select ID from NhanVien where MaNV = 'NV01'))
insert into TaiKhoanDangNhap values (NEWID(),'nhanvien02','toan123',(Select ID from ChucVu where Ma = 'CV02'),(Select ID from NhanVien where MaNV = 'NV02'))
insert into TaiKhoanDangNhap values (NEWID(),'quanly','viet123',(Select ID from ChucVu where Ma = 'CV01'),(Select ID from NhanVien where MaNV = 'NV03'))
select * from TaiKhoanDangNhap
create table HoaDon(
	ID uniqueidentifier primary key,
	NgayTao date,
	NgayThanhToan date,
	IDTaiKhoanDN uniqueidentifier,
	IDThanhVien uniqueidentifier,
	TinhTrang nvarchar(50),
	foreign key (IDThanhVien) references ThanhVien(ID),
	foreign key (IDTaiKhoanDN) references TaiKhoanDangNhap(ID)
)
insert into HoaDon values (NEWID(),'2023-4-11','2023-4-12',(Select ID from TaiKhoanDangNhap where TenTK = 'nhanvien01'),(Select ID from ThanhVien where MaTV = 'TV01'),N'Đã Thanh Toán')
insert into HoaDon values (NEWID(),'2023-4-20','2023-4-21',(Select ID from TaiKhoanDangNhap where TenTK = 'nhanvien02'),(Select ID from ThanhVien where MaTV = 'TV02'),N'Đã Thanh Toán')
insert into HoaDon values (NEWID(),'2023-4-15','2023-4-16',(Select ID from TaiKhoanDangNhap where TenTK = 'quanly'),(Select ID from ThanhVien where MaTV = 'TV03'),N'Đã Thanh Toán')

create table HoaDonChiTiet(
	ID uniqueidentifier primary key,
	IDHopThit uniqueidentifier,
	IDGiamGiaTheoHSD uniqueidentifier,
	IDHoaDon uniqueidentifier,
	foreign key (IDHopThit) references HopThit(ID),
	foreign key (IDGiamGiaTheoHSD) references GiamGiaTheoHSD(ID),
	foreign key (IDHoaDon) references HoaDon(ID)
)
insert into HoaDonChiTiet values (NEWID(),(Select ID from HopThit where Ma = 'HT01'),(Select ID from GiamGiaTheoHSD where PhanTramGiamGia = '50'),(Select ID from HoaDon where NgayTao = '2023-4-11'))
insert into HoaDonChiTiet values (NEWID(),(Select ID from HopThit where Ma = 'HT02'),(Select ID from GiamGiaTheoHSD where PhanTramGiamGia = '30'),(Select ID from HoaDon where NgayTao = '2023-4-20'))
insert into HoaDonChiTiet values (NEWID(),(Select ID from HopThit where Ma = 'HT03'),(Select ID from GiamGiaTheoHSD where PhanTramGiamGia = '10'),(Select ID from HoaDon where NgayTao = '2023-4-15'))
select * from GiaSuc
select * from BoPhanThit
select * from DonViTinh
select * from LoaiThit
select * from GiamGiaTheoHSD
select * from HopThit
	select * from HangThanhVien
select * from ThanhVien
select * from KhachHang
select * from NhanVien
select * from ChucVu
select * from TaiKhoanDangNhap
select * from HoaDon
select * from HoaDonChiTiet
Select * from HoaDonChiTiet where IDHoaDon = '3571D1CA-6088-41A0-81CA-9BC66CB73BCB'

