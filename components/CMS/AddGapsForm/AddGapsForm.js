import styles from './AddGapsForm.module.css';
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
} from './AddGapsForm.styles';
import { ThemeProvider } from '@material-ui/core';
import { useState } from 'react';

const AddGapsForm = ({
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
                <UploadFile /> Obraz dokumentu
            </>
        )
    );

    useEffect(() => {
        setPictureButtonContent(() =>
            initialPicture ? (
                <img className={styles.pictureButton} src={initialPicture} />
            ) : (
                <>
                    <UploadFile /> Obraz dokumentu
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
                <StyledTextField
                    className={styles.transcription}
                    spellCheck={false}
                    label="Tekst luk"
                    value={data.transcription}
                    variant="outlined"
                    multiline
                    rows={15}
                    autoCorrect="off"
                    onChange={(e) => {
                        setData({
                            ...data,
                            transcription: e.target.value,
                        });
                    }}
                />
                <StyledFormControl>
                    <StyledSelect
                        id="difficulty-select"
                        displayEmpty
                        variant="outlined"
                        value={data.difficultyLevel}
                        onChange={(e) => {
                            setData({
                                ...data,
                                difficultyLevel: e.target.value,
                            });
                        }}
                        renderValue={
                            data?.difficultyLevel !== ''
                                ? undefined
                                : () => <span>Poziom trudności</span>
                        }
                    >
                        <MenuItem disabled value="">
                            Poziom trudności
                        </MenuItem>
                        <MenuItem value={1}>Łatwy</MenuItem>
                        <MenuItem value={2}>Wymagający</MenuItem>
                        <MenuItem value={3}>Trudny</MenuItem>
                    </StyledSelect>
                </StyledFormControl>
                <StyledButton
                    className={styles.docImage}
                    variant="outlined"
                    component="label"
                >
                    {pictureButtonContent}
                    <input type="file" hidden onChange={uploadPicture} />
                </StyledButton>
                <div className={styles.buttons}>
                    <Button href="/admin/gaps" className={styles.buttonCms}>
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

export default AddGapsForm;
