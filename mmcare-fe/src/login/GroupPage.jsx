import React, { useEffect } from "react";
import { useNavigate } from 'react-router-dom'; 
import { auth } from "./api/oauth";

function GroupPage(props) {

    const navigate = useNavigate();

    useEffect(() => {
        const code = new URL(window.location.href).searchParams.get('code');
        
        fetch(`${process.env.REACT_APP_SERVER_URL}auth?code=${code}`, {
            method : "GET"   
        })
        .then(res=>res.json())
        .then(res=>{
            sessionStorage.setItem("user",JSON.stringify(res));
        })
        .catch(e => {
            console.error(e);
        });
    },[])

    return (
        <div>
            Login Success
        </div>
    )
}

export default GroupPage;