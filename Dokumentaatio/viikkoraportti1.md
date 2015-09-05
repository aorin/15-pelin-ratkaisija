# Viikkoraportti 1

Tällä viikolla valitsin aiheen ja aloin kirjoittamaan määrittelydokumenttia. Tutustuin IDA*-algoritmiin ja mietin sen mahdollista toteutustapaa. Algoritmin periaate vaikuttaa kohtalaisen yksinkertaiselta, mutta sisältää monia osia, kuten esim. Manhattan distance -funktion toteuttamisen.

Opin, että IDA\*-algoritmi on samantapainen iteratiivisen syvyyshaun ja A\*-algoritmin kanssa. Normaalista syvyyshausta poiketen iteratiivisessa syvyyshaussa on raja, jota syvemmälle haku ei etene. Rajaa kasvatetaan joka iteraatiokerralla. Samoin kuin A\*-algoritmissa IDA\*-algoritmissa arvoidaan edetyn matkan lisäksi myös sitä kuinka paljon matkaa ratkaisuun vielä on jäljellä.

Tein ohjelman pohjan valmiiksi ja seuraavaksi voisi lähteä toteuttamaan itse algoritmia. Ihan aluksi pitäisi luoda jonkinlainen funktio, jonka avulla saa arvottua satunnaisia 15-pelin alkuasetelmia. Sitten voisi pohtia miten toteutetaan funktio, joka kertoo, onko peli ratkaistavissa vai ei.
