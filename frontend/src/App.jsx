import './App.css'
import { useState } from 'react';
import Signup from './SignUp';
import SignIn from './SignIn';
function App() {
const [displaySignIn, setDisplaySignIn] = useState(true);

  return (
    <>
    <div className="header d-flex flex-column justify-content-center align-items-center p-3">
    <div className="button-group font-weight-bold">
      <button className="btn btn-primary" onClick={() => setDisplaySignIn(true)}>Sign In</button>
      <button className="btn btn-secondary" onClick={() => setDisplaySignIn(false)}>Sign Up</button>
    </div>
    {displaySignIn ? <SignIn /> : <Signup />}
    </div>
    </>
  )
}

export default App
