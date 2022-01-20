import PageLayout from '../../components/PageLayout/PageLayout';
import ContactPage from "../../components/ContactPage/ContactPage";

const Home = () => (
    <PageLayout title="Kontakt" active="contact">
        <ContactPage />
    </PageLayout>
);

export default Home;
