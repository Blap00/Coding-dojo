USE `twitter`;

select * from users;
insert into users values(7,'nombre1','nombre2','username','2023-01-01',"2023-06-22 00:00:00","2023-06-22 12:43:30");
UPDATE users SET first_name = 'nombre!', last_name='Apellido', handle = 'NombreuserNuevo', birthday='1979-04-15', updated_at='2023-06-22 00:01:01' WHERE id=2;
DELETE FROM users WHERE id=6;