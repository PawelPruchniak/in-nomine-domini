import styles from './AddLettersForm.module.css';
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
} from './AddLettersForm.styles';
import { ThemeProvider } from '@material-ui/core';
import { useState } from 'react';

const AddLettersForm = ({
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
                    className={styles.transcription}
                    spellCheck={false}
                    value={data.transcription}
                    variant="outlined"
                    rows={20}
                    autoCorrect="off"
                    onChange={(e) => {
                        setData({
                            ...data,
                            transcription: e.target.value,
                        });
                    }}
                />

                <div className={styles.buttons}>
                    <Button href="/admin/letters" className={styles.buttonCms}>
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

export default AddLettersForm;
