/**
  Funcion generica para reutilizarse
 */
CREATE OR REPLACE FUNCTION xd
(
)
    RETURNS void AS
$$
DECLARE
begin

end;
$$
    LANGUAGE plpgsql;

/**
  Cuenta en si el numero de pedidos
 */
SELECT sum(i.quantity) FROM invoices i;

/**
    Cuenta el numero de pedidos por persona
 */
SELECT p.name,p.phone,count(p) FROM persons p
    INNER JOIN sales s on p.id = s.person_id
    INNER JOIN invoices i on s.id = i.sale_id
GROUP BY p.name,p.phone;

/**
    Cuenta el numero de pedidos y el dinero invertido por persona
 */
SELECT p.name AS nombre,count(p) AS num_pedidos,sum(p2.sale_price*i.quantity) AS inversion
FROM persons p
    INNER JOIN sales s on p.id = s.person_id
    INNER JOIN invoices i on s.id = i.sale_id
    INNER JOIN products p2 on p2.id = i.product_id
GROUP BY p.name;