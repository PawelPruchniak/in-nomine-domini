import styles from './AddButton.module.css';
import { NoteAdd } from "@material-ui/icons";

const AddButton = ({ href, name }) => {

    return (
        <div className={styles.addDocumentButtonContainer}>
            <a href={href} className={styles.addDocumentButton}>
                <NoteAdd />
                <span>{name}</span>
            </a>
        </div>
    );
};

export default AddButton;