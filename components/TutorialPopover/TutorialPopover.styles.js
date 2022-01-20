import { styled } from '@mui/material/styles';
import { Popover, Typography } from '@material-ui/core';

export const StyledPopover = styled(Popover)(() => ({
    maxWidth: '900px',
    minWidth: '100px',
    '& .MuiPaper-root': {
        maxWidth: '900px',
        minWidth: '400px',
        padding: '15px 30px',
        backgroundColor: '#333333',
        display: 'flex',
        justifyContent: 'row',
        alignItems: 'center',
        '& svg': {
            padding: '5px',
            fontSize: 40,
            marginLeft: '20px',
            cursor: 'pointer',
            color: '#d8a28d',
            border: '2px solid grey',
            borderRadius: '20px',
            borderColor: '#d8a28d',
        },
    },
}));

export const StyledTypography = styled(Typography)(() => ({
    fontSize: '14px !important',
    color: '#f2f2f2',
}));
