import styles from './HomePage.module.css';
import Button from '../Button/Button';
import TopBar from '../TopBar/TopBar';
import {
    AlternateEmailOutlined,
    HomeOutlined,
    PhoneOutlined,
} from '@material-ui/icons';

const HomePage = ({ active }) => (
    <>
        <TopBar active={active} />
        <header className={styles.hero}>
            <div className={styles.hero__background}></div>
            <div className={styles.hero__box}>
                <h2 className={styles.hero__content}>
                    Verba volant, scripta manen
                </h2>
                <Button href="/tutorial" special>
                    Start
                </Button>
            </div>
        </header>
        <div className={styles.wrapper}>
            <section>
                <header className={styles.header}>
                    <div className={styles.marquise}></div>
                    <h3 className={styles.title}>O projekcie</h3>
                    <div className={styles.marquise}></div>
                </header>
                <article className={styles.section__article}>
                    <div className={styles.section__content}>
                        <h4>Twórcy projektu</h4>
                        <p>
                            Pomysłodawcą projektu była dr hab. Magdalena Biniaś-Szkopek natomiast inicjatorem działań z zakresu stworzenia odpowiedniego oprogramowania dr Rafał Witkowski. Całkowicie nową wersję strony i jej funkcjonalności stworzył zespół studentów Wydziału Matematyki i Informatyki Uniwersytetu im. Adama Mickiewicza w Poznaniu w składzie: Edyta Jarzębska, Dawid Piskadło, Paweł Pruchniak, Krzysztof Szostak.
                        </p>
                        <div className={styles.section__button}>
                            <Button href="/projectInfo">Więcej...</Button>
                        </div>
                    </div>
                    <div className={styles.section__imageBox}>
                        <img
                            alt="profesor Magdalena Biniaś-Szkopek"
                            src="prof.m.binias-szkopek.jpg"
                        />
                    </div>
                </article>
            </section>

            <div className={styles.spaceBox}></div>

            <section>
                <header className={styles.header}>
                    <div className={styles.marquise}></div>
                    <h3 className={styles.title}>Paleografia łacińska</h3>
                    <div className={styles.marquise__invisible}></div>
                </header>
                <article className={styles.section__article}>
                    <div className={styles.section__box}>
                        <div className={styles.section__image}>
                            <img
                                alt="Dokument arcybiskupa gnieźnieńskiego Pełki"
                                src="doc1.png"
                            />
                        </div>
                        <p>1234 rok</p>
                        <h4>Dokument arcybiskupa gnieźnieńskiego Pełki</h4>
                        <hr />
                        <p>
                            <span>
                                Dokument arcybiskupa gnieźnienskiego Pełki,
                            </span>
                            <span>
                                oryginał w Archiwum Państwowym w Poznaniu
                            </span>
                            <span>(Cystersi Lubiąż D 1)</span>
                        </p>
                    </div>
                    <div className={styles.section__box}>
                        <div className={styles.section__image}>
                            <img
                                alt="Dokument Władysława Jagiełły"
                                src="doc2.png"
                            />
                        </div>
                        <p>1424 rok</p>
                        <h4>Dokument Władysława Jagiełły</h4>
                        <hr />
                        <p>
                            <span>Dokument Władysława Jagiełły,</span>
                            <span>
                                oryginał w Archiwum Państwowym w Poznaniu
                            </span>
                            <span>(Akta Miasta Poznania D 450)</span>
                        </p>
                    </div>
                </article>
                <footer className={styles.section__footer}>
                    <Button href="/exercises/transcription/XIII">
                        Więcej ...
                    </Button>
                </footer>
            </section>
        </div>
    </>
);
export default HomePage;
