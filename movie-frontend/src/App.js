import './App.css';
import api from './api/axiosConfig';
import {useState, useEffect} from "react";

function App() {
  // movies: store an array of movie data returned from the call to the relevant api endpoint
  // setMovies: function that can be used to change the state of the movies variable
  // when the state of the variable tracked by react through the useState hook is changed, the component is re-rendered by React
  // App component will be re-rendered when the state of the movies variable changes.
  const [movies, setMovies] = useState();

  // function that will handle a HTTP get request to an endpoint that returns an array of movie data
  const getMovies = async () => {
    try{
      const response = await api.get("/api/v1/movies");
      setMovies(response.data);
    } catch(err) {
      console.log(err);
    }
  }

  // getMovie function to be executed when the app component first loads
  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div className="App">

    </div>
  );
}

export default App;
