import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import CareMainPage from "./care/CareMainPage";
import NoticeEditPage from "./care/NoticeEditPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <CareMainPage />,
  },
  {
    path: "/aa",
    element: <NoticeEditPage />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <div style={{ width: "100%", height: "100%" }}>
    <RouterProvider router={router} />
  </div>
);
