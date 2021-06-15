import Comment from "./Comment";
import { useEffect, useState, useContext } from "react";
// eslint-disable-next-line no-unused-vars
import { API_BASE_URL } from "../constants";
import { UserContext } from "../contexts/UserContext";

const Comments = ({ newsId }) => {
  const [comments, setComments] = useState([]);
  const [showComment, setShowComment] = useState(false);
  const [text, setText] = useState("");
  // eslint-disable-next-line no-unused-vars
  const [user, setUser] = useContext(UserContext);

  useEffect(() => {
    const getComments = async () => {
      const commentsFromApi = await fetchComments();
      setComments(commentsFromApi);
    };
    getComments();
  }, []);

  const fetchComments = async () => {
    // const res = await fetch(`${API_BASE_URL}/comments/${newsId}`);
    // const data = await res.json();
    const data = [
      {
        id: 1,
        newsId: 27391676,
        text: "Test 1",
      },
      {
        id: 2,
        newsId: 27391676,
        text: "Test 2",
      },
    ];
    return data;
  };

  const showInput = () => {
    setShowComment(!showComment);
  };

  const handleOnChange = (e) => {
    setText(e.target.value);
  };

  const addTextToComments = () => {
    setComments((oldComments) => [
      ...oldComments,
      { id: 3, newsId: newsId, text: text },
    ]);
    showInput();
    setText("");
  };

  return (
    <>
      <ul>
        {comments.map(
          (comment) =>
            comment.newsId === newsId && (
              <li key={comment.id}>
                <Comment comment={comment} />
              </li>
            )
        )}
      </ul>
      {showComment ? (
        <>
          <input
            id="comment"
            name="comment"
            value={text}
            onChange={handleOnChange}
          />
          <button onClick={addTextToComments}>Submit</button>
        </>
      ) : (
        user !== null && <button onClick={showInput}>Add comment</button>
      )}
    </>
  );
};

export default Comments;
