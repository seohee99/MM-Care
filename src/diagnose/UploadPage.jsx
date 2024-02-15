import React, { useState } from 'react';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import Box from '@mui/material/Box';
import { StyledButton, SubmitButton, ImageGrid, VisuallyHiddenInput } from './styles';


export default function UploadButton() {
  const [images, setImages] = useState([]);

  const handleImageUpload = (e) => {
    const files = Array.from(e.target.files);
    if (files) {
      const readers = files.map(file => {
        return new Promise((resolve, reject) => {
          const reader = new FileReader();
          reader.onloadend = () => resolve(reader.result);
          reader.onerror = reject;
          reader.readAsDataURL(file)
        });
      });

      Promise.all(readers).then(imagePreviews => {
        setImages(prevImages => [...prevImages, ...imagePreviews]);
      });
    }
  }

  const handleImageDelete = (index) => {
    setImages(prevImages => prevImages.filter((img, i) => i !== index));
  }



  return (
    <Box 
      component="form" 
      encType="multipart/form-data" 
      display="flex" 
      flexDirection="column"
      justifyContent="center" 
      alignItems="center" 
      height="100vh" 
      backgroundColor="beige"
      onSubmit={e => e.preventDefault()} // 지금은 submit 버튼 눌러도 페이지 안넘어감 추후에 고치기 
    >
      <label>
      <StyledButton component="label" variant="contained" startIcon={<CloudUploadIcon />}  type="button">
        진단하고 싶은 사진을 올려주세요
        <VisuallyHiddenInput type="file" accept="image/*" multiple onChange={handleImageUpload} />
      </StyledButton>
      </label>
      <ImageGrid>
        {images.map((imagePreview, index) => (
          <div key={index}>
            <img src={imagePreview} alt={`preview ${index}`} 
            style={{ 
              width: '100px',   
              height: '100px',   
              objectFit: 'cover', 
              marginBottom: '10px'
            }} />
            <button onClick={() => handleImageDelete(index)}
             style={{ 
              border: 'none', 
              padding: '0',           
              background: 'transparent' }}>❌</button>
          </div>
        ))}
      </ImageGrid>
      <SubmitButton type="submit">진단하기</SubmitButton>
    </Box>
  );
}
