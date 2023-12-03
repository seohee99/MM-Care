import React, { useEffect } from "react";
import styled from "styled-components";
import axios from "axios";

function CarePage() {
  return (
    <>
      <Container>
        <MainInfo>
          <p>메인 정보</p>
        </MainInfo>
        <Notice>
          <p>공지 사항</p>
        </Notice>
        <Eat>
          <Type>
            <a>식사</a>
          </Type>
          <CheckCnt>
            <a>123</a>
          </CheckCnt>
        </Eat>
        <Walk>
          <Type>
            <a>산책</a>
          </Type>
          <CheckCnt>
            <a>123</a>
          </CheckCnt>
        </Walk>
        <Medicine>
          <Type>
            <a>약</a>
          </Type>
          <CheckCnt>
            <a>123</a>
          </CheckCnt>
        </Medicine>
        <Poop>
          <Type>
            <a>배변</a>
          </Type>
          <CheckCnt>
            <a>123</a>
          </CheckCnt>
        </Poop>
      </Container>
    </>
  );
}

const Container = styled.div`
  width: 100%;
  height: 100%;
  background-color: aqua;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
const MainInfo = styled.div`
  width: 90%;
  height: 15%;
  margin-top: 12%;
  background-color: blue;
`;

const Notice = styled.div`
  width: 80%;
  height: 15%;
  margin-top: 3%;
  background-color: gray;
`;
const Eat = styled.div`
  width: 80%;
  height: 9%;
  margin-top: 3%;
  background-color: green;
  display: flex;
  flex-direction: row;
`;
const Walk = styled.div`
  width: 80%;
  height: 9%;
  margin-top: 3%;
  background-color: yellow;
  display: flex;
  flex-direction: row;
`;
const Medicine = styled.div`
  width: 80%;
  height: 9%;
  margin-top: 3%;
  background-color: aquamarine;
  display: flex;
  flex-direction: row;
`;
const Poop = styled.div`
  width: 80%;
  height: 9%;
  margin-top: 3%;
  background-color: beige;
  display: flex;
  flex-direction: row;
`;
const Type = styled.div`
  width: 30%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
`;
const CheckCnt = styled.div`
  width: 69%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export default CarePage;
