# bites
## Užduotis


Spring Boot projektas, naudojamas Maven ir H2 integruota duomenų bazė,
naudotas jdk11 paketas, Java compiler versija 11.
Reikėtų atsisųsti ir importuoti projektą, arba įkelti repozitorijos nuorodą, kai šaltinis VCS.

Programos įėjimo taškas yra BitesApplication klasė.
Duomenys iš duomenų bazės yra ištrinami kiekvieną kartą sustabdžius programą.
Duomenų bazės sąsaja pasiekiama per http://localhost:8080/h2-console/login.jsp paleidus programą, bei jungiantis patikrinti ar JDBC URL yra toks, kaip šis jdbc:h2:mem:bite. Swagger 3 UI dokumentacija pasiekiama per http://localhost:8080/swagger-ui/index.html#/.
Programos pakete pridedamas postman REST kreipinių rinkinys.

Įgyvendinti REST kreipiniai:

### **Customer klasei:**


Gauti visus klientus

                                      GET: localhost:8080/api/customer

Gauti konkretų klientą  

                                      GET: localhost:8080/api/customer/{id}

Sukurti naują klientą

                                      POST: localhost:8080/api/customer

Atnaujinti esamo kliento duomenis

                                      PUT: localhost:8080/api/customer

Ištrinti konkretų klientą

                                      DEL: localhost:8080/api/customer/{id}


### OrderedService klasei:


Gauti konkrečią užsakytą paslaugą

                                        GET: localhost:8080/api/orderedService/{id}

Gauti visas užsakytas paslaugas

                                        GET: localhost:8080/api/OrderedService

Gauti konkretaus kliento užsakytas paslaugas

                                        GET: localhost:8080/api/orderedService/customer/{id}
                                        
Gauti užsakytas paslaugas pagal konkretų paslaugos id
 
                                        GET: localhost:8080/api/orderedService/service/{id}
                                        
Sukurti naują užsakytą paslaugą klientui

                                        POST: localhost:8080/api/orderedService

Atnaujinti esamos užsakytos paslaugos duomenis

                                        PUT: localhost:8080/api/orderedService

Ištrinti konkrečią paslaugą

                                        DEL: localhost:8080/api/orderedService/{id}
                                        
                                        

### Service klasei:
                                        
Sukurti paslaugą

                                        POST: localhost:8080/api/service     

Gauti paslaugą pagal id

                                        GET: localhost:8080/api/service/{id}

Gauti visas paslaugas

                                        GET: localhost:8080/api/service

Atnaujinti konkrečią paslaugą

                                        PUT: localhost:8080/api/service

Ištrinti paslaugą

                                        DELETE: localhost:8080/api/service/{id}
