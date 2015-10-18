#Toteutusdokumentti

##Yleisrakenne
Ohjelmassa on luokka GameboardGenerator, jonka avulla voidaan luoda satunnaisia 3x3 tai 4x4 kokonaislukutaulukoita 8-peliä tai 15-peliä varten. 3x3-taulukko sisältää luvut 0-8 ja 4x4 luvut 0-15, missä 0 merkitsee tyhjää ruutua. Lukujen arpomiseen luokka käyttää avukseen Javan valmista Random-luokkaa.

Luokka käynnistetään Main-luokasta, joka luo uuden 15-pelin GameboardGenerator-luokan avulla ja käynnistää graafisen käyttöliittymän. Käyttäjä voi vaihtaa 8-pelin ja 15-pelin välillä, arpoa uuden pelin, vaihtaa ratkaisussa käytettyä heurestiikkaa ja aloittaa pelin ratkaisemisen.

Ennen pelin ratkaisua ohjelma tarkistaa SolvabilityDeterminer-luokan avulla, onko peliä edes mahdollista ratkaista. Ratkaistavuuden selvittäminen perustuu inversioiden laskemiseen, ruudokon leveyteen ja tyhjän paikan sijaintiin pelilaudalla. Kaava tälle on: Jos ((ruudukon leveys pariton) && (inversioita parillinen määrä))  ||  ((ruudukon leveys parillinen) && ((tyhjä parittomalla rivillä pohjasta katsoen) == (inversioita parillinen määrä))), niin peli on ratkaistavissa,

Pelin ratkaisu perustuu IDAStar-algoritmiin. Algoritmissa käytettään Heuristic-rajapinnan oliota, jonka tarkoitus on arvioida siirtojen määrä nykyisestä tilasta tavoitetilaan. Algoritmi on iteratiivinen, eli ennen sen search-metodin kutsumista asetetaan raja, jota pidemmälle syvyyshakua ei jatketa. Rajaa kasvatetaan ja search-metodia kutsutaan niin kauan, että ratkaisu saavutetaan. Iteratiivisen ominaisuutensa takia algoritmi ei ole niin vie niin paljon tilaa kuin normaali syvyyshaku.

Ohjelmassa käytetään jäljellä olevien siirtojen määrän laskemiseen Manhattan-etäisyys funktiota. Funktio laskee jokaisen palan paitsi etäisyyden tavoitepaikkaansa. Ohjelmassa on myös luokka ManhattanDistanceWithConflicts, missä Manhattan-etäisyyden lisäksi arvioon lisätään mahdolliset lineaariset konfliktit.

##Aika- ja tilavaativuudet
Luokan SolvabilityDeterminen aikavaativuus ja tilavaativuus on vakio O(1). Algoritmi käy koko taulukon läpi, joten sen aikavaativuus on neliöllinen taulukon kokoon nähden, mutta koska taulukon koko on aina vakio (9 tai 16), niin vaativuuskin on vakio.

IDAStar-algoritmin tilavaativuus on O(bd), missä b on ratkaisupuun haarojen määrä ja d on ratkaisusolmun korkeus. Käytännössä se on siis lineaarinen pelin ratkaisuun tarvittavien siirtojen määrään. Aikavaativuudeltaan algoritmi on eksponentiaalinen. 

##Puutteet ja parannusehdotukset
Vaikka algoritmi ratkaisee useimmat 15-pelit kohtuullisessa ajassa, ratkaisuun tarvittavien siirtojen määrän kasvaessa liian suureksi, ohjelmalla menee liian kauan ratkaisun saavuttamiseen. Enimmillään 15-pelin ratkaisuun voi tarvita jopa 80 siirtoa. Suurin, mitä olen algoritmillani testannut, oli 60 siirtoa vaativa peli, jonka ratkaisemiseen kului jo melkein minuutti. Koska ratkaisuun kuluva aika kasvaa eksponentiaalisesti, 80 pelin ratkaiseminen on jo aika mahdotonta ohjelmallani.

Algoritmia voisi nopeuttaa ainakin ottamalla käyttöön "disjoint pattern database" -heuristiikka. Sen ideana on jakaa laatat osajoukkoihin ja luoda tietokanta, joka sisältää jäljellä olevien siirtojen arvion jokaisesta erilaista tilanteesta. Tälläinen heuristiikka olisi n. 1700 kertaa nopeampi kuin Manhattan etäisyys-heuristiikka.

##Lähteet
https://heuristicswiki.wikispaces.com/pattern+database
