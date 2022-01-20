import { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import AddTranscriptionForm from '../../../../components/CMS/AddTranscriptionForm/AddTranscriptionForm';
import AdminPageLayout from '../../../../components/AdminPageLayout/AdminPageLayout';
import { backendDomain } from '../../../../components/variables';

const Home = () => {
    const router = useRouter();
    const [token, setToken] = useState('');
    const [picture, setPicture] = useState();
    const [newData, setNewData] = useState({
        transcription: '',
        description: '',
        century: '',
        difficultyLevel: '',
        image: {
            path: '',
            lightPath: '',
        },
    });

    useEffect(async () => {
        if (!localStorage.getItem('token')) {
            router.push('/admin');
        } else if (
            localStorage.getItem('token') &&
            typeof window !== undefined
        ) {
            const tempToken = localStorage.getItem('token');
            const response = await fetch(`${backendDomain}/security/hello/`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    Authorization: `Bearer ${tempToken}`,
                },
            });
            if (response.ok) {
                setToken(localStorage.getItem('token'));
            } else {
                localStorage.removeItem('token');
                router.push('/admin');
            }
        }
    }, []);

    const logout = () => {
        localStorage.removeItem('token');
    };

    const getInvalidFormMessage = () => {
        const fieldsMsgNames = {
            transcription: 'Tekst transkrypcji',
            description: 'Tytuł dokumentu',
            century: 'Wiek',
            difficultyLevel: 'Poziom trudności',
            image: 'Obraz dokumentu',
        };
        const emptyFields = Object.keys(newData).filter((key) => !newData[key]);
        if (!picture) {
            emptyFields.push('image');
        }

        let message = `Przed dodaniem dokumentu uzupełnij następujące pola:\n`;
        emptyFields.forEach((fieldName) => {
            message += '- ' + fieldsMsgNames[fieldName] + '\n';
        });

        return message;
    };

    const add = async () => {
        const isFormFullyFilled = Object.keys(newData).every(
            (key) => !!newData[key]
        );
        if (!isFormFullyFilled) {
            alert(getInvalidFormMessage());
            return;
        }

        let formData = new FormData();
        formData.append('image', picture);
        const req = await fetch(`${backendDomain}/security/image`, {
            method: 'POST',
            headers: {
                Authorization: `Bearer ${token}`,
            },
            body: formData,
        });
        const res = await req.text();
        const finalObject = {
            transcription: newData.transcription,
            description: newData.description,
            century: newData.century,
            difficultyLevel: newData.difficultyLevel,
            image: {
                path: res,
                lightPath: res,
            },
        };
        if (res) {
            const response = await fetch(
                `${backendDomain}/security/document/`,
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        Authorization: `Bearer ${token}`,
                    },
                    body: JSON.stringify(finalObject),
                }
            );
            let data = await response;
            if (data.ok) {
                alert('Pomyślnie dodano dokument.');
                router.push('/admin/transcription');
            }
        }
    };

    return (
        <AdminPageLayout
            title="Transkrypcja"
            active="transcription"
            logout={logout}
        >
            <AddTranscriptionForm
                data={newData}
                setData={setNewData}
                submit={add}
                setPicture={setPicture}
            />
        </AdminPageLayout>
    );
};

export default Home;
