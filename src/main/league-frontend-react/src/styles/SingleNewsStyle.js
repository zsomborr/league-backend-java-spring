import styled from "styled-components";

export const Link = styled.a`
  float: right;
  color: yellow;
  margin-right: 1%;
`;

export const SingleNewsCard = styled.div`
  opacity: 0.93;
  background-color: #2c5d72;
  color: #d3b509;
  padding: 1%;
  margin: 1%;
  width: 96%;
  border-radius: 20px;
  border: 1px solid #d3b509;
  font-weight: 900;
`;

export const Title = styled.div`
  font-size: 1.5rem;
`;

export const Data = styled.div`
  font-size: 0.8rem;
  font-style: italic;
`;

export const PaginationButton = styled.button`
  font-size: 0.8rem;
  font-style: italic;
  background-color: #2c5d72;
  color: #d3b509;
  border-radius: 10px;
  padding: 1%;
  margin: 0% 1%;
  font-weight: 900;
`;

export const PaginationButtonContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;
