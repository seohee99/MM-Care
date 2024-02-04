
export function auth(code){
    fetch(`${process.env.REACT_APP_SERVER_URL}auth?code=${code}`, {
        method : "GET"   
    })
    .then(res=>res.json())
    .then(res=>{
        console.log(res);
        sessionStorage.setItem("user",JSON.stringify(res));
    })
    .catch(e => {
        console.error(e);
    });
}
