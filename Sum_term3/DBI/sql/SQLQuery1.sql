Select * from tblGender
Select * from tblPerson

Insert into tblPerson(id, name, email, GenderID)
values (9, 'sara', 's@s.com',1)

alter table tblPerson
add constraint df_tblPerson_GenderID
Default 3 for GenderID