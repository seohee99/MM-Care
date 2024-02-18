import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

import dogImg from "./image/dog.png";
import check from "./image/full.png";
import checkEmpty from "./image/emty.png";

function CareMainPage() {
  const [userId, setUserId] = useState("");
  const [petName, setPetName] = useState("");
  const [petBirtday, setPetBirtday] = useState("");
  const [petGender, setPetGender] = useState("");
  const [foodCnt, setFoodCnt] = useState(0);
  const [walkCnt, setWalkCnt] = useState(0);
  const [mediCnt, setMediCnt] = useState(0);
  const [foodMaxCnt, setFoodMaxCnt] = useState(0);
  const [walkMaxCnt, setWalkMaxCnt] = useState(0);
  const [mediMaxCnt, setMediMaxCnt] = useState(0);

  const [poopCnt, setPoopCnt] = useState(0);
  const [peeCnt, setPeeCnt] = useState(0);

  useEffect(() => {
    sessionStorage.setItem("userId", 1);
    sessionStorage.setItem("petName", "멈뭄미");
    sessionStorage.setItem("petBirthday", "1997-09-05");
    sessionStorage.setItem("userId", 1);
    sessionStorage.setItem("foodCnt", 3);
    sessionStorage.setItem("foodMaxCnt", 5);
    sessionStorage.setItem("walkCnt", 2);
    sessionStorage.setItem("walkMaxCnt", 3);
    sessionStorage.setItem("mediCnt", 1);
    sessionStorage.setItem("mediMaxCnt", 6);

    let fetchData = sessionStorage.getItem("userId");
    setUserId(fetchData);

    fetchData = sessionStorage.getItem("petName");
    setPetName(fetchData);

    fetchData = sessionStorage.getItem("petBirthday");
    setPetBirtday(calculateAge(fetchData));

    fetchData = sessionStorage.getItem("petGender");
    setPetGender(fetchData);

    fetchData = sessionStorage.getItem("foodCnt");
    setFoodCnt(fetchData);

    fetchData = sessionStorage.getItem("walkCnt");
    setWalkCnt(fetchData);

    fetchData = sessionStorage.getItem("mediCnt");
    setMediCnt(fetchData);

    fetchData = sessionStorage.getItem("poopCnt");
    setPoopCnt(fetchData);

    fetchData = sessionStorage.getItem("peeCnt");
    setPeeCnt(fetchData);

    fetchData = sessionStorage.getItem("foodMaxCnt");
    setFoodMaxCnt(fetchData);

    fetchData = sessionStorage.getItem("walkMaxCnt");
    setWalkMaxCnt(fetchData);

    fetchData = sessionStorage.getItem("mediMaxCnt");
    setMediMaxCnt(fetchData);

    fetch(`http://localhost:9999/care/food/list`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        petSeq: "2",
        date: "2023-11-26",
        // 필요한 다른 데이터들도 같이 입력해주세요
      }),
    })
      .then((res) => {
        if (res.ok) {
          console.log("식사 체크 성공...");
          return res.json();
        } else {
          throw new Error("식사 체크 추가 실패...");
        }
      })
      .then((res) => {
        console.log(res);
        sessionStorage.setItem("user", JSON.stringify(res));
      })
      .catch((e) => {
        console.error(e);
      });
  }, []);

  const movePage = useNavigate();
  function go() {
    movePage("/aa");
  }
  function goFoodCare() {
    movePage("/foodCare");
  }
  function goWalkCare() {
    movePage("/walkCare");
  }
  function goMediCare() {
    movePage("/mediCare");
  }
  function goPoopCare() {
    movePage("/poopCare");
  }
  return (
    <Container>
      <Profile>
        <ProfileImage src={dogImg} alt="dog profile" />
        <ProfileInfo>
          <h2>멈뭄미 :: {petName}</h2>
          <p>
            2세 :: {petBirtday}/ 여아 :: {petGender}/ {userId}
          </p>
        </ProfileInfo>
      </Profile>

      <Notice>
        <Title>
          <a>공지사항</a>
          <NoticeButton onClick={go}>수정</NoticeButton>
        </Title>
        <a>약 잘 먹이기!</a>
      </Notice>

      <CheckBox onClick={goFoodCare}>
        <ItemName>식사</ItemName>
        <ItemCount>
          체크 횟수: {foodCnt} :: 총 {foodMaxCnt} 회
        </ItemCount>
        <Check>
          {Array.from({ length: parseInt(foodCnt) }).map((_, index) => (
            <img
              key={index}
              src={check}
              style={{ width: "50px", height: "50px" }}
            ></img>
          ))}{" "}
          {Array.from({ length: parseInt(foodMaxCnt - foodCnt) }).map(
            (_, index) => (
              <img
                key={index}
                src={checkEmpty}
                style={{ width: "50px", height: "50px" }}
              ></img>
            )
          )}
        </Check>
      </CheckBox>

      <CheckBox onClick={goWalkCare}>
        <ItemName>산책</ItemName>
        <ItemCount>
          체크 횟수: {walkCnt} :: 총 {walkMaxCnt} 회
        </ItemCount>
        <Check>
          {Array.from({ length: parseInt(walkCnt) }).map((_, index) => (
            <img
              key={index}
              src={check}
              style={{ width: "50px", height: "50px" }}
            ></img>
          ))}{" "}
          {Array.from({ length: parseInt(walkMaxCnt - walkCnt) }).map(
            (_, index) => (
              <img
                key={index}
                src={checkEmpty}
                style={{ width: "50px", height: "50px" }}
              ></img>
            )
          )}
        </Check>
      </CheckBox>

      <CheckBox onClick={goMediCare}>
        <ItemName>약</ItemName>
        <ItemCount>
          체크 횟수: {mediCnt} :: 총 {mediMaxCnt} 회
        </ItemCount>
        <Check>
          {Array.from({ length: parseInt(mediCnt) }).map((_, index) => (
            <img
              key={index}
              src={check}
              style={{ width: "50px", height: "50px" }}
            ></img>
          ))}
          {Array.from({ length: parseInt(mediMaxCnt - mediCnt) }).map(
            (_, index) => (
              <img
                key={index}
                src={checkEmpty}
                style={{ width: "50px", height: "50px" }}
              ></img>
            )
          )}
        </Check>
      </CheckBox>

      <CheckBox onClick={goPoopCare}>
        <ItemName>배변</ItemName>
        <ItemCount>대변 횟수: {poopCnt}</ItemCount>
        <ItemCount>소변 횟수: {peeCnt}</ItemCount>
      </CheckBox>
    </Container>
  );
}

function calculateAge(birthdate) {
  const birthDate = new Date(birthdate);
  const today = new Date();

  let age = today.getFullYear() - birthDate.getFullYear();
  const monthDiff = today.getMonth() - birthDate.getMonth();

  // 생일이 아직 오지 않은 경우, 나이에서 1을 빼줍니다.
  if (
    monthDiff < 0 ||
    (monthDiff === 0 && today.getDate() < birthDate.getDate())
  ) {
    age--;
  }

  return age;
}
const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const Profile = styled.div`
  border: 1px solid #dcdcdc;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  width: 80%;
  margin-top: 10%;
  padding: 20px;
  display: flex;
  flex-direction: row;
  align-items: center;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.5;
  background-color: #f5f5f5;
  color: #333;
`;

const ProfileImage = styled.img`
  width: 100%;
`;

const ProfileInfo = styled.div`
  width: 100%;
  text-align: center;
  font-weight: bold;
  color: #3b362b;
`;

const Notice = styled.div`
  margin-top: 3%;
  padding: 20px;
  border: 1px solid #dcdcdc;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  width: 70%;
  height: 20%;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.5;
  background-color: #f5f5f5;
  color: #333;
`;

const Title = styled.div`
  width: 100%;
  height: 10%;
  font-size: 20px;
  margin-bottom: 3%;
`;

const NoticeButton = styled.button`
  float: right;
`;

const CheckBox = styled.div`
  border: 1px solid #dcdcdc;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  width: 70%;
  height: 9%;
  margin-top: 3%;
  padding: 20px;
  flex-direction: column;
  background-color: #f5f5f5;
  color: #333;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.5;
`;

const ItemName = styled.div`
  width: 100%;
  font-weight: bold;
  color: #3b362b;
`;

const ItemCount = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-around;
`;

const Check = styled.div`
  display: flex;
  justify-content: center;
`;

export default CareMainPage;
