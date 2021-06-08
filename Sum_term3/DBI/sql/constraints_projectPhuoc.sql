USE ProjectDBI202

alter table Students
alter column Name nvarchar(50) not null

alter table Students
add default 'M' for gender

alter table Students
add unique (Email)

alter table Students
add foreign key(ClassID) references Class(ClassID)

alter table Students
add check (Email like '%fpt.edu.vn')

alter table Class
alter column Name nvarchar(50) not null

alter table Courses
alter column Name nvarchar(50) not null

alter table Teachers
alter column Name nvarchar(50) not null

alter table Teachers
add default 'M' for gender

alter table TimeTable
add foreign key(ClassID) references Class(ClassID)

alter table TimeTable
add foreign key(SlotNo) references Slot(SlotNo)

alter table TimeTable
add foreign key(RoomNo) references Room(RoomNo)

alter table TimeTable
add foreign key(TeacherID) references Teachers(TeacherID)

alter table TimeTable
add foreign key(CourseID) references Courses(CourseID)

alter table TimeTable
add primary key(Date, ClassID, SlotNo)