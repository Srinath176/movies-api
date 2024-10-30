import { Route, Routes } from 'react-router-dom';
import './App.css';
import { apiClient } from './api/axiosConfig';
import { useEffect, useState } from 'react';
import Layout from './components/Layout';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/reviews/Reviews';
import NotFound from './components/notFound/NotFound';

function App() {


  const [movies, setMovies] = useState([]);
  const [movie, setMovie] = useState()
  const [reviews, setReviews] = useState([])


  const getMovies = async () => {

    await apiClient.get("/movies-api")
      .then(response => {
        setMovies(response.data)
        console.log(response.data)
      })
      .catch(error => console.log(error))

  }

  const getMovieData = async (movieId) => {

    await apiClient.get(`/movies-api/${movieId}`)
      .then(response => {

        setMovie(response.data);

        setReviews(response.data.reviews);

      })

      .catch(error => console.log(error))


  }

  useEffect(() => { getMovies() }, [])

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path='/' element={<Home movies={movies} />}></Route>
          <Route path='/Trailer/:ytTrailerId' element={<Trailer />} />
          <Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
          <Route path='*' element={<NotFound/>}/>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
