package cz.muni.fi.pb138;

import javax.swing.*;

/**
 * @author Martin Zaťko
 * @version 10.6.2014
 */
public class GUIAbout extends JFrame {

    public GUIAbout() {
        initComponents();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBar(null);

        jLabel1.setText("<html>\n" +
                "<body>\n" +
                "<h1>Dokumentace k programu Textovky</h1>\n" +
                "<b>Program vznikl jako projekt v rámci výuky předmětu PB138 - Moderní značkovaci jazyky a jejich aplikace na Fakultě informatiky Masarykovy univerzity v Brně.</b>\n" +
                "<p>Program umožňuje odehrávat jednoduché textové hry (textovky) prostřednictvím přiloženého rozhraní. Scénáře her si hráči mohou tvořit sami.</p>\n" +
                "<br>\n" +
                "<h2>Obsah:</h2><br>\n" +
                "<a href=\"#uvod\">Popis schématu</a><br>\n" +
                "<a href=\"#markup\">Popis značek</a><br>\n" +
                "<ul>\n" +
                "    <li><a href=\"#game\">Značka &lt;game&gt;</a></li>\n" +
                "    <li><a href=\"#scene\">Značka &lt;scene&gt;</a></li>\n" +
                "    <li><a href=\"#name\">Značka &lt;name&gt;</a></li>\n" +
                "    <li><a href=\"#description\">Značka &lt;description&gt;</a></li>\n" +
                "    <li><a href=\"#chocies\">Značka &lt;choices&gt;</a></li>\n" +
                "    <li><a href=\"#chocie\">Značka &lt;choice&gt;</a></li>\n" +
                "</ul>\n" +
                "<br>\n" +
                "<h2><a id=\"uvod\">Schéma</a></h2>\n" +
                "<p>Základem scénářů je příběh, uložený ve formátu xml, který je možné po vytvoření načíst do ovládacího programu a odehrát.</p>\n" +
                "<p>Každý takovýto příběh musí mít následující strukturu (podrobněji viz jednotlivé odkazy:)</p>\n" +
                "<ul><li>&lt;<a href=\"#game\">game</a> name=\"jmeno\" startingScene=cislo&gt;\n" +
                "    <ul>\n" +
                "        <li>\n" +
                "            &lt;<a href=\"#scene\">scene</a> id=\"#cislo\"&gt;\n" +
                "            <ul>\n" +
                "                <li>&lt;<a href=\"#name\">name</a>&gt;Jméno scény&lt;<a href=\"#name\">/name</a>&gt;</li>\n" +
                "                <li>&lt;<a href=\"#description\">description</a>&gt;Popis scény, neboli co se ve hře děje<a href=\"#description\">&lt;/description&gt;</a></li>\n" +
                "                <li>\n" +
                "                    &lt;<a href=\"#choices\">choices</a>&gt;\n" +
                "                    <ul>\n" +
                "                        <li>&lt;choice goTo=\"#cislo\" points=\"cislo\"&gt;Volba akce pro danou scénu&lt;/choice&gt;</li>\n" +
                "                        <li>...</li>\n" +
                "                    </ul>\n" +
                "                    &lt;<a href=\"#choices\">/choices</a>&gt;\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "    &lt;<a href=\"#game\">/game</a>&gt;\n" +
                "</li>\n" +
                "</ul>\n" +
                "<br>\n" +
                "<p>Každá hra musí obsahovat minimálně dvě scény, z nichž jedna musí být počáteční. Tu určuje atribut startingScene u první značky hry.</p>\n" +
                "<p>Hra se skládá z jednotlivých scén, mezi kterými je možné přecházet prostřednictvím voleb. Z toho důvodu musí každá scéna mít definované své ID, které slouží jako informace pro navigaci.</p>\n" +
                "<p>Každá scéna kromě poslední obsahuje volby akcí, které je možné v ní udělat. Tyto akce se nachází ve značce &lt;choices&gt;, která je párová a značí výčet jednotlivých možností.<br>Tyto volby mohou být maximálně čtyři. Pokud má být scéna poslední, nechte tento výčet prázdný.</p>\n" +
                "<br/>\n" +
                "<a id=\"markup\"><h2>Seznam značek</h2></a>\n" +
                "<br><br>\n" +
                "<a id=\"game\"><h3>Značka &lt;game&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: není<br>\n" +
                "    Musí obsahovat: <a href=\"#scene\">&lt;scene&gt;</a> (alespoň dvakrát)\n" +
                "    Má atributy: #name a #startingScene\n" +
                "    Příklad zápisu: &lt;game name=\"Enderova hra\" startingScene=\"1\"&gt;\n" +
                "</i>\n" +
                "<p><b>Párová značka, každá otevřená scéna musí být ukončená odpovídajícím &lt;/scene&gt;</b></p>\n" +
                "<p>Touto značkou se uvozuje celá hra. Značka je na nejvyšší úrovni a má dva <b>attributy</b> - <b><i>name</i></b> a <b><i>startingScene</i></b>.</p>\n" +
                "<p>Každý sobour se hrou může obsahovat nanejvýš jednu takovouto značku, to znamená, že v nahratelném souboru musí být vždy právě jedna hra.</p>\n" +
                "<p>Atribut <b><i>name</i></b> slouží pro snazší identifikaci hry při prohlížení souboru. Atribut <b><i>startingScene</i></b> udává, na které číslo scény má program přejít po otevření souboru. Jinými slovy jde o první zobrazenou scénu.</p>\n" +
                "<p>Na konec hry, tedy jakmile jsme zapsali všechny scény a další údaje, musíme vložit ukončující značku &lt;/game&gt;.</p>\n" +
                "<br>\n" +
                "<a id=\"scene\"><h3>Značka &lt;scene&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: <a href=\"#game\">&lt;game&gt;</a><br>\n" +
                "    Musí obsahovat: <a href=\"#name\">&lt;name&gt;</a>,<a href=\"#description\">&lt;description&gt;</a> a <a href=\"#choices\">&lt;choices&gt;</a><br>\n" +
                "    Má atributy: #id<br>\n" +
                "    Příklad zápisu: &lt;scene id=\"1\"&gt;<br>\n" +
                "</i>\n" +
                "<p><b>Párová značka, každá otevřená scéna musí být ukončená odpovídajícím &lt;/scene&gt;</b></p>\n" +
                "<p>Tato značka se nachází uvnitř značky &lt;game&gt; a slouží k označení scén ve hře. Každá hra musí mít minimálně dvě scény - počáteční a koncovou.</p>\n" +
                "<p>Označuje začátek scény. Musí mít <b>atribut</b> <b><i>id</i></b>. Ten slouží pro identifikaci scén pro účely programu a také pro značku choice jako parametr pro přechod.</p>\n" +
                "<p>Na konec scény, tedy jakmile jsme zapsali její jméno, popis a volby, které v ní můžeme udělat, musíme vložit ukončující značku &lt;/scene&gt;.</p>\n" +
                "<br>\n" +
                "<a id=\"name\"><h3>Značka &lt;name&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: <a href=\"#scene\">&lt;scene&gt;</a><br>\n" +
                "    Formát obsahu: Text<br>\n" +
                "    Příklad zápisu: &lt;name&gt;Jméno scény&lt;/name&gt;<br>\n" +
                "</i>\n" +
                "<p><b>Párová značka, každé jméno musí být ukončené odpovídajícím &lt;/name&gt;</b></p>\n" +
                "<p>Značka name udává jméno scény, které se zobrazí ve hře. Musí být uvedena v každé scéně právě jednou a obsahovat alespoň jeden zobrazitelný znak.</p>\n" +
                "<br>\n" +
                "<a id=\"description\"><h3>Značka &lt;description&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: <a href=\"#scene\">&lt;scene&gt;</a><br>\n" +
                "    Formát obsahu: Text<br>\n" +
                "    Příklad zápisu: &lt;description&gt;V lese se tě snaží sežrat vlk.&lt;/description&gt;<br>\n" +
                "</i>\n" +
                "<p><b>Párová značka. Popis scény musí být ukončen odpovídajícím &lt;/description&gt;</b></p>\n" +
                "<p>Tato značka se nachází uvnitř scény a udává informace o tom, co postava vidí, nebo co se v dané scéně děje. Musí být v každé scéně právě jednou.</p>\n" +
                "<br>\n" +
                "<a id=\"choices\"><h3>Značka &lt;choices&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: <a href=\"#scene\">&lt;scene&gt;</a><br>\n" +
                "    Obsahuje: &lt;choice&gt; (až čtyřikrát)<br>\n" +
                "    Příklad zápisu: &lt;name&gt;Jméno scény&lt;/name&gt;<br>\n" +
                "</i>\n" +
                "<p>Značí počátek pro zápis voleb, které je možné v dané scéně udělat.<br>\n" +
                "    Tato značka se musí vysktovat právě jednou uvnitř každé scény. Jednotlivé volby (až čtyři) jsou potom zadány jako značky uvnitř této.<br>\n" +
                "    Značka slouží i k označení poslední scény hry. V takovém případě ji použijeme prázdnou, to jest nedáme mezi její otevření a zavření žádnou značku <a href=\"#choice\">&lt;choice&gt;</a>.\n" +
                "</p>\n" +
                "<br>\n" +
                "<a id=\"choice\"><h3>Značka &lt;choice&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: <a href=\"#choices\">&lt;choices&gt;</a><br>\n" +
                "    Formát obsahu: Text<br>\n" +
                "    Má atributy: #goTo, #points\n" +
                "    Příklad zápisu: &lt;choice&gt;<br>\n" +
                "</i>\n" +
                "<p><b>Párová značka. Musí být uzavřena odpovídající značkou &lt;/choice&gt;</b></p>\n" +
                "<p>Značka se používá pro jednotlivé volby, které může uživatel udělat v rámci scény. Má atributy <b><i>goTo</i></b> a <b><i>points</i></b>.<br>\n" +
                "    Atribut <b><i>goTo</i></b> slouží pro nastavení identifikace scény, která se zobrazí po vybrání dané volby. Jeho hodnota musí být shodná s id některé existující scény.<br>\n" +
                "    Atribut <b><i>points</i></b>Slouží k ohodnocení hráčova postupu. Může obsahovat libovolné celé číslo.</p>\n" +
                "<br>\n" +
                "<a id=\"text\"><h3>Značka &lt;text&gt;</h3></a>\n" +
                "<i>\n" +
                "    Nadřazená značka: <a href=\"#scene\">&lt;choice&gt;</a><br>\n" +
                "    Formát obsahu: Text<br>\n" +
                "    Příklad zápisu: &lt;text&gt;Vysmeknout se vlkovi.&lt;/text&gt;<br><br><br>\n" +
                "</i>\n" +
                "</body>\n" +
                "</html>");
        jLabel1.setVerticalAlignment(SwingConstants.TOP);
        jScrollPane1.setViewportView(jLabel1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(getOwner());
    }

    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
}
