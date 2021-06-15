import React, { useState, useEffect } from "react";
import { API_BASE_URL } from "../constants";
import SingleNew from "./SingleNews";
import {
  PaginationButton,
  PaginationButtonContainer,
} from "../styles/SingleNewsStyle";

const News = () => {
  const [news, setNews] = useState([]);
  const [pageNumber, setPageNumber] = useState(1);

  useEffect(() => {
    const getNews = async () => {
      const newsFromApi = await fetchNews();
      setNews(newsFromApi);
    };
    getNews();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [pageNumber]);

  const minPageNum = 1;
  const maxPageNum = 10;

  const onNextPage = () => {
    pageNumber < maxPageNum && setPageNumber(pageNumber + 1);
  };

  const onPreviousPage = () => {
    pageNumber > minPageNum && setPageNumber(pageNumber - 1);
  };

  const fetchNews = async () => {
    const res = await fetch(`${API_BASE_URL}/news/${pageNumber}`);
    const data = await res.json();
    return data;
  };

  return (
    <div>
      <PaginationButtonContainer>
        <PaginationButton onClick={onPreviousPage}>Previous</PaginationButton>
        <PaginationButton onClick={onNextPage}>Next</PaginationButton>
      </PaginationButtonContainer>

      {news.map((singleNews) => (
        <SingleNew key={singleNews.id} singleNews={singleNews} />
      ))}

      <PaginationButtonContainer>
        <PaginationButton onClick={onPreviousPage}>Previous</PaginationButton>
        <PaginationButton onClick={onNextPage}>Next</PaginationButton>
      </PaginationButtonContainer>
    </div>
  );
};

export default News;
