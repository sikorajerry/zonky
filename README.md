# ZONKY

## Úkol 
ukol zde: 
Zkuste naprogramovat kod, ktery bude kazdych 5m kontrolovat nove pujcky na Zonky.cz trzisti a ty vypise. Programove API Zonky trziste je dostupne na adrese https://api.zonky.cz/loans/marketplace dokumentace http://docs.zonky.apiary.io/#). Vyber technologii nechame na Vas, jenom at je to prosim v Jave.

Řešení úkolu: V dokumentaci na apiary http://docs.zonky.apiary.io je uvedený endpoint "https://api.zonky.cz/loans/marketplace" , užitečná informace je zde o filtru konkrétně "datePublished__gt". Pro efektivní získání záznamu ```bash
                                            curl -i -X GET \
                                             'https://api.zonky.cz/loans/marketplace?datePublished__gt=2019-10-17T14%3A00%3A00.0024785'
                                            ```

## Instalace
Pro sestavení aplikace použijeme maven příkaz 
``` mvn clean install```

Pro běh pak  
``` java -jar ./target/restclient-0.0.1-SNAPSHOT.jar```

##Technologie
V projektu je použito : Spring , Jersey , Lombok , Mockito , Junit.

##Popis
Projekt je rozdělen  :

1, factory - odpovědna za inicializaci webového klienta

2, model - uložené modely(entity)
 
3, service - logika aplikace

4, task - tisk 

5, test - testovací třídy




 