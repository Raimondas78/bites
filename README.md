# bites
## Užduotis


Spring Boot projektas, naudojamas Maven ir H2 integruota duomenų bazė,
naudotas jdk11 paketas, Java compiler versija 11.
Reikėtų atsisųsti ir importuoti projektą, arba įkelti repozitorijos nuorodą, kai šaltinis VCS.

Programos įėjimo taškas yra BitesApplication klasė.
Duomenys iš duomenų bazės yra ištrinami kiekvieną kartą sustabdžius programą.
Duomenų bazės sąsaja pasiekiama per http://localhost:8080/h2-console/login.jsp paleidus programą.
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

                                        GET: localhost:8080/api/service/{id}

Gauti visą užsakytų paslaugų rinkinį

                                        GET: localhost:8080/api/service

Gauti konkretaus kliento užsakytas paslaugas

                                        GET: localhost:8080/api/service/customer/{id}

Sukurti naują paslauą klientui

                                        POST: localhost:8080/api/service

Atnaujinti esamos paslaugos duomenis

                                        PUT: localhost:8080/api/service

Ištrinti konkrečią paslaugą

                                        DEL: localhost:8080/api/service/{id}
