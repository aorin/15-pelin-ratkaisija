# Viikkoraportti 4

Tällä viikolla sain nopeutettua IDA\*:n toimintaa. Lisäämällä algoritmiin tarkistuksen, ettei etsintä kulje samaa polkua taaksepäin, sen toiminta nopeutui huomattavasti. Tein myös muita pieniä muutoksia algoritmin rakenteeseen. Nykyään sillä kuluu joidenkin 15-pelien ratkaisemiseen vain muutama sekunti, mutta enemmän siirtoja vaativissa asetelmissa aikaa kuluu vieläkin paljon. Voisi yrittää vielä vähän nopeuttaa sitä.

Aloin toteuttamaan luokkaa ManhattanDistanceWithConflicts. En saanut sitä vielä täysin toimimaan, luokan LinearConflicts metodissa changeBetweenStates on vielä jotain korjattavaa. Seuraavaksi aion ainakin saada sen korjattua.

Tällä viikolla tein myös vertaisarvioinnin ja aloitin kirjoittamaan toteutusdokumenttia ja hiukan testausdokumenttia. Lisäsin JUnit-testejä kaikille algoritmeille. Suorituskykytestausta varten tein ohjelmaan luokat IDAStarEfficiencyTester ja EfficiencyTester. En vielä kirjoittanut mitään arvoja ylös, ensi viikolla aloitan varsinaisesti suorituskyvyn testauksen.
