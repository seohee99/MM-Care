import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:9999",
  withCredentials: true,
});

const fetchGroups = async (groupId) => {
  const { data: groups } = await instance.get(
    `/calendarTest/groupDog/${groupSeq}`
  );
};
