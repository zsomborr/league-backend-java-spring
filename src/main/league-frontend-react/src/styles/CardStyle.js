import styled from "styled-components";

export const Card = styled.div`
  /* background-color: ${(props) => props.theme.backgroundColor}; */
  text-align: center;
  float: left;
  color: ${(props) => props.theme.color};
  font-size: 1rem;
`;

export const CardContainer = styled.div`
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  border-radius: 5px;
  background-color: ${(props) => props.theme.backgroundColor};
  text-align: center;
  width: 16.5%;
  padding: 10px;
  padding-bottom: 20px;
  float: left;
  margin: 10px;
  color: ${(props) => props.theme.color};
  font-size: 1rem;
  &:hover {
    box-shadow: 0 10px 18px 5px #000;
    background-color: ${(props) =>
      props.theme.backgroundColor === "#d3b509" ? "#ffdb0e" : "#3888aa"};
    color: white;
  }
`;
