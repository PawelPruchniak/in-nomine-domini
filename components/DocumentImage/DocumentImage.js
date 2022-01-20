import styles from './DocumentImage.module.css';
import InnerImageZoom from 'react-inner-image-zoom';
import 'react-inner-image-zoom/lib/InnerImageZoom/styles.css';

const DocumentImage = ({ imgData, title }) => (
    <div className={styles.docContainer}>
        <div className={styles.imgWrapper}>
            <InnerImageZoom
                className={styles.heightFix}
                src={imgData.path}
                zoomSrc={imgData.path}
                moveType="drag"
            />
        </div>
    </div>
);

export default DocumentImage;
