import styles from './ExerciseItem.module.css';
import Link from 'next/link';

const ExerciseItem = ({ type, url, imgUrl, difficulty, text }) => {
    let docTitleClassName = styles.hide;
    let docDiffIconClassName = styles.hide;

    if (type === 'transcription') {
        docTitleClassName = styles.infoBar;

        if (difficulty === 1) docDiffIconClassName = styles.easy;
        if (difficulty === 2) docDiffIconClassName = styles.medium;
        if (difficulty === 3) docDiffIconClassName = styles.hard;
    }

    return (
        <Link href={`/exercises/${url}`}>
            <div
                style={{ backgroundImage: `url(${imgUrl})` }}
                className={styles.base}
            >
                <div className={docDiffIconClassName}/>
                <div className={docTitleClassName}>
                    <p>{text}</p>
                </div>
            </div>
        </Link>
    );
};

ExerciseItem.defaultProps = {
    type: 'transcription',
};

export default ExerciseItem;
