import { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import AddTranscriptionForm from '../../../components/CMS/AddTranscriptionForm/AddTranscriptionForm';
import AdminPageLayout from '../../../components/AdminPageLayout/AdminPageLayout';
import { compress, compressAccurately } from 'image-conversion';
import { backendDomain, frontendDomain } from '../../../components/variables';

export const getServerSideProps = async ({ params }) => {
    return { props: { params } };
};

const Home = ({ params }) => {
    const router = useRouter();
    const [token, setToken] = useState('');
    const [picture, setPicture] = useState();
    const [data, setData] = useState({
        id: '',
        transcription: '',
        description: '',
        century: '',
        difficultyLevel: '',
        image: {
            path: '',
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
                const res = await fetch(
                    `${backendDomain}/api/document/${params.id}`
                ).then((response) =>
                    response.json().then((result) => {
                        setData(result);
                        setPicture(
                            `${frontendDomain}${result.image.lightPath}`
                        );
                    })
                );
                setToken(localStorage.getItem('token'));
            } else {
                localStorage.removeItem('token');
                router.push('/admin');
            }
        }
    }, []);
    console.log(data);
    const getInvalidFormMessage = () => {
        const fieldsMsgNames = {
            transcription: 'Tekst transkrypcji',
            description: 'Tytuł dokumentu',
            century: 'Wiek',
            difficultyLevel: 'Poziom trudności',
            image: 'Obraz dokumentu',
        };
        const emptyFields = Object.keys(data).filter((key) => !data[key]);
        if (!picture) {
            emptyFields.push('image');
        }

        let message = `Przed dodaniem dokumentu uzupełnij następujące pola:\n`;
        emptyFields.forEach((fieldName) => {
            message += '- ' + fieldsMsgNames[fieldName] + '\n';
        });

        return message;
    };

    const update = async () => {
        const isFormFullyFilled = Object.keys(data).every((key) => !!data[key]);
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
            transcription: data.transcription,
            description: data.description,
            century: data.century,
            difficultyLevel: data.difficultyLevel,
            image: {
                path: res,
                lightPath: res,
            },
        };
        if (res) {
            const response = await fetch(
                `${backendDomain}/security/document/${params.id}`,
                {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        Authorization: `Bearer ${token}`,
                    },
                    body: JSON.stringify(finalObject),
                }
            );
            let data = await response;
            if (data.ok) {
                alert('Pomyślnie edytowano dokument.');
                router.push('/admin/transcription');
            }
        }
    };

    const logout = () => {
        localStorage.removeItem('token');
    };

    return (
        <AdminPageLayout
            title="Transkrypcja"
            active="transcription"
            logout={logout}
        >
            <AddTranscriptionForm
                data={data}
                setData={setData}
                submit={update}
                initialPicture={picture}
                setPicture={setPicture}
            />
        </AdminPageLayout>
    );
};

export default Home;
