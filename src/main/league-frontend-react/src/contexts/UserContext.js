import { useState, createContext, useEffect } from "react";

export const UserContext = createContext();

export const UserProvider = (props) => {
  const [user, setUser] = useState(sessionStorage.getItem("user"));

  useEffect(() => {
    user === null
      ? sessionStorage.removeItem("user")
      : sessionStorage.setItem("user", user);
  }, [user]);

  return (
    <UserContext.Provider value={[user, setUser]}>
      {props.children}
    </UserContext.Provider>
  );
};
