--¥���
insert into floor values('F03',10);
insert into floor values('F04',10);
insert into floor values('F05',10);

--�������ͱ�
insert into roomtype values('RT01','���˼�',800);
insert into roomtype values('RT02','˫�˼�',1200);
insert into roomtype values('RT03','��ͳ�׷�',8888);
insert into roomtype values('RT04','�����׷�',6888);
insert into roomtype values('RT05','�����׷�',3888);
SELECT * FROM roomtype FOR UPDATE;

select * from roomtype r
WHERE r.roomtype_piece BETWEEN 1000 AND 2000;
--����״̬��
insert into roomstate values('RS01','��');
insert into roomstate values('RS02','��Ԥ��');
insert into roomstate values('RS03','����ס');
insert into roomstate values('RS04','��');
insert into roomstate values('RS05','ά��');
SELECT * FROM roomstate
--������Ϣ��
SELECT * FROM Room FOR UPDATE;
SELECT r.room_id,re.roomtype_name,re.roomtype_piece,r.room_number,r.floor_id r.
FROM room r,roomtype re
WHERE r.roomtype_id=re.roomtype_id AND re.roomtype_name LIKE '%��%';

SELECT r.room_id,re.roomtype_name,re.roomtype_piece,r.room_number,r.floor_id
FROM room r,roomtype re
WHERE r.roomtype_id=re.roomtype_id AND r.room_id LIKE '%303%'


SELECT MAX(room_id)
FROM room
WHERE floor_id='F03'

SELECT r.room_id
FROM room r,roomtype re
WHERE r.roomtype_id=re.roomtype_id  AND re.roomtype_name
UPDATE room SET roomtype_id=?, room_number=?, floor_id=?, roomstate_id=? WHERE room_id=?
--��¥��Ϣ
insert into room values('R301','RT01',1,'F03','RS01');
insert into room values('R302','RT01',1,'F03','RS01');
insert into room values('R303','RT01',1,'F03','RS01');
insert into room values('R304','RT01',1,'F03','RS01');
insert into room values('R305','RT01',1,'F03','RS01');
insert into room values('R306','RT01',1,'F03','RS01');
insert into room values('R307','RT01',1,'F03','RS01');
insert into room values('R308','RT01',1,'F03','RS01');
insert into room values('R309','RT01',1,'F03','RS01');
insert into room values('R310','RT01',1,'F03','RS01');
--��¥��Ϣ
insert into room values('R401','RT02',2,'F04','RS01');
insert into room values('R402','RT02',2,'F04','RS01');
insert into room values('R403','RT02',2,'F04','RS01');
insert into room values('R404','RT02',2,'F04','RS01');
insert into room values('R405','RT02',2,'F04','RS01');
insert into room values('R406','RT02',2,'F04','RS01');
insert into room values('R407','RT01',1,'F04','RS01');
insert into room values('R408','RT01',1,'F04','RS01');
insert into room values('R409','RT01',1,'F04','RS01');
insert into room values('R410','RT01',1,'F04','RS01');
--��¥��Ϣ
insert into room values('R501','RT02',2,'F05','RS01');
insert into room values('R502','RT02',2,'F05','RS01');
insert into room values('R503','RT02',2,'F05','RS01');
insert into room values('R504','RT01',1,'F05','RS01');
insert into room values('R505','RT01',1,'F05','RS01');
insert into room values('R506','RT03',2,'F05','RS01');
insert into room values('R507','RT03',3,'F05','RS01');
insert into room values('R508','RT03',4,'F05','RS01');
insert into room values('R509','RT03',2,'F05','RS01');
insert into room values('R510','RT03',3,'F05','RS01');

--�˿����ͱ�
SELECT * FROM MEMBER FOR UPDATE;
insert into member values('MG101','��ͨ',99);
insert into member values('MG102','vip',90);
insert into member values('MG103','svip',80);

--�˿���Ϣ��
SELECT * FROM customer FOR UPDATE;
insert into Customer values('G1001','������','Ů','18738385438','420629198201245568','MG101');
insert into Customer values('G1002','������','��','15052015523','420626197802361142','MG101');
insert into Customer values('G1004','�','��','15052015523','420626197802361142','MG101');
insert into Customer values('G1005','����','��','15052015523','420626197802361142','MG101');
insert into Customer values('G1006','����i','��','15052015523','420626197802361142','MG101');

SELECT c.customer_id,c.customer_name,c.customer_sex,c.customer_tel,c.customer_cid,c.member_id,m.member_name
FROM customer c,MEMBER m
WHERE c.member_id=m.member_id
 

-----����Ա��

CREATE TABLE Manager(
   Manager_name VARCHAR2(20),--����
	 Manager_id Varchar2(20),--�˺�
	 Manager_pwd CHAR(6),--����
	CONSTRAINTS pk_Manager_id PRIMARY KEY  (Manager_id)--�����˺�
);
SELECT * FROM Manager FOR UPDATE;
--Ա�����ͱ�
SELECT * FROM Emtype;
insert into EMtype values('EMT01','��ͨԱ��');
insert into EMtype values('EMT02','����');

--Ԥ����
SELECT * FROM  Reserve FOR UPDATE;
INSERT INTO Reserve VALUES('YD100002','G1002','MG102','R310','RT02','EM1002','',to_date('2018-10-18','yyyy-mm-dd'),to_date('2018-10-19','yyyy-mm-dd'));
--���ݹ˿ͱ�Ų�˿����ͱ��
SELECT c.member_id
FROM customer c
WHERE c.customer_id='G1002';



UPDATE reserve r SET r.room_id='R504',r.roomtype_id='RT01',r.reserve_state='��Ԥ��',r.reserve_rtime=to_date('2018-10-18','yyyy-mm-dd'),r.reserve_ltime=to_date('2018-10-19','yyyy-mm-dd')
WHERE r.reserve_id='YD100007';

--���ݷ���Ų鷿�����ͱ��
SELECT r.roomtype_id FROM room r WHERE r.room_id=?
--��ѯ����Ԥ�����
SELECT r.reserve_id,c.customer_name,c.customer_sex,c.customer_tel,c.customer_cid,m.member_name,r.room_id,re.roomtype_name,r.employee_id,e.employee_name,r.reserve_state,r.reserve_rtime,r.reserve_ltime
FROM reserve r,customer c,MEMBER m,employee e,roomtype re
WHERE r.customer_id=c.customer_id AND c.member_id=m.member_id AND r.employee_id=e.employee_id AND r.roomtype_id=re.roomtype_id ;
 AND r.room_id=? AND c.customer_name=? AND c.customer_tel=?
 
SELECT v.vip_id
FROM reserve r,vip v
WHERE r.customer_id=v.customer_id
 
--Ա����Ϣ

SELECT *FROM Employee
insert into Employee values('EM1001','EMT01','��˼��',to_date('1994-02-14','yyyy-mm-dd'),'��','18854546652','41125619940214554x');
insert into Employee values('EM1002','EMT01','����',to_date('1982-03-15','yyyy-mm-dd'),'��','18854546652','411256198203155544');
insert into Employee values('EM1003','EMT02','��һ��',to_date('1986-07-10','yyyy-mm-dd'),'��','13062615498','420626198607102236');


SELECT * FROM Employee  FOR UPDATE;
--DROP TABLE reserve;

SELECT MAX(employee_id)
FROM employee;

SELECT em.employee_id,e.emtype_name,em.employee_name,em.employee_birthday,em.employee_sex,em.employee_tel,em.employee_eid
FROM emtype e,employee em
WHERE e.emtype_id=em.emtype_id AND em.employee_name LIKE '%��%';
SELECT  *
FROM emtype e,employee em
WHERE e.emtype_id=em.emtype_id;
--��¼��
insert into Log values('EM1001',(select EMtype_id from Employee where Employee_id='EM1001'),
                        '123456','0'
                        );

insert into Log values('EM1001', '123456','0');
                        
select * from LOG FOR UPDATE;

SELECT e.employee_id,e.employee_name,l.log_password
FROM LOG l,employee e
WHERE l.employee_id=e.employee_id
                        
--��Ʒ����
insert into foodstock values('FS101',30); --ܽ����
insert into foodstock values('FS102',30); --С�ɾ�
insert into foodstock values('FS103',30); --������Ȫˮ
insert into foodstock values('FS104',30); --��ţ
insert into foodstock values('FS105',30); --�����
insert into foodstock values('FS106',300); --����
insert into foodstock values('FS107',320); --����
insert into foodstock values('FS108',80); --�ۺ�
insert into foodstock values('FS109',80); --�ϰ׸�
insert into foodstock values('FS210',80); --����Һ
---
select *from foodstock FOR UPDATE;
--��Ʒ��Ϣ��
insert into food values('SP101','ܽ����',25,'FS101');
insert into food values('SP102','С�ɾ�',25,'FS102');
insert into food values('SP103','������Ȫˮ',2,'FS103');
insert into food values('SP104','��ţ',5.50,'FS104');
insert into food values('SP105','�����',4,'FS105');
insert into food values('SP106','����',2,'FS106');
insert into food values('SP107','����',20,'FS107');
insert into food values('SP108','�ۺ�',50,'FS108');
insert into food values('SP109','�ϰ׸�',80,'FS109');
insert into food values('SP201','����Һ',200,'FS201');

SELECT * FROM food FOR UPDATE;
--
--��Ա��
SELECT * FROM vip FOR UPDATE;
--����
SELECT * FROM room FOR UPDATE;
--��ס
SELECT * FROM reside FOR UPDATE;

