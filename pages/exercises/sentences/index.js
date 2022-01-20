import PageLayout from '../../../components/PageLayout/PageLayout';
import ExerciseSentences from '../../../components/ExerciseSentences/ExerciseSentences';
import { backendDomain } from '../../../components/variables';

export const getServerSideProps = async () => {
    const res = await fetch(`${backendDomain}/api/exercisesSentences`);

    let data = await res.json();
    data = data[Math.floor(Math.random() * data.length)];

    if (!data) return { notFound: true };
    return { props: { data } };
};

const Home = ({ data }) => (
    <PageLayout title="Sentencje" active="exercises sentences">
        <ExerciseSentences data={data} />
    </PageLayout>
);

export default Home;
