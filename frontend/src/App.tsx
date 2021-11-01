import AllContextProviders from "./Contexts/AllContextProviders";
import AllRoutes from "./Router/AllRoutes";
import Navigation from "./Components/Navigation/Navigation";
import LoginRegisterModal from "./Components/LoginRegisterModal/LoginRegisterModal";
import FloatingAddBtn from "./Components/FloatingAddBtn/FloatingAddBtn";
import SnackBar from "./Components/SnackBar/SnackBar";
import { useSnackBar } from "./Contexts/SnackBarContext";

function App() {

  const { showSnackBar, setShowOpenSnackBar } = useSnackBar();

  return (
    <div className="App">
      <AllRoutes>
        <>
          <Navigation />
          <FloatingAddBtn />
        </>
      </AllRoutes>
      <SnackBar open={showSnackBar} setOpen={setShowOpenSnackBar} />
      <LoginRegisterModal />
    </div>
  );
}

export default App;
