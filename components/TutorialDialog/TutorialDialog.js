import { useState, useEffect } from 'react';
import { DialogContent } from '@material-ui/core';
import { IntroText, EndingText } from './TutorialDialog.helpers';
import {
    StyledDialog,
    StyledTypography,
    StyledButton,
} from './TutorialDialog.styles';
import Button2 from '../Button2/Button2';
import Button from '../Button/Button';

export const TutorialDialog = ({ done, dialogOpen, dialogClose }) => {
    const [open, setOpen] = useState(true);
    useEffect(() => {
        setOpen(dialogOpen);
    }, [dialogOpen]);
    const handleClose = () => {
        dialogClose();
        setOpen(false);
    };

    return (
        <StyledDialog
            aria-labelledby="customized-dialog-title"
            open={open}
            sx={{ padding: '20px' }}
        >
            <DialogContent>
                {done ? (
                    <>
                        <StyledTypography>Świetnie! </StyledTypography>
                        <StyledTypography>{EndingText}</StyledTypography>
                        <StyledButton>
                            <Button href="/exercises/letters">OK</Button>
                        </StyledButton>
                    </>
                ) : (
                    <>
                        <StyledTypography gutterBottom>Witaj,</StyledTypography>
                        <StyledTypography gutterBottom>
                            {IntroText}
                        </StyledTypography>
                        <StyledTypography gutterBottom>
                            Życzymy ci powodzenia :)
                            <StyledButton>
                                <Button2 onClick={handleClose}>Dalej</Button2>
                            </StyledButton>
                        </StyledTypography>
                    </>
                )}
            </DialogContent>
        </StyledDialog>
    );
};
