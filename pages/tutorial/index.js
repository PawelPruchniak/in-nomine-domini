import PageLayout from '../../components/PageLayout/PageLayout';
import About from '../../components/About/About';
import Button from '../../components/Button/Button';

const Home = () => (
    <PageLayout title="Wprowadzenie" active="instruction">
        <About />
    </PageLayout>
);

export default Home;
