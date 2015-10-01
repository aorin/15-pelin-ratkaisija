#Toteutusdokumentti

##Yleisrakenne
Ohjelmassa on luokka GameboardGenerator, jonka avulla voidaan luoda satunnaisia 3x3 tai 4x4 kokonaislukutaulukoita 8-peliä tai 15-peliä varten. 3x3-taulukko sisältää luvut 0-8 ja 4x4 luvut 0-15, missä 0 merkitsee tyhjää ruutua. Lukujen arpomiseen luokka käyttää avukseen Javan valmista Random-luokkaa.

Luokka käynnistetään Main-luokasta, joka luo uuden 15-pelin GameboardGenerator-luokan avulla ja käynnistää graafisen käyttöliittymän. Käyttäjä voi vaihtaa 8-pelin ja 15-pelin välillä, arpoa uuden pelin ja aloittaa pelin ratkaisemisen.

Pelin ratkaisu perustuu IDAStar-algoritmiin. Algoritmissa käytettään Heuristic-rajapinnan oliota, jonka tarkoitus on arvioida siirtojen määrä nykyisestä tilasta tavoitetilaan. Algoritmi on iteratiivinen, eli ennen sen search-metodin kutsumista asetetaan raja, jota pidemmälle syvyyshakua ei jatketa. Rajaa kasvatetaan ja search-metodia kutsutaan niin kauan, että ratkaisu saavutetaan. Iteratiivisen ominaisuutensa takia algoritmi ei ole niin vie niin paljon tilaa kuin normaali syvyyshaku.

Ohjelmassa käytetään jäljellä olevien siirtojen määrän laskemiseen Manhattan-etäisyys funktiota. Funktio laskee jokaisen palan paitsi etäisyyden tavoitepaikkaansa. Ohjelmassa on myös luokka ManhattanDistanceWithConflicts, missä Manhattan-etäisyyden lisäksi arvioon lisätään mahdolliset lineaariset konfliktit.

##Aika- ja tilavaativuudet

##Puutteet ja parannusehdotukset
Vaikka algoritmi ratkaisee useimmat 15-pelit kohtuullisessa ajassa, ratkaisuun kuluvien siirtojen määrän kasvaessa liian suureksi, ohjelmalla menee liian kauan ratkausun saavuttamiseen. Enimmillään 15-pelin ratkaisuun voi tarvita jopa 80 siirtoa. Algoritmia voisi nopeuttaa ottamalla käyttöön "disjoint pattern database" -heuristiikka. Sen ideana on jakaa laatat osajoukkoihin ja luoda tietokanta, joka sisältää jäljellä olevien siirtojen arvion jokaisesta erilaista tilanteesta. 
