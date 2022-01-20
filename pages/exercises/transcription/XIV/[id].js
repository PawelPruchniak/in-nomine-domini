import PageLayout from '../../../../components/PageLayout/PageLayout';
import Transcription from '../../../../components/Transcription/Transcription';
import DocumentImage from '../../../../components/DocumentImage/DocumentImage';
import { backendDomain } from '../../../../components/variables';

export const getServerSideProps = async ({ params }) => {
    const res = await fetch(`${backendDomain}/api/document/${params.id}`);
    const post = await res.json();
    return { props: { post } };
};

const Home = ({ post }) => (
    <PageLayout title="Transkrypcja" active="exercises transcription">
        <DocumentImage imgData={post.image} title={post.description} />
        <Transcription parsedTranscription={post.parsedTranscription} />
    </PageLayout>
);

export default Home;
