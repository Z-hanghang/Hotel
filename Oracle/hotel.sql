
--楼层表  floor
create  table floor(
  floor_id  varchar2(20),       --楼层编号
  floor_room number(2),         --房间数
  constraints pk_floor_fid primary key(floor_id) --主键 楼层编号
);

-------------------------------------------------

--房间类型表  roomtype
create table roomtype(
  roomtype_id varchar2(20),     --房间类型编号
  roomtype_name varchar2(20),   --房间类型名称
  roomtype_piece number(8,2),   --房间价格
  constraints pk_rot_rotpid primary key(roomtype_id) --主键 房间类型编号
)
-------------------------------------------------

--房间状态表  roomstate
create table roomstate(
  roomstate_id varchar2(20),    --状态编号
  roomstate_name varchar2(20),  --状态名称
  constraints pk_ros_rostid primary key(roomstate_id) --主键 状态编号
); 

-------------------------------------------------

--房间信息表  room
create table room(
  room_id varchar2(20),         --房间号
  roomtype_id varchar2(20),     --房间类型编号
  room_number number(2),        --床位数
  floor_id varchar(20),         --所在楼层编号
  roomstate_id varchar(20),     --房间状态编号
  constraints pk_room_roid primary key(room_id) --主键 房间号
);
--room 外键约束
--房间类型编号
alter table room 
  add constraints fk_room_rtid foreign key(roomtype_id) references roomtype(roomtype_id);
--所在楼层编号
alter table room 
  add constraints fk_room_flid foreign key(floor_id) references floor(floor_id);
--房间状态编号
alter table room 
  add constraints fk_room_rsid foreign key(roomstate_id) references roomstate(roomstate_id);

-------------------------------------------------
--顾客类型表  Member
CREATE TABLE Member(
  Member_id  varchar2(20),      --顾客类型编号
  Member_name  varchar2(20),    --顾客类型名称
  Member_count number(2),       --折扣
  constraints pk_mb_mbid PRIMARY KEY (Member_id)--主键 顾客类型编号
);
--------------------------------------------------------
--顾客信息表  Customer
CREATE TABLE Customer(
  Customer_id   varchar2(20),  --顾客编号
  Customer_name varchar2(20),  --顾客姓名
  Customer_sex char(2),        --顾客性别
  Customer_tel  varchar(20),      --手机号
  Customer_cid varchar2(20),   --身份证号
  Member_id varchar2(20),      --顾客类型编号
  constraints pk_cus_cid primary key (Customer_id) --主键 顾客编号
);
--Customer 外键约束 
--顾客类型编号
ALTER table customer 
  ADD constraints fk_cus_mbid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);

-------------------------------------------------

--商品库存表  Foodstock
create table Foodstock (
  Foodstock_id varchar2(20),    --库存编号
  Foodstock_amount number(4),   --商品数量
  constraints Pk_fsk_fskid primary key (Foodstock_id)  --主键 库存编号
);

-------------------------------------------------
--商品表  Food
create table Food (
  Food_id varchar2(20) ,        --商品编号
  Food_name varchar2(20),       --商品名称
  Food_piece  number(8,2),      --商品价格  
  Foodstock_id  varchar2(20),  --库存编号
  constraints pk_fd_fdid   primary key (Food_id)  --主键 商品编号
);
--Food 外键约束 
--库存编号
alter table Food 
  add constraints fk_fok_fskd foreign key (Foodstock_id) references Foodstock (Foodstock_id);

-------------------------------------------------

--房间商品消费表  Consume
--房间商品消费表  Consume
create table Consume(
  Room_id varchar2(20),     --房间号
  Customer_id varchar2(20),  --顾客编号
  Food_id varchar2(20),         --商品编号
  Consume_number number(4),    --购买数量
  Consume_date  date,           --日期
  Consume_state int,        --状态(1)已结账，(0)未结账
  consume_count	number(8,2) --单笔消费
);
--Consume 外键约束  
--商品编号
alter table Consume 
  add constraints  fk_cs_fdd foreign key(Food_id) references Food (Food_id);
--房间号
alter table Consume  
  add constraints fk_cs_rid foreign key(Room_id) references Room (Room_id);
--顾客编号
alter table Consume
  add constraints fk_cs_cid foreign key(Customer_id) references Customer(Customer_id);

--DROP TABLE consume;

SELECT * FROM consume;

-------------------------------------------------
--换房记录表
create table Csrecord(
CSrecord_id  varchar2(20),--记录编号
Customer_id  varchar2(20),--顾客编号
Room_id  varchar2(20),--当前房间号
BeforeRoom_id  varchar2(20),--最初房间号
CSrecord_date  date,--换房日期
constraints pk_csd_csid   primary key (CSrecord_id)--主键 记录编号
);
--Csrecord 外键约束
--顾客编号
alter table Csrecord
  add constraints fk_csd_cid foreign key(Customer_id) references Customer(Customer_id);
--当前房间号
alter table Csrecord  
  add constraints fk_csd_rid foreign key(Room_id) references Room (Room_id);

-------------------------------------------------
--预订信息表  Reserve
INSERT INTO Reserve VALUES('YD100002','G1002','MG1002','R310','RT02','EM1002','已预订',to_date('2018-10-18','yyyy-mm-dd'),to_date('2018-10-19','yyyy-mm-dd'));

SELECT * FROM  Reserve FOR UPDATE;

CREATE TABLE Reserve(
  Reserve_id varchar2(20),      --预订单号
  Customer_id  varchar2(20),    --顾客编号
  Member_id  varchar2(20),      --顾客类型编号
  Room_id  varchar2(20),        --房间号
  Roomtype_id  varchar2(20),    --房间类型编号
  Employee_id  varchar2(20),   --员工编号
  Reserve_state  varchar(20),   --预订状态
  Reserve_rtime  date,          --预抵达时间
  Reserve_ltime  date,          --预保留时间
  constraints pk_re_rid PRIMARY KEY (Reserve_id) --主键 预订单号
);
--Reserve 外键约束
--顾客编号
ALTER TABLE Reserve  
  ADD constraints fk_re_cid FOREIGN KEY (Customer_id) REFERENCES Customer (Customer_id);
--顾客类型编号
ALTER TABLE Reserve  
  ADD constraints fk_re_mid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);
--房间类型编号
ALTER TABLE Reserve  
  ADD constraints fk_re_rmid FOREIGN KEY (Roomtype_id) REFERENCES Roomtype (Roomtype_id);
--房间编号
ALTER TABLE Reserve  
  ADD constraints fk_re_romid FOREIGN KEY (Room_id) REFERENCES Room (Room_id);
 --员工编号
ALTER TABLE Reserve 
  ADD constraints fk_re_eid FOREIGN KEY (Employee_id) REFERENCES Employee (Employee_id);

-------------------------------------------------

--入住信息表  reside
CREATE TABLE reside (
  Reside_id varchar2(20),       --订单号
  Deposit number(4),            --押金
  Checkout_state int, --结账状态(1)已结账，(0)未结账
  Reside_number number(1),      --入住人数
  Customer_id varchar2(20),     --顾客编号
  Member_id varchar2(20),       --顾客类型编号
  Room_id varchar2(20),         --房间号
  Roomtype_id varchar2(20),     --房间类型编号
  Employee_id varchar2(20),     --员工编号
  Reside_rtime  date,           --入住时间
  Reside_ltime  date,           --退房时间
  constraints pk_res_resid PRIMARY KEY (Reside_id) -- 主键 订单号
);
--reside 外键约束
--顾客编号
ALTER  TABLE reside  ADD 
  constraints fk_res_cid FOREIGN KEY (Customer_id) REFERENCES Customer (Customer_id);
--顾客类型编号
ALTER  TABLE reside  ADD
  constraints fk_res_mid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);
--房间类型编号
ALTER  TABLE reside  ADD
  constraints fk_res_rmid FOREIGN KEY (Roomtype_id) REFERENCES Roomtype (Roomtype_id);
--房间编号
ALTER  TABLE reside  ADD
  constraints fk_res_romid FOREIGN KEY (Room_id) REFERENCES Room (Room_id);
--员工编号
ALTER  TABLE reside  ADD
  constraints fk_res_eid FOREIGN KEY (Employee_id) REFERENCES Employee (Employee_id);
  
-------------------------------------------------

--员工类型表  emtype
create table emtype(
  emtype_id varchar2(20),            --员工类型编号
  emtype_name varchar2(20),     --类型名称
  constraints pk_emt_eid primary key(emtype_id) -- 主键 员工类型编号     
);

-------------------------------------------------
--员工表  employee
create table employee(
  employee_id varchar2(20),     --员工编号
  emtype_id varchar2(20),            --员工类型编号
  employee_name varchar2(20),   --员工姓名
  employee_birthday  date,      --员工生日
  employee_sex char(2),         --员工性别
  employee_tel varchar2(20),        --员工电话
  employee_eid varchar2(20),    --员工身份证号
  constraints pk_emp_eid primary  key(employee_id) --主键 员工编号
);
--employee 外键约束
--员工类型编号
alter table employee add
  constraints fk_emp_id foreign key (emtype_id) references emtype (emtype_id);

-------------------------------------------------
--员工登录表  log
create table log(
  employee_id varchar2(20),     --员工编号
  log_password  char(6),        --密码
  log_state int        --状态
) 
--log 外键约束
--员工编号
alter table log add
  constraints fk_log_eid foreign key (employee_id) references employee (employee_id);     
-------------------------------------------------

--结算表  Account
create table Account (
  Account_id varchar2(20),      --结算单号
  Reside_id varchar2(20),      --入住订单号
  Customer_id varchar2(20),     --顾客编号
  Member_id varchar2(20),       --顾客类型编号
  Room_id varchar2(20),         --房间号
  Roomtype_id varchar2(20),     --房间类型编号
  Employee_id varchar2(20),     --员工编号
  Account_money number(8,2),    --消费总额
  Deposit number(4),            --已交押金
  Return_deposit number(4),     --退还押金
  Account_state  int,            --状态 (1)已结账，(0)未结账
  Account_txt  varchar2(200),    --备注（房间损坏物品 押金去向）

  constraints pk_acc_aid primary key (Account_id) --主键 结算单号
);
--Account外键约束
--顾客编号
Alter table Account 
  add constraints fk_acc_cid foreign key (Customer_id) references Customer (Customer_id);
--顾客类型编号
Alter table Account 
  add constraints fk_acc_mid foreign key (Member_id) references Member (Member_id);
--房间号
Alter table Account 
  add constraints fk_acc_rid foreign key (Room_id) references Room (Room_id);
--房间类型编号
Alter table Account 
  add constraints fk_acc_rtid foreign key (Roomtype_id) references Roomtype (Roomtype_id);
--订单号
Alter table Account 
  add constraints fk_acc_rsid foreign key (Reside_id) references Reside (Reside_id);
--员工编号
Alter table Account 
  add constraints fk_acc_eid foreign key (Employee_id) references Employee (Employee_id);

-------------------------------------------------

--营业表  Business
create table Business (
  Business_id varchar2(20),     --编号
  Account_id  varchar2(20),     --结算单号
  Room_id varchar2(20),         --房间号
  Roomtype_id varchar2(20),     --房间类型编号
  Customer_id varchar2(20),     --顾客编号
  Member_id varchar2(20),       --顾客类型编号
  Account_money number(8,2),    --消费总额
  constraints pk_bus_bid primary key (Business_id) --主键 编号
);
--Business 外键约束
--房间号
Alter table Business 
  add constraints fk_bus_rid foreign key (Room_id) references Room (Room_id);
--房间类型编号
Alter table Business 
  add constraints fk_bus_rtid foreign key (Roomtype_id) references Roomtype (Roomtype_id);
--顾客编号
Alter table Business 
  add constraints fk_bus_cid foreign key (Customer_id) references Customer (Customer_id);
--顾客类型编号
Alter table Business 
  add constraints fk_bus_mid foreign key (Member_id) references Member (Member_id);
--结算单号
Alter table Business 
  add constraints fk_bus_aid foreign key (Account_id) references Account (Account_id);

--修改数据库中int类型
alter table log modify log_state char(1);
alter table reside modify Checkout_state char(1);
alter table Consume modify Consume_state  char(1);
alter table Account modify Account_state  char(1);
--添加管理员表
CREATE TABLE Manager(
   Manager_name VARCHAR2(20),--姓名
	 Manager_id Varchar2(20),--账号
	 Manager_pwd CHAR(6),--密码
	CONSTRAINTS pk_Manager_id PRIMARY KEY  (Manager_id)--主键账号
);
--会员表
SELECT * FROM vip FOR UPDATE;
CREATE TABLE Vip(
  vip_id  varchar2(20),          --会员编号
  Customer_id   varchar2(20),   --顾客编号
  Member_id  varchar2(20),      --顾客类型编号
  constraints pk_vip_id primary key (Customer_id) --主键 会员编号
);

ALTER table vip 
  ADD constraints fk_vip_csid FOREIGN KEY (Customer_id) REFERENCES customer (Customer_id);

ALTER table vip 
  ADD constraints fk_vip_mbid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);


SELECT * FROM Manager FOR UPDATE;


----暂时不添加
--日志表
CREATE TABLE rizhi(
    Employee_id varchar2(20),
		rizhi_rdate DATE,
		rizhi_ldate DATE
);
Alter table rizhi 
  add constraints fk_rz_eid foreign key (Employee_id) references Employee (Employee_id);
	
	SELECT * FROM rizhi;
	INSERT INTO rizhi(Employee_id,rizhi_rdate) values('EM1001',SYSDATE);
	
