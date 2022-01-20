import styles from './ContactPage.module.css';
import {AlternateEmailOutlined, HomeOutlined, PhoneOutlined} from "@material-ui/icons";

const ContactPage = () => (
    <div id="contact" className={styles.footer}>
        <div className={styles.footer__wrapper}>
            <ul className={styles.contactList}>
                <li className={styles.contactList__item}>
                    <div className={styles.iconHolder}>
                        <HomeOutlined />
                    </div>
                    <p>
                        <span>Zakład Archiwistyki</span>
                        <span>Instytut Historii UAM</span>
                        <span>ul. Umultowska 89D</span>
                        <span>61-614 Poznań</span>
                    </p>
                </li>
                <li className={styles.contactList__item}>
                    <div className={styles.iconHolder}>
                        <PhoneOutlined />
                    </div>
                    <p>61 829-14-65</p>
                </li>
                <li className={styles.contactList__item}>
                    <div className={styles.iconHolder}>
                        <AlternateEmailOutlined />
                    </div>
                    <p>biszkopt@amu.edu.pl</p>
                </li>
            </ul>
            <div className={styles.mapImage}>
                <img
                    alt="Mapa z lokalizacją Zakładu Archiwistyki Instytutu Historii UAM"
                    src="map.png"
                />
            </div>
        </div>
    </div>
);

export default ContactPage;
