import styles from './Error404.module.css';
import Button from '../Button/Button';

const Error404 = () => (
    <div className={styles.wrapper}>
        <h1 className={styles.title}>404</h1>
        <h2 className={styles.subTitle}>Aliquid abiit iniuriam</h2>
        <div className={styles.box}>
            <p className={styles.info}>Coś poszło nie tak?</p>
            <Button href="/" color={false}>
                Wróć na stronę główną
            </Button>
        </div>
    </div>
);

export default Error404;
