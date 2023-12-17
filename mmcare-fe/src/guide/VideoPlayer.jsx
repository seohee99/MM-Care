
export const videos = [
    { id: 'CtFf5oTspxg?si=oEc3JWehVzdo4A9h', title: '강아지가 뽀뽀를 싫어하는 이유 4가지' },
    { id: 'fbvx6kPEddw?si=OqrZRN9ji-Zh0077', title: '강아지가 하울링 하는 이유' },
    { id: 'zcDVCI4nRJw?si=RQFnAcsgnO8ErHFe', title: '유기견을 받아들이려면..' },
    { id: '6Wa499KgEkU?si=NHmGram2_CC2bxzu', title: '유기소에 간 강아지는 어떻게 ..' },
    { id: 'AcA7cIBbKR8?si=XCeUwa8nBM1aL5RK', title: '강아지가 삐졌을 때 하는 행동' },
  ];


const VideoPlayer = ({ videoId }) => (
    <iframe width="560" height="315" src={`https://www.youtube.com/embed/${videoId}`}
      title="YouTube video player" frameborder="0" 
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; 
      gyroscope; picture-in-picture; web-share" allowfullscreen>
    </iframe>
  );
  
  export default VideoPlayer;