import styles from './SubBar.module.css';
import Link from 'next/link';

const SubBar = ({ active }) => {
    let exerciseType = 'transcription';
    let scaleDesc = [
        ['XII', 'XII'],
        ['XIII', 'XIII'],
        ['XIV', 'XIV'],
        ['XV', 'XV'],
        ['XVI', 'XVI'],
    ];

    if (active[0] !== 'X') {
        exerciseType = 'gaps';
        scaleDesc = [
            ['easy', 'Łatwe'],
            ['medium', 'Wymagające'],
            ['hard', 'Trudne'],
        ];
    }

    return (
        <ul className={styles.base}>
            {scaleDesc.map((element, index) => (
                <li
                    key={index}
                    className={
                        active === element[0]
                            ? styles.menuCell__active
                            : styles.menuCell
                    }
                >
                    <Link href={`/exercises/${exerciseType}/${element[0]}`}>
                        {element[1]}
                    </Link>
                    <hr />
                </li>
            ))}
        </ul>
    );
};

export default SubBar;
