import styles from './TopBar.module.css';
import Link from 'next/link';
import { ArrowDropDown } from '@material-ui/icons';
import { useState } from 'react';
import Logo from "../Logo/Logo";

const TopBar = ({ active }) => {
    const [burger, setBurger] = useState(false);
    const toggle = () => setBurger(!burger);

    const [exercises, setExercises] = useState(false);
    const toggleExercises = () => setExercises(!exercises);

    let exercisesClassNames = [styles.item__dropdown];
    exercisesClassNames.push(
        active === 'exercises' ? styles.item__active : styles.item
    );
    if (exercises) exercisesClassNames.push(styles.showExercises);

    return (
        <div
            className={
                active === 'home' ? styles.topBar__invisible : styles.topBar
            }
        >
            <div className={styles.logoContainer}>
                <Logo/>
            </div>

            <div>
                <div
                    className={burger ? styles.menuBox : styles.emptyBox}
                />
                <div
                    className={
                        burger ? styles.menuBox__bg : styles.emptyBox__bg
                    }
                />
            </div>

            <button
                className={burger ? styles.hamburger__fixed : styles.hamburger}
                onClick={toggle}
            >
                <div />
                <div />
                <div />
            </button>

            <ul className={burger ? styles.navigationSlide : styles.navigation}>
                <li
                    className={
                        active === 'home' ? styles.item__active : styles.item
                    }
                >
                    <Link href="/">Start</Link>
                </li>
                <li
                    className={
                        active === 'projectInfo'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/projectInfo">O projekcie</Link>
                </li>
                <li
                    className={exercisesClassNames.join(' ')}
                    onClick={toggleExercises}
                >
                    <a
                        className={
                            active.includes('exercises')
                                ? styles.item__active
                                : styles.item
                        }
                    >
                        Ćwiczenia
                        {burger ? <ArrowDropDown /> : <span />}
                    </a>
                    <ul className={burger ? styles.sub : styles.showSub}>
                        <li
                            className={
                                active.includes('transcription')
                                    ? styles.subItem__active
                                    : styles.subItem
                            }
                        >
                            <Link href="/exercises/transcription/XII">
                                Transkrypcja
                            </Link>
                        </li>
                        <li
                            className={
                                active.includes('sentences')
                                    ? styles.subItem__active
                                    : styles.subItem
                            }
                        >
                            <Link href={`/exercises/sentences`}>Sentencje</Link>
                        </li>
                        <li
                            className={
                                active.includes('letters')
                                    ? styles.subItem__active
                                    : styles.subItem
                            }
                        >
                            <Link href="/exercises/letters">Litery</Link>
                        </li>
                        {/*<li className={(active.includes("shortcuts")) ? styles.subItem__active : styles.subItem}>
                            <Link href="/exercises/shortcuts">Skróty</Link>
                        </li>*/}
                        <li
                            className={
                                active.includes('gaps')
                                    ? styles.subItem__active
                                    : styles.subItem
                            }
                        >
                            <Link href="/exercises/gaps/easy">Luki</Link>
                        </li>
                    </ul>
                </li>
                <li
                    className={
                        active === 'instruction'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/instruction">Instrukcja</Link>
                </li>
                <li
                    className={
                        active === 'materials'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/materials">Materiały</Link>
                </li>
                <li
                    className={
                        active === 'contact'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/contact">Kontakt</Link>
                </li>
            </ul>
        </div>
    );
};

export default TopBar;
