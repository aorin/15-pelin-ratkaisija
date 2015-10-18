# Käyttöohjeet

Tiedosto 15-pelin-ratkaisija.jar sijaitsee hakemiston juuressa. Ohjelma voidaan suorittaa komentoriviltä komennolla "java -jar 15-pelin-ratkaisija.jar".

Ohjelman tarkoituksena on ratkaista satunnaisia tai syötettyjä 15- tai 8-pelejä. Pelin tavoitteena on saada numerot suuruusjärjestykseen siirtämällä yksi kerrallaan tyhjän paikan vieressä olevia paloja tyhjän paikan tilalle.

## Toiminnot
### Uusi
Arpoo uuden satunnaisen pelin.

### Ratkaise
Aloittaa pelin ratkaisun hakemisen. Jos peliä, ei ole mahdollista edes ratkaista, ohjelma ilmoittaa siitä.

### Siirtäjä
Kun ratkaisu on löytynyt, on mahdollista käynnistää automaattisiirtäjä, joka siirtää pelin paloja niin, että saavutetaan ratkaisutila. Siirtoja voi kelata myös nuolinäppäinten avulla, oikealla näppäimellä mennään yksi siirto eteenpäin ja vasemmalla yksi taaksepäin.

### 8-peli/15-peli
Ohjelmassa on mahdollista vaihtaa kahden erikokoisen pelin välillä, 8-pelin ja 15-pelin välillä.

### Vaihda heurestiikkaa
On mahdollista vaihtaa ratkaisualgoritmin apuna käyttämää heurestiikkaa. Oletuksena ohjelma käyttää Manhattan-etäisyys lineaaristen konfliktien kanssa-heurestiikaa, mutta sen voi vaihtaa myös Manhattan-etäisyys-heurestiikaksi.

### Syötä uusi
Käyttäjä voi syöttää myös haluamansa 15- tai 8-pelin ohjelmaan. Kun kaikki numerot on syötetty, painamalla enteriä tai siirtymällä toiseen ruutuun ohjelma hyväksyy pelin, jos se on syötetty oikein. 15-peli tulee sisältää numerot 1-15 ja 8-peli numerot 1-8. Luvun 0 voi syöttää tai olla syöttämättä tyhjän ruudun paikalle.
