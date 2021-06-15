import React, { useState, useContext } from "react";
import { Modal, ModalContent } from "../styles/ModalStyle.js";
import { API_BASE_URL } from "../constants";
import { UserContext } from "../contexts/UserContext";

const LoginModal = ({ toggleLoginModal, onLogin }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  // eslint-disable-next-line no-unused-vars
  const [user, setUser] = useContext(UserContext);

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const loginAndSaveUser = (e) => {
    e.preventDefault();
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email: email, password: password }),
    };

    fetch(`${API_BASE_URL}/login`, requestOptions)
      .then((response) => response.json())
      .then((data) => data && handleLoggedIn());
  };

  const handleLoggedIn = () => {
    setUser(email);
    onLogin();
  };

  return (
    <Modal>
      <ModalContent>
        <button
          style={{ float: "right", backgroundColor: "red", fontWeight: "bold" }}
          onClick={toggleLoginModal}
        >
          X
        </button>
        <form onSubmit={loginAndSaveUser}>
          <h3>Sign in</h3>

          <div>
            <label>Email address</label>
            <br />
            <input
              type="email"
              placeholder="Enter email"
              onChange={handleEmailChange}
            />
          </div>

          <div>
            <br />
            <label>Password</label>
            <br />
            <input
              type="password"
              placeholder="Enter password"
              onChange={handlePasswordChange}
            />
          </div>

          <button style={{ marginTop: "15px" }} type="submit">
            Login
          </button>
        </form>
      </ModalContent>
    </Modal>
  );
};

export default LoginModal;
