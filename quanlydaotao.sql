-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th3 30, 2025 lúc 06:29 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlydaotao`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_cotdiem`
--

CREATE TABLE `ctdt_cotdiem` (
  `id` int(11) NOT NULL,
  `decuong_id` int(11) NOT NULL,
  `ten_cot_diem` varchar(100) NOT NULL,
  `ty_le_phan_tram` decimal(5,2) NOT NULL,
  `hinh_thuc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_cotdiem`
--

INSERT INTO `ctdt_cotdiem` (`id`, `decuong_id`, `ten_cot_diem`, `ty_le_phan_tram`, `hinh_thuc`) VALUES
(1, 1, 'Điểm chuyên cần', 10.00, 'Điểm danh'),
(2, 1, 'Điểm thảo luận', 20.00, 'Thảo luận nhóm'),
(3, 1, 'Điểm kiểm tra', 20.00, 'Trắc nghiệm'),
(4, 1, 'Điểm thi cuối kỳ', 50.00, 'Tự luận'),
(5, 2, 'Điểm chuyên cần', 10.00, 'Điểm danh'),
(6, 2, 'Điểm bài tập', 20.00, 'Bài tập về nhà'),
(7, 2, 'Điểm kiểm tra', 20.00, 'Trắc nghiệm + Tự luận'),
(8, 2, 'Điểm thi thực hành', 50.00, 'Bài tập lớn'),
(9, 3, 'Điểm chuyên cần', 10.00, 'Điểm danh'),
(10, 3, 'Điểm bài tập', 15.00, 'Bài tập về nhà'),
(11, 3, 'Điểm kiểm tra', 15.00, 'Trắc nghiệm'),
(12, 3, 'Điểm đồ án', 20.00, 'Đồ án nhóm'),
(13, 3, 'Điểm thi thực hành', 40.00, 'Thực hành cá nhân'),
(14, 4, 'Điểm chuyên cần', 10.00, 'Điểm danh'),
(15, 4, 'Điểm thảo luận', 10.00, 'Thảo luận nhóm'),
(16, 4, 'Điểm kiểm tra', 20.00, 'Trắc nghiệm'),
(17, 4, 'Điểm đồ án', 30.00, 'Đồ án nhóm'),
(18, 4, 'Điểm thi cuối kỳ', 30.00, 'Tự luận');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_decuongchitiet`
--

CREATE TABLE `ctdt_decuongchitiet` (
  `id` int(11) NOT NULL,
  `hoc_phan_id` int(11) NOT NULL,
  `muc_tieu` text DEFAULT NULL,
  `noi_dung` text DEFAULT NULL,
  `phuong_phap_giang_day` text DEFAULT NULL,
  `phuong_phap_danh_gia` text DEFAULT NULL,
  `tai_lieu_tham_khao` text DEFAULT NULL,
  `trang_thai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_decuongchitiet`
--

INSERT INTO `ctdt_decuongchitiet` (`id`, `hoc_phan_id`, `muc_tieu`, `noi_dung`, `phuong_phap_giang_day`, `phuong_phap_danh_gia`, `tai_lieu_tham_khao`, `trang_thai`) VALUES
(1, 1, 'Trang bị kiến thức cơ bản về triết học Mác-Lênin', 'Chương 1: Khái luận về Triết học và vai trò của Triết học\nChương 2: Chủ nghĩa duy vật biện chứng\nChương 3: Chủ nghĩa duy vật lịch sử', 'Thuyết giảng, thảo luận nhóm', 'Chuyên cần: 10%, Thảo luận: 20%, Kiểm tra giữa kỳ: 20%, Thi cuối kỳ: 50%', 'Giáo trình Triết học Mác-Lênin, NXB Chính trị Quốc gia, 2021', 'Đã duyệt'),
(2, 9, 'Trang bị kiến thức cơ bản về lập trình và kỹ năng giải quyết vấn đề', 'Chương 1: Giới thiệu về lập trình\nChương 2: Biến và kiểu dữ liệu\nChương 3: Cấu trúc điều khiển\nChương 4: Hàm và module\nChương 5: Mảng và chuỗi', 'Thuyết giảng, thực hành trên máy tính, bài tập lớn', 'Chuyên cần: 10%, Bài tập: 20%, Kiểm tra giữa kỳ: 20%, Thi thực hành: 50%', 'Introduction to Programming with C++, Liang Y. Daniel, Pearson, 2019', 'Đã duyệt'),
(3, 10, 'Trang bị kiến thức về lập trình hướng đối tượng và các nguyên tắc thiết kế', 'Chương 1: Tổng quan về lập trình hướng đối tượng\nChương 2: Lớp và đối tượng\nChương 3: Tính kế thừa\nChương 4: Tính đa hình\nChương 5: Mẫu thiết kế', 'Thuyết giảng, thực hành trên máy tính, bài tập lớn, đồ án môn học', 'Chuyên cần: 10%, Bài tập: 15%, Kiểm tra giữa kỳ: 15%, Đồ án: 20%, Thi thực hành: 40%', 'Object-Oriented Programming in Java, Barnes D.J., Kölling M., Pearson, 2020', 'Đã duyệt'),
(4, 15, 'Trang bị kiến thức về quy trình phát triển phần mềm và kỹ năng làm việc nhóm', 'Chương 1: Giới thiệu về Công nghệ phần mềm\nChương 2: Quy trình phát triển phần mềm\nChương 3: Phân tích yêu cầu\nChương 4: Thiết kế phần mềm\nChương 5: Kiểm thử phần mềm\nChương 6: Bảo trì và tiến hóa phần mềm', 'Thuyết giảng, thảo luận nhóm, đồ án', 'Chuyên cần: 10%, Thảo luận: 10%, Kiểm tra: 20%, Đồ án: 30%, Thi cuối kỳ: 30%', 'Software Engineering, Ian Sommerville, Pearson, 2021', 'Đã duyệt'),
(5, 25, 'Trang bị kiến thức và kỹ năng thực hiện đề tài tốt nghiệp', 'Sinh viên thực hiện một đề tài nghiên cứu hoặc phát triển sản phẩm dưới sự hướng dẫn của giảng viên', 'Hướng dẫn cá nhân, seminar, báo cáo tiến độ', 'Báo cáo tiến độ: 30%, Sản phẩm: 30%, Báo cáo tốt nghiệp: 40%', 'Tùy theo đề tài cụ thể', 'Đã duyệt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_giangvien`
--

CREATE TABLE `ctdt_giangvien` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ma_gv` varchar(50) NOT NULL,
  `ho_ten` varchar(100) NOT NULL,
  `bo_mon` varchar(100) DEFAULT NULL,
  `khoa` varchar(100) DEFAULT NULL,
  `trinh_do` varchar(50) DEFAULT NULL,
  `chuyen_mon` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_giangvien`
--

INSERT INTO `ctdt_giangvien` (`id`, `user_id`, `ma_gv`, `ho_ten`, `bo_mon`, `khoa`, `trinh_do`, `chuyen_mon`, `trang_thai`) VALUES
(1, 3, 'GV001', 'Trần Thị Phương', 'Công nghệ phần mềm', 'Công nghệ thông tin', 'Tiến sĩ', 'Công nghệ phần mềm, Kiểm thử phần mềm', 'Đang làm việc'),
(2, 4, 'GV002', 'Lê Thanh Hùng', 'Khoa học máy tính', 'Công nghệ thông tin', 'Tiến sĩ', 'Trí tuệ nhân tạo, Machine Learning', 'Đang làm việc'),
(3, 5, 'GV003', 'Phạm Tuấn Minh', 'Hệ thống thông tin', 'Công nghệ thông tin', 'Thạc sĩ', 'Cơ sở dữ liệu, Data Mining', 'Đang làm việc'),
(4, 6, 'GV004', 'Nguyễn Thị Lan', 'Mạng máy tính', 'Công nghệ thông tin', 'Tiến sĩ', 'An toàn mạng, Điện toán đám mây', 'Đang làm việc'),
(5, 7, 'GV005', 'Trần Văn Bình', 'Công nghệ phần mềm', 'Công nghệ thông tin', 'Thạc sĩ', 'Phát triển Web, Mobile Computing', 'Đang làm việc'),
(6, 8, 'GV006', 'Võ Thị Linh', 'Khoa học máy tính', 'Công nghệ thông tin', 'Thạc sĩ', 'Xử lý ngôn ngữ tự nhiên, Thị giác máy tính', 'Đang làm việc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_hocphan`
--

CREATE TABLE `ctdt_hocphan` (
  `id` int(11) NOT NULL,
  `ma_hp` varchar(50) NOT NULL,
  `ten_hp` varchar(255) NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  `so_tiet_ly_thuyet` int(11) DEFAULT NULL,
  `so_tiet_thuc_hanh` int(11) DEFAULT NULL,
  `nhom_id` int(11) DEFAULT NULL,
  `loai_hp` varchar(50) DEFAULT NULL,
  `hoc_phan_tien_quyet` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_hocphan`
--

INSERT INTO `ctdt_hocphan` (`id`, `ma_hp`, `ten_hp`, `so_tin_chi`, `so_tiet_ly_thuyet`, `so_tiet_thuc_hanh`, `nhom_id`, `loai_hp`, `hoc_phan_tien_quyet`) VALUES
(1, 'CB001', 'Triết học Mác - Lênin', 3, 45, 0, 1, 'Bắt buộc', NULL),
(2, 'CB002', 'Kinh tế chính trị Mác - Lênin', 2, 30, 0, 1, 'Bắt buộc', 'CB001'),
(3, 'CB003', 'Tư tưởng Hồ Chí Minh', 2, 30, 0, 1, 'Bắt buộc', 'CB001'),
(4, 'CB004', 'Tiếng Anh 1', 4, 45, 30, 1, 'Bắt buộc', NULL),
(5, 'CB005', 'Tiếng Anh 2', 4, 45, 30, 1, 'Bắt buộc', 'CB004'),
(6, 'CB006', 'Giải tích 1', 3, 45, 0, 1, 'Bắt buộc', NULL),
(7, 'CB007', 'Đại số tuyến tính', 3, 45, 0, 1, 'Bắt buộc', NULL),
(8, 'CB008', 'Xác suất thống kê', 3, 45, 0, 1, 'Bắt buộc', 'CB006'),
(9, 'IT001', 'Nhập môn lập trình', 4, 30, 60, 2, 'Bắt buộc', NULL),
(10, 'IT002', 'Lập trình hướng đối tượng', 4, 30, 60, 2, 'Bắt buộc', 'IT001'),
(11, 'IT003', 'Cấu trúc dữ liệu và giải thuật', 4, 30, 60, 2, 'Bắt buộc', 'IT001'),
(12, 'IT004', 'Cơ sở dữ liệu', 4, 45, 30, 2, 'Bắt buộc', NULL),
(13, 'IT005', 'Mạng máy tính', 4, 45, 30, 2, 'Bắt buộc', NULL),
(14, 'IT006', 'Hệ điều hành', 4, 45, 30, 2, 'Bắt buộc', NULL),
(15, 'CN001', 'Công nghệ phần mềm', 4, 45, 30, 3, 'Bắt buộc', 'IT002'),
(16, 'CN002', 'Trí tuệ nhân tạo', 4, 45, 30, 3, 'Bắt buộc', 'IT003'),
(17, 'CN003', 'Phát triển ứng dụng web', 4, 30, 60, 3, 'Bắt buộc', 'IT002'),
(18, 'CN004', 'Phát triển ứng dụng di động', 4, 30, 60, 3, 'Bắt buộc', 'IT002'),
(19, 'CN005', 'An toàn và bảo mật thông tin', 4, 45, 30, 3, 'Bắt buộc', 'IT005'),
(20, 'CN006', 'Điện toán đám mây', 3, 30, 30, 3, 'Tự chọn', 'IT005'),
(21, 'CN007', 'Phân tích dữ liệu lớn', 3, 30, 30, 3, 'Tự chọn', 'IT004'),
(22, 'CN008', 'Blockchain và ứng dụng', 3, 30, 30, 3, 'Tự chọn', NULL),
(23, 'CN009', 'Thị giác máy tính', 3, 30, 30, 3, 'Tự chọn', 'CN002'),
(24, 'CN010', 'Xử lý ngôn ngữ tự nhiên', 3, 30, 30, 3, 'Tự chọn', 'CN002'),
(25, 'TN001', 'Thực tập tốt nghiệp', 5, 0, 150, 4, 'Bắt buộc', NULL),
(26, 'TN002', 'Khóa luận tốt nghiệp', 10, 0, 300, 4, 'Bắt buộc', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_kehoachdayhoc`
--

CREATE TABLE `ctdt_kehoachdayhoc` (
  `id` int(11) NOT NULL,
  `ctdt_id` int(11) NOT NULL,
  `hoc_phan_id` int(11) NOT NULL,
  `hoc_ky` int(11) NOT NULL,
  `nam_hoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_kehoachdayhoc`
--

INSERT INTO `ctdt_kehoachdayhoc` (`id`, `ctdt_id`, `hoc_phan_id`, `hoc_ky`, `nam_hoc`) VALUES
(1, 1, 1, 1, 2023),
(2, 1, 4, 1, 2023),
(3, 1, 6, 1, 2023),
(4, 1, 7, 1, 2023),
(5, 1, 5, 2, 2023),
(6, 1, 2, 2, 2023),
(7, 1, 8, 2, 2023),
(8, 1, 9, 2, 2023),
(9, 1, 3, 3, 2024),
(10, 1, 10, 3, 2024),
(11, 1, 11, 3, 2024),
(12, 1, 12, 3, 2024),
(13, 1, 13, 4, 2024),
(14, 1, 14, 4, 2024),
(15, 1, 15, 5, 2025),
(16, 1, 16, 5, 2025),
(17, 1, 17, 5, 2025),
(18, 1, 18, 6, 2025),
(19, 1, 19, 6, 2025),
(20, 1, 20, 6, 2025),
(21, 1, 21, 6, 2025),
(22, 1, 25, 8, 2026),
(23, 1, 26, 8, 2026);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_kehoachmonhom`
--

CREATE TABLE `ctdt_kehoachmonhom` (
  `id` int(11) NOT NULL,
  `ma_nhom` varchar(20) NOT NULL,
  `hoc_phan_id` int(11) NOT NULL,
  `nam_hoc` varchar(20) NOT NULL,
  `hoc_ky` int(11) NOT NULL,
  `so_luong_sv` int(11) DEFAULT NULL,
  `thoi_gian_bat_dau` date DEFAULT NULL,
  `thoi_gian_ket_thuc` date DEFAULT NULL,
  `trang_thai` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_kehoachmonhom`
--

INSERT INTO `ctdt_kehoachmonhom` (`id`, `ma_nhom`, `hoc_phan_id`, `nam_hoc`, `hoc_ky`, `so_luong_sv`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `trang_thai`) VALUES
(1, 'CB001.01', 1, '2023-2024', 1, 60, '2023-08-15', '2023-12-31', 'Đã kết thúc'),
(2, 'CB001.02', 1, '2023-2024', 1, 60, '2023-08-15', '2023-12-31', 'Đã kết thúc'),
(3, 'CB004.01', 4, '2023-2024', 1, 40, '2023-08-15', '2023-12-31', 'Đã kết thúc'),
(4, 'CB004.02', 4, '2023-2024', 1, 40, '2023-08-15', '2023-12-31', 'Đã kết thúc'),
(5, 'CB004.03', 4, '2023-2024', 1, 40, '2023-08-15', '2023-12-31', 'Đã kết thúc'),
(6, 'IT001.01', 9, '2023-2024', 2, 35, '2024-01-15', '2024-05-31', 'Đã kết thúc'),
(7, 'IT001.02', 9, '2023-2024', 2, 35, '2024-01-15', '2024-05-31', 'Đã kết thúc'),
(8, 'IT002.01', 10, '2024-2025', 1, 35, '2024-08-15', '2024-12-31', 'Đang diễn ra'),
(9, 'IT002.02', 10, '2024-2025', 1, 35, '2024-08-15', '2024-12-31', 'Đang diễn ra'),
(10, 'CN001.01', 15, '2025-2026', 1, 30, '2025-08-15', '2025-12-31', 'Chưa mở');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_khungchuongtrinh`
--

CREATE TABLE `ctdt_khungchuongtrinh` (
  `id` int(11) NOT NULL,
  `ctdt_id` int(11) NOT NULL,
  `ma_nhom` varchar(50) NOT NULL,
  `ten_nhom` varchar(255) NOT NULL,
  `so_tin_chi_toi_thieu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_khungchuongtrinh`
--

INSERT INTO `ctdt_khungchuongtrinh` (`id`, `ctdt_id`, `ma_nhom`, `ten_nhom`, `so_tin_chi_toi_thieu`) VALUES
(1, 1, 'GDDC', 'Khối kiến thức giáo dục đại cương', 45),
(2, 1, 'CSN', 'Khối kiến thức cơ sở ngành', 30),
(3, 1, 'CN', 'Khối kiến thức chuyên ngành', 55),
(4, 1, 'TN', 'Khối kiến thức tốt nghiệp', 15),
(5, 2, 'GDDC', 'Khối kiến thức giáo dục đại cương', 45),
(6, 2, 'CSN', 'Khối kiến thức cơ sở ngành', 34),
(7, 2, 'CN', 'Khối kiến thức chuyên ngành', 50),
(8, 2, 'TN', 'Khối kiến thức tốt nghiệp', 16),
(9, 3, 'GDDC', 'Khối kiến thức giáo dục đại cương', 45),
(10, 3, 'CSN', 'Khối kiến thức cơ sở ngành', 32),
(11, 3, 'CN', 'Khối kiến thức chuyên ngành', 52),
(12, 3, 'TN', 'Khối kiến thức tốt nghiệp', 16);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_khungchuongtrinh_nhomkienthuc`
--

CREATE TABLE `ctdt_khungchuongtrinh_nhomkienthuc` (
  `id` int(11) NOT NULL,
  `id_khungchuongtrinh` int(11) NOT NULL,
  `id_manhom` int(11) NOT NULL,
  `sotinchibatbuoc` int(11) DEFAULT NULL,
  `sotinchituchon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_khungchuongtrinh_nhomkienthuc`
--

INSERT INTO `ctdt_khungchuongtrinh_nhomkienthuc` (`id`, `id_khungchuongtrinh`, `id_manhom`, `sotinchibatbuoc`, `sotinchituchon`) VALUES
(1, 1, 1, 40, 5),
(2, 1, 3, 25, 5),
(3, 1, 4, 45, 10),
(4, 1, 6, 10, 5),
(5, 2, 1, 40, 5),
(6, 2, 3, 30, 4),
(7, 2, 4, 40, 10),
(8, 2, 6, 10, 6),
(9, 3, 1, 40, 5),
(10, 3, 3, 27, 5),
(11, 3, 4, 42, 10),
(12, 3, 6, 10, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_nhomkienthuc`
--

CREATE TABLE `ctdt_nhomkienthuc` (
  `id` int(11) NOT NULL,
  `manhom` varchar(50) NOT NULL,
  `ten_nhom` varchar(255) NOT NULL,
  `trangthai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_nhomkienthuc`
--

INSERT INTO `ctdt_nhomkienthuc` (`id`, `manhom`, `ten_nhom`, `trangthai`) VALUES
(1, 'GDDC', 'Giáo dục đại cương', 'active'),
(2, 'CSNN', 'Cơ sở nhóm ngành', 'active'),
(3, 'CSN', 'Cơ sở ngành', 'active'),
(4, 'CN', 'Chuyên ngành', 'active'),
(5, 'TC', 'Tự chọn', 'active'),
(6, 'TN', 'Tốt nghiệp', 'active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_phanconggiangday`
--

CREATE TABLE `ctdt_phanconggiangday` (
  `id` int(11) NOT NULL,
  `nhom_id` int(11) NOT NULL,
  `giang_vien_id` int(11) NOT NULL,
  `vai_tro` varchar(50) DEFAULT NULL,
  `so_tiet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_phanconggiangday`
--

INSERT INTO `ctdt_phanconggiangday` (`id`, `nhom_id`, `giang_vien_id`, `vai_tro`, `so_tiet`) VALUES
(1, 1, 1, 'Phụ trách', 45),
(2, 2, 2, 'Phụ trách', 45),
(3, 3, 4, 'Phụ trách', 75),
(4, 4, 4, 'Phụ trách', 75),
(5, 5, 6, 'Phụ trách', 75),
(6, 6, 3, 'Phụ trách', 90),
(7, 7, 3, 'Phụ trách', 90),
(8, 8, 5, 'Phụ trách', 90),
(9, 9, 5, 'Phụ trách', 90),
(10, 10, 1, 'Phụ trách', 75),
(11, 6, 1, 'Trợ giảng', 30),
(12, 7, 1, 'Trợ giảng', 30);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_thongtinchung`
--

CREATE TABLE `ctdt_thongtinchung` (
  `id` int(11) NOT NULL,
  `ma_ctdt` varchar(50) NOT NULL,
  `ten_ctdt` varchar(255) NOT NULL,
  `nganh` varchar(100) DEFAULT NULL,
  `ma_nganh` varchar(50) DEFAULT NULL,
  `khoa_quan_ly` varchar(100) DEFAULT NULL,
  `he_dao_tao` varchar(50) DEFAULT NULL,
  `trinh_do` varchar(50) DEFAULT NULL,
  `tong_tin_chi` int(11) DEFAULT NULL,
  `thoi_gian_dao_tao` varchar(50) DEFAULT NULL,
  `nam_ban_hanh` int(11) DEFAULT NULL,
  `trang_thai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_thongtinchung`
--

INSERT INTO `ctdt_thongtinchung` (`id`, `ma_ctdt`, `ten_ctdt`, `nganh`, `ma_nganh`, `khoa_quan_ly`, `he_dao_tao`, `trinh_do`, `tong_tin_chi`, `thoi_gian_dao_tao`, `nam_ban_hanh`, `trang_thai`) VALUES
(1, 'CNTT2020', 'Chương trình đào tạo ngành Công nghệ thông tin', 'Công nghệ thông tin', '7480201', 'Khoa Công nghệ thông tin', 'Chính quy', 'Đại học', 145, '4 năm', 2020, 'Đang áp dụng'),
(2, 'KTPM2020', 'Chương trình đào tạo ngành Kỹ thuật phần mềm', 'Kỹ thuật phần mềm', '7480103', 'Khoa Công nghệ thông tin', 'Chính quy', 'Đại học', 145, '4 năm', 2020, 'Đang áp dụng'),
(3, 'HTTT2021', 'Chương trình đào tạo ngành Hệ thống thông tin', 'Hệ thống thông tin', '7480104', 'Khoa Công nghệ thông tin', 'Chính quy', 'Đại học', 145, '4 năm', 2021, 'Đang áp dụng'),
(4, 'KHMT2021', 'Chương trình đào tạo ngành Khoa học máy tính', 'Khoa học máy tính', '7480101', 'Khoa Công nghệ thông tin', 'Chính quy', 'Đại học', 145, '4 năm', 2021, 'Đang áp dụng'),
(5, 'DTVT2022', 'Chương trình đào tạo ngành Điện tử viễn thông', 'Điện tử viễn thông', '7520207', 'Khoa Điện tử - Viễn thông', 'Chính quy', 'Đại học', 150, '4 năm', 2022, 'Đang áp dụng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_user`
--

CREATE TABLE `ctdt_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ho_ten` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `so_dien_thoai` varchar(20) DEFAULT NULL,
  `vai_tro` varchar(30) DEFAULT NULL,
  `nam_sinh` int(11) DEFAULT NULL,
  `trang_thai` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt_user`
--

INSERT INTO `ctdt_user` (`id`, `username`, `password`, `ho_ten`, `email`, `so_dien_thoai`, `vai_tro`, `nam_sinh`, `trang_thai`) VALUES
(1, 'admin', '$2y$10$FKlZJ6Ky0GPM/tAEFO.DwehOQHblUCfEbOM35ZED3kN32yVxUcmOe', 'Quản trị viên', 'admin@truong.edu.vn', '0901234567', 'admin', 1985, 1),
(2, 'truongkhoa', '$2y$10$IiU5NAzEpBnZ1K7V3YlbVew5a3RKV1hEfYCJqXcLYU4DQB3TLW3hW', 'Nguyễn Văn Trưởng', 'truongkhoa@truong.edu.vn', '0912345678', 'truongkhoa', 1975, 1),
(3, 'phuong', '$2y$10$0gLaiD6mxrx.yBBgF5yKZOAfl/IK6D1Kj0.oRiJK7n0ZwGpysVZxi', 'Trần Thị Phương', 'phuong@truong.edu.vn', '0923456789', 'giangvien', 1980, 1),
(4, 'hung', '$2y$10$YeG6nF2FtV4y09KF96yTveyrNhU0Mb6aSvDsycHMZCHoG4s45HUFq', 'Lê Thanh Hùng', 'hung@truong.edu.vn', '0934567890', 'giangvien', 1982, 1),
(5, 'minh', '$2y$10$1E/R23EwIfWf8QQyF3lqkeNYHj.YlbVJbCVP5N523XsIxkzZBBmHC', 'Phạm Tuấn Minh', 'minh@truong.edu.vn', '0945678901', 'giangvien', 1985, 1),
(6, 'lan', '$2y$10$9UAfLvv/OO5K19RlVGJO0e2Rl43W1JSQio4BXdGJZyDfvYKbnlPom', 'Nguyễn Thị Lan', 'lan@truong.edu.vn', '0956789012', 'giangvien', 1987, 1),
(7, 'binh', '$2y$10$w6BFRxeRefP9zZrmdQA3qedAI0FN9XgpRcvJLSOLmV0kHXUbDEROa', 'Trần Văn Bình', 'binh@truong.edu.vn', '0967890123', 'giangvien', 1979, 1),
(8, 'linh', '$2y$10$uM/mfghPzDzT0ZoJ5DJVQuhl3rjXwQeE04zzar9Kru9mKdgIEQ8kW', 'Võ Thị Linh', 'linh@truong.edu.vn', '0978901234', 'giangvien', 1990, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctdt_cotdiem`
--
ALTER TABLE `ctdt_cotdiem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `decuong_id` (`decuong_id`);

--
-- Chỉ mục cho bảng `ctdt_decuongchitiet`
--
ALTER TABLE `ctdt_decuongchitiet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hoc_phan_id` (`hoc_phan_id`);

--
-- Chỉ mục cho bảng `ctdt_giangvien`
--
ALTER TABLE `ctdt_giangvien`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_gv` (`ma_gv`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `ctdt_hocphan`
--
ALTER TABLE `ctdt_hocphan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_hp` (`ma_hp`),
  ADD KEY `nhom_id` (`nhom_id`);

--
-- Chỉ mục cho bảng `ctdt_kehoachdayhoc`
--
ALTER TABLE `ctdt_kehoachdayhoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ctdt_id` (`ctdt_id`),
  ADD KEY `hoc_phan_id` (`hoc_phan_id`);

--
-- Chỉ mục cho bảng `ctdt_kehoachmonhom`
--
ALTER TABLE `ctdt_kehoachmonhom`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hoc_phan_id` (`hoc_phan_id`);

--
-- Chỉ mục cho bảng `ctdt_khungchuongtrinh`
--
ALTER TABLE `ctdt_khungchuongtrinh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ctdt_id` (`ctdt_id`);

--
-- Chỉ mục cho bảng `ctdt_khungchuongtrinh_nhomkienthuc`
--
ALTER TABLE `ctdt_khungchuongtrinh_nhomkienthuc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_khungchuongtrinh` (`id_khungchuongtrinh`),
  ADD KEY `id_manhom` (`id_manhom`);

--
-- Chỉ mục cho bảng `ctdt_nhomkienthuc`
--
ALTER TABLE `ctdt_nhomkienthuc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ctdt_phanconggiangday`
--
ALTER TABLE `ctdt_phanconggiangday`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nhom_id` (`nhom_id`),
  ADD KEY `giang_vien_id` (`giang_vien_id`);

--
-- Chỉ mục cho bảng `ctdt_thongtinchung`
--
ALTER TABLE `ctdt_thongtinchung`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_ctdt` (`ma_ctdt`);

--
-- Chỉ mục cho bảng `ctdt_user`
--
ALTER TABLE `ctdt_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ctdt_cotdiem`
--
ALTER TABLE `ctdt_cotdiem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `ctdt_decuongchitiet`
--
ALTER TABLE `ctdt_decuongchitiet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `ctdt_giangvien`
--
ALTER TABLE `ctdt_giangvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `ctdt_hocphan`
--
ALTER TABLE `ctdt_hocphan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `ctdt_kehoachdayhoc`
--
ALTER TABLE `ctdt_kehoachdayhoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `ctdt_kehoachmonhom`
--
ALTER TABLE `ctdt_kehoachmonhom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `ctdt_khungchuongtrinh`
--
ALTER TABLE `ctdt_khungchuongtrinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `ctdt_khungchuongtrinh_nhomkienthuc`
--
ALTER TABLE `ctdt_khungchuongtrinh_nhomkienthuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `ctdt_nhomkienthuc`
--
ALTER TABLE `ctdt_nhomkienthuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `ctdt_phanconggiangday`
--
ALTER TABLE `ctdt_phanconggiangday`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `ctdt_thongtinchung`
--
ALTER TABLE `ctdt_thongtinchung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `ctdt_user`
--
ALTER TABLE `ctdt_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctdt_cotdiem`
--
ALTER TABLE `ctdt_cotdiem`
  ADD CONSTRAINT `ctdt_cotdiem_ibfk_1` FOREIGN KEY (`decuong_id`) REFERENCES `ctdt_decuongchitiet` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_decuongchitiet`
--
ALTER TABLE `ctdt_decuongchitiet`
  ADD CONSTRAINT `ctdt_decuongchitiet_ibfk_1` FOREIGN KEY (`hoc_phan_id`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_giangvien`
--
ALTER TABLE `ctdt_giangvien`
  ADD CONSTRAINT `ctdt_giangvien_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `ctdt_user` (`id`) ON DELETE SET NULL;

--
-- Các ràng buộc cho bảng `ctdt_hocphan`
--
ALTER TABLE `ctdt_hocphan`
  ADD CONSTRAINT `ctdt_hocphan_ibfk_1` FOREIGN KEY (`nhom_id`) REFERENCES `ctdt_khungchuongtrinh` (`id`) ON DELETE SET NULL;

--
-- Các ràng buộc cho bảng `ctdt_kehoachdayhoc`
--
ALTER TABLE `ctdt_kehoachdayhoc`
  ADD CONSTRAINT `ctdt_kehoachdayhoc_ibfk_1` FOREIGN KEY (`ctdt_id`) REFERENCES `ctdt_thongtinchung` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `ctdt_kehoachdayhoc_ibfk_2` FOREIGN KEY (`hoc_phan_id`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_kehoachmonhom`
--
ALTER TABLE `ctdt_kehoachmonhom`
  ADD CONSTRAINT `ctdt_kehoachmonhom_ibfk_1` FOREIGN KEY (`hoc_phan_id`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_khungchuongtrinh`
--
ALTER TABLE `ctdt_khungchuongtrinh`
  ADD CONSTRAINT `ctdt_khungchuongtrinh_ibfk_1` FOREIGN KEY (`ctdt_id`) REFERENCES `ctdt_thongtinchung` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_khungchuongtrinh_nhomkienthuc`
--
ALTER TABLE `ctdt_khungchuongtrinh_nhomkienthuc`
  ADD CONSTRAINT `ctdt_khungchuongtrinh_nhomkienthuc_ibfk_1` FOREIGN KEY (`id_khungchuongtrinh`) REFERENCES `ctdt_khungchuongtrinh` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `ctdt_khungchuongtrinh_nhomkienthuc_ibfk_2` FOREIGN KEY (`id_manhom`) REFERENCES `ctdt_nhomkienthuc` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_phanconggiangday`
--
ALTER TABLE `ctdt_phanconggiangday`
  ADD CONSTRAINT `ctdt_phanconggiangday_ibfk_1` FOREIGN KEY (`nhom_id`) REFERENCES `ctdt_kehoachmonhom` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `ctdt_phanconggiangday_ibfk_2` FOREIGN KEY (`giang_vien_id`) REFERENCES `ctdt_giangvien` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
