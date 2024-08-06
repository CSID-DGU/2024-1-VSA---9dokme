// import React, { useEffect, useRef } from "react";
// import { useParams, useLocation } from "react-router-dom";
// import styled from "styled-components";

// interface Book {
//   bookTitle: string;
//   author: string;
//   bookCategory: string;
//   bookURL: string;
// }

// const PdfViewer2: React.FC = () => {
//   const pdfURL = "https://www.booksr.co.kr/wp-content/uploads/2022/12/%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5-%EC%8B%9C%EB%8C%80%EC%9D%98-%EC%BB%B4%ED%93%A8%ED%84%B0-%EA%B0%9C%EB%A1%A0%EA%B0%9C%EC%A0%958%ED%8C%90-%EC%83%98%ED%94%8C%EC%B1%95%ED%84%B0.pdf"
//   const { bookId } = useParams<{ bookId: string }>();
//   const location = useLocation();
//   const { book }: { book?: Book } = location.state || {}; // Use type assertion for book
//   const canvasRef = useRef<HTMLCanvasElement | null>(null);

//   return (
//     <Frame className="bg-customGradient">
//       <h1>{book?.bookTitle || "Title not available"}</h1>
//       <div>
//         <p>저자: {book?.author || "Author not available"}</p>
//         <p>카테고리: {book?.bookCategory || "Category not available"}</p>
//         <p>책url: {book?.bookURL}</p>
//         <div style={{ height: "750px" }}></div>
//       </div>
//     </Frame>
//   );
// };

// const Frame = styled.div`
//   min-height: 100vh;
//   background: radial-gradient(
//     circle at 10% 50%,
//     rgb(163, 175, 243) 0%,
//     rgb(220, 182, 232) 100.2%
//   );
//   padding: 20px;
// `;

import React from "react";
import { useParams, useLocation } from "react-router-dom";
import styled from "styled-components";

// Define Book interface for type safety
interface Book {
  bookTitle: string;
  author: string;
  bookCategory: string;
  bookURL: string;
}

const PdfViewer2: React.FC = () => {
  // PDF URL to be rendered
  const pdfURL =
    "https://www.booksr.co.kr/wp-content/uploads/2022/12/%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5-%EC%8B%9C%EB%8C%80%EC%9D%98-%EC%BB%B4%ED%93%A8%ED%84%B0-%EA%B0%9C%EB%A1%A0%EA%B0%9C%EC%A0%958%ED%8C%90-%EC%83%98%ED%94%8C%EC%B1%95%ED%84%B0.pdf";

  // Get bookId from route params
  const { bookId } = useParams<{ bookId: string }>();

  // Access book details passed through location state
  const location = useLocation();
  const { book }: { book?: Book } = location.state || {}; // Use type assertion for book

  return (
    <Frame className="bg-customGradient">
      <h1>{book?.bookTitle || "Title not available"}</h1>
      <div>
        <p>저자: {book?.author || "Author not available"}</p>
        <p>카테고리: {book?.bookCategory || "Category not available"}</p>
        <p>책url: {book?.bookURL}</p>

        {/* Add a link to open the PDF */}
        <a href={pdfURL} target="_blank" rel="noopener noreferrer">
          Open PDF
        </a>
      </div>
    </Frame>
  );
};

const Frame = styled.div`
  min-height: 100vh;
  background: radial-gradient(
    circle at 10% 50%,
    rgb(163, 175, 243) 0%,
    rgb(220, 182, 232) 100.2%
  );
  padding: 20px;
`;

export default PdfViewer2;
