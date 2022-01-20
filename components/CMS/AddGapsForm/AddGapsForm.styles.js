import { styled } from '@mui/material/styles';
import { Button, FormControl, TextField } from '@mui/material';
import { Select } from '@mui/material';
import { createMuiTheme } from '@material-ui/core';

export const StyledTextField = styled(TextField)(() => ({
    maxHeight: '500px',
    '& .Mui-focused': {
        borderColor: '#fefefe !important',
        color: '#fefefe',
    },
    '& .MuiInputLabel-root': {
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
    minHeight: '300px',
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
