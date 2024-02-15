import React, { useState, useEffect }  from 'react';
import axios from 'axios';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';

const containerStyle = {
    width: '80%',
    height: '400px',
    margin : 'auto'
};

function MapComponent({ location }) {
    const [hospitals, setHospitals] = useState([]);
    const handleListItemClick = (phone) => {
        alert(`병원 전화번호: ${phone}`); //alert창으로 할지 모달창 열려서 번호뜨게 할지 물어보기 
    };

    useEffect(() => {
        const script = document.createElement("script");
        script.async = true;
        script.src =
            "//dapi.kakao.com/v2/maps/sdk.js?appkey=a9fb92eacd90cea67430fd4cf9c94d27&autoload=false";
            
        document.head.appendChild(script);

        script.onload = () => {
            window.kakao.maps.load(() => {
                let container = document.getElementById("Mymap"); // 지도를 담을 영역의 DOM 레퍼런스
                let options = {
                    // 지도를 생성할 때 필요한 기본 옵션
                    center: new window.kakao.maps.LatLng(location.lat, location.lng), // 지도의 중심좌표.
                    level: 3, // 지도의 레벨(확대, 축소 정도)
                };

                // 지도 생성 및 객체 리턴
                const map = new window.kakao.maps.Map(container, options);
                new window.kakao.maps.Marker({ position: map.getCenter(), map: map });
                hospitals.forEach((hospital) => {
                    const marker = new window.kakao.maps.Marker({
                        position: new window.kakao.maps.LatLng(hospital.y, hospital.x),
                        map: map,
                    });

                    window.kakao.maps.event.addListener(marker, 'click', function() {
                        const infowindow = new window.kakao.maps.InfoWindow({
                            content: `<div style="padding:5px;font-size:14px;">${hospital.place_name}<br/>${hospital.address_name}</div>` 
                        });
                        infowindow.open(map, marker); 
                    });
                });
            });
        };
    }, [location, hospitals]);

    const getNearbyHospitals = async () => {
        try {
            const { data } = await axios.get(`https://dapi.kakao.com/v2/local/search/keyword.json?y=${location.lat}&x=${location.lng}&radius=2000&query=동물병원`, {
                headers: { 'Authorization': "KakaoAK 974cec09da302528a40953dbc42aefe6" }
            });
            setHospitals(data.documents);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <Box  
        display="block" 
        alignItems="center" 
        backgroundColor="beige"
        >
        <Button onClick={getNearbyHospitals} >병원 찾기</Button>
        <div id="Mymap" style={containerStyle}></div>
        <List>
            {hospitals.map((hospital, index) => (
                <ListItem key={index} onClick={() => handleListItemClick(hospital.phone)}>
                    <ListItemText primary={hospital.place_name} secondary={hospital.address_name} />
                </ListItem>
            ))}
        </List>
        </Box>
    );
}

class MapContainer extends React.Component {
    state = {
        location: { lat: 0, lng: 0 },
    };

    componentDidMount() {
        navigator.geolocation.getCurrentPosition((position) => {
            this.setState({
                location: { lat: position.coords.latitude, lng: position.coords.longitude },
            });
        });
    }

    render() {
        return <MapComponent location={this.state.location} />;
    }
}

export default MapContainer;