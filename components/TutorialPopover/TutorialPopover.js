import { StyledPopover, StyledTypography } from './TutorialPopover.styles';
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos';

export const TutorialPopover = ({ content, anchorEl, handleClose }) => {
    const open = Boolean(anchorEl);
    const id = open ? 'simple-popover' : undefined;
    return (
        <StyledPopover
            id={id}
            open={open}
            anchorEl={anchorEl}
            anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
            }}
        >
            <StyledTypography>{content}</StyledTypography>
            <ArrowForwardIosIcon onClick={handleClose} />
        </StyledPopover>
    );
};
