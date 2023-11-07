import { BrowserRouter, Route, Routes } from "react-router-dom";
import Stockstate from "./Components/Gate/Stockstate";

function App() {
  return (
    <BrowserRouter>

      <Routes>

        <Route>

          <Route path="/stockstate" element={<Stockstate/>} />

        </Route>        

      </Routes>

    </BrowserRouter>  

  );
}

export default App;
