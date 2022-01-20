import styles from './LoginForm.module.css';
import { InputAdornment, InputLabel } from '@material-ui/core';
import Button2 from '../Button2/Button2';
import { Visibility, VisibilityOff } from '@material-ui/icons';
import Logo from '../Logo/Logo';
import {
    StyledOutlinedInput,
    StyledFormControl,
    StyledIconButton,
} from './LoginForm.styles';
import {useState} from "react";

const LoginForm = ({ credentials, setCredentials, submit }) => {
    const buttonSize = 'small';
    const logoSize = 'medium';

    const [values, setValues] = useState({
        amount: '',
        password: '',
        weightRange: '',
        showPassword: false,
    });

    const handleClickShowPassword = () => {
        setValues({
            ...values,
            showPassword: !values.showPassword,
        });
    };

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    return (
        <div className={styles.loginContainer}>
            <Logo size={logoSize} />
            <hr className={styles.marquise} />
            <main className={styles.formContainer}>
                <h1 className={styles.formTitle}>Zaloguj się</h1>
                <div className={styles.inputsContainer}>
                    <StyledFormControl
                        variant="outlined"
                        sx={{ m: 1, width: '25ch', borderColor: '#fefefe' }}
                    >
                        <InputLabel htmlFor="outlined-login">Login</InputLabel>
                        <StyledOutlinedInput
                            id="outlined-login"
                            className={styles.formInput}
                            variant="outlined"
                            label="Login"
                            onChange={(event) => {
                                setCredentials({
                                    login: event.target.value,
                                    password: credentials.password,
                                });
                            }}
                        />
                    </StyledFormControl>
                    <StyledFormControl
                        variant="outlined"
                        sx={{ m: 1, width: '25ch', borderColor: '#fefefe' }}
                    >
                        <InputLabel htmlFor="outlined-adornment-password">
                            Hasło
                        </InputLabel>
                        <StyledOutlinedInput
                            id="outlined-adornment-password"
                            className={styles.formInput}
                            variant="outlined"
                            label="Hasło"
                            onChange={(event) => {
                                setCredentials({
                                    login: credentials.login,
                                    password: event.target.value,
                                });
                            }}
                            type={values.showPassword ? 'text' : 'password'}
                            endAdornment={
                                <InputAdornment position="end">
                                    <StyledIconButton
                                        aria-label="toggle password visibility"
                                        onClick={handleClickShowPassword}
                                        onMouseDown={handleMouseDownPassword}
                                        edge="end"
                                    >
                                        {values.showPassword ? (
                                            <VisibilityOff />
                                        ) : (
                                            <Visibility />
                                        )}
                                    </StyledIconButton>
                                </InputAdornment>
                            }
                        />
                    </StyledFormControl>
                </div>
                <Button2
                    special
                    size={buttonSize}
                    className={styles.submitButton}
                    onClick={submit}
                >
                    Zaloguj
                </Button2>
            </main>
        </div>
    );
};

export default LoginForm;
