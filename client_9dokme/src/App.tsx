import React from "react";
import { Route, Routes } from "react-router-dom";
import Main from "./pages/Main";
import BookDiscription from "./pages/BookDiscription";
function App() {
  return (
    <Routes>
      <Route path="/" element={<Main />} />
      <Route path="/api/bookdetail/:bookId/" element={<BookDiscription />} />
    </Routes>
  );
}

export default App;
