import { useEffect, useState } from 'react';
import PageLayout from '../../../components/PageLayout/PageLayout';
import ExerciseLetters from '../../../components/ExerciseLetters/ExerciseLetters';
import { randoms } from '../../../lib/randoms';
import { backendDomain } from '../../../components/variables';

export const getServerSideProps = async ({ params }) => {
    return { props: { params } };
};

const Home = ({ params }) => {
    const [data, setData] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const [indexes, setIndexes] = useState([]);
    useEffect(async () => {
        if (typeof window !== undefined) {
            const res = await fetch(
                `${backendDomain}/api/exerciseLetters/random/${params.id}`
            );
            let req = await res.json();
            const newData = req.sort(() => 0.5 - Math.random()).slice(0, 5);
            await setData(newData);
            await setIndexes(
                newData.map((item) => {
                    return item.id;
                })
            );
            setLoaded(true);
        }
    }, []);
    return (
        <PageLayout title="Litery" active="exercises letters">
            {loaded && <ExerciseLetters data={data} indexes={indexes} />}
        </PageLayout>
    );
};

export default Home;
