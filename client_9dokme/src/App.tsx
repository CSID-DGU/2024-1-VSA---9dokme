import { Route, Routes } from "react-router-dom";
import Main from "./pages/Main";
import BookDiscription from "./pages/BookDiscription";
import Landing from "./pages/Landing";
import PdfViewer from "./pages/PdfViewer";
import PdfViewer2 from "./pages/PdfViewer2";
function App() {
  return (
    <Routes>
      <Route path="/" element={<Landing />} />
      <Route path="/api/mainPage/" element={<Main />} />
      <Route path="/api/bookdetail/:bookId/" element={<BookDiscription />} />
      <Route path="api/view/:bookId/" element={<PdfViewer />} />
      {/* <Route path="api/view/" element={<PdfViewer2 />} /> */}
    </Routes>
  );
}

export default App;
