import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';

export const VisuallyHiddenInput = styled('input')({
    position: 'absolute',
    width: 1,
    height: 1,
    margin: -1,
    padding: 0,
    overflow: 'hidden',
    clip: 'rect(0, 0, 0, 0)',
    whiteSpace: 'nowrap',
    border: 0,
  });
  
export const StyledButton = styled(Button)({
      backgroundColor: 'green',
      '&:hover': {
        backgroundColor: 'darkgreen',
      },
  });
  
export const SubmitButton = styled(Button)({
    backgroundColor: 'beige',
    '&:hover': {
      backgroundColor: 'darkgreen',
    },
  });
  
export const ImageGrid = styled('div')({
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gridTemplateRows: 'repeat(2, 1fr)',
    gap: '1rem',
  });