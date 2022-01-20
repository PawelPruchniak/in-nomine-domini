import styles from './ExerciseGrid.module.css';
import ExerciseItem from '../ExerciseItem/ExerciseItem';

const ExerciseGrid = ({ type, subpage, data }) =>
    data.length ? (
        <div className={styles.base}>
            {data.map((document) => (
                <ExerciseItem
                    type={type}
                    key={document.id}
                    imgUrl = {document.image.lightPath} 
                    text = {document.description} 
                    difficulty = {document.difficultyLevel} 
                    url = {`${type}/${subpage}/${document.id}`}
                />
            ))}
        </div>
    ) : (
        <p className={styles.emptyBase}>Brak dokumentów do transkrypcji</p>
    );

ExerciseGrid.defaultProps = {
    type: 'transcription',
};

export default ExerciseGrid;
