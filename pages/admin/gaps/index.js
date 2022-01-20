import { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import AdminPageLayout from '../../../components/AdminPageLayout/AdminPageLayout';
import GapsTable from '../../../components/CMS/GapsTable/GapsTable';
import AddButton from '../../../components/CMS/AddButton/AddButton';
import Router from 'next/router';
import { backendDomain } from '../../../components/variables';

const Home = () => {
    const addDocumentUrl = '/admin/gaps/add';
    const addDocumentButtonText = 'Dodaj zadanie';

    const [data, setData] = useState([
        {
            transcription: '',
            difficultyLevel: '',
            image: {
                path: '',
                lightPath: '',
            },
        },
    ]);
    const router = useRouter();
    const [token, setToken] = useState('');
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
                const res = await fetch(`${backendDomain}/api/exercisesGaps/`);
                setData(await res.json());
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

    const handleDelete = async (id) => {
        const response = await fetch(
            `${backendDomain}/security/exerciseGaps/${id}`,
            {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                    Authorization: `Bearer ${token}`,
                },
            }
        );
        const data = await response;
        if (typeof window !== 'undefined') {
            Router.reload(window.location.pathname);
        }
    };

    return (
        <AdminPageLayout
            title="Luki"
            active="gaps"
            logout={logout}
        >
            <AddButton href={addDocumentUrl} name={addDocumentButtonText} />
            <GapsTable data={data} handleDelete={handleDelete} />
        </AdminPageLayout>
    );
};

export default Home;
