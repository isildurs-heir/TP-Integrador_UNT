# TP-Integrador_UNT

Listado inicial en CSV
IDCODE  MARCA    MODELO COLOR   ESTADO
789123)_ Bugatti, W16 - Azul   Disponible
789124)_ Bugatti, W9 - Rojo   Disponible
654321)_ Volvo, T2 - Blanco   Disponible
654322)_ Volvo, G6 - Negro   Disponible

Caso de prueba:
Listado inicial en DB 
IDCODE  MARCA    MODELO COLOR   ESTADO
154322)_ Chevrolet, J5 - Blanco   Disponible
154678)_ VMW, E7 - Gris   Vendido
245786)_ Ford, V4 - Rojo   Disponible
245787)_ Ford, V2 - Azul   Disponible
245788)_ Ford, V1 - Blanco   Disponible
245999)_ Ford, V9 - Blanco   Vendido
321654)_ VMW, E1 - Blanco   Disponible
321655)_ VMW, E2 - Azul   Disponible
321656)_ VMW, E3 - Rojo   Disponible
321657)_ VMW, E4 - Negro   Disponible
693259)_ Mercedez Benz, M1 - Negro   Disponible
154323)_ Chevrolet, J4 - Negro   Disponible
154687)_ Chevrolet, J9 - Negro   Vendido
245789)_ Ford, V3 - Negro   Disponible
154324)_ Chevrolet, J6 - Gris   Disponible
693258)_ Mercedez Benz, M3 - Rojo   Disponible
693693)_ Mercedez Benz, M5 - Rojo   Vendido

CLIENTES REGISTADOS
('Barney','Stinson',123456), --> tiene 2 compras registradas
('Lily','Aldrin',741852),--> tiene 2 compras registradas
('James','Stinson',486426), --> no tiene compras registradas

EMPLEADOS REGISTRADOS
('Marshall','Eriksen',159753),
('Ted','Mosby',357951),
('Robin','Scherbatsky',852456);


Al iniciar el programa, pide datos del cliente.
1)_ se ingresa dni. -->Si ya esta registrado se recuperan sus datos.
                    -->Sino se registra al cliente en la base de datos.
2)_ Se asigna vendedor de manera aleatoria.
2)_ se despliega el menu de opciones
  "*_Comprar un vehiculo.
   *_Ver catalogo.
   *_Historial de compras a mi nombre."
   Si el cliente compra un vehiculo, se registra la venta.
   Si el cliente no compra un vehiculo. Se termina la ejecucion

