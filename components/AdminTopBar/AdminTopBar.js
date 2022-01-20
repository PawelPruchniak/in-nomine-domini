import styles from './AdminTopBar.module.css';
import Link from 'next/link';
import { useState } from 'react';

const AdminTopBar = ({ active, logout }) => {
    const [burger, setBurger] = useState(false);
    const toggle = () => setBurger(!burger);

    return (
        <div
            className={
                active === 'home' ? styles.topBar__invisible : styles.topBar
            }
        >
            <a href="/" className={styles.topBarLogo}>
                <img
                    src="/logotyp.png"
                    alt="Uniwersytet im. Adama Mickiewicza w Poznaniu"
                ></img>
            </a>

            <div>
                <div
                    className={burger ? styles.menuBox : styles.emptyBox}
                ></div>
                <div
                    className={
                        burger ? styles.menuBox__bg : styles.emptyBox__bg
                    }
                ></div>
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
                        active === 'gaps'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/admin/gaps">Luki</Link>
                </li>
                <li
                    className={
                        active === 'letters' ? styles.item__active : styles.item
                    }
                >
                    <Link href="/admin/letters">Litery</Link>
                </li>
                <li
                    className={
                        active === 'sentences'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/admin/sentences">Sentencje</Link>
                </li>

                <li
                    className={
                        active === 'transcription'
                            ? styles.item__active
                            : styles.item
                    }
                >
                    <Link href="/admin/transcription">Transkrypcja</Link>
                </li>
                <li className={styles.item} onClick={logout}>
                    <Link href="/admin">Wyloguj</Link>
                </li>
            </ul>
        </div>
    );
};

export default AdminTopBar;
