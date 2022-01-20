import styles from './AddSentencesForm.module.css';
import { MenuItem, OutlinedInput } from '@material-ui/core';
import { useEffect } from 'react';
import { UploadFile } from '@mui/icons-material';
import Button2 from '../../Button2/Button2';
import Button from '../../Button/Button';
import {
    StyledTextField,
    StyledSelect,
    StyledFormControl,
    StyledButton,
    Theme,
} from './AddSentencesForm.styles';
import { ThemeProvider } from '@material-ui/core';
import { useState } from 'react';

const AddSentencesForm = ({
    data,
    setData,
    initialPicture = null,
    setPicture,
    submit,
}) => {
    const [pictureButtonContent, setPictureButtonContent] = useState(() =>
        initialPicture ? (
            <img className={styles.pictureButton} src={initialPicture} />
        ) : (
            <>
                <UploadFile /> Obraz zadania
            </>
        )
    );

    useEffect(() => {
        setPictureButtonContent(() =>
            initialPicture ? (
                <img className={styles.pictureButton} src={initialPicture} />
            ) : (
                <>
                    <UploadFile /> Obraz zadania
                </>
            )
        );
    }, [initialPicture]);

    const uploadPicture = async (e) => {
        if (e.target.files.length > 0) {
            await setPicture(e.target.files[0]);
            await setPictureButtonContent(() => (
                <img
                    className={styles.pictureButton}
                    src={URL.createObjectURL(e.target.files[0])}
                />
            ));
        }
    };

    return (
        <div className={styles.formContainer}>
            <ThemeProvider theme={Theme}>
                <StyledButton
                    className={styles.docImage}
                    variant="outlined"
                    component="label"
                >
                    {pictureButtonContent}
                    <input type="file" hidden onChange={uploadPicture} />
                </StyledButton>
                <StyledTextField
                    className={styles.title}
                    label="Tekst"
                    value={data.transcription}
                    multiline
                    rows={3}
                    variant="outlined"
                    onChange={(e) => {
                        setData({
                            ...data,
                            transcription: e.target.value,
                        });
                    }}
                />
                <StyledTextField
                    className={styles.transcription}
                    spellCheck={false}
                    label="Tłumaczenie"
                    value={data.translation}
                    multiline
                    rows={3}
                    variant="outlined"
                    autoCorrect="off"
                    onChange={(e) => {
                        setData({
                            ...data,
                            translation: e.target.value,
                        });
                    }}
                />
                <div className={styles.buttons}>
                    <Button
                        href="/admin/sentences"
                        className={styles.buttonCms}
                    >
                        Wróć
                    </Button>
                    <Button2
                        onClick={() => submit(data.id)}
                        className={styles.buttonCms}
                    >
                        Wyślij
                    </Button2>
                </div>
            </ThemeProvider>
        </div>
    );
};

export default AddSentencesForm;
