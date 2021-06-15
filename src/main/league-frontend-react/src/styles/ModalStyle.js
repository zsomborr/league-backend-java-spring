import styled from "styled-components";

export const Modal = styled.div`
  display: block; /* Hidden by default */
  position: fixed; /* Stay in place */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
`;

export const ModalContent = styled.div`
  background-color: #2c5d72;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #d3b509;
  width: 25%;
  text-align: center;
  border-radius: 30px;
  color: #d3b509;
`;
