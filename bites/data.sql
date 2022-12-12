insert into CUSTOMER values (1, 'adresas', 'kompanijos kodas', 'kompanijos pavadinimas', 'vardas', '11111111111','pavarde' )

insert into ordered_service values (2, '2022-12-09', '2022-12-31', 'description', 'vardas', 'Int',1);

select * from customer;
select * from ORDERED_SERVICE where CUSTOMER_id = 1 ;