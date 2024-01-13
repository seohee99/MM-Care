import styled from "styled-components";

export default function Circle({ color }) {
  return <Mark color={color}></Mark>;
}

const Mark = styled.div`
  width: 10px;
  height: 10px;
  border-radius: 9999px;
  background: red;
`;
