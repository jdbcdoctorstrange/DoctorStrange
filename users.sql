select * from user;
select * from role;

-- get all users and their roles
-- The many-to-many relationship between user and role creates a third table in the database called user_roles
select username, password, role
from user a
inner join user_roles b on a.id = b.user_id
inner join role c on b.role_id = c.id;