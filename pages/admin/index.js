import fetch from 'node-fetch';
import { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import LoginForm from '../../components/LoginForm/LoginForm';
import { backendDomain } from '../../components/variables';

const Home = () => {
    const router = useRouter();
    const [credentials, setCredentials] = useState({
        login: '',
        password: '',
    });

    useEffect(() => {
        if (localStorage.getItem('token')) {
            router.push('/admin/transcription');
        }
    }, []);

    const login = async () => {
        const response = await fetch(`${backendDomain}/api/authenticate`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username: credentials.login,
                password: credentials.password,
            }),
        });
        let data = await response.json();
        if (data.token) {
            localStorage.setItem('token', data.token);
            router.push('/admin/transcription/');
        } else if (!response.ok) {
            alert('Podane hasło jest nieprawidłowe');
        }
    };
    return (
        <LoginForm
            credentials={credentials}
            setCredentials={setCredentials}
            submit={login}
        />
    );
};

export default Home;
