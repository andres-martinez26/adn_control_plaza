update alquiler
set nombre = :nombre,
	numero = :numero,
	fecha_pago = :fechaPago,
	estado_pago = :estadoPago,
	letra_local = :letraLocal
where id = :id