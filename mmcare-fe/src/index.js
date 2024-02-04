import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

import LoginPage from './login/LoginPage';
import GroupPage from './login/GroupPage';
import SuccessPage from './login/SuccessPage';
import Navigation from './Navigation';

const router = createBrowserRouter([
  {
    path: '/',
    element: <LoginPage/>,
  },
  {
    path: '/group',
    element: <GroupPage/>,
  },
  {
    path: '/success',
    element: <SuccessPage/>,
  },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
    <div style={{width:"100%", height:"10%"}}>
      <RouterProvider router={router}/>
      
    </div>
);
