import { Modal, ModalContent } from "../styles/ModalStyle.js";
import { useState } from "react";
import { API_BASE_URL } from "../constants";

const RegisterModal = ({ toggleRegisterModal }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const onRegister = () => {
    toggleRegisterModal();
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email: email, password: password }),
    };
    fetch(`${API_BASE_URL}/register`, requestOptions).then((response) =>
      console.log(response)
    );
  };

  return (
    <Modal>
      <ModalContent>
        <button
          style={{ float: "right", backgroundColor: "red", fontWeight: "bold" }}
          onClick={toggleRegisterModal}
        >
          X
        </button>
        <form onSubmit={onRegister}>
          <h3>Register</h3>

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
            Register
          </button>
        </form>
      </ModalContent>
    </Modal>
  );
};

export default RegisterModal;
