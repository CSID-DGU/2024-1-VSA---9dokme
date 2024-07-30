import styled from "styled-components";
import { useParams } from "react-router-dom";
import book1 from "../images/books/book1.png";
import books from "../json/BookDetail.json";
import { BookDetailType, Books } from "../json/BookDetailType";
const BookDetail = () => {
  return (
    <div className="w-screen h-screen bg-customColor bg-opacity-20">
      <div className="w-screen h-[65%]">
        <div className="grid grid-cols-3by5 h-screen">
          <div className="p-20 box-content">
            <img
              src={book1}
              alt="book1 mt-10"
              className="w-[15vw] rounded-lg mt-10 self-senter"
            />
          </div>
          <div>
            <div className="font-bold text-left mt-20 text-[1.5vw] ">
              [경영학개론]
              <p className="text-[1.3vw] mt-[0.2vw]">김수진</p>
            </div>
            <div>
              <TagBtn>공학</TagBtn>
            </div>
            <div className="text-left mt-5 text-[1.2vw] me-5 text-slate-600">
              This book provides an in-depth understanding of the modeling and
              simulation of discrete event systems. It covers the theoretical
              foundations and practical applications, making it essential for
              engineering professionals and students alike. The text delves into
              the mathematical models that represent various systems and
              processes, providing a comprehensive guide to the design and
              analysis of complex systems. Practical examples and case studies
              are included to illustrate the application of these models in
              real-world scenarios, ensuring that readers gain a robust
              understanding of both the theory and practice of discrete event
              simulation. Additionally, advanced topics such as stochastic
              modeling and system optimization are explored, offering insights
              into cutting-edge techniques used in modern engineering and
              research.
            </div>
          </div>
        </div>
      </div>
      <div className="w-screen h-[35%] bg-customColor2 flex justify-center pt-20">
        <button className="border-xl bg-submitColor w-[30vw] h-[5vw] rounded-lg text-white font-semibold text-[1.5vw] mr-20">
          제출하기
        </button>
        <GradientDiv className="border-xl bg-customGradient w-[30vw] h-[5vw] rounded-lg text-white font-semibold text-[1.5vw] ml-20">
          조회하기
        </GradientDiv>
      </div>
    </div>
  );
};

const TagBtn = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  margin: 0 1vw;
  width: 5vw;
  height: 2vw;
  border-radius: 3vw;
  border-style: solid;
  border-width: 1px;
  border-color: #2519b2;
  padding: 1vw;
  font-size: 1vw;
  background-color: #c5b5f7;
  margin: 1vw 1vw 1vw 0vw;
`;

const GradientDiv = styled.div`
  background-image: linear-gradient(
    to right,
    #918fff 0%,
    #5956ff 45%,
    #3f3cff 55%,
    #3431ff 79%,
    #0011ff 100%
  );
  display: flex;
  align-items: center;
  justify-content: center;
`;
export default BookDetail;
