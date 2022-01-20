import PageLayout from '../../../components/PageLayout/PageLayout';
import {
    firstPopupPracticeData,
    practiceData,
    popoverTextData,
} from '../../../helpers/pages';
import styles from './index.module.css';
import InputBox from '../../../components/InputBox/InputBox';
import { useRef, useState, useEffect } from 'react';
import { TutorialDialog } from '../../../components/TutorialDialog/TutorialDialog';
import { TutorialPopover } from '../../../components/TutorialPopover/TutorialPopover';
import HelpOutlineIcon from '@mui/icons-material/HelpOutline';

const Home = () => {
    const words = practiceData.parsedTranscription[0];
    const [anchorEl, setAnchorEl] = useState(null);
    const [dialogOpen, setDialogOpen] = useState(true);
    const [controlledBoxStyle, setControlledBoxStyle] = useState(styles.input);
    const [controlledPopupFlag, setControlledPopupFlag] = useState(false);
    const [tutorialStepCounter, setTutorialStepCounter] = useState(0);
    const [firstRunFinished, setFirstRunFinished] = useState(false);
    const [done, setDone] = useState(false);
    const counter = new Array(words.length + 1).fill(0);
    const [popoverSettings, setPopoverSettings] = useState({
        content: '',
    });

    const handleCallback = (index, index2, childData) => {
        childData ? (counter[index] = 1) : (counter[index] = 0);
        if (counter.every((val) => val)) {
            setDone(true);
            setDialogOpen(true);
        }
    };

    const popoverRefs = {
        imageRef: useRef(null),
        textboxRef: useRef(null),
    };

    const openPopover = () => {
        setDialogOpen(false);
        if (done) {
            return;
        }
        if (!firstRunFinished) {
            setPopoverSettings({
                content: popoverTextData[tutorialStepCounter],
            });
            setAnchorEl(popoverRefs.imageRef.current);
            setTutorialStepCounter(tutorialStepCounter + 1);
        } else {
            setPopoverSettings({ content: popoverTextData[0] });
            setAnchorEl(popoverRefs.imageRef.current);
            return;
        }
    };
    const changePopover = () => {
        setPopoverSettings({ content: popoverTextData[tutorialStepCounter] });
        switch (tutorialStepCounter) {
            case 1:
                setAnchorEl(popoverRefs.textboxRef.current);
                setControlledPopupFlag(true);
                break;
            case 2:
                setControlledPopupFlag(false);
                setControlledBoxStyle(styles.wrong);
                break;
            case 3:
                setControlledBoxStyle(styles.almost);
                break;
            case 4:
                setControlledBoxStyle(styles.right);
                break;
            default:
                setControlledBoxStyle(styles.input);
                setAnchorEl(null);
                setFirstRunFinished(true);
                break;
        }
    };

    useEffect(() => {
        changePopover();
    }, [tutorialStepCounter]);

    const redisplayTextPopup = () => {
        setTutorialStepCounter(1);
    };

    return (
        <PageLayout title="Sentencje" active="exercises sentences">
            <TutorialDialog
                dialogOpen={dialogOpen}
                dialogClose={openPopover}
                done={done}
            />
            <TutorialPopover
                content={popoverSettings.content}
                anchorEl={anchorEl}
                handleClose={() =>
                    setTutorialStepCounter(tutorialStepCounter + 1)
                }
            />
            <div className={styles.sentenceContainer}>
                <HelpOutlineIcon
                    className={styles.helpIcon}
                    onClick={openPopover}
                />
                <img
                    ref={popoverRefs.imageRef}
                    alt="Sentencja"
                    src={practiceData.image.path}
                />
                <div className={styles.inputsContainer}>
                    <div
                        className={styles.tutorialBox}
                        ref={popoverRefs.textboxRef}
                    >
                        <InputBox
                            parentCallback={handleCallback}
                            key={0}
                            index={0}
                            index2={0}
                            word={firstPopupPracticeData}
                            tutorialColor={controlledBoxStyle}
                            tutorialPopupTrigger={controlledPopupFlag}
                        />
                        <HelpOutlineIcon
                            className={styles.helpTextIcon}
                            onClick={() => redisplayTextPopup()}
                        />
                    </div>
                    {practiceData.parsedTranscription[0].map((word, index) => (
                        <InputBox
                            parentCallback={handleCallback}
                            key={index + 1}
                            index={index + 1}
                            index2={index + 1}
                            word={word}
                        />
                    ))}
                </div>
            </div>
        </PageLayout>
    );
};

export default Home;
