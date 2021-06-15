import { useState, createContext } from "react";

export const FavouriteContext = createContext();

export const FavouriteProvider = (props) => {
  const [favouriteChampions, setFavouriteChampions] = useState([]);
  return (
    <FavouriteContext.Provider value={[favouriteChampions, setFavouriteChampions]}>
      {props.children}
    </FavouriteContext.Provider>
  );
};