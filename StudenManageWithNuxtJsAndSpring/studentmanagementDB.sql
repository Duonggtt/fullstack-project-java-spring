CREATE TABLE [Clazz] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [class_name] nvarchar(255),
  [monitor_name] nvarchar(255),
  [academicYear_id] int,
  [course_id] int
)
GO

CREATE TABLE [Advisor] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [name] nvarchar(255),
  [email] nvarchar(255),
  [gender_id] int,
  [phone] nvarchar(255)
)
GO

CREATE TABLE [Clazz_Advisor] (
  [clazz_id] int,
  [advisor_id] int
)
GO

CREATE TABLE [Major] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [major_name] nvarchar(255),
  [detail] nvarchar(255),
  [year_quantity] int
)
GO

CREATE TABLE [Student] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [full_name] nvarchar(255),
  [birth_date] date,
  [address] nvarchar(255),
  [gender_id] int,
  [email] nvarchar(255),
  [phone] nvarchar(255),
  [ethnicity] nvarchar(255),
  [status] nvarchar(255),
  [major_id] int,
  [clazz_id] int
)
GO

CREATE TABLE [Gender] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [genderName] nvarchar(255)
)
GO

CREATE TABLE [academicYear] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [yearName] nvarchar(255)
)
GO

CREATE TABLE [Course] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [courseNum] int
)
GO

CREATE TABLE [User] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [name] nvarchar(255),
  [username] nvarchar(255),
  [password] nvarchar(255)
)
GO

CREATE TABLE [Role] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [name] nvarchar(255)
)
GO

CREATE TABLE [Subject] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [name] nvarchar(255),
  [description] nvarchar(255)
)
GO

CREATE TABLE [Point] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [diligencePoint] float,
  [midTermPoint] float,
  [finalPoint] float,
  [gpa] float,
  [student_id] int,
  [subject_id] int
)
GO

CREATE TABLE [Lecturer] (
  [id] int PRIMARY KEY IDENTITY(1, 1),
  [fullName] nvarchar(255),
  [gender_id] int,
  [email] nvarchar(255),
  [phone] nvarchar(255)
)
GO

CREATE TABLE [Lecturer_Subject] (
  [lecturer_id] int,
  [subject_id] int
)
GO

CREATE TABLE [User_Role] (
  [user_id] int,
  [role_id] int
)
GO

ALTER TABLE [Clazz] ADD FOREIGN KEY ([academicYear_id]) REFERENCES [academicYear] ([id])
GO

ALTER TABLE [Clazz] ADD FOREIGN KEY ([course_id]) REFERENCES [Course] ([id])
GO

ALTER TABLE [Advisor] ADD FOREIGN KEY ([gender_id]) REFERENCES [Gender] ([id])
GO

ALTER TABLE [Clazz_Advisor] ADD FOREIGN KEY ([clazz_id]) REFERENCES [Clazz] ([id])
GO

ALTER TABLE [Clazz_Advisor] ADD FOREIGN KEY ([advisor_id]) REFERENCES [Advisor] ([id])
GO

ALTER TABLE [Student] ADD FOREIGN KEY ([gender_id]) REFERENCES [Gender] ([id])
GO

ALTER TABLE [Student] ADD FOREIGN KEY ([major_id]) REFERENCES [Major] ([id])
GO

ALTER TABLE [Student] ADD FOREIGN KEY ([clazz_id]) REFERENCES [Clazz] ([id])
GO

ALTER TABLE [Point] ADD FOREIGN KEY ([student_id]) REFERENCES [Student] ([id])
GO

ALTER TABLE [Point] ADD FOREIGN KEY ([subject_id]) REFERENCES [Subject] ([id])
GO

ALTER TABLE [Lecturer] ADD FOREIGN KEY ([gender_id]) REFERENCES [Gender] ([id])
GO

ALTER TABLE [Lecturer_Subject] ADD FOREIGN KEY ([lecturer_id]) REFERENCES [Lecturer] ([id])
GO

ALTER TABLE [Lecturer_Subject] ADD FOREIGN KEY ([subject_id]) REFERENCES [Subject] ([id])
GO

ALTER TABLE [User_Role] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [User_Role] ADD FOREIGN KEY ([role_id]) REFERENCES [Role] ([id])
GO
