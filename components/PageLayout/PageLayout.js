import styles from './PageLayout.module.css';
import TopBar from '../TopBar/TopBar';

const PageLayout = ({ title, active, children }) => (
    <>
        <TopBar active={active} />
        <div className={styles.outerLayout}>
            <hr className={styles.marquise} />
            <main className={styles.innerLayout}>
                <h1 className={styles.contentTitle}>{title}</h1>
                <article className={styles.content}>{children}</article>
            </main>
        </div>
    </>
);

export default PageLayout;
