import { Route, Routes } from "react-router-dom";
import Main from "./pages/Main";
import BookDiscription from "./pages/BookDiscription";
import Landing from "./pages/Landing";
function App() {
  return (
    <Routes>
      <Route path="/" element={<Landing />} />
      <Route path="/api/mainPage/" element={<Main />} />
      <Route path="/api/bookdetail/:bookId/" element={<BookDiscription />} />
    </Routes>
  );
}

export default App;
