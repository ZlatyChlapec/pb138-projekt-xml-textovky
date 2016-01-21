


# Úvod #

Seznam XML značek použitých v projetu a jejich specifikace tak, jak jsou uvedeny v XML schématu v souboru _textGameXmlSchema.xsd_ (dále jen XSD).


# Detaily #

## Element `<game>` ##

Kořenovým atributem každého herního souboru je párová značka `<game>`, která uzavírá každý herní scénář. Samotná značka je v XSD definována takto:
```
    <xsd:element name="game" type="gameType">
        <xsd:unique name="sceneUnique">
            <xsd:selector xpath="./scene"/>
            <xsd:field xpath="./@id"/>
        </xsd:unique>
    </xsd:element>
```

Jak je z definice značky patrné, má typ gameType a jejími potomky jsou scény, které mají unikátní scene id. Samotný **gameType** má následující XSD definici:
```
    <xsd:complexType name="gameType">
        <xsd:sequence>
            <xsd:element name="scene" type="sceneType" minOccurs="2" maxOccurs="unbounded"/>
        </xsd:sequence>
        <xsd:attribute name="name" type="nonEmptyString" use="required"/>
        <xsd:attribute name="startingScene" type="xsd:positiveInteger" use="required"/>
    </xsd:complexType>
```

Jinými slovy každá hra má jako atributy své jméno, které slouží pro její identifikaci, a informaci o id startovní scény. Jméno hry je také po dobu, kdy je hra načtená v aplikaci, zobrazeno v záhlaví jako název okna.
Nastavení id startovní scény je nastaveno proto, aby v případě složitějších scénářů, které například zahrnují více lokací s desítkami provázaných scén, měl autor větší volnost volby. Uvažme například, že je hra tvořena více lokacemi, z nichž každá má více scén a i když hráč mezi nimi může procházet, autor hry chce, aby bylo jasné která lokace má které scény. Pak může id scén chtít nastavit například na XXYYY, kde XX je kód lokace a YYY kód scény. První scéna pak může nést číslo 1001.


## Element `<scene>` ##

Je párová značka, použitá pro zobrazení jednotlivých scén v příběhu. Vlastní definice tohoto elementu v XSD je následující:
```
<xsd:element name="scene" type="sceneType" minOccurs="2" maxOccurs="unbounded"/>
```

Každá hra tedy musí obsahovat minimálně dvě scény - startovní a konečnou. Maximální počet scén není omezen. Každá scéna musí mít své jméno, které je při běhu programu zobrazeno v záhlaví, nad jejím obsahem. Scéna je definována svým vlastním typem sceneType, který vypadá takto:
```
   <xsd:complexType name="sceneType">
        <xsd:sequence>
            <xsd:element name="name" type="nonEmptyString" minOccurs="1" maxOccurs="1"/>
            <xsd:element name="description" type="xsd:string" minOccurs="1" maxOccurs="1"/>
            <xsd:element name="choices" type="choicesType" minOccurs="1" maxOccurs="1"/>
        </xsd:sequence>
        <xsd:attribute name="id" type="xsd:positiveInteger" use="required"/>
    </xsd:complexType>
```
Scéna tedy má poměrně pevně danou strukturu. Jejím jediným atributem je atribut id, který slouží jako identifikační číslo scény a je vyžadovaný. Tento fakt program při načítání hry sám validuje.
Každá scéna pak musí obsahovat jméno, které je definováno uživatelským typem nonEmptyString, popis, uzavřený v párové značce `<description>`, který se uživateli zobrazí v hlavním dialogovém okně programu jako informace o samotné scéně. Poslední částí scény je `<choices>` element, který obsahuje volby, které uživatel v dané scéně může udělat. Ten je definován pomocí uživatelského typu `<choicesType>`.


## Element `<name>` ##

Párový element, který je povinně obsažen v každém elementu scene. Jeho XSD definice je:
`<xsd:element name="name" type="nonEmptyString" minOccurs="1" maxOccurs="1"/>`
Jde tedy o textový řetězech uživatelského typu nonEmptyString. Tento typ definuje XSD takto:
```
<xsd:simpleType name="nonEmptyString">
         <xsd:restriction base="xsd:string">
             <xsd:minLength value="1"/>
         </xsd:restriction>
</xsd:simpleType> 
```
Jde tedy o rozšíření základního typu string o podmínku minimální délky jednoho znaku. Scéna tedy nemůže být bezjmenná nebo mít více jmen, a její jméno musí vždy mít minimálně jeden znak.


## Element `<description>` ##

Je obsažen v každé scéně a definuje její obsah. Jedná se o element základního typu xsd:string s touto definicí:
```
<xsd:element name="description" type="xsd:string" minOccurs="1" maxOccurs="1"/>
```
Text, obsažený v tomto elementu, se v aplikaci zobrazí v okně pod jménem scény, a je následován možnými volbami dalšího postupu.


## Element `<choices>` ##

Jde o povinný element, do kterého se uzavírá seznam voleb, které může uživatel v dané scéně vykonat. Je povinný a může obsahovat 0 - 4 volby, přičemž pokud neobsahuje žádnou, je scéna programem vyhodnocena jako závěrečná a uživateli se zároveň s popisem scény zobrazí zpráva, že se dostal na konec. Zápis elementu podle XSD je následující:
```
<xsd:element name="choices" type="choicesType" minOccurs="1" maxOccurs="1"/>
```
Přičemž odpovídající typ _choicesType_ je definován takto:
```
<xsd:complexType name="choicesType">
         <xsd:sequence>
             <xsd:element name="choice" type="choiceType" minOccurs="0" maxOccurs="4"/>
         </xsd:sequence>
</xsd:complexType> 
```

### Element `<choice>` ###

Vyskytuje se uvnitř elementu `<choices>` a to 0 až 4 krát. Představuje volby, které v dané scéně může udělat uživatel. Samotný `<choice>` element je definován takto:
```
<xsd:element name="choice" type="choiceType" minOccurs="0" maxOccurs="4"/>
```
Přičemž jeho typ je uživatelský typ choiceType s následující definicí:
```
<xsd:complexType name="choiceType">
         <xsd:sequence>
             <xsd:element name="text" type="nonEmptyString" minOccurs="1" maxOccurs="1"/>
         </xsd:sequence>
         <xsd:attribute name="goTo" type="xsd:positiveInteger" use="required"/>
</xsd:complexType>
```
Každý element choice tedy má atribut goTo, který uznačuje scénu, na kterou se uživatel přesune po zvolení dané volby, a obsahuje text typu nonEmptyString (typová defnicice v [#Element\_&lt;name&gt;](#Element_<name>.md)).
Součástí elementu `<choice>` je také element `<text>`, do kterého se uzavírá daná volba. Syntaxe elementu je následující:
```
<xsd:element name="text" type="nonEmptyString" minOccurs="1" maxOccurs="1"/>
```
Jde tedy o povinný element, s uživatelsky definovaným typem nonEmptyString.

Dohromady tyto typy tvoří kostru hry.