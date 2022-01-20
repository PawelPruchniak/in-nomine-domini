import styles from './AddTranscriptionForm.module.css';
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
} from './AddTranscriptionForm.styles';
import { ThemeProvider } from '@material-ui/core';
import { useState } from 'react';

const AddTranscriptionForm = ({
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
                    label="Tekst transkrypcji"
                    value={data.transcription}
                    variant="outlined"
                    multiline
                    rows={20}
                    autoCorrect="off"
                    onChange={(e) => {
                        setData({
                            ...data,
                            transcription: e.target.value,
                        });
                    }}
                />
                <StyledTextField
                    className={styles.title}
                    label="Tytuł dokumentu"
                    value={data.description}
                    variant="outlined"
                    onChange={(e) => {
                        setData({
                            ...data,
                            description: e.target.value,
                        });
                    }}
                />
                <StyledFormControl className={styles.century}>
                    <StyledSelect
                        id="century-select"
                        displayEmpty
                        value={data.century}
                        onChange={(event) => {
                            setData({
                                ...data,
                                century: event.target.value,
                            });
                        }}
                        renderValue={
                            data?.century !== ''
                                ? undefined
                                : () => <span>Wiek</span>
                        }
                        inputProps={{ 'aria-label': 'Without label' }}
                    >
                        <MenuItem disabled value="">
                            Wiek
                        </MenuItem>
                        <MenuItem value="XII">XII</MenuItem>
                        <MenuItem value="XIII">XIII</MenuItem>
                        <MenuItem value="XIV">XIV</MenuItem>
                        <MenuItem value="XV">XV</MenuItem>
                        <MenuItem value="XVI">XVI</MenuItem>
                    </StyledSelect>
                </StyledFormControl>
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
                        <MenuItem value={2}>Średni</MenuItem>
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
                    <Button
                        href="/admin/transcription"
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

export default AddTranscriptionForm;
