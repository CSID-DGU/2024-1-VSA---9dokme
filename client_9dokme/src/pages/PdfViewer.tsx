import React, { useState, useEffect, useRef } from "react";
import { useParams, useLocation } from "react-router-dom";
import styled from "styled-components";
import * as pdfjsLib from "pdfjs-dist";

pdfjsLib.GlobalWorkerOptions.workerSrc = "/pdf.worker.min.mjs";

interface Book {
  bookTitle: string;
  author: string;
  bookCategory: string;
  bookURL: string;
}

const PdfViewer: React.FC = () => {
  const [page, setPage] = useState<number>(1);
  const [pdfDoc, setPdfDoc] = useState<pdfjsLib.PDFDocumentProxy | null>(null);
  const [numPages, setNumPages] = useState<number>(0); // Track total number of pages
  const { bookId } = useParams<{ bookId: string }>();
  const location = useLocation();
  const { book }: { book?: Book } = location.state || {};
  const canvasRef = useRef<HTMLCanvasElement | null>(null);

  useEffect(() => {
    const loadPdf = async () => {
      if (book?.bookURL) {
        const proxyUrl = "http://localhost:8080/"; // Proxy server address
        const pdfUrl = `${proxyUrl}${book.bookURL}`;
        try {
          const loadedPdfDoc = await pdfjsLib.getDocument(pdfUrl).promise;
          setPdfDoc(loadedPdfDoc);
          setNumPages(loadedPdfDoc.numPages); // Set the total number of pages
        } catch (error) {
          console.error("Error loading PDF document:", error);
        }
      }
    };

    loadPdf();
  }, [book?.bookURL]);

  useEffect(() => {
    const renderPage = async (pageNum: number) => {
      if (pdfDoc && canvasRef.current) {
        try {
          const page = await pdfDoc.getPage(pageNum);
          const scale = 1;
          const viewport = page.getViewport({ scale });
          const context = canvasRef.current.getContext("2d");

          if (context) {
            canvasRef.current.height = viewport.height;
            canvasRef.current.width = viewport.width;

            const renderContext = {
              canvasContext: context,
              viewport,
            };
            await page.render(renderContext).promise;
          }
        } catch (error) {
          console.error("Error rendering page:", error);
        }
      }
    };

    renderPage(page);
  }, [pdfDoc, page]);

  const handlePreviousPage = () => {
    setPage((prevPage) => Math.max(prevPage - 1, 1));
  };

  const handleNextPage = () => {
    setPage((prevPage) => Math.min(prevPage + 1, numPages));
  };

  return (
    <Frame className="bg-customGradient w-full h-[150vh]">
      <div className="flex flex-col items-center justify-center">
        <div className="text-center mt-20 mb-5">
          <div className="font-bold text-[3vw]">[{book?.bookTitle}]</div>
          <p className="text-[2vw] mt-[0.2vw]">{book?.author}</p>
        </div>
        <div>
          <TagBtn>{book?.bookCategory}</TagBtn>
        </div>

        <div
          className="mt-10"
          style={{ height: "750px", width: "100%", overflow: "auto" }}
        >
          <div className="flex justify-center items-center h-full">
            <canvas ref={canvasRef}></canvas>
          </div>
        </div>

        <div className="mt-5 flex justify-center">
          <button
            className="bg-blue-500 text-white font-bold py-2 px-4 rounded mx-2"
            onClick={handlePreviousPage}
            disabled={page === 1}
          >
            다음페이지
          </button>
          <div className="bg-white-500 text-grey font-bold py-2 px-4 rounded mx-2">
            {page}
          </div>
          <button
            className="bg-blue-500 text-white font-bold py-2 px-4 rounded mx-2"
            onClick={handleNextPage}
            disabled={page === numPages}
          >
            이전페이지
          </button>
        </div>
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
  overflow: auto;
`;

const TagBtn = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  margin: 0 1vw;
  width: auto;
  height: 4vw;
  border-radius: 3vw;
  border-style: solid;
  border-width: 1px;
  border-color: #2519b2;
  padding: 1vw;
  font-size: 2vw;
  background-color: #d195ff;
  margin: 1vw 1vw 1vw 0vw;
`;

export default PdfViewer;
