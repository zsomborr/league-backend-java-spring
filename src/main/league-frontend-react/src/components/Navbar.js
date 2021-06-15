import { Ul, Li, NavLink, InputBar, NavElement } from "../styles/NavBarStyle";
import Tags from "./Tags";
import { useLocation } from "react-router-dom";
import { useState, useContext } from "react";
import { UserContext } from "../contexts/UserContext";

const Navbar = ({ toggleLoginModal, toggleRegisterModal }) => {
  const location = useLocation();

  const [text, setText] = useState("");
  const [user, setUser] = useContext(UserContext);

  const handleOnChange = (e) => {
    setText(e.target.value);
  };

  const onLogout = () => {
    setUser(null);
  };

  return (
    <Ul>
      <Li>
        <NavLink to="/news">Main Page</NavLink>
      </Li>
      <Li>
        <NavLink to="/champions">Champions</NavLink>
      </Li>
      <Li>
        {sessionStorage.getItem("user") !== null && (
          <NavLink to="/favouriteChampions">Favourites</NavLink>
        )}
      </Li>
      <Li>{location.pathname === "/champions" && <Tags />}</Li>
      <Li>
        <InputBar
          type="search"
          id="search"
          name="search"
          value={text}
          onChange={handleOnChange}
        />
      </Li>
      <Li>
        <NavLink to={{ pathname: "/userDetail", search: `?user=${text}` }}>
          Search For User
        </NavLink>
      </Li>
      <Li style={{ float: "right" }}>
        {user !== null ? (
          <NavElement onClick={onLogout}>Logout</NavElement>
        ) : (
          <NavElement onClick={toggleLoginModal}>Login</NavElement>
        )}
      </Li>
      <Li style={{ float: "right" }}>
        {user === null && (
          <NavElement onClick={toggleRegisterModal}>Register</NavElement>
        )}
      </Li>
    </Ul>
  );
};

export default Navbar;
