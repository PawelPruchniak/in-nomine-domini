import { styled } from '@mui/material/styles';
import { Box, Dialog, Typography } from '@material-ui/core';

export const StyledDialog = styled(Dialog)(() => ({
    '& .MuiPaper-root': {
        padding: '15px 30px',
        backgroundColor: '#333333',
    },
}));

export const StyledTypography = styled(Typography)(() => ({
    fontSize: '14px !important',
    color: '#f2f2f2',
}));

export const StyledButton = styled(Box)(() => ({
    display: 'flex',
    marginTop: '30px',
    justifyContent: 'end',
}));
