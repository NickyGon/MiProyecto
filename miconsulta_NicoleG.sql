use bookstore;
select empleado.nombre, usuario.usuario from empleado inner join usuario on empleado.idempleado=usuario.idempleado;

select email as correo from empleado inner join usuario on empleado.idempleado=usuario.idempleado && usuario.activo=1;

select count(idpublicacion) from publicacion where publicacion.autor like 'Eric G. Coronel C%';

select sum(precio) from venta inner join empleado where venta.idempleado=empleado.idempleado && empleado.nombre='EMILIO';