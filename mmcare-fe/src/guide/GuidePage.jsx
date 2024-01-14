import * as React from 'react';
import { useState } from 'react';
import List from '@mui/joy/List';
import ListItem from '@mui/joy/ListItem';
import Sheet from '@mui/joy/Sheet';
import VideoPlayer, { videos } from './VideoPlayer';
import ChatModal from './ChatModal';

export default function GuideList() {

  const [search, setSearch] = React.useState('');

  const filteredVideos = videos.filter(video => video.title.includes(search)); // 검색어가 포함된 동영상만 필터링

  const inputStyle = {
    width: '500px',
    height: '32px',
    fontSize: '15px',
    border: '0',
    borderRadius: '15px',
    outline: 'none',
    paddingLeft: '10px',
    backgroundColor: '#719049',
    marginBottom: '60px',
    marginTop: '20px'
  };

  const titleStyle = {
    color: 'darkgreen',
    textAlign: 'center'
  };

  const listItemStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginBottom: '20px'

  };

 

  return (

    
    <Sheet
      sx={{
        position: 'relative',
        display: 'flex', 
        flexDirection: 'column', 
        justifyContent: 'center', // 가운데 정렬
        alignItems: 'center', // 가운데 정렬
        width: '100%', // 너비를 100%로 설정
        maxHeight: 'none', // maxHeight 제거
        overflow: 'auto',
        borderRadius: 'sm',
        backgroundColor: 'beige',
      }}
    >


      <input type="text" value={search} onChange={e => setSearch(e.target.value)} placeholder="Search..." style={inputStyle}/>
      <List>
      {filteredVideos.map((video, index) => (
          <ListItem key={index} style={listItemStyle} >
            <VideoPlayer videoId={video.id} />
            <p style={titleStyle}>{video.title}</p>
            </ListItem>
      ))}
      </List>
     <ChatModal/>   
    </Sheet>
    
  );
}