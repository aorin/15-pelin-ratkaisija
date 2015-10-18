# Määrittelydokumentti

15-peli on ongelmapeli, jossa 15 numeroitua laattaa on sijoitettu 4 x 4 kokoiseen kehykseen ja jossa yritetään saada laatat numerojärjestykseen siirtämällä niitä aina yksi laatta kerrallaan tyhjänä olevaan ruutuun. Tavoitteena on tehdä pelille ratkaisija, joka ratkaisee pelin mahdollisimman nopeasti ja vähillä siirroilla. Lisäksi ratkaisijan tulisi tunnistaa mieluiten jo alkuvaiheessa mikäli annettu peli on mahdoton ratkaista. 

## Syöte
Syötteenä algoritmille annetaan kaksiulotteinen taulukko, joka sisältää tiedon numerolaattojen alkusijainnista.

## Tarvittavat algoritmit ja tietorakenteet
### Algoritmit
#### Inversioiden laskeminen
Pelin ratkaistavuus voidaan selvittää käyttämällä algoritmia, joka laskee inversioiden lukumäärän.
#### IDA* (Iterative Deepening A Star)
IDA* on polunhakualgoritmi, jonka avulla voidaan löytää pienin määrä siirtoja alkuasetelmasta ratkaisuun. Jokainen erilainen pelitilanne voidaan nähdä solmuna ja mahdolliset siirtymät tilojen välillä kaarina, jolloin tilannetta voidaan mallintaa verkkona. Ratkaisuun vievien siirtojen määrän arvioimiseen tarvitaan jonkinlaista heuristista funktiota, kuten Manhattan distance -funktiota.
### Tietorakenteet
IDA*:n toteutuksen apuna tarvitaan joukkoa. 

## Aika- ja tilavaativuudet
IDA*:n ja samalla koko algoritmin tilavaativuus on O(bd), missä b on ratkaisupuun haarojen määrä ja d on ratkaisusolmun korkeus. 15-pelin lyhimmän ratkaisun löytäminen on NP-vaikea tehtävä, joten aikavaativuus tulee olemaan korkea.

## Lähteet
https://en.wikipedia.org/wiki/15_puzzle
https://en.wikipedia.org/wiki/Iterative\_deepening_A*
https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
http://heuristicswiki.wikispaces.com/Manhattan+Distance
