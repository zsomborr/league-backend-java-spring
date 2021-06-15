import styled from "styled-components";
import { Link } from "react-router-dom";

export const Li = styled.li`
  float: left;
`;

export const Ul = styled.ul`
  list-style-type: none;
  overflow: hidden;
  background-color: #d3b509;
`;

export const NavLink = styled(Link)`
  display: block;
  color: #2c5d72;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  &:hover {
    background-color: #ffdb0e;
  }
`;

export const NavElement = styled.div`
  display: block;
  color: #2c5d72;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  &:hover {
    background-color: #ffdb0e;
  }
`;

export const InputBar = styled.input`
  display: block;
  color: #2c5d72;
  text-align: left;
  margin: 14px 16px;
  text-decoration: none;
`;
