import { useContext } from "react";
import { FavouriteContext } from "../contexts/FavouriteContext";
import Champion from "./Champion";

const FavouriteChampions = () => {
  // eslint-disable-next-line no-unused-vars
  const [favouriteChampions, setFavouriteChampions] =
    useContext(FavouriteContext);

  return (
    <div>
      {favouriteChampions.map((champion) => (
        <Champion key={champion.id} champion={champion} />
      ))}
    </div>
  );
};

export default FavouriteChampions;
