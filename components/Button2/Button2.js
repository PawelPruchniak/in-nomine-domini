import styles from './Button2.module.css';

const Button2 = ({ children, special, onClick, color, size }) => {

    const handleClassNames = () => {
        let classNames = '';

        if (size === 'small') {
            classNames += ' ' + styles.small;
        }

        if (color) {
            if (special) {
                classNames += ' ' + styles.special;
            } else {
                classNames += ' ' + styles.button;
            }
        } else {
            classNames += ' ' + styles.whiteButton;
        }

        return classNames;
    };


    return (
        <div
            className={handleClassNames()}
            onClick={onClick}
        >
            {children}
        </div>
    )
};

Button2.defaultProps = {
    special: null,
    onClick: () => null,
    color: true,
};

export default Button2;
