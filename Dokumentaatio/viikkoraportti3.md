# Viikkoraportti 3

Tällä viikolla toteutin algoritmin pelin ratkaistavuuden selvittämiseen ja IDA\*-algoritmin. Pelin ratkaistavuuden selvittävä algoritmi oli aika helppo toteuttaa, toisin kuin IDA\*. IDA\* toimii tällä hetkellä hyvin pienillä 3x3-taulukoilla, mutta 4x4 taulukoiden ratkaisemiseen kuluu useita minuutteja. Algoritmia pitäisi yrittää saada vielä jotenkin nopeammaksi.

Tietorakenteista toteutin yksinkertaisen listan. Lisäksi aloin totetuttamaan AVL-puuta, jota voisi käyttää avain-arvo-parien tallentamiseen.  

Seuraavaksi haluisin saada pelin ratkaisualgoritmin toimimaan nopeammin. Voisi kokeilla käyttää siinä myös muita heuristisia funktioita kuin nyt käytössä olevaa Manhattan-etäisyys funktiota. Lisäksi jos aikaa on, voisi kokeilla toteuttaa vertailun vuoksi jonkun muunkin ratkaisualgoritmin, kuten A*:n.
