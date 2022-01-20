import PageLayout from '../../../../components/PageLayout/PageLayout';
import SubBar from '../../../../components/SubBar/SubBar';
import ExerciseGrid from '../../../../components/ExerciseGrid/ExerciseGrid';
import { backendDomain } from '../../../../components/variables';

export const getServerSideProps = async () => {
    // params contains the post `id`.
    // If the route is like /posts/1, then params.id is equal to 1.
    const res = await fetch(`${backendDomain}/api/document/century/XIV`);
    const data = await res.json();

    // Fallback for cases, where page was generated before but content is removed.
    if (!data) return { notFound: true };
    // Pass post data to the page via props.
    return { props: { data } };
};

const Home = ({ data }) => (
    <PageLayout title="Transkrypcja" active="exercises transcription">
        <SubBar active="XIV" />
        <ExerciseGrid data={data} subpage="XIV" />
    </PageLayout>
);

export default Home;
