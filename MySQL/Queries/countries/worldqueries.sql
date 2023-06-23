
SELECT c.name AS country_name, l.language, l.percentage
	FROM country c
	JOIN countrylanguage l ON c.Code = l.countryCode
	WHERE l.language = 'Slovene'
	ORDER BY l.percentage DESC;
    
SELECT co.name AS country_name, COUNT(ci.ID) AS city_count
	FROM country co
	JOIN city ci ON co.code = ci.CountryCode
	GROUP BY co.name
	ORDER BY city_count DESC;
    
SELECT ci.name AS city_name, ci.population
	FROM city ci
	JOIN country co ON ci.CountryCode= co.code
	WHERE co.name = 'Mexico' AND ci.population > 500000
	ORDER BY ci.population DESC;
    
SELECT co.name AS country_name, cl.language, cl.percentage
	FROM country co
	JOIN countrylanguage cl ON co.code = cl.countrycode
	WHERE cl.percentage > 89
	ORDER BY cl.percentage DESC; /*No logre ordenar como estaba en la imagen*/

SELECT name AS country_name
	FROM country
	WHERE surfacearea < 501 AND population > 100000;

SELECT name AS name, governmentform as 'government_form', capital, lifeexpectancy as 'life_expectancy'
	FROM country
	WHERE governmentform = 'Constitutional Monarchy' 
	AND capital > 200 AND lifeexpectancy > 75;
    
SELECT co.name AS country_name, ci.name AS city_name, ci.district, ci.population
	FROM country co
	JOIN city ci ON co.code = ci.countrycode
	WHERE co.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000;
    
SELECT region, COUNT(name) AS countries
	FROM country
	GROUP BY region
	ORDER BY countries DESC;