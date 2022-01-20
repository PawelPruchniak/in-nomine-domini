import styles from './InputBox.module.css';
import { useEffect, useState } from 'react';

const InputBox = ({
    word,
    parentCallback,
    index,
    index2,
    tutorialColor = null,
    tutorialPopupTrigger = null,
}) => {
    const [value, setValue] = useState('');
    const [style, setStyle] = useState(
        tutorialColor ? tutorialColor : styles.input
    );
    const [opened, setOpen] = useState(styles.closed);
    const [flag, setSwitch] = useState(false);

    const switcher = () => {
        if (flag) {
            setOpen(styles.closed);
            setSwitch(false);
        } else {
            setOpen(styles.open);
            setSwitch(true);
        }
    };

    useEffect(() => {
        setStyle(tutorialColor ? tutorialColor : styles.input);
        if (tutorialPopupTrigger || flag) {
            switcher();
        }
    }, [tutorialColor, tutorialPopupTrigger]);
    const validation = (input, value) => {
        if (input.toLowerCase() != '') {
            if (
                value.includes('(') &&
                input.toLowerCase() ==
                    value.toLowerCase().replace(/\(\w+\)/g, '')
            ) {
                setStyle(styles.almost);
                parentCallback(index, index2, false);
                return;
            } else if (
                input.toLowerCase() == value.toLowerCase() ||
                input.toLowerCase() ==
                    value.toLowerCase().replace(/\)/g, '').replace(/\(/g, '')
            ) {
                setStyle(styles.right);
                parentCallback(index, index2, true);
                return;
            } else {
                setStyle(styles.wrong);
                parentCallback(index, index2, false);
                return;
            }
        } else {
            setStyle(styles.input);
        }
    };

    return (
        <div className={styles.base}>
            <img
                src="/loupe.png"
                alt="Lupka"
                onClick={() => {
                    switcher(flag);
                }}
            />
            <input
                id={word}
                className={style}
                value={value}
                onChange={(e) => {
                    setValue(e.currentTarget.value);
                }}
                maxLength={word.length}
                size={word.length + 2}
                autoComplete="off"
                onBlur={() => {
                    validation(value, word);
                    if (flag) {
                        setOpen(styles.closed);
                        setSwitch(false);
                    }
                }}
            />
            <label className={opened}>{word}</label>
        </div>
    );
};

InputBox.defaultProps = {
    parentCallback: (...args) => void 0,
};

export default InputBox;
