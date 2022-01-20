import styles from './About.module.css';
import Button from '../../components/Button/Button';
import { ChevronRightOutlined } from '@material-ui/icons';

const About = () => (
    <div className={styles.base}>
        <article className={styles.instruction}>
            <section className={styles.thirdSection}>
                <p>
                    Witamy w naszej aplikacji! Zanim przejdziesz do pierwszego
                    ćwiczenia, zapoznaj się z poniższymi instrukcjami
                    dotyczącymi funkcjonalności ćwiczeń. Kiedy będziesz gotowy,
                    użyj przycisku "Do dzieła!" znajdującego się na dole strony,
                    przekieruje cię on na stronę ćwiczenia. Powodzenia! :)
                </p>
                <ul className={styles.exercisesList}>
                    <li>
                        <h2 className={styles.exerciseTitle}>Transkrypcja</h2>
                        <hr className={styles.marquise} />
                        <div className={styles.exerciseWrapper}>
                            <p>
                                Dokumenty są pogrupowane według okresu, z
                                którego pochodzą.
                            </p>
                            <img src="instruction_img1.png" />
                            <p>
                                Każdy z nich posiada oznaczenie poziomu
                                trudności, odpowiednio:
                            </p>
                            <div className={styles.exerciseDiff}>
                                <div className={styles.easy}></div>
                                <p>łatwe</p>
                                <div className={styles.medium}></div>
                                <p>wymagające</p>
                                <div className={styles.hard}></div>
                                <p>trudne</p>
                            </div>
                            <p>
                                Zadanie polega na wpisywaniu w odpowiednie
                                miejsca rozczytu dokumentu z jego zdjęcia, a
                                następnie podane odpowiedzi zostają sprawdzone
                                przez system.
                            </p>
                            <div className={styles.exerciseVertBox}>
                                <img src="instruction_img2.png" />
                                <ol className={styles.exerciseInstruction}>
                                    <li>
                                        Zdjęcie dokumentu możesz powiększyć
                                        klikając na nie, następnie myszką możesz
                                        przeciągać obraz do wybranego fragmenu.
                                    </li>
                                    <li>
                                        W każdą pojedynczą komórkę tekstową
                                        należy wpisać dokładnie jedno słowo.
                                    </li>
                                    <li>
                                        Słowa są w ponumerowanych grupach, które
                                        odpowiadają wersom tekstu w dokumencie.
                                    </li>
                                    <li>
                                        Za pomocą kolorów system oznacza
                                        poprawność podanych odpowiedzi,
                                        odpowiednio:
                                        <ul>
                                            <li>
                                                <span className={styles.right}>
                                                    zielony
                                                </span>{' '}
                                                - poprawna odpowiedź,
                                            </li>
                                            <li>
                                                <span className={styles.wrong}>
                                                    czerwony
                                                </span>{' '}
                                                - odpowedź błędna,
                                            </li>
                                            <li>
                                                <span className={styles.almost}>
                                                    żółty
                                                </span>{' '}
                                                - wyraz został odpowiednio
                                                rozczytany, ale jest on skrótem
                                                i należy go rozwinąć.
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        Możliwe jest sprawdzenie poprawnej
                                        odpowiedzi, wysuwa się ona po kliknięciu
                                        w ikonę lupy.
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </li>

                    <li>
                        <h2 className={styles.exerciseTitle}>Luki</h2>
                        <hr className={styles.marquise} />
                        <div className={styles.exerciseWrapper}>
                            <p>
                                Zadanie jest podobne do pełnej transkrypcji
                                dokumentu, tutaj jednak zostały wybrane
                                poszczególne słowa, natomiast pozostała część
                                tekstu jest odkryta.{' '}
                            </p>
                            <img src="instruction_img6.png" />
                            <p>Mechanizm sprawdzania - patrz Transkrypcja.</p>
                        </div>
                    </li>

                    <li>
                        <h2 className={styles.exerciseTitle}>Litery</h2>
                        <hr className={styles.marquise} />
                        <div className={styles.exerciseWrapper}>
                            <p>
                                Zadanie działa analogicznie do transkrypcji,
                                natomiast jego podmiotem są pojedyncze litery z
                                wybranych rękopisów.{' '}
                            </p>
                            <img src="instruction_img4.png" />
                            <p>Mechanizm sprawdzania - patrz Transkrypcja.</p>
                        </div>
                    </li>

                    <li>
                        <h2 className={styles.exerciseTitle}>Sentencje</h2>
                        <hr className={styles.marquise} />
                        <div className={styles.exerciseWrapper}>
                            <p>
                                Zadanie działa analogicznie do transkrypcji,
                                natomiast jego podmiotem są losowane sentencje.
                            </p>
                            <img src="instruction_img3.png" />
                            <p>Mechanizm sprawdzania - patrz Transkrypcja.</p>
                        </div>
                    </li>
                </ul>
            </section>
        </article>
        <div className={styles.buttonWrapper}>
            <Button href="/tutorial/practice">Do dzieła!</Button>
        </div>
    </div>
);

export default About;
