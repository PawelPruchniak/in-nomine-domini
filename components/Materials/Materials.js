import styles from './Materials.module.css';

const Materials = () => (
    <div>
        <section className={styles.section}>
            <h2 className={styles.sectionTitle}>Paleografia</h2>
            <hr className={styles.marquise} />
            <div>
                <p>
                    <strong>Paleografia</strong> – (jej nazwa pochodzi z języka greckiego z połączenie słów <em>palaiós</em> - stary i <em>graphō</em> - piszę).
                    Jest to jedna z Nauk Pomocniczych Historii służąca pomocą w odczytywaniu dawnego pisma ręcznego. Początki badań nad nią wiżążą się z benedyktynem Jeanem Mabillon (1632-1707), który dziś uznawany jest za ojca paleografii i dyplomatyki.
                </p>
                <div>
                    <p>
                        Wyróżniamy trzy działy tej nauki:
                    </p>
                    <ol className={styles.numberList}>
                        <li>
                            Badania nad rozwojem historycznym i zmianami wyglądu pisma,
                        </li>
                        <li>
                            Badania służące wykrywaniu kryteriów chronologicznych i geograficznych rozwoju pisma (umieszczanie źródła w czasie i przestrzeni, wykrywanie fałszerstw),
                        </li>
                        <li>
                            Naukę praktycznego odczytywania dawnego pisma.
                        </li>
                    </ol>
                </div>
                <p>
                    To trzeci z działów stanowi powód stworzenia strony, którą obecnie oglądasz.
                </p>
            </div>

            <h2 className={styles.sectionTitle}>Przydatne definicje</h2>
            <hr className={styles.marquise} />
            <div>
                <p>
                    <strong>Manuskrypt</strong> – (łac. <em>manuscriptum</em> - rękopis): każdy tekst, który został utrwalony ręcznie – niezależnie od rodzaju pisma, materiału pisarskiego i techniki pisania. W odróżnieniu od tekstów powielanych mechanicznie, <strong>każdy rękopis jest egzemplarzem niepowtarzalnym</strong> o własnych cechach indywidualnych.
                </p>
                <h3 className={styles.subTitle}>
                    Badaniu w manuskrypcie podlegają:
                </h3>
                <ul className={styles.list}>
                    <li>
                        <strong>Dukt</strong> – (łac. <em>duco</em> – prowadzę) – wygląd pisma wynikający ze sposobu prowadzenia pióra
                    </li>
                    <li>
                        <strong>Kąt pisma</strong> – wygląd pisma ynikający ze stosunku położenia narzędzia pisarskiego względem wiersza
                    </li>
                    <li>
                        <strong>Moduł pisma</strong> – określający jego względne rozmiary
                    </li>
                    <li>
                        <strong>Dyplomatyka</strong> - (nazwa pochodzi z języka greckiego od słowa <em>diplōma</em>, co oznacza „podwójnie złożony”). Jest jedną z Nauk Pomocniczych Historii, a przedmiotem jej badania jest dokument i kancelaria, w której go wytworzono. Dyplomatyka początkowo służyła wykrywaniu fałszerstw, dziś bada dzieje kancelarii, a także historię oraz rodzaje dokumentów, a także cechy zewnętrzne i wewnętrzne tego źródła (w tym materiał na którym został spisany, rodzaje pisma, formuły, układ tekstu oraz jego treść).
                    </li>
                    <li>
                        <strong>Brachygrafia</strong> - (nazwa pochodzi z języka greckiego i jest wynikiem połączenia słów <em>brachýs</em> – krótki oraz <em>graphō</em> – piszę). Jedna z Nauk Pomocniczych Historii służąca odczytywaniu różnych form zapisu wyrazów w wersji skróconej. Systemy stosowanych od starożytności skrótów ulegały przez wieki ewolucji. Ich celem było przyspieszenie oraz usprawnienie pisania, a także zaoszczędzenie cennego materiału pisarskiego. Dziś rozwiązywanie ich stanowi dodatkowe utrudnienie w transkrypcji tekstów rękopiśmiennych – a brachygrafia jest nauką pomagającą w wykonaniu tego zadania.
                    </li>
                </ul>
                <h3 className={styles.subTitle}>
                    Wyróżniamy trzy rodzaje skrótów, z którymi spotykamy się przy lekturze tekstów pisanych:
                </h3>
                <ul className={styles.list}>
                    <li>
                        - suspensja (odcięcie) – kiedy w zapisie wyrazu odnotowano tylko początkową jego część. W języku polskim to przykładowo: lic. – licencjat; prof. – profesor, w języku łacińskim: cap – <em>caput</em> (rozdział), ib, ibid. – <em>ibidem</em> (tamże).
                    </li>
                    <li>
                        - kontrakcję (ściągnięcie) – kiedy w zapisie wyrazu odnotowano początek i koniec wyrazu (lub nawet pojedyncze litery początkową i końcową), jednak w większości usunięto litery środkowe. W języku polskim to przykładowo: dr – doktor; mgr – magister, w języku łacińskim: ca – <em>circa</em> (około); eps – <em>episcopus</em> (biskup).
                    </li>
                    <li>
                        - zapis znaku zamiast konkretnego wyrazu – przykładowo <em>&</em>.
                    </li>
                </ul>
            </div>

            <h2 className={styles.sectionTitle}>Historia i wybrane rodzaje pisma</h2>
            <hr className={styles.marquise} />
            <div>
                <p>
                    W rękopisach w pierwszej kolejności możemy wyróżnić dwa rodzaje zapisu liter – majuskułę i minuskułę. Pierwsza jak nazwa wskazuje składa się z liter o tej samej wysokości, które z łatwością możemy wpisać w dwie linie. Drugi rodzaj zapisu charakteryzuje się tym, że litery wpisują się w cztery linie. Majuskuła była w pierwszej kolejności stosowana na twardym materiale pisarskim, który wymuszał prostszy zapis. Powstanie minuskuły związane jest z wprowadzeniem miękkich materiałów pisarskich, które pozwalały na większe skomplikowanie kreski i większą różnorodność zapisu kształtu liter. Z czasem zmiany w wyglądzie zapisu związane były z upowszechnianiem się pisma, a także z rolą jakie miało odgrywać. W kolejnych wiekach wykształcił się podział na pismo ozdobne charakterystyczne dla pięknych kodeksów oraz pismo o charakterze użytkowym używane szczególnie w kancelariach.
                </p>
                <p>
                    W polskich dokumentach średniowiecznych, które stanowią podstawę niniejszej strony stosowano pismo gotyckie, jednak uważny poszukiwacz manuskryptów wieków średnich może trafić również na inne rodzaje pism, których krótką charakterystykę znajdzie poniżej:
                </p>
                <ul className={styles.list}>
                    <li>
                        <strong>Kapitała</strong> – najstarsza forma pisma majuskulnego (pismo wpisane w dwie linie), od którego wywodzą się wszystkie późniejsze rodzaje pisma łacińskiego. Kapitała była pismem monumentalnym, przeznaczonym do kucia napisów w materiale twardym. Litery są symetryczne i mają identyczną wysokość.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 1 Kapitała kwadratowa" src="Rys.1.png"/>
                                <figcaption>Rys. 1 Kapitała kwadratowa</figcaption>
                            </figure>
                        </div>
                    </li>
                    <li>
                        <strong>Uncjała</strong> – (łac. <em>scriptura uncialis</em>) typ pisma majuskulnego, w którym jednak pojawiają się elementy minuskulne występujący w okresie od IV do X wieku. Uncjała wywodzi się od kapitały, lecz charakteryzuje się tendencją do zaokrąglenia liter.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 2 Uncjała" src="Rys.2.png"/>
                                <figcaption>Rys. 2 Uncjała</figcaption>
                            </figure>
                        </div>
                    </li>
                    <li>
                        <strong>Półuncjała</strong> –pismo, które pojawiło w VI wieku i w przeciwieństwie do wszystkich poprzedzających ją wcześniej rodzajów charakteryzowało się zróżnicowaniem wielkości liter, czyli było krokiem w kierunku pisma minuskulnego. Litery półuncjały były wyraźnie zaokrąglone, pisane płynnie.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 3 Półuncjała" src="Rys.3.jpg"/>
                                <figcaption>Rys. 3 Półuncjała</figcaption>
                            </figure>
                        </div>
                    </li>
                    <li>
                        <strong>Minuskuła karolińska</strong>, (<strong>karolina</strong>) — rodzaj pisma minuskulnego (pisma wpisanego w cztery linie) wypracowany w IX wieku przez kancelarię cesarską Karola Wielkiego we współpracy z akwizgrańską szkołą pałacową, charakteryzujący się dużą czytelnością liter oraz ujednoliconym systemem skrótów.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 4 Minuskuła karolińska" src="Rys.4.png"/>
                                <figcaption>Rys. 4 Minuskuła karolińska</figcaption>
                            </figure>
                        </div>
                    </li>
                    <li>
                        <strong>Pisma gotyckie</strong> – to rodzina krojów pisma opartych na alfabecie łacińskim. Jego początki datuje się na XI wiek, kiedy to obserwuje się pierwsze tendencje do zaostrzania liter minuskuły karolińskiej (północna Francja). W wieku XIII pisma gotyckie były w powszechnym użyciu w całej Europie Zachodniej i Środkowej i tendencja ta utrzymała się do późnego średniowiecza. W większości krajów wyparte zostało dopiero przez tzw. pismo humanistyczne w XV/XVI wieku.
                    </li>
                    <li>
                        <strong>Tekstura</strong> – pismo gotyckie książkowe/kodeksowe stosowane przede wszystkim w XIV wieku. Na jej powstanie wpływ wywarła konieczność zwiększenia szybkości powstawania ksiąg, przez co zastosowano skośnie ścięte, płaskiego pióra, litery i wyrazy stawiane są bardzo blisko siebie.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 6 Tekstura" src="Rys.6.png"/>
                                <figcaption>Rys. 6 Tekstura</figcaption>
                            </figure>
                        </div>
                    </li>
                    <li>
                        <strong>Bastarda</strong> – pismo gotyckie powstałe w XIV w., będące połączeniem tekstury i pisma minuskulnego używanych w Europie południowej. Cechami charakterystycznymi bastardy, które wyraźnie różnią ją od tekstury są m.in.: poszerzenie liter, zwiększenie odstępów pomiędzy literami i pomiędzy całymi wyrazami, zwiększenie interlinii.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 5 Bastarda" src="Rys.5.png"/>
                                <figcaption>Rys. 5 Bastarda</figcaption>
                            </figure>
                        </div>
                    </li>
                    <li>
                        <strong>Kursywa gotycka</strong> – pismo gotyckie stworzone w związku z narastającą koniecznością posługiwania się nim w życiu codziennym. Potrzeba szybkiego pisania, występująca w połączeniu z zaniedbywaniem reguł kaligrafii, doprowadziła do wykształcenia w XIII w. kursywy gotyckiej - pisma używanego głównie na potrzeby bieżące.
                        <div className={styles.imgFigureContainer}>
                            <figure className={styles.imgFigure}>
                                <img alt="Rys. 7 Kursywa gotycka" src="Rys.7.png"/>
                                <figcaption>Rys. 7 Kursywa gotycka</figcaption>
                            </figure>
                        </div>
                    </li>
                </ul>
            </div>

            <h2 className={styles.sectionTitle}>Krótka historia materiałów pisarskich</h2>
            <hr className={styles.marquise} />
            <div>
                <p>
                    Najstarszym używanym miękkim materiałem pisarskim były <strong>tabliczki woskowe</strong> (deseczki drewniane ujęte w ramki, pokryte warstwą wosku). Teksty zapisane na nich były łatwe do starcia, a tabliczkę wykorzystywano wielokrotnie. W związku z tym posiadamy bardzo mało zabytków pisarskich zachowanych na nich. Z kolei <strong>papirus</strong> (wytwarzany z rośliny o tej nazwie rosnącej w dorzeczu Nilu) przez wiele lat był najpowszechniej stosowanym materiałem pisarskim – w średniowieczu używano go w kancelariach władców hiszpańskich, longobardzkich i merowińskich, a najdłużej, bo aż do połowy XI wieku w kancelarii papieskiej. Dla odmiany <strong>pergamin</strong> wytwarzany był ze skóry zwierzęcej (używano przede wszystkim skór owiec, koźląt i cieląt). Pomimo, iż pierwsze próby jego produkcji podjęto już w starożytności jego użycie rozpowszechniło się dopiero w VIII wieku. W średniowieczu był on cenionym i chętnie używanym materiałem pisarskim. Warto zwrócić uwagę na fakt, iż jego produkcja była bardzo kosztowna, w związku z czym zdarzało się, że próbując odzyskać zapisaną kartę pisarze wycierali wcześniejszy tekst i zapisywali nowy – takie pergaminy nazywamy palimpsestami. W średniowieczu znanym materiałem pisarskim był też <strong>papier</strong> wynaleziony przez Chińczyków w I wieku n. e. Sposób jego wytwarzanie był starannie chroniony i dopiero w VIII wieku udało się go zdobyć Arabom. W XII wieku papier przez Hiszpanię dotarł w granice Europy chrześcijańskiej, a jego upowszechnienie nastąpiło w XIII i XIV wieku (co ciekawe pierwszy polski list napisany na papierze pochodzi z 1337 roku i powstał w kancelarii Kazimierza Wielkiego – obecnie przechowywany w Archiwum Watykańskim).
                </p>
                <p>
                    Z kolei narzędzia pisarskie, którymi się posługiwano w dużym stopniu zależały od zastosowanego materiału pisarskiego. Do pisania na tabliczkach woskowych wykorzystywano <strong>rylce</strong> produkowane najczęściej z kości słoniowej lub metalu. Jeden koniec rylca był zaostrzony i służył do zapisywania tekstu, drugi płaski do jego zacierania. Z kolei do pisania po papirusie używano zaostrzonego pióra trzcinowego, a po pergaminie i papierze pisano już zaostrzonym specjalnie piórem ptasim (gęsim, łabędzim).
                </p>
            </div>
        </section>

        <section className={styles.section}>
            <h2 className={styles.sectionTitle}>Bibliografia</h2>
            <hr className={styles.marquise} />
            <ul className={styles.bulletList}>
                <li>
                    Biniaś-Szkopek M., Delimata M., Skrzypczak Ł., <em>Paleografia łacińska – skrypt dla studentów archiwistyki</em>, Poznań 2007
                </li>
                <li>
                    Bischoff B., <em>Latin Paleography: Antiquity and the Middle Ages</em>, Cambridge 1990
                </li>
                <li>
                    Boyle L., <em>Medieval Latin Palaeography: A Bibliographical Introduction</em>, Toronto 1984
                </li>
                <li>
                    Brown M., <em>A Guide to Western Historical Scripts: From Antiquity to 1600</em>, London 1990
                </li>
                <li>
                    Capelli A., <em>Dizionario di abreviature latine et italiane</em>, Milano 1949
                </li>
                <li>
                    <em>Chronologia polska</em>, red. B. Włodarski, Warszawa 1957
                </li>
                <li>
                    Gieysztor A., <em>Zarys dziejów pisma łacińskiego</em>,Warszawa 1973
                </li>
                <li>
                    Gieysztor A., <em>Zarys nauk pomocniczych historii, t. 1</em>, Warszawa 1948, wyd. 3, rozszerzone przy współudziale S. Herbsta
                </li>
                <li>
                    <em>Jak czytać rękopis średniowieczny</em>, red. Paul Géhin,tł. Beata Spieralska, Warszawa 2008.
                </li>
                <li>
                    Krzyżanowski S., <em>Monumenta Poloniae paleographica, tabl. 1-2, fasc. I-II</em>, Cracoviae 1907-1910
                </li>
                <li>
                    Pelzer A., <em>Abreviations latines medievales: supplement au Dizionario di abbreviature latine ed italiane de Adriano Cappelli</em>, Bruxelles 1982
                </li>
                <li>
                    Porębski S. A., <em>Paleografia łacińska – podręcznik dla studentów</em>, Warszawa 1997 (wyd. 2 Warszawa 2005)
                </li>
                <li>
                    Steffens F., Lateinische Paläographie, 2 Auflage, Berlin-Leipzig 1929
                </li>
                <li>
                    Semkowicz W., <em>Paleografia łacińska</em>, Kraków 2002
                </li>
                <li>
                    Stiennon J., <em>Paleographie du Moyen Age</em>, Paris 1991
                </li>
                <li>
                    Szymański J., <em>Nauki pomocnicze historii</em>, Warszawa 2001
                </li>
                <li>
                    Wierzbowski T., <em>Vademecum, Wykaz skrótów i słowniczek łacińsko-polski</em>, Warszawa-Łódź 1984
                </li>
            </ul>
        </section>
    </div>
);

export default Materials;
