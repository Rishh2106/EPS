import api from "./AxiosSetup";
export default function SignIn(){
    function handleSubmit(e){
        e.preventDefault();
        const name = e.target[0].value;
        const pwd = e.target[1].value;
        api.post("/signin", {name, pwd})
        .then((response) => {
            console.log(response.data);
        })
        .catch((error) => {
            console.error(error);
        });
    }
    return(
        <>
        <div className="d-flex flex-column justify-content-center align-items-center">
        <h1>Sign In</h1>
        <form className="d-flex flex-column justify-content-center align-items-center" onSubmit={handleSubmit}>
            <input type="text" placeholder="Username" className="form-control mb-3 w-50"/>
            <input type="password" placeholder="Password" className="form-control mb-3 w-50"/>
            <button type="submit" className="btn btn-primary w-100">
                Sign In
            </button>
        </form>
        </div>
        </>
    )
}