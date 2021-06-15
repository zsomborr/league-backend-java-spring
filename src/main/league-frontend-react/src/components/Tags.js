import { useHistory } from "react-router-dom";
import { CustomSelectTag } from "../styles/TagStyle";

const Tags = () => {
  let history = useHistory();
  const changeChampions = (e) => {
    history.push(`?tag=${e.target.value}`);
  };

  return (
    <div>
      <CustomSelectTag
        name="tags"
        id="tags"
        selected
        onChange={changeChampions}
      >
        <option value="Fighter">Fighter</option>
        <option value="Tank">Tank</option>
        <option value="Mage">Mage</option>
        <option value="Assassin">Assassin</option>
        <option value="Support">Support</option>
        <option value="Marksman">Marksman</option>
      </CustomSelectTag>
    </div>
  );
};

export default Tags;
