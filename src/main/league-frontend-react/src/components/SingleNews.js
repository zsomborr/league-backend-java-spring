import { SingleNewsCard, Link, Title, Data } from "../styles/SingleNewsStyle";
import Comments from "./Comments";

const SingleNews = ({ singleNews }) => {
  return (
    <div>
      <SingleNewsCard>
        <Title>{singleNews.title}</Title>
        <Link href={singleNews.url}>Go to site</Link>
        <Data>
          Uploaded by: {singleNews.user}
          <br />
          {singleNews.time_ago}
        </Data>
        <Comments newsId={singleNews.id} />
      </SingleNewsCard>
    </div>
  );
};

export default SingleNews;
