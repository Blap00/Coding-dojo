use sakila;
/*
1. ¿Qué consulta ejecutarías para obtener todos los clientes dentro de city_id = 312? 
Su consulta debe devolver el nombre, apellido, correo electrónico y dirección del cliente.
*/

select c.first_name, c.last_name, c.email, a.address
from customer c 
join address a on c.address_id = a.address_id
where city_id=312;


/*
2. ¿Qué consulta harías para obtener todas las películas de comedia? Su consulta 
debe devolver el título de la película, la descripción, el año de estreno, 
la calificación, las características especiales y el género (categoría).
*/
SELECT f.title, f.description, f.release_year, f.rating, f.special_features, c.name AS category
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
WHERE c.name = 'Comedy';

/*
3. ¿Qué consulta harías para obtener todas las películas unidas por actor_id = 5? 
Su consulta debe devolver la identificación del actor, el nombre del actor, 
el título de la película, la descripción y el año de lanzamiento.
*/

select a.actor_id , concat(a.first_name,' ',a.last_name) as actor_name, f.title, f.description, release_year
from actor a
join film_actor fa on a.actor_id = fa.actor_id
join film f on fa.film_id = f.film_id
where a.actor_id=5;

/*
4. ¿Qué consulta ejecutaría para obtener todos los clientes en store_id = 1 y dentro de estas ciudades 
(1, 42, 312 y 459)? Su consulta debe devolver el nombre, apellido, correo electrónico y dirección del cliente.
*/
select concat(cu.first_name,' ' ,cu.last_name) name, cu.email, ad.address
from customer cu
join address ad on cu.address_id = ad.address_id
where cu.store_id=1  && ad.city_id IN (1, 42, 312, 459);
/*
5. ¿Qué consulta realizarías para obtener todas las películas con una "calificación = G" y "característica especial 
= detrás de escena", unidas por actor_id = 15? Su consulta debe devolver el título de la película, la descripción, 
el año de lanzamiento, la calificación y la función especial. Sugerencia: puede usar la función LIKE para obtener 
la parte 'detrás de escena'.
*/
select fi.title, fi.description , fi.release_year, fi.rating, fi.special_features 
from film fi
join film_actor fa on fa.film_id = fi.film_id
where fi.rating like "G" And fi.special_features like "%Behind the Scenes%" and fa.actor_id  = 15;
/*
¿Qué consulta harías para obtener todos los actores que se unieron en el film_id = 369? Su consulta debe devolver 
film_id, title, actor_id y actor_name.
*/
SELECT fa.film_id, f.title, fa.actor_id, CONCAT(a.first_name, ' ', a.last_name) AS actor_name
	FROM film_actor AS fa
	JOIN actor AS a ON fa.actor_id = a.actor_id
	JOIN film AS f ON fa.film_id = f.film_id
	WHERE fa.film_id = 369;
/*
¿Qué consulta harías para obtener todas las películas dramáticas con una tarifa de alquiler de 2.99? 
Su consulta debe devolver el título de la película, la descripción, el año de estreno, la calificación, 
las características especiales y el género (categoría).
*/
SELECT f.title, f.description, f.release_year, f.rating, f.special_features, c.name AS category
	FROM film AS f
	JOIN film_category AS fc ON f.film_id = fc.film_id
	JOIN category AS c ON fc.category_id = c.category_id
	WHERE c.name = 'Drama' AND f.rental_rate = 2.99;

/*
¿Qué consulta harías para obtener todas las películas de acción a las que se une SANDRA KILMER? 
Su consulta debe devolver el título de la película, la descripción, el año de estreno, la calificación, 
las características especiales, el género (categoría) y el nombre y apellido del actor.
*/

SELECT f.title, f.description, f.release_year, f.rating, f.special_features, c.name AS category, CONCAT(a.first_name, ' ', a.last_name) AS actor_name
	FROM film AS f
	JOIN film_category AS fc ON f.film_id = fc.film_id
	JOIN category AS c ON fc.category_id = c.category_id
	JOIN film_actor as fa on f.film_id = fa.film_id
	join actor as a on fa.actor_id = a.actor_id
	WHERE c.name = 'Action' AND a.first_name = 'SANDRA' AND a.last_name ='KILMER';