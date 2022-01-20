import { styled } from '@mui/material/styles';
import { OutlinedInput, FormControl } from '@mui/material';
import { IconButton } from '@mui/material';
import { createMuiTheme } from '@material-ui/core';

export const StyledOutlinedInput = styled(OutlinedInput)(() => ({
    color: '#fefefe',
    borderColor: '#fefefe',

    '& .MuiOutlinedInput-root': {
        color: '#fefefe',
        border: '1px solid #fefefe',
        '& fieldset': {
            borderColor: 'white',
        },
        '&:hover fieldset': {
            borderColor: 'white',
        },
        '&.Mui-focused fieldset': {
            borderColor: 'yellow',
        },
        '&:hover': {
            color: '#fefefe',
            borderColor: '#fefefe',
        },
    },
}));

export const StyledIconButton = styled(IconButton)(() => ({
    color: '#fefefe',
    borderColor: '#fefefe',
}));

export const StyledFormControl = styled(FormControl)(() => ({
    '& .MuiFormLabel-root': {
        color: '#fefefe',
    },
    '& .MuiOutlinedInput-root': {
        color: '#fefefe',
        '& .MuiOutlinedInput-notchedOutline': {
            borderColor: '#fefefe !important',
            '&:hover': {
                color: '#fefefe',
                borderColor: '#fefefe !important',
            },
        },
    },
}));

