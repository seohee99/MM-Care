import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

function FoodCarePage() {
  const movePage = useNavigate();
  function gohome() {
    movePage("/");
  }
  return (
    <>
      <Main>
        <form action="/">
          <input type="text"></input>
          <input
            type="button"
            value={"식사관리 페이지"}
            onClick={gohome}
          ></input>
        </form>
      </Main>
    </>
  );
}

const Main = styled.div`
  width: 100%;
  height: 100%;
  padding: 10%;
`;
export default FoodCarePage;
