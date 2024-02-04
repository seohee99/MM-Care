import React, { useEffect } from 'react';
import styled from 'styled-components';

/* Image */
import naverBtnImg from './image/naver_login.png';
import kakaoBtnImg from './image/kakao_login.png';
import backgroundImg from './image/background.png';
import logoImg from './image/logo.png';
import dogImg from './image/dog.png';


function LoginPage() {
    
    const handleLoginClick = () => {
        window.open(process.env.REACT_APP_KAKAO_LOGIN_URL, '_self');
    };

    return (
        <Container>
            <Wrapper>
                <Box>
                    <img src={logoImg} alt="" />
                </Box>
                <Box>
                    <Intro>멍뭉케어를 소개합니다!</Intro>
                </Box>
                <Box>
                    <LoginBox>
                        <div style={{display: "flex", alignItems: "center"}}>
                            <div style={{fontWeight: "bold", color: "#3B362B"}}>멍뭉케어 시작하기</div>
                        </div>
                        <div style={{padding:"20px", display: "flex", justifyContent: "space-between" }}>
                            <img src={kakaoBtnImg} onClick={handleLoginClick} style={{height: "40px"}}/>
                            <img src={naverBtnImg} style={{height: "40px"}}/>
                        </div>
                    </LoginBox>
                </Box>    
            </Wrapper>
        </Container>
    )
}

const Container = styled.div`
    background-image: url(${backgroundImg});
    width: 100%;
    height: 100vh;
`

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
`
const Box = styled.div`
    width: 100%;
    padding: 20px;
    display: flex;
    justify-content: center;
    margin-left: 13px;
`

const Intro = styled.div`
    box-shadow: 0 20px 25px -5px rgb(0 0 0 / 0.1), 0 8px 10px -6px rgb(0 0 0 / 0.1);
    padding: 10px;
    border-radius: 0.75rem;
    color: #3B362B;
    font-weight:bold;
`

const LoginBox = styled.div`
    display: flex;
    flex-direction: column;
    padding: 10px;
    margin-top: 105px;
`
const Dog = styled.img`
    height: 24px;
`

export default LoginPage;