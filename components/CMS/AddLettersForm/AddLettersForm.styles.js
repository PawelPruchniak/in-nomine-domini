import { styled } from '@mui/material/styles';
import { Button, FormControl, TextField } from '@mui/material';
import { Select } from '@mui/material';
import { createMuiTheme } from '@material-ui/core';
import { NoEncryption } from '@mui/icons-material';

export const StyledTextField = styled(TextField)(() => ({
    maxWidth: '40px',
    margin: '0 auto',
    '& .Mui-focused': {
        borderColor: '#fefefe !important',
        color: '#fefefe',
    },
    '& .MuiInputLabel-root': {
        display: 'none',
        color: '#fefefe !important',
    },
    '&:hover': {
        color: '#fefefe',
        borderColor: '#fefefe !important',
    },
    '& .MuiOutlinedInput-root': {
        color: '#fefefe',
        '& .MuiOutlinedInput-notchedOutline': {
            borderColor: '#fefefe !important',
        },
    },
}));

export const StyledSelect = styled(Select)(() => ({
    fontSize: '14px !important',
    '& .MuiSvgIcon-root': {
        color: '#fefefe !important',
    },
}));

export const StyledButton = styled(Button)(() => ({
    color: '#fefefe',
    maxWidth: '30%',
    margin: '0 auto',
    height: '200px',
    border: '1px solid #fefefe',
    '&:hover': {
        color: '#fefefe',
        borderColor: '#fefefe',
    },
    '& img': {
        height: '100%',
        width: '100%',
    },
}));

export const StyledFormControl = styled(FormControl)(() => ({
    color: '#fefefe',
    '& .MuiOutlinedInput-root': {
        color: '#fefefe',
        '& fieldset': {
            borderColor: '#fefefe',
        },
        '&:hover fieldset': {
            borderColor: '#fefefe',
        },
        '&.Mui-focused fieldset': {
            borderColor: 'yellow',
        },
        '& .MuiOutlinedInput-notchedOutline': {
            borderColor: '#fefefe',
            '&:hover': {
                color: '#fefefe',
                borderColor: '#fefefe',
            },
        },
    },
}));

export const Theme = createMuiTheme({
    palette: {
        primary: {
            main: '#fefefe',
        },
        secondary: { main: '#fefefe' },
        grey: { main: '#fefefe' },
    },
    overrides: {
        MuiOutlinedInput: {
            root: {
                position: 'relative',
                '& $notchedOutline': {
                    borderColor: '#fefefe',
                },
                '&:hover:not($disabled):not($focused):not($error) $notchedOutline':
                    {
                        borderColor: '#fefefe',
                        '@media (hover: none)': {
                            borderColor: '#fefefe',
                        },
                    },
                '&$focused $notchedOutline': {
                    borderColor: '#fefefe',
                    borderWidth: 1,
                },
            },
        },
    },
});
