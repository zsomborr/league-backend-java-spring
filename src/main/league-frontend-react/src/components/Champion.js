import { Link } from "react-router-dom";
import { Card, CardContainer } from "../styles/CardStyle.js";
import { ThemeProvider } from "styled-components";
import { useState, useEffect, useContext } from "react";
import { FavouriteContext } from "../contexts/FavouriteContext";
import { Icon } from "@iconify/react";
import starIcon from "@iconify-icons/entypo/star";
import { UserContext } from "../contexts/UserContext";

const Champion = ({ champion }) => {
  const [theme, setTheme] = useState({
    color: "#d3b509",
    backgroundColor: "#2c5d72",
  });

  const [favouriteChampions, setFavouriteChampions] =
    useContext(FavouriteContext);
  // eslint-disable-next-line no-unused-vars
  const [user, setUser] = useContext(UserContext);

  useEffect(() => {
    champion.free
      ? setTheme((oldTheme) => ({
          ...oldTheme,
          color: "#2c5d72",
          backgroundColor: "#d3b509",
        }))
      : setTheme((oldTheme) => ({
          ...oldTheme,
          color: "#d3b509",
          backgroundColor: "#2c5d72",
        }));
  }, [champion.key, champion.free]);

  const isChampion = (element) => element.key === champion.key;

  const toggleFavouriteChamp = (e) => {
    let index = favouriteChampions.findIndex(isChampion);
    let changedFavChamps = [...favouriteChampions];
    index === -1
      ? (changedFavChamps = [...changedFavChamps, champion])
      : changedFavChamps.splice(index, 1);
    setFavouriteChampions(changedFavChamps);
  };

  return (
    <ThemeProvider theme={theme}>
      <CardContainer>
        {user && (
          <Icon
            icon={starIcon}
            color={
              favouriteChampions
                .map((favouriteChampion) => favouriteChampion.key)
                .includes(champion.key)
                ? theme.color
                : "black"
            }
            onClick={toggleFavouriteChamp}
          />
        )}
        <Link
          to={{
            pathname: `/championDetail/${champion.key}`,
            state: { champion: champion },
          }}
        >
          <Card>
            <img
              width="100%"
              alt="test"
              src={`https://ddragon.canisback.com/img/champion/tiles/${
                champion.id === "Fiddlesticks" ? "FiddleSticks" : champion.id
              }_0.jpg`}
            ></img>
            <br />
            {champion.name}
            <br />
            {champion.title}
          </Card>
        </Link>
      </CardContainer>
    </ThemeProvider>
  );
};

export default Champion;
