import styled from "styled-components";
interface HashtagProps {
  onCategoryChange: (category: string) => void;
  selectedCategory: string | null;
}
const Hashtag = ({ onCategoryChange, selectedCategory }: HashtagProps) => {
  const categories = ["공학", "자연", "예술", "인문/사회", "체육", "경영/경제"];
  return (
    <div className="flex justify-center items-center flex-wrap gap-4 mx-8">
      {categories.map(function (category) {
        return (
          <TagBtn
            key={category}
            className={`hover:bg-[#C5B5F7] ${
              selectedCategory === category ? "bg-[#C5B5F7]" : ""
            }`}
            onClick={() => onCategoryChange(category)}
          >
            <p className="">#{category}</p>
          </TagBtn>
        );
      })}
    </div>
  );
};

const TagBtn = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  margin: 0 1vw;
  width: 9vw;
  height: 3vw;
  border-radius: 3vw;
  border-style: solid;
  border-width: 1px;
  border-color: #2519b2;
  padding: 1vw;
  font-size: 1.2vw;
`;
export default Hashtag;
