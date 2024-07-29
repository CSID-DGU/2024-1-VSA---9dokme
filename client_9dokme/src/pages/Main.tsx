import { useState, useEffect } from "react";
import SlidingBanner from "../components/SlidingBanner";
import Hashtag from "../components/Hashtag";
const Main = () => {
  const [category, setCategory] = useState<string | null>(null);
  const handleHashBtnClick = (newCategory: string) => {
    setCategory(newCategory);
  };
  //category 상태 변경시
  useEffect(() => {
    if (category) {
      console.log("category: ", category);
    }
  }, [category]);

  return (
    <div className="w-screen h-full bg-customColor bg-opacity-20">
      <SlidingBanner />
      <div className="w-screen h-screen flex flex-col">
        <div className="m-[2vw] text-[1.2vw]">
          도서 검색을 통해 원하는 교재를 검색해보세요!
        </div>
        <input className="bg-white-900 rounded-[2vw] mx-[8vw] h-[3vw] mb-[2vw]" />
        <div className="m-3">
          <Hashtag
            onCategoryChange={handleHashBtnClick}
            selectedCategory={category}
          />
        </div>
      </div>
    </div>
  );
};
export default Main;
