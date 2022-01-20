import styles from './Logo.module.css';

const Logo = (size) => {

    const handleClassNames = () => {
        let classNames = styles.topBarLogo;

        if (size === 'medium') {
            classNames += ' medium';
        }

        return classNames;
    };

    return (
        <a href="/" className={handleClassNames()}>
            <img
                src="/logotyp.png"
                alt="Uniwersytet im. Adama Mickiewicza w Poznaniu"
            />
        </a>
    );
};

export default Logo;
