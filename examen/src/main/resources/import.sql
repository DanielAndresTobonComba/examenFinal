insert into modelo (nombre , descripcion) values ("01" , "Todo terreno") ,("02" , "De pista");

insert into marca (nombre ) values ("Dakar" ) ,("GW");


insert into bicicletas (modelo , marca , precio , stock ) values ( 1 , 1 , 250 , 10  ) , ( 2 , 2 , 150 , 5  );

select * from bicicletas; 

insert into paises (nombre) values ("Colombia"); 
insert into ciudades (nombre , pais_id) values ("Bucaramanga" , 1) , ("Bogota" , 1); 
insert into clientes (nombre , email , telefono, password , ciudad_id) values ("daniel" , "datc@g,mail.com" , 31334252236  , "password"  , 1) , ("marco" , "marcoc@g,mail.com" , 31284672812 ,"password" , 2);


insert into ventas (fecha , cliente_id) values ("2024/12/12" , 1) , ("2024/12/12" , 2);


insert into detalles_ventas (cantidad , precio_unitario , venta_id , bicicleta_id) values (12 , 150 , 1 , 1);


