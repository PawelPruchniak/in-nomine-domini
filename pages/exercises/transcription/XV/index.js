import PageLayout from '../../../../components/PageLayout/PageLayout';
import SubBar from '../../../../components/SubBar/SubBar';
import ExerciseGrid from '../../../../components/ExerciseGrid/ExerciseGrid';
import {backendDomain} from "../../../../components/variables";

export const getServerSideProps = async () => {
    // params contains the post `id`.
    // If the route is like /posts/1, then params.id is equal to 1.
    const res = await fetch(`${backendDomain}/api/document/century/XV`);
    const data = await res.json();

    // Fallback for cases, where page was generated before but content is removed.
    if (!data) return { notFound: true };
    // Pass post data to the page via props.
    return { props: { data } };
};

const Home = ({ data }) => (
    <PageLayout title="Transkrypcja" active="exercises transcription">
        <SubBar active="XV" />
        <ExerciseGrid data={data} subpage="XV" />
    </PageLayout>
);

export default Home;
