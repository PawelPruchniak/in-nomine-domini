import styles from './ExerciseLetters.module.css';
import InputBox from '../InputBox/InputBox';
import { useState } from 'react';
import Button from '../Button/Button';
import { useRouter } from 'next/router';

const ExerciseLetters = ({ data, indexes }) => {
    const counter = new Array(data.length).fill(0);
    const [done, setDone] = useState(false);
    const router = useRouter();
    const handleCallback = (index,index2, childData) => {
        childData ? (counter[index] = 1) : (counter[index] = 0);
        if (counter.every((val) => val)) {
            setDone(true);
        }
    };
    return (
        <>
            <div className={styles.lettersContainer}>
                {data.map((item, index) => (
                    <div key={index} className={styles.letterBox}>
                        <img alt={item.description} src={item.image.path} />
                        <InputBox
                            parentCallback={handleCallback}
                            key={index}
                            index={index}
                            index2={index}
                            word={item.transcription}
                        />
                    </div>
                ))}
            </div>
            {done && (
                <div className={styles.done}>
                    Brawo! Zadanie wykonane poprawnie.
                    <Button href={`/exercises/letters/${indexes.toString()}`}>Dalej</Button>
                </div>
            )}
        </>
    );
};

export default ExerciseLetters;
