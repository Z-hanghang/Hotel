
--¥���  floor
create  table floor(
  floor_id  varchar2(20),       --¥����
  floor_room number(2),         --������
  constraints pk_floor_fid primary key(floor_id) --���� ¥����
);

-------------------------------------------------

--�������ͱ�  roomtype
create table roomtype(
  roomtype_id varchar2(20),     --�������ͱ��
  roomtype_name varchar2(20),   --������������
  roomtype_piece number(8,2),   --����۸�
  constraints pk_rot_rotpid primary key(roomtype_id) --���� �������ͱ��
)
-------------------------------------------------

--����״̬��  roomstate
create table roomstate(
  roomstate_id varchar2(20),    --״̬���
  roomstate_name varchar2(20),  --״̬����
  constraints pk_ros_rostid primary key(roomstate_id) --���� ״̬���
); 

-------------------------------------------------

--������Ϣ��  room
create table room(
  room_id varchar2(20),         --�����
  roomtype_id varchar2(20),     --�������ͱ��
  room_number number(2),        --��λ��
  floor_id varchar(20),         --����¥����
  roomstate_id varchar(20),     --����״̬���
  constraints pk_room_roid primary key(room_id) --���� �����
);
--room ���Լ��
--�������ͱ��
alter table room 
  add constraints fk_room_rtid foreign key(roomtype_id) references roomtype(roomtype_id);
--����¥����
alter table room 
  add constraints fk_room_flid foreign key(floor_id) references floor(floor_id);
--����״̬���
alter table room 
  add constraints fk_room_rsid foreign key(roomstate_id) references roomstate(roomstate_id);

-------------------------------------------------
--�˿����ͱ�  Member
CREATE TABLE Member(
  Member_id  varchar2(20),      --�˿����ͱ��
  Member_name  varchar2(20),    --�˿���������
  Member_count number(2),       --�ۿ�
  constraints pk_mb_mbid PRIMARY KEY (Member_id)--���� �˿����ͱ��
);
--------------------------------------------------------
--�˿���Ϣ��  Customer
CREATE TABLE Customer(
  Customer_id   varchar2(20),  --�˿ͱ��
  Customer_name varchar2(20),  --�˿�����
  Customer_sex char(2),        --�˿��Ա�
  Customer_tel  varchar(20),      --�ֻ���
  Customer_cid varchar2(20),   --���֤��
  Member_id varchar2(20),      --�˿����ͱ��
  constraints pk_cus_cid primary key (Customer_id) --���� �˿ͱ��
);
--Customer ���Լ�� 
--�˿����ͱ��
ALTER table customer 
  ADD constraints fk_cus_mbid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);

-------------------------------------------------

--��Ʒ����  Foodstock
create table Foodstock (
  Foodstock_id varchar2(20),    --�����
  Foodstock_amount number(4),   --��Ʒ����
  constraints Pk_fsk_fskid primary key (Foodstock_id)  --���� �����
);

-------------------------------------------------
--��Ʒ��  Food
create table Food (
  Food_id varchar2(20) ,        --��Ʒ���
  Food_name varchar2(20),       --��Ʒ����
  Food_piece  number(8,2),      --��Ʒ�۸�  
  Foodstock_id  varchar2(20),  --�����
  constraints pk_fd_fdid   primary key (Food_id)  --���� ��Ʒ���
);
--Food ���Լ�� 
--�����
alter table Food 
  add constraints fk_fok_fskd foreign key (Foodstock_id) references Foodstock (Foodstock_id);

-------------------------------------------------

--������Ʒ���ѱ�  Consume
--������Ʒ���ѱ�  Consume
create table Consume(
  Room_id varchar2(20),     --�����
  Customer_id varchar2(20),  --�˿ͱ��
  Food_id varchar2(20),         --��Ʒ���
  Consume_number number(4),    --��������
  Consume_date  date,           --����
  Consume_state int,        --״̬(1)�ѽ��ˣ�(0)δ����
  consume_count	number(8,2) --��������
);
--Consume ���Լ��  
--��Ʒ���
alter table Consume 
  add constraints  fk_cs_fdd foreign key(Food_id) references Food (Food_id);
--�����
alter table Consume  
  add constraints fk_cs_rid foreign key(Room_id) references Room (Room_id);
--�˿ͱ��
alter table Consume
  add constraints fk_cs_cid foreign key(Customer_id) references Customer(Customer_id);

--DROP TABLE consume;

SELECT * FROM consume;

-------------------------------------------------
--������¼��
create table Csrecord(
CSrecord_id  varchar2(20),--��¼���
Customer_id  varchar2(20),--�˿ͱ��
Room_id  varchar2(20),--��ǰ�����
BeforeRoom_id  varchar2(20),--��������
CSrecord_date  date,--��������
constraints pk_csd_csid   primary key (CSrecord_id)--���� ��¼���
);
--Csrecord ���Լ��
--�˿ͱ��
alter table Csrecord
  add constraints fk_csd_cid foreign key(Customer_id) references Customer(Customer_id);
--��ǰ�����
alter table Csrecord  
  add constraints fk_csd_rid foreign key(Room_id) references Room (Room_id);

-------------------------------------------------
--Ԥ����Ϣ��  Reserve
INSERT INTO Reserve VALUES('YD100002','G1002','MG1002','R310','RT02','EM1002','��Ԥ��',to_date('2018-10-18','yyyy-mm-dd'),to_date('2018-10-19','yyyy-mm-dd'));

SELECT * FROM  Reserve FOR UPDATE;

CREATE TABLE Reserve(
  Reserve_id varchar2(20),      --Ԥ������
  Customer_id  varchar2(20),    --�˿ͱ��
  Member_id  varchar2(20),      --�˿����ͱ��
  Room_id  varchar2(20),        --�����
  Roomtype_id  varchar2(20),    --�������ͱ��
  Employee_id  varchar2(20),   --Ա�����
  Reserve_state  varchar(20),   --Ԥ��״̬
  Reserve_rtime  date,          --Ԥ�ִ�ʱ��
  Reserve_ltime  date,          --Ԥ����ʱ��
  constraints pk_re_rid PRIMARY KEY (Reserve_id) --���� Ԥ������
);
--Reserve ���Լ��
--�˿ͱ��
ALTER TABLE Reserve  
  ADD constraints fk_re_cid FOREIGN KEY (Customer_id) REFERENCES Customer (Customer_id);
--�˿����ͱ��
ALTER TABLE Reserve  
  ADD constraints fk_re_mid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);
--�������ͱ��
ALTER TABLE Reserve  
  ADD constraints fk_re_rmid FOREIGN KEY (Roomtype_id) REFERENCES Roomtype (Roomtype_id);
--������
ALTER TABLE Reserve  
  ADD constraints fk_re_romid FOREIGN KEY (Room_id) REFERENCES Room (Room_id);
 --Ա�����
ALTER TABLE Reserve 
  ADD constraints fk_re_eid FOREIGN KEY (Employee_id) REFERENCES Employee (Employee_id);

-------------------------------------------------

--��ס��Ϣ��  reside
CREATE TABLE reside (
  Reside_id varchar2(20),       --������
  Deposit number(4),            --Ѻ��
  Checkout_state int, --����״̬(1)�ѽ��ˣ�(0)δ����
  Reside_number number(1),      --��ס����
  Customer_id varchar2(20),     --�˿ͱ��
  Member_id varchar2(20),       --�˿����ͱ��
  Room_id varchar2(20),         --�����
  Roomtype_id varchar2(20),     --�������ͱ��
  Employee_id varchar2(20),     --Ա�����
  Reside_rtime  date,           --��סʱ��
  Reside_ltime  date,           --�˷�ʱ��
  constraints pk_res_resid PRIMARY KEY (Reside_id) -- ���� ������
);
--reside ���Լ��
--�˿ͱ��
ALTER  TABLE reside  ADD 
  constraints fk_res_cid FOREIGN KEY (Customer_id) REFERENCES Customer (Customer_id);
--�˿����ͱ��
ALTER  TABLE reside  ADD
  constraints fk_res_mid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);
--�������ͱ��
ALTER  TABLE reside  ADD
  constraints fk_res_rmid FOREIGN KEY (Roomtype_id) REFERENCES Roomtype (Roomtype_id);
--������
ALTER  TABLE reside  ADD
  constraints fk_res_romid FOREIGN KEY (Room_id) REFERENCES Room (Room_id);
--Ա�����
ALTER  TABLE reside  ADD
  constraints fk_res_eid FOREIGN KEY (Employee_id) REFERENCES Employee (Employee_id);
  
-------------------------------------------------

--Ա�����ͱ�  emtype
create table emtype(
  emtype_id varchar2(20),            --Ա�����ͱ��
  emtype_name varchar2(20),     --��������
  constraints pk_emt_eid primary key(emtype_id) -- ���� Ա�����ͱ��     
);

-------------------------------------------------
--Ա����  employee
create table employee(
  employee_id varchar2(20),     --Ա�����
  emtype_id varchar2(20),            --Ա�����ͱ��
  employee_name varchar2(20),   --Ա������
  employee_birthday  date,      --Ա������
  employee_sex char(2),         --Ա���Ա�
  employee_tel varchar2(20),        --Ա���绰
  employee_eid varchar2(20),    --Ա�����֤��
  constraints pk_emp_eid primary  key(employee_id) --���� Ա�����
);
--employee ���Լ��
--Ա�����ͱ��
alter table employee add
  constraints fk_emp_id foreign key (emtype_id) references emtype (emtype_id);

-------------------------------------------------
--Ա����¼��  log
create table log(
  employee_id varchar2(20),     --Ա�����
  log_password  char(6),        --����
  log_state int        --״̬
) 
--log ���Լ��
--Ա�����
alter table log add
  constraints fk_log_eid foreign key (employee_id) references employee (employee_id);     
-------------------------------------------------

--�����  Account
create table Account (
  Account_id varchar2(20),      --���㵥��
  Reside_id varchar2(20),      --��ס������
  Customer_id varchar2(20),     --�˿ͱ��
  Member_id varchar2(20),       --�˿����ͱ��
  Room_id varchar2(20),         --�����
  Roomtype_id varchar2(20),     --�������ͱ��
  Employee_id varchar2(20),     --Ա�����
  Account_money number(8,2),    --�����ܶ�
  Deposit number(4),            --�ѽ�Ѻ��
  Return_deposit number(4),     --�˻�Ѻ��
  Account_state  int,            --״̬ (1)�ѽ��ˣ�(0)δ����
  Account_txt  varchar2(200),    --��ע����������Ʒ Ѻ��ȥ��

  constraints pk_acc_aid primary key (Account_id) --���� ���㵥��
);
--Account���Լ��
--�˿ͱ��
Alter table Account 
  add constraints fk_acc_cid foreign key (Customer_id) references Customer (Customer_id);
--�˿����ͱ��
Alter table Account 
  add constraints fk_acc_mid foreign key (Member_id) references Member (Member_id);
--�����
Alter table Account 
  add constraints fk_acc_rid foreign key (Room_id) references Room (Room_id);
--�������ͱ��
Alter table Account 
  add constraints fk_acc_rtid foreign key (Roomtype_id) references Roomtype (Roomtype_id);
--������
Alter table Account 
  add constraints fk_acc_rsid foreign key (Reside_id) references Reside (Reside_id);
--Ա�����
Alter table Account 
  add constraints fk_acc_eid foreign key (Employee_id) references Employee (Employee_id);

-------------------------------------------------

--Ӫҵ��  Business
create table Business (
  Business_id varchar2(20),     --���
  Account_id  varchar2(20),     --���㵥��
  Room_id varchar2(20),         --�����
  Roomtype_id varchar2(20),     --�������ͱ��
  Customer_id varchar2(20),     --�˿ͱ��
  Member_id varchar2(20),       --�˿����ͱ��
  Account_money number(8,2),    --�����ܶ�
  constraints pk_bus_bid primary key (Business_id) --���� ���
);
--Business ���Լ��
--�����
Alter table Business 
  add constraints fk_bus_rid foreign key (Room_id) references Room (Room_id);
--�������ͱ��
Alter table Business 
  add constraints fk_bus_rtid foreign key (Roomtype_id) references Roomtype (Roomtype_id);
--�˿ͱ��
Alter table Business 
  add constraints fk_bus_cid foreign key (Customer_id) references Customer (Customer_id);
--�˿����ͱ��
Alter table Business 
  add constraints fk_bus_mid foreign key (Member_id) references Member (Member_id);
--���㵥��
Alter table Business 
  add constraints fk_bus_aid foreign key (Account_id) references Account (Account_id);

--�޸����ݿ���int����
alter table log modify log_state char(1);
alter table reside modify Checkout_state char(1);
alter table Consume modify Consume_state  char(1);
alter table Account modify Account_state  char(1);
--��ӹ���Ա��
CREATE TABLE Manager(
   Manager_name VARCHAR2(20),--����
	 Manager_id Varchar2(20),--�˺�
	 Manager_pwd CHAR(6),--����
	CONSTRAINTS pk_Manager_id PRIMARY KEY  (Manager_id)--�����˺�
);
--��Ա��
SELECT * FROM vip FOR UPDATE;
CREATE TABLE Vip(
  vip_id  varchar2(20),          --��Ա���
  Customer_id   varchar2(20),   --�˿ͱ��
  Member_id  varchar2(20),      --�˿����ͱ��
  constraints pk_vip_id primary key (Customer_id) --���� ��Ա���
);

ALTER table vip 
  ADD constraints fk_vip_csid FOREIGN KEY (Customer_id) REFERENCES customer (Customer_id);

ALTER table vip 
  ADD constraints fk_vip_mbid FOREIGN KEY (Member_id) REFERENCES MEMBER (Member_id);


SELECT * FROM Manager FOR UPDATE;


----��ʱ�����
--��־��
CREATE TABLE rizhi(
    Employee_id varchar2(20),
		rizhi_rdate DATE,
		rizhi_ldate DATE
);
Alter table rizhi 
  add constraints fk_rz_eid foreign key (Employee_id) references Employee (Employee_id);
	
	SELECT * FROM rizhi;
	INSERT INTO rizhi(Employee_id,rizhi_rdate) values('EM1001',SYSDATE);
	
