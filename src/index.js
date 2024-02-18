import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import CareMainPage from "./care/CareMainPage";
import NoticeEditPage from "./care/NoticeEditPage";
import FoodCarePage from "./care/FoodCarePage";
import PoopCarePage from "./care/PoopCarePage";
import WalkCarePage from "./care/WalkCarePage";
import MediCarePage from "./care/MediCarePage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <CareMainPage />,
  },
  {
    path: "/aa",
    element: <NoticeEditPage />,
  },
  {
    path: "/foodCare",
    element: <FoodCarePage />,
  },
  {
    path: "/walkCare",
    element: <WalkCarePage />,
  },
  {
    path: "/mediCare",
    element: <MediCarePage />,
  },
  {
    path: "/poopCare",
    element: <PoopCarePage />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <div style={{ width: "100%", height: "100%" }}>
    <RouterProvider router={router} />
  </div>
);
