import styles from './Button.module.css';

const Button = ({ children, special, href, color, size }) => {

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
        <a
            href={href}
            className={handleClassNames()}
        >
            {children}
        </a>
    )
};

Button.defaultProps = {
    special: null,
    href: '/',
    color: true,
};

export default Button;
