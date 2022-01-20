import { useEffect, useState } from 'react';
import PageLayout from '../../../components/PageLayout/PageLayout';
import ExerciseLetters from '../../../components/ExerciseLetters/ExerciseLetters';
import { randoms } from '../../../lib/randoms';
import { backendDomain } from '../../../components/variables';

const Home = () => {
    const [data, setData] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const [indexes, setIndexes] = useState([]);
    useEffect(async () => {
        if (typeof window !== undefined) {
            const res = await fetch(`${backendDomain}/api/exercisesLetters/`);
            let newData = await res.json();
            const randomIndexes = randoms(newData.length);
            await setData(
                newData.filter((item, index) => randomIndexes.includes(index))
            );
            await setIndexes(
                newData
                    .filter((item, index) => randomIndexes.includes(index))
                    .map((item) => {
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
