import styles from './Transcription.module.css';
import InputBox from '../InputBox/InputBox';
import { useState } from 'react';
import Button from '../Button/Button';
import { useRouter } from 'next/router';
const Transcription = ({ parsedTranscription, gaps }) => {
    const counter = gaps
        ? parsedTranscription.map((array) => {
              return new Array(array.length).fill(1);
          })
        : parsedTranscription.map((array) => {
              return new Array(array.length).fill(0);
          });
    gaps &&
        parsedTranscription.map((sentence, index) =>
            sentence.map((word, index2) => {
                if (word.includes('~')) {
                    counter[index][index2] = 0;
                }
            })
        );
    const [done, setDone] = useState(false);
    const router = useRouter();
    const handleCallback = (index, index2, childData) => {
        childData ? (counter[index][index2] = 1) : (counter[index][index2] = 0);
        if (counter.every((val) => val.every((val2) => val2))) {
            setDone(true);
        }
    };
    return (
        <>
            <ol className={styles.transcription}>
                {parsedTranscription.map((sentence, index) => (
                    <li key={index}>
                        {sentence.map((word, index2) =>
                            gaps ? (
                                word.includes('~') ? (
                                    <InputBox
                                        parentCallback={handleCallback}
                                        index={index}
                                        index2={index2}
                                        key={index2}
                                        word={word.replace('~', '')}
                                    />
                                ) : (
                                    ' ' + word + ' '
                                )
                            ) : (
                                <InputBox
                                    parentCallback={handleCallback}
                                    index={index}
                                    index2={index2}
                                    key={index}
                                    word={word}
                                />
                            )
                        )}
                    </li>
                ))}
            </ol>
            {done && (
                <div className={styles.done}>
                    Brawo! Zadanie wykonane poprawnie.
                    <Button href={router.pathname.slice(0, -4)}>Dalej</Button>
                </div>
            )}
        </>
    );
};

Transcription.defaultProps = {
    gaps: false,
};

export default Transcription;
