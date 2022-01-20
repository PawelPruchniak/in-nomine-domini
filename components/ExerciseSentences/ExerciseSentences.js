import styles from './ExerciseSentences.module.css';
import InputBox from '../InputBox/InputBox';
import { useState } from 'react';
import Button from '../Button/Button';

const ExerciseSentences = ({ data }) => {
    const words = data.parsedTranscription[0];
    const counter = new Array(words.length).fill(0);
    const [done, setDone] = useState('');
    const [translationStyles, setTranslationStyles] = useState(styles.hide);

    const handleCallback = (index,index2, childData) => {
        childData ? (counter[index] = 1) : (counter[index] = 0);
        if (counter.every((val) => val)) {
            setDone(data.translation ? data.translation : true);
            setTranslationStyles(translationStyles + ' ' + styles.show);
        }
    };

    return (
        <div className={styles.sentenceContainer}>
            <img alt="Sentencja" src={data.image.path} />
            <div className={styles.inputsContainer}>
                {words.map((word, index) => (
                    <InputBox
                        parentCallback={handleCallback}
                        key={index}
                        index={index}
                        index2={index}
                        word={word}
                    />
                ))}
            </div>
            <p className={translationStyles}>{done}</p>
            {done && (
                <div className={styles.done}>
                    Brawo! Zadanie wykonane poprawnie.
                    <Button href={`/exercises/sentences/${data.id}`}>
                        Dalej
                    </Button>
                </div>
            )}
        </div>
    );
};

export default ExerciseSentences;
