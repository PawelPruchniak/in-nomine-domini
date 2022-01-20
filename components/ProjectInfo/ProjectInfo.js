import styles from './ProjectInfo.module.css';

const ProjectInfo = () => (
    <>
        <section className={styles.section}>
            <h2 className={styles.sectionTitle}>Początek...</h2>
            <p>
                <br/>
                Projekt powstał z myślą o wszystkich osobach, które rozpoczynają swoją przygodę z paleografią łacińską, na czele ze studentami kierunków historia i archiwistyka. Idea stworzenia strony internetowej zrodziła się w roku 2012, kiedy we współpracy dr hab. Magdaleny Biniaś-Szkopek z Wydziału Historii Uniwersytetu im. Adama Mickiewicza w Poznaniu z dr. Rafałem Witkowskim oraz studentami Wydziału Matematyki i Informatyki Uniwersytetu im. Adama Mickiewicza w Poznaniu stworzono pierwszy prototyp programu o nazwie „In nomine Domini” służący podstawom nauki o transkrypcji rękopiśmiennych tekstów łacińskich z okresu średniowiecza. Z kolei w roku 2021 z zaangażowaniem nowej grupy studentów Wydziału Matematyki i Informatyki podjęto działania nad stworzeniem nowej, atrakcyjnej odsłony projektu – powiększając zarówno zakres udostępnionych tekstów jak i wybór rodzajów ćwiczeń.
            </p>
        </section>
        <section className={styles.section}>
            <h2 className={styles.sectionTitle}>Cel projektu</h2>
            <p>
                <br/>
                Istotnym celem powstania projektu było umożliwienie użytkownikom pracy na doskonałej jakości fotografiach wybranych dokumentów średniowiecznych, a także poprzez udostępnienie narzędzi do wykonania transkrypcji zachęcenie ich do samodzielnej pracy nad rozwijaniem swych umiejętności w zakresie paleografii łacińskiej.
                <br/>
                <br/>
                Projekt służyć ma nie tylko studentom historii i archiwistyki, ale także użytkownikom archiwów i bibliotek, którzy choćby na gruncie wzmożonych badań genealogicznych coraz aktywniej korzystają z rękopiśmiennych materiałów archiwalnych, powstałych w różnych okresach. Umiejętność czytania pisma ręcznego, a także znajomości łaciny stanowiących niegdyś podstawę komunikacji zanika we współczesnym społeczeństwie, stąd niniejszy projekt jest także próbą spowolnienia tego procesu i zwiększenia zainteresowania paleografią w środowiskach poza uczelniami wyższymi i instytutami naukowymi.
            </p>
        </section>
        <section className={styles.section}>
            <h2 className={styles.sectionTitle}>Twórcy</h2>
            <p>
                <br/>
                Pomysłodawcą projektu była dr hab. Magdalena Biniaś-Szkopek natomiast inicjatorem działań z zakresu stworzenia odpowiedniego oprogramowania dr Rafał Witkowski. Całkowicie nową wersję strony i jej funkcjonalności stworzył zespół studentów Wydziału Matematyki i Informatyki Uniwersytetu im. Adama Mickiewicza w Poznaniu w składzie: Edyta Jarzębska, Dawid Piskadło, Paweł Pruchniak, Krzysztof Szostak.
            </p>
        </section>
        <section className={styles.section}>
            <h2 className={styles.sectionTitle}>Materiały</h2>
            <p>
                <br/>
                Na umieszczenie swoich materiałów rękopiśmiennych, które stanowią podstawę dla ćwiczeń projektowych wyraziły zgodę Polska Akademia Nauk Biblioteka Kórnicka oraz Archiwum Państwowe w Poznaniu. Manuskrypty ze zbiorów tych instytucji stanowią zatem podstawę dla wszystkich znajdujących się na stronie zadań.
            </p>
        </section>
    </>
);

export default ProjectInfo;
