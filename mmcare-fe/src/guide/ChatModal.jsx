import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import chat from './image/chat.png'; 

export default function ChatModal() {
  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const imgStyle ={
      cursor: 'pointer', 
      width: '150px', 
      height: '150px', 
      right: '100px',
      overflow: 'hidden',
      align : 'right'
  };
  
  const chatStyle ={
    position: 'absolute',
    bottom: '1px',
    right: '1px'
  }
  return (
    <div style={chatStyle}>
      <img src={chat} alt="chat" style={imgStyle} onClick={handleClickOpen} /> {/* 이미지 클릭 시 ChatModal 열기 */}
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>물어보고 싶은 걸 물어보라 멍!</DialogTitle>
        <DialogContent>
          {/* Chatbot Interface goes here */}
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Close</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
