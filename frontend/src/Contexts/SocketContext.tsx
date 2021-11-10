import { createContext, useContext } from "react";
import io from "socket.io-client";
import { useAuction } from "./AuctionContext";
import { useAuth } from './AuthContext';
import { useSnackBar } from './SnackBarContext';

type Props = {
  children?: JSX.Element;
};

const SocketContext = createContext<any>(null);

export const useSocket = () => useContext(SocketContext);

const SocketProvider = ({ children }: Props) => {
  const endpoint = "http://localhost:9092";
  const socket = io(endpoint, { transports: ["websocket"] });
  const { getAllAuctions } = useAuction();
  const { whoAmI } = useAuth();
  const { setText, setShowOpenSnackBar } = useSnackBar();

  socket.on("connect", () => {
    console.log("conneted");
  });

  socket.on("bid", async function () {
    await getAllAuctions();
  });

  socket.on("reconnect_attempt", () => {
    console.log("Reconnecting");
  });

  socket.on("join", (data: any) => {
    console.log("Connected to room", data);
  });

  socket.on("auctionUpdate", (data: any) => {
    console.log(data);
  });

  socket.on("notification", (data: number) => {
      if (whoAmI?.id === data) {
        setText("Någon har budat över dig!" );
        setShowOpenSnackBar(true);
      }
  });

  const values = {
    socket,
  };

  return (
    <SocketContext.Provider value={values}>{children}</SocketContext.Provider>
  );
};

export default SocketProvider;
