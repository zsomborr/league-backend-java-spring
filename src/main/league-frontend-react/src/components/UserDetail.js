import { useState, useEffect } from "react";
import { UserCard, MatchCard, H1 } from "../styles/UserDetailStyle.js";
import icon from "../static/icon.png";
import { API_BASE_URL } from "../constants";

const UserDetail = (props) => {
  const search = props.location.search;
  const params = new URLSearchParams(search);
  const user = params.get("user");

  const [userInfo, setUserInfo] = useState([]);
  const [userMatchDetail, setUserMatchDetail] = useState([]);
  const [matchResult, setMatchResult] = useState([]);
  const [champions, setChampions] = useState([]);

  useEffect(() => {
    const getUserInfo = async () => {
      const userInfoFromApi = await fetchUserInfo();
      setUserInfo(userInfoFromApi);

      const matchDetailFromApi = await fetchUserMatchDetails();
      setUserMatchDetail(matchDetailFromApi);

      const matchResultFromApi = await fetchMatchResult();
      setMatchResult(matchResultFromApi);
    };

    const getChampions = async () => {
      let championsFromApi = await fetchChampions();
      championsFromApi = Object.entries(championsFromApi).map((e) => e[1]);
      setChampions(championsFromApi);
    };

    getUserInfo();
    getChampions();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [user]);

  const fetchChampions = async () => {
    const res = await fetch(`${API_BASE_URL}/champions`);
    const data = await res.json();
    return data.data;
  };

  const fetchUserInfo = async () => {
    const res = await fetch(`${API_BASE_URL}/user/${user}`);
    const userData = await res.json();
    return userData;
  };

  const fetchUserMatchDetails = async () => {
    // matches by accountId
    const res = await fetch(`${API_BASE_URL}/matches`);
    const matchDetails = await res.json();

    return matchDetails;
  };

  const fetchMatchResult = async () => {
    // match detail by gameId
    const res = await fetch(`${API_BASE_URL}/results`);
    const matchResults = await res.json();

    return matchResults;
  };

  return (
    <div>
      <H1>User:</H1>

      <UserCard>
        <img src={icon} alt="avatar"></img>
        <div>User: {userInfo.name}</div>
        <div>Level : {userInfo.summonerLevel}</div>
      </UserCard>

      <H1>Last 10 Matches:</H1>
      {matchResult.map((match) => (
        <MatchCard key={parseInt(match.gameId)}>
          <p>Match duration: {Math.floor(match.gameDuration / 60)} min</p>
          <p>Game mode: {match.gameMode} </p>
          <p>Match Result: {match.teams[0].win}</p>
          {userMatchDetail.map(
            (matchDetail) =>
              matchDetail.gameId === match.gameId &&
              champions.map(
                (champion) =>
                  parseInt(champion.key) === matchDetail.champion && (
                    <div>
                      <p>Played champion:</p>
                      <img
                        key={match.gameId}
                        width="100%"
                        alt="test"
                        src={`https://ddragon.canisback.com/img/champion/tiles/${
                          champion.id === "Fiddlesticks"
                            ? "FiddleSticks"
                            : champion.id
                        }_0.jpg`}
                      ></img>
                    </div>
                  )
              )
          )}
        </MatchCard>
      ))}
    </div>
  );
};

export default UserDetail;
