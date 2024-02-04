import React from "react";

import careImg from './image/care.jpg';
import calendarImg from './image/calendar.jpg';
import aiDoctorImg from './image/ai-doctor.jpg';
import guideImg from './image/guide.jpg';
import settingImg from './image/setting.jpg';
import styled from "styled-components";

function Navigation(){

    return(
        <>
            <div style={{display: 'flex', justifyContent: 'space-around', alignItems: 'center'}}>
                <img src={careImg} alt="" style={{height: "50px"}}/>
                <img src={calendarImg} alt="" style={{height: "50px"}}/>
                <img src={guideImg} alt="" style={{height: "50px"}}/>
                <img src={aiDoctorImg} alt="" style={{height: "50px"}}/>
                <img src={settingImg} alt="" style={{height: "50px"}}/>
            </div>
        </>
    )
}

export default Navigation;

const Img = styled`

`;