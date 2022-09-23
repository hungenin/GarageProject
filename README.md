## GARAGE PROJECT

The task:
```
A feladat egy garázs és benne elhelyezhető járművek modellezése Java 17-ben.



A garázsban el lehet helyezni járműveket, és azokat ki is lehet venni.

A garázs kapacítása véges, egész egységben van meghatározva (szóban pl "a garázs mérete 20 egység").

Legyenek tömeges műveletek (legalább 1 mód több jármű elhelyezésére, és 1 mód több jármű kivételére).



A modellben legyen legalább háromféle jármű típus (osztályok szintjén).

Minden jármű rendelkezzen a következő tulajdonságokkal: gyártás éve, szín, kerekek száma, méret (egész egységben meghatározva), tulajdonos (a személy neve).

Minden jármű rendelkezzen egy egyértelmű azonosítóval.

A modellben legyenek olyan jármű tulajdonságok is, amikkel nem rendelkezik minden típusú jármű.



Legyen hibakezelés.

Legyen logozás (konzolra elég).

A program futása egy fix scenario legyen, ami a modell minden elemét demonstrálja (user input nincs).

Ne használj semmilyen JDK-n kívüli library-t vagy frameworkot.
```

#

How to compile:
```shell
javac --target 17 -d target/classes -classpath . src/main/java/com/genin/Main.java src/main/java/com/genin/model/*.java src/main/java/com/genin/service/*.java
```

How to run:
```shell
java -cp target/classes com.genin.Main
```