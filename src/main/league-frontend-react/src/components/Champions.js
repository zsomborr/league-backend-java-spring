import { useEffect, useState } from "react";
import Champion from "./Champion.js";
import { API_BASE_URL } from "../constants";

const Champions = (props) => {
  const [champions, setChampions] = useState([]);

  useEffect(() => {
    const getChampions = async () => {
      const search = props.location.search;
      const params = new URLSearchParams(search);
      const tag = params.get("tag");
      let championsFromApi = await fetchChampions(tag);
      championsFromApi = Object.entries(championsFromApi).map((e) => e[1]);
      setChampions(championsFromApi);
    };

    getChampions();
  }, [props.location.search]);

  const fetchChampions = async (tag) => {
    const res =
      tag !== null
        ? await fetch(`${API_BASE_URL}/champions/${tag}`)
        : await fetch(`${API_BASE_URL}/champions`);
    const data = await res.json();
    return data.data;
  };

  return (
    <div>
      {champions.map((champion) => (
        <Champion key={champion.id} champion={champion} />
      ))}
    </div>
  );
};

export default Champions;
