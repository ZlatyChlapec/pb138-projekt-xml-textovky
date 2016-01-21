
# Introduction #

Projekt pro předmět PB138 - Moderní značkovací jazyky a jejich aplikace.


# Details #

Výstupem projektu by byla grafická, případně textová aplikace  (pravděpodobně v jazyce Java), která by zpracovávala XML soubory, které by obsahovaly informace o aktuální scéně, na které hráč právě stojí, možnostech, které hráč má k dalším
krokům a podobně a umožnila hráči na základě voleb zobrazit nový uzel v XML stromu, a takto odehrát de facto celé dobrodružství. Aby se skutečně jednalo o hru, mohl by být implementován i systém uzlů, na kterých hráčova postava "zemře" => současná relace se ukončí a podle jeho postupu (například při detektivní zápletce by součástí některých atributů pro změnu scény mohla být informace o změně "skore" při provedení této volby) by se mu nabídlo buď pokračování od některého bodu, anebo restartování celé aplikace.
Cílem úkolu by pak byl vznik nejen samotného parseru na procházení herních stromů a hraní hry, ale také vznik co nejpodrobnější a uživatelsky přívětivé dokumentace na vytváření dobrodružství, uchovávaných v XML dokumentech, která by uživatelé aplikace mohli sami tvořit.

# JavaDoc #

[JavaDoc.zip](https://mega.co.nz/#!h8hyXQxD!aPj1dz80a1pEUWyKeC4CGr1tvelEAKxeqLeUt8K_5So)

# Rozdelenie úloh #

  * Štefan Malček - unit testing, tvorba scenára
  * František Sedláček - vytvorenie hry a in-game manuálu, návrh XML Scheme, tvorba wiki stránok
  * Filip Sonta - parsovanie XML do objektového modelu, validácia XML
  * Martin Zaťko - tvorba a nastavenia GUI

# Komunikácia a použité nástroje #

  * Java 1.7
  * Netbeans IDE
  * Subversion
  * JUnit Testing Framework
  * Apache Maven
  * Skype

# Odkazy na záverečné správy členov tímu #

  * Štefan Malček [.xml](http://www.fi.muni.cz/~xmalcek1/PB138/sprava.xml) [.html](http://www.fi.muni.cz/~xmalcek1/PB138/sprava.html)
  * František Sedláček [.xml](http://is.muni.cz/www/397507/49284969/FinalReport.xml) [.html](http://is.muni.cz/www/397507/49284969/FinalReport.html)
  * Filip Sonta [.xml](http://www.fi.muni.cz/~xsonta/PB138/sonta_sprava.xml) [.html](http://www.fi.muni.cz/~xsonta/PB138/sonta_sprava.html)
  * Martin Zaťko [.xml](http://mober.net/PB138.sprava.xml) [.html](http://mober.net/PB138.sprava.html)

# Jak vytvořit vlastní scenáře #

  https://github.com/ZlatyChlapec/pb138-projekt-xml-textovky/wiki/Jak-vytvo%C5%99it-vlastn%C3%AD-scen%C3%A1%C5%99e
