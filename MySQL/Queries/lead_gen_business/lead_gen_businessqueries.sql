use lead_gen_business;
/*
1. ¿Qué consulta ejecutaría para obtener los ingresos totales para marzo de 2012?
*/
select sum(amount), monthname(charged_datetime) as Month # sum(amount) 
from billing 
where charged_datetime >='2012-03-01 00:00:00' and charged_datetime <='2012-03-31 00:00:00' 
group by Month
order by 2 asc;

/*
2. ¿Qué consulta ejecutaría para obtener los ingresos totales recaudados del cliente con una identificación de 2?
*/
select client_id, sum(amount) as Total_del_cliente from billing where client_id=2 group by client_id;
/*
3. ¿Qué consulta ejecutaría para obtener todos los sitios que posee client = 10?
*/
select client_id, domain_name website
from sites where client_id=10;
/*
4. ¿Qué consulta ejecutaría para obtener el número total de sitios creados por --mes-- por año para el 
cliente con una identificación de 1? ¿Qué pasa con el cliente = 20?
*/
SELECT COUNT(site_id) AS total_sites, client_id, MONTHNAME(created_datetime) AS month,  YEAR(created_datetime) AS year
FROM sites
WHERE client_id = 1
GROUP BY YEAR(created_datetime), MONTH(created_datetime);

#ESTUVE AGRUPANDO YA QUE NO LEI BIEN LA TAREA A REALIZAR jsjsjs
/*
5. ¿Qué consulta ejecutaría para obtener el número total de clientes potenciales 
generados para cada uno de los sitios entre el 1 de enero de 2011 y el 15 de febrero de 2011?
*/
SELECT s.domain_name, (
    SELECT COUNT(*)
    FROM leads l
    WHERE l.site_id = s.site_id
    AND l.registered_datetime >= '2011-01-01'
    AND l.registered_datetime <= '2011-02-15'
) AS total_leads, (
SELECT DATE_FORMAT(l.registered_datetime, '%M %e, %Y') AS date_generated
    FROM leads l
    WHERE l.site_id = s.site_id
    AND l.registered_datetime >= '2011-01-01'
    AND l.registered_datetime <= '2011-02-15'
) AS total_leads
FROM sites s
HAVING total_leads >= 1
order by 3 desc;
/*
6. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total 
de clientes potenciales que hemos generado para cada uno de nuestros clientes entre el 1 de enero de 
2011 y el 31 de diciembre de 2011?
*/
SELECT c.first_name,c.last_name,(
	SELECT COUNT(*)
	   FROM sites s, leads l
	   WHERE s.client_id = c.client_id
		 AND s.site_id = l.site_id
		 AND l.registered_datetime >= '2011-01-01'
		 AND l.registered_datetime <= '2011-12-31'
	  ) AS total_leads
FROM clients c
HAVING total_leads >= 1;
/*
7. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes 
y el número total de clientes potenciales que hemos generado para cada cliente cada mes entre los meses 1 y 6 del año 2011?
*/
SELECT
	concat(c.first_name,' ',c.last_name) client_name,
    COUNT(*) AS number_of_leads,
	MONTHNAME(l.registered_datetime) AS month_generated
	FROM clients c, sites s, leads l
	WHERE c.client_id = s.client_id
		AND s.site_id = l.site_id
		AND YEAR(l.registered_datetime) = 2011
		AND MONTH(l.registered_datetime) BETWEEN 1 AND 6
	GROUP BY c.client_id, MONTH(l.registered_datetime);
/*
8. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes 
potenciales que hemos generado para cada uno de los sitios de nuestros clientes entre el 1 de enero de 2011 y el 31 de 
diciembre de 2011? Solicite esta consulta por ID de cliente. Presente una segunda consulta que muestre todos los clientes, 
los nombres del sitio y el número total de clientes potenciales generados en cada sitio en todo momento.
*/
#Query 1
SELECT
  c.client_id,
  c.first_name,
  c.last_name,
  s.domain_name,
  COUNT(l.leads_id) AS total_leads
FROM clients c
JOIN sites s ON c.client_id = s.client_id
LEFT JOIN leads l ON s.site_id = l.site_id AND l.registered_datetime BETWEEN '2011-01-01' AND '2011-12-31'
GROUP BY c.client_id, s.site_id
having total_leads>=1;
#QUERY 2
SELECT
  c.client_id,
  c.first_name,
  c.last_name,
  s.domain_name,
  COUNT(l.leads_id) AS total_leads
FROM clients c
JOIN sites s ON c.client_id = s.client_id
LEFT JOIN leads l ON s.site_id = l.site_id
GROUP BY c.client_id, s.site_id;
/*
9. Escriba una sola consulta que recupere los ingresos totales recaudados de cada cliente para cada mes del año. 
Pídalo por ID de cliente.
*/
SELECT
	concat(c.first_name,' ', c.last_name),
	b.client_id,
	MONTHNAME(b.charged_datetime) AS month,
	YEAR(b.charged_datetime) AS year,
	SUM(b.amount) AS total_income
	FROM billing b
    join clients c on b.client_id= c.client_id
	GROUP BY client_id, YEAR(charged_datetime), MONTH(charged_datetime)
	order by  client_id asc;
    
/*
10. Escriba una sola consulta que recupere todos los sitios que posee cada cliente. Agrupe los resultados para que cada 
fila muestre un nuevo cliente. Se volverá más claro cuando agregue un nuevo campo llamado 'sitios' que tiene todos los sitios que 
posee el cliente. (SUGERENCIA: use GROUP_CONCAT)
*/
SELECT
  c.client_id,
  CONCAT(c.first_name, ' ', c.last_name) AS client_name,
  GROUP_CONCAT(s.domain_name, ' / ') AS sites
FROM clients c
JOIN sites s ON c.client_id = s.client_id
GROUP BY client_id, client_name;