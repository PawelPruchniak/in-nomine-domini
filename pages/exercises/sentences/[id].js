import PageLayout from '../../../components/PageLayout/PageLayout';
import ExerciseSentences from '../../../components/ExerciseSentences/ExerciseSentences';
import { backendDomain } from '../../../components/variables';

export const getServerSideProps = async ({ params }) => {
    const res = await fetch(
        `${backendDomain}/api/exerciseSentences/random/${params.id}`
    );

    let data = await res.json();
    if (!data) return { notFound: true };
    return { props: { data } };
};

const Home = ({ data }) => {
    return (
        <PageLayout title="Sentencje" active="exercises sentences">
            <ExerciseSentences data={data} />
        </PageLayout>
    );
};

export default Home;
