import PageLayout from '../../../../components/PageLayout/PageLayout';
import SubBar from '../../../../components/SubBar/SubBar';
import ExerciseGrid from '../../../../components/ExerciseGrid/ExerciseGrid';
import { backendDomain } from '../../../../components/variables';

export const getServerSideProps = async () => {
    const res = await fetch(`${backendDomain}/api/document/century/XII`);
    const data = await res.json();

    // Fallback for cases, where page was generated before but content is removed.
    if (!data) return { notFound: true };

    return { props: { data } };
};

const Home = ({ data }) => (
    <PageLayout title="Transkrypcja" active="exercises transcription">
        <SubBar active="XII" />
        <ExerciseGrid data={data} subpage="XII" />
    </PageLayout>
);

export default Home;
