import { useEffect, useState } from "react";
import Calendar from "react-calendar";
import "./Calendar.css";
import styled from "styled-components";
import axios from "axios";
import moment from "moment";
import Circle from "./components/Circle";
import Modal from "./components/Modal";

//그룹 선택할때마다, 몇월달인지 바꿀때마다 api 호출하고 캘린더 부르도록 수정하기
export default function CalendarPage() {
  const [selectedGroup, setSelectedGroup] = useState(1);
  const [value, onChange] = useState(new Date());
  const [groups, setGroups] = useState([]);
  const [plan, setPlan] = useState([]);
  const monthOfActiveDate = moment(value).format("YYYY-MM");
  const [activeMonth, setActiveMonth] = useState(monthOfActiveDate);

  const [isOpen, setIsOpen] = useState(false);
  const openModalHandler = () => {
    setIsOpen((cur) => !cur);
  };

  useEffect(() => {
    axios.get("http://localhost:9999/calendarTest/groupDog/1").then((res) => {
      console.log(res.data);
      setGroups(res.data);
    });
    axios
      .get(
        "http://localhost:9999/calendar/monthly?groupSeq=1&year=2023&month=1"
      )
      .then((res) => {
        setPlan(res.data);
        console.log(plan);
      });
  }, []);

  useEffect(() => {
    openModalHandler();
  }, [value]);

  const isBetweenDate = (today, startDate, endDate) => {
    return moment(moment(today).format("YYYY-MM-DD")).isBetween(
      moment(startDate).format("YYYY-MM-DD"),
      moment(endDate).format("YYYY-MM-DD"),
      undefined,
      "[]"
    );
  };

  const addContent = ({ date }) => {
    const contents = [];
    const contentDict = {};

    for (let i = 0; i < plan.length; i++) {
      if (isBetweenDate(date, plan[i].calStartDate, plan[i].calEndDate)) {
        if (
          plan[i].aniSeq + "/" + moment(date).format("YYYY-MM-DD") in
          contentDict
        ) {
          continue;
        }
        contents.push(<Circle></Circle>);
        contentDict[
          plan[i].aniSeq + "/" + moment(date).format("YYYY-MM-DD")
        ] = true;
      }
    }
    return <div>{contents}</div>;
  };

  const getActiveMonth = (activeStartDate) => {
    const newActiveMonth = moment(activeStartDate).format("YYYY-MM");
    setActiveMonth(newActiveMonth);
  };

  return (
    <Container>
      <H1>그룹 캘린더</H1>
      <SelectBox>
        <Select>
          {groups?.map((item) => (
            <Option key={item.pet_seq}>{item.pet_name}</Option>
          ))}
        </Select>
      </SelectBox>
      <Calendar
        onChange={onChange}
        value={value}
        tileContent={addContent}
        onActiveStartDateChange={({ activeStartDate }) =>
          getActiveMonth(activeStartDate)
        }
      />
      <div>{activeMonth}</div>
      <button>PLUS</button>

      {isOpen ? (
        <Modal today={value} plan={plan} modalClose={openModalHandler} />
      ) : null}
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const H1 = styled.p`
  font-size: 1.25rem; /* 20px */
  line-height: 1.75rem; /* 28px */
`;

const SelectBox = styled.div`
  position: relative;
  width: 80%;
  height: 35px;
  border-radius: 4px;
  border: 2px solid #fff9f1;
  margin: 10px 0;
`;

const Select = styled.select`
  width: 100%;
  height: inherit;
  background: transparent;
  border: 0 none;
  outline: 0 none;
  padding: 0 5px;
  position: relative;
  z-index: 3; // select가 위로 올라와야 함
`;

const Option = styled.option`
  background: #fff9f1;
  padding: 3px 0;
  font-size: 16px;
`;
