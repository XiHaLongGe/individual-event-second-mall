DROP DATABASE
IF
	EXISTS malldb;

-- ///////////////////////////////// 

CREATE DATABASE malldb CHARSET utf8;

USE malldb;

-- /////////////////////////////////


DROP TABLE IF EXISTS customer_login;

CREATE TABLE customer_login (
	login_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户登录表ID',
	head_icon_url VARCHAR (200) COMMENT '头像路径',
	login_name VARCHAR ( 20 ) COMMENT '昵称',
	login_account VARCHAR ( 11 ) COMMENT '登录账号',
	login_password VARCHAR ( 32 ) COMMENT '登录密码',
	activate_code VARCHAR(32) COMMENT '邮箱激活码',
	account_stats BIT DEFAULT 0 COMMENT '账号状态(0:"未激活",1:"激活")',
	webmaster BIT DEFAULT 0 COMMENT '管理员身份(0:"否",1:"是")'
) COMMENT '用户登录表';

-- 密码默认六个1
INSERT INTO customer_login(head_icon_url, login_name, login_account,  login_password, activate_code, account_stats, webmaster) VALUES
('\\static\\background\\upload-file\\headIconImage\\001.png', 'xiha1', '18546320231', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 0),
('\\static\\background\\upload-file\\headIconImage\\002.png', 'xiha2', '28546320232', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 0),
('\\static\\background\\upload-file\\headIconImage\\003.png', 'xiha3', '38546320233', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 0),
('\\static\\background\\upload-file\\headIconImage\\004.png', 'xiha4', '48546320234', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 0, 0),
('\\static\\background\\upload-file\\headIconImage\\005.png', 'xiha5', '58546320235', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 0),
('\\static\\background\\upload-file\\headIconImage\\006.png', 'xiha6', '68546320236', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 0),
('\\static\\background\\upload-file\\headIconImage\\007.png', 'xiha7', '78546320237', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 0, 0),
('\\static\\background\\upload-file\\headIconImage\\008.png', 'xiha8', '87546320238', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 0),
('\\static\\background\\upload-file\\headIconImage\\009.png', 'xiha9', '82854632039', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 0, 0),
('\\static\\background\\upload-file\\headIconImage\\003.png', 'xiha10', '98546320230', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 0, 0),
('\\static\\background\\upload-file\\headIconImage\\006.png', 'xiha11', '10854632021', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 0, 0),
('\\static\\background\\upload-file\\headIconImage\\004.png', 'SmallRubbish', '11111111111', '96e79218965eb72c92a549dd5a330112', '42fa4af762b843dca0393605a1feba30', 1, 1);

-- /////////////////////////////////
select * from customer_login;
-- /////////////////////////////////

DROP TABLE IF EXISTS customer_individual;

CREATE TABLE customer_individual (
	customer_individual_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户信息表ID',
	login_id INT COMMENT '用户登录表ID',
	customer_individual_name VARCHAR ( 20 ) COMMENT '用户姓名',
	customer_individual_gender BIT DEFAULT 0 COMMENT '用户性别(0:"男",1:"女")',
	customer_individual_card VARCHAR ( 18 ) COMMENT '用户身份证号',
	customer_individual_phone VARCHAR ( 11 ) COMMENT '用户手机号',
	customer_individual_email VARCHAR ( 20 ) COMMENT '用户邮箱'
) COMMENT '用户信息表';

INSERT INTO customer_individual(login_id, customer_individual_name, customer_individual_gender, customer_individual_card, customer_individual_phone, customer_individual_email) VALUES
(1, '李一', 1, '362432200804113847', '18128364756', '1612364756@qq.com'),
(2, '李二', 0, '362432200704123847', '18228364756', '1627064756@qq.com'),
(3, '李三', 1, '362432200604133847', '18328364756', '1627964756@qq.com'),
(4, '李四', 0, '362432200504143847', '18428364756', '1627864756@qq.com'),
(5, '李五', 1, '362432200404153847', '18528364756', '1627764756@qq.com'),
(6, '李流', 0, '362432200304163847', '18628364756', '1627664756@qq.com'),
(7, '李期', 1, '362432200204173847', '18728364756', '162754756@qq.com'),
(8, '李把', 0, '362432200104183847', '18828364756', '16274364756@qq.com'),
(9, '李就', 1, '362432200467194767', '18928364756', '1627364756@qq.com'),
(10, '李是', 0, '362432200202173847', '18028364756', '1622364756@qq.com'),
(11, '李十一', 1, '362432200202074745', '13128364756', '1127364756@qq.com'),
(12, '龙吉鹏', 0, '362432200106133016', '18707960607', '1530937232@qq.com');

-- /////////////////////////////////
select * from customer_individual;
-- /////////////////////////////////

DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category(
  product_category_id VARCHAR(15) PRIMARY KEY COMMENT '商品类型表ID',
  product_category_name VARCHAR(10) COMMENT '类型名称',
	sidebar_category_describe VARCHAR(60) COMMENT '类型描述',
-- 	product_category_column BIT DEFAULT 0 COMMENT '是否属于栏目类型(0 : "否" 1 : "是")',
  product_category_level INT DEFAULT 1 COMMENT '栏目层级',
	parent_id VARCHAR(10) COMMENT '父类型ID'
)ENGINE = innodb COMMENT '商品类型表';

INSERT INTO product_category(product_category_id, product_category_name, sidebar_category_describe, product_category_level, parent_id) VALUES
-- 商品父栏目id '类型层次id' + '-' + '序号(第几个)'
('1-1', '运动', '', 1, ''),('1-2', '户外', '', 1, ''),('1-3', '乐器', '', 1, ''),
('1-4', '家电', '', 1, ''),('1-5', '数码', '', 1, ''),('1-6', '手机', '', 1, ''),
('1-7', '美食', '', 1, ''),('1-8', '生鲜', '', 1, ''),
-- 商品子栏目id '父类型id' + '-' + '序号(第几个)'
('1-1-1', '羽毛球', '', 2, '1-1'),('1-1-2', '足球', '', 2, '1-1'),('1-1-3', '篮球', '', 2, '1-1'),
('1-2-1', '背包', '', 2, '1-2'),('1-2-2', '登山鞋', '', 2, '1-2'),
('1-3-1', '钢琴', '', 2, '1-3'),('1-3-2', '口琴', '', 2, '1-3'),('1-3-3', '尤格里里', '', 2, '1-3'),
('1-4-1', '电视', '', 2, '1-4'),('1-4-2', '冰箱', '', 2, '1-4'),('1-4-3', '空调', '', 2, '1-4'),
('1-5-1', '相机', '', 2, '1-5'),('1-5-2', '无人机', '', 2, '1-5'),('1-5-3', '笔记本', '', 2, '1-5'),
('1-6-1', '拍照手机', '', 2, '1-6'),('1-6-2', '音乐手机', '', 2, '1-6'),('1-6-3', '商务手机', '', 2, '1-6'),
('1-7-1', '巧克力', '', 2, '1-7'),('1-7-2', '蜂蜜', '', 2, '1-7'),
('1-8-1', '龙虾', '', 2, '1-8'),
-- 主页父栏目id '类型层次id' + '-' + '序号(第几个)'
('3-1', '热销商品', 'HOT-SALE', 3, ''),('3-2', '户外出行', 'OUTDOORS & AUTOMOTIVE', 3, ''),('3-3', '潮电酷玩', 'ELECTRONICS', 3, ''),('3-4', '居家生活', 'GROCERY & HEALTH', 3, ''),('3-5', '休闲美食', 'LEISURE-FOOD', 3, ''),('3-6', '生鲜水果', 'FRESH & FRUIT', 3, ''),('3-7', '图书影像', 'LIBRARY & VIDEO', 3, ''),
-- 主页子栏目id '父类型id' + '-' + '序号(第几个)'
('3-2-1', '背包', '', 4, '3-2'),
('3-2-2', '鞋子', '', 4, '3-2'),
('3-3-1', '手机', '', 4, '3-3'),
('3-3-2', '电脑', '', 4, '3-3'),
('3-3-3', '游戏机', '', 4, '3-3');

-- /////////////////////////////////
select * from product_category ORDER BY product_category_id;
-- /////////////////////////////////

DROP TABLE IF	EXISTS brand_inf;

CREATE TABLE brand_inf(
  brand_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '品牌信息表ID',
	brand_inf_name VARCHAR(15) COMMENT '品牌名称'
)ENGINE = innodb COMMENT '品牌信息表';

INSERT INTO brand_inf(brand_inf_name) VALUES
('远行客'),
('德芙'),
('HUAWEI'),
('LENOVO');

-- /////////////////////////////////
select * from brand_inf;
-- /////////////////////////////////

DROP TABLE IF	EXISTS procategory_brandinf_relevance;

CREATE TABLE procategory_brandinf_relevance(
	pbr_id INT PRIMARY KEY AUTO_INCREMENT COMMENT 'pbr关联表ID',
	product_category_id VARCHAR(15) COMMENT '商品类型表ID',
	brand_inf_id INT COMMENT '品牌信息表ID'
)ENGINE = innodb COMMENT '商品类型品牌信息关联表';

INSERT INTO procategory_brandinf_relevance(product_category_id, brand_inf_id) VALUES
('1-2-1', 1),
('1-2-2', 1),
('1-7-1', 2),
('1-6-3', 3),
('1-5-3', 4);

-- /////////////////////////////////
select * from procategory_brandinf_relevance;
-- /////////////////////////////////

DROP TABLE IF	EXISTS product_inf;

CREATE TABLE product_inf(
	product_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品信息表ID',
	brand_inf_id INT COMMENT '品牌信息表ID',
-- 	product_category_id VARCHAR(10) COMMENT '商品类型表ID',
	product_category_id VARCHAR(10) COMMENT '栏目类型ID',
	product_inf_name VARCHAR(50) COMMENT '商品名称',
	product_inf_describe VARCHAR(50) COMMENT '商品描述',
  product_inf_price DECIMAL(6,2) COMMENT '商品价格',
	product_inf_sales INT COMMENT '商品销量',
	product_inf_stockpile INT COMMENT '商品库存',
	product_inf_carousel BIT DEFAULT 0 COMMENT '是否轮播展示(0:"否",1:"是")'
)ENGINE = innodb COMMENT '商品信息表';

INSERT INTO product_inf(brand_inf_id, product_category_id, product_inf_name, product_inf_describe, product_inf_price, product_inf_sales, product_inf_stockpile) VALUES
(1, '3-2-1', '远行客登山包双肩男户外背包40L50L徒步旅行包60升','',268.00,1,345),
(1, '3-2-2', 'Topsky户外高帮登山鞋男鞋运动徒步爬山鞋防泼水登山靴旅游骑行鞋','玩转户外 攀山涉水 防水袜套 护踝高帮设计',159.00,2,567),
(2, '3-1', '德芙礼盒装丝滑牛奶纯黑白夹心巧克力3碗排块送女友小零食喜糖果','热销600万碗 多种组合可选 纵享丝滑',89.97,3,234),
(3, '3-1', 'Huawei/华为P30 Pro手机官方旗舰店曲面屏麒麟980智能商务手机mate20x5g正版','直降500 再享优惠200元 6期免息 延保2年',4899.00,4,657),
(4, '3-1', '联想ThinkBook 14/15 .6英寸十代酷睿i5/i7独显轻薄便携','金属机身 轻薄高颜值 读秒开机',4699,5,673);

-- /////////////////////////////////
select * from product_inf where product_category_id = '3-2-2';
-- /////////////////////////////////

DROP TABLE IF	EXISTS picture_inf;
CREATE TABLE picture_inf(
	picture_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '图片信息表ID',
	product_inf_id INT COMMENT '商品信息表ID',
	picture_inf_url VARCHAR(200) COMMENT '图片路径',
  picture_inf_master BIT DEFAULT 0 COMMENT '是否为主图(0:"否",1:"是")'
)ENGINE=innodb COMMENT '图片信息表';

INSERT INTO picture_inf(product_inf_id, picture_inf_url, picture_inf_master) VALUES

(1,'/static/background/upload-file/product-inf-image/登山包.jpg',1),
(1,'/static/background/upload-file/product-inf-image/登山包.jpg',0),
(1,'/static/background/upload-file/product-inf-image/登山包.jpg',0),
(1,'/static/background/upload-file/product-inf-image/登山包.jpg',0),
(1,'/static/background/upload-file/product-inf-image/登山包.jpg',0),

(2,'/static/background/upload-file/product-inf-image/登山鞋.jpg',1),
(2,'/static/background/upload-file/product-inf-image/登山鞋.jpg',0),
(2,'/static/background/upload-file/product-inf-image/登山鞋.jpg',0),
(2,'/static/background/upload-file/product-inf-image/登山鞋.jpg',0),
(2,'/static/background/upload-file/product-inf-image/登山鞋.jpg',0),

(3,'/static/background/upload-file/product-inf-image/德芙巧克力.jpg',1),
(3,'/static/background/upload-file/product-inf-image/德芙巧克力.jpg',0),
(3,'/static/background/upload-file/product-inf-image/德芙巧克力.jpg',0),
(3,'/static/background/upload-file/product-inf-image/德芙巧克力.jpg',0),
(3,'/static/background/upload-file/product-inf-image/德芙巧克力.jpg',0),

(4,'/static/background/upload-file/product-inf-image/HUAWEI_P30_Pro.jpg',1),
(4,'/static/background/upload-file/product-inf-image/HUAWEI_P30_Pro.jpg',0),
(4,'/static/background/upload-file/product-inf-image/HUAWEI_P30_Pro.jpg',0),
(4,'/static/background/upload-file/product-inf-image/HUAWEI_P30_Pro.jpg',0),
(4,'/static/background/upload-file/product-inf-image/HUAWEI_P30_Pro.jpg',0),

(5,'/static/background/upload-file/product-inf-image/ThinkBook.jpg',1),
(5,'/static/background/upload-file/product-inf-image/ThinkBook.jpg',0),
(5,'/static/background/upload-file/product-inf-image/ThinkBook.jpg',0),
(5,'/static/background/upload-file/product-inf-image/ThinkBook.jpg',0),
(5,'/static/background/upload-file/product-inf-image/ThinkBook.jpg',0);

-- /////////////////////////////////
select * from picture_inf;
-- /////////////////////////////////

DROP TABLE IF	EXISTS product_cart;

CREATE TABLE product_cart(
	product_cart_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '购物车表ID',
  login_id INT COMMENT '用户登录表ID',
	product_inf_id INT COMMENT '商品信息表ID',
	product_cart_num INT COMMENT '商品数量'
)ENGINE=innodb COMMENT '购物车表';

INSERT INTO product_cart(login_id, product_inf_id, product_cart_num) VALUES
(1,1,1),
(1,2,1),
(1,3,1),
(2,2,2),
(3,3,3),
(4,4,4),
(5,5,5);

-- /////////////////////////////////
select * from product_cart;
-- /////////////////////////////////

DROP TABLE IF	EXISTS receiving_inf;

CREATE TABLE receiving_inf(
	receiving_inf_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '收货信息表ID',
  login_id INT COMMENT '用户登录表ID',
  receiving_inf_name VARCHAR(15) COMMENT '收货人姓名',
  receiving_inf_phone VARCHAR(11) COMMENT '收货人手机号',
	receiving_inf_province VARCHAR(10) COMMENT '收货人省份/自治区',
	receiving_inf_city VARCHAR(10) COMMENT '收货人城市/地区/自治州',
	receiving_inf_district VARCHAR(10) COMMENT '收货人区/县',
	receiving_inf_address VARCHAR(100) COMMENT '收货人详细地址',
  receiving_inf_default BIT DEFAULT 0 COMMENT '是否为默认地址(0:"否",1:"是")'
)ENGINE=innodb COMMENT '收货信息表';

INSERT INTO receiving_inf
									(login_id, 
									receiving_inf_name, 
									receiving_inf_phone,
									receiving_inf_province,
									receiving_inf_city,
									receiving_inf_district,
									receiving_inf_address,
									receiving_inf_default)
VALUES
			(1, '李一', '18128364756', '江西', '吉安市', '井冈山市', '鹅岭乡白石街88号', 1),
			(1, '李一弟弟', '18493857463', '江西', '吉安市', '井冈山市', '鹅岭乡白石街89号', 0),
			(12, '李一', '18128364756', '江西', '吉安市', '井冈山市', '鹅岭乡白石街88号', 1),
			(12, '李一弟弟', '18493857463', '江西', '吉安市', '井冈山市', '鹅岭乡白石街89号', 0);
		

-- /////////////////////////////////
select * from receiving_inf;
-- /////////////////////////////////

DROP TABLE IF	EXISTS product_order;

CREATE TABLE product_order(
	product_order_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品订单表ID',
  login_id INT COMMENT '用户登录表ID',
	receiving_inf_id INT COMMENT '收货信息表ID',
  product_inf_id INT COMMENT '商品信息表ID',
	product_num INT COMMENT '商品数量',
	leave_word VARCHAR(200) COMMENT '用户留言',
	payment INT DEFAULT 0 COMMENT '支付方式：0未支付，1支付宝，2微信，3现金',
	submit_time DATETIME COMMENT '下单时间',
	payment_time DATETIME COMMENT '付款时间',
	product_order_state INT DEFAULT 1 COMMENT '订单状态：1待付款，2待收货，3已收货',
	product_order_number VARCHAR(18) COMMENT '订单编号'
)ENGINE=innodb COMMENT '商品订单表';

INSERT INTO product_order
									(login_id, 
									receiving_inf_id, 
									product_inf_id,
									product_num,
									leave_word,
									payment,
									submit_time,
									payment_time,
									product_order_state,
									product_order_number)
VALUES
			(1, 1, 1, 1, '发货速度要快哦！！！', 0, '2019-12-19 08:40:40', null, 1, '283948566858674324');

-- /////////////////////////////////
select * from product_order;
-- /////////////////////////////////



























































