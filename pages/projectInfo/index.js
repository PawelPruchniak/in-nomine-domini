import PageLayout from '../../components/PageLayout/PageLayout';
import ProjectInfo from '../../components/ProjectInfo/ProjectInfo';

const Home = () => (
    <PageLayout title="O projekcie" active="projectInfo">
        <ProjectInfo />
    </PageLayout>
);

export default Home;
