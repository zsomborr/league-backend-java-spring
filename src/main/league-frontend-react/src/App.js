import Champions from "./components/Champions";
import ChampionDetail from "./components/ChampionDetail";
import Navbar from "./components/Navbar";
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";
import { FavouriteProvider } from "./contexts/FavouriteContext";
import FavouriteChampions from "./components/FavouriteChampions";
import UserDetail from "./components/UserDetail";
import LoginModal from "./components/LoginModal";
import RegisterModal from "./components/RegisterModal";
import { useState } from "react";
import News from "./components/News";
import { UserProvider } from "./contexts/UserContext";

function App() {
  const [showLogin, setShowLogin] = useState(false);
  const [showRegister, setShowRegister] = useState(false);

  const toggleLoginModal = () => {
    setShowLogin(!showLogin);
  };

  const toggleRegisterModal = () => {
    setShowRegister(!showRegister);
  };

  const onLogin = () => {
    toggleLoginModal();
  };

  return (
    <UserProvider>
      <FavouriteProvider>
        <Router>
          <Navbar
            toggleLoginModal={toggleLoginModal}
            toggleRegisterModal={toggleRegisterModal}
          />
          <Route
            exact
            path="/"
            render={() => {
              return <Redirect to="/news" />;
            }}
          />
          <Route path="/champions" exact component={Champions} />
          <Route
            path="/championDetail/:championId"
            component={ChampionDetail}
          />
          <Route path="/favouriteChampions" component={FavouriteChampions} />
          <Route path="/userDetail" component={UserDetail} />
          <Route path="/news" component={News} />
          {showLogin && (
            <LoginModal toggleLoginModal={toggleLoginModal} onLogin={onLogin} />
          )}
          {showRegister && (
            <RegisterModal toggleRegisterModal={toggleRegisterModal} />
          )}
        </Router>
      </FavouriteProvider>
    </UserProvider>
  );
}

export default App;
