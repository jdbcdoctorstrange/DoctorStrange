-- select * from user;

-- select * from role;

select username, password, role
from user a
inner join user_roles b on a.id = b.user_id
inner join role c on b.role_id = c.id;