import styles from './AdminPageLayout.module.css';
import AdminTopBar from '../AdminTopBar/AdminTopBar';

const AdminPageLayout = ({ title, active, logout, children }) => (
    <>
        <AdminTopBar active={active} logout={logout} />
        <div className={styles.outerLayout}>
            <hr className={styles.marquise} />
            <main className={styles.innerLayout}>
                <h1 className={styles.contentTitle}>{title}</h1>
                <article className={styles.content}>{children}</article>
            </main>
        </div>
    </>
);

export default AdminPageLayout;
