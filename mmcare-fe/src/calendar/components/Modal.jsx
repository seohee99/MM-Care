import styled from "styled-components";
import moment from "moment";
import { useEffect, useState } from "react";

export default function Modal({ today, plan, modalClose }) {
  const [plans, setPlans] = useState([]);

  const onCloseModal = (e) => {
    if (e.target === e.currentTarget) {
      modalClose();
    }
  };

  const isBetweenDate = (today, startDate, endDate) => {
    return moment(moment(today).format("YYYY-MM-DD")).isBetween(
      moment(startDate).format("YYYY-MM-DD"),
      moment(endDate).format("YYYY-MM-DD"),
      undefined,
      "[]"
    );
  };

  useEffect(() => {
    let tmp_plans = [];
    for (let i = 0; i < plan.length; i++) {
      if (isBetweenDate(today, plan[i].calStartDate, plan[i].calEndDate)) {
        tmp_plans.push(plan[i]);
        setPlans(tmp_plans);
      }
    }
    //   console.log(plan);
    console.log(plans);
  }, [plan]);

  return (
    <ModalContainer onClick={onCloseModal}>
      <ModalBox>
        <div>
          {today.getFullYear()}-{today.getMonth() + 1}-{today.getDate()}
        </div>
        <div>
          {plans?.map((index, item) => (
            <div>{item.calStartDate}</div>
          ))}
        </div>
      </ModalBox>
    </ModalContainer>
  );
}

const ModalContainer = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 10;
  position: fixed;
  top: 0;
  left: 0;
`;

const ModalBox = styled.div`
  width: 80%;
  height: 50%;
  background-color: #fff;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  z-index: 100;
  overflow: scroll;
`;
