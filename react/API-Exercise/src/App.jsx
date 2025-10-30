import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [photoData, setPhotoData] = useState([]);
  const [loading, setLoading] = useState(true);
  useEffect(() => {

    fetch("https://boringapi.com/api/v1/photos?limit=9")
      .then((response) => response.json())
      .then((data) => {
        setPhotoData(data.photos);
        setLoading(false);
      })
      .catch((error) => {
        console.error(`error fetching data ${error}`);
        setLoading(false);
      });

  }, []);

  if (loading) return <p>Loading</p>;

  return (
    <div className="photo-grid">
      {photoData.map((photo) => (
        <div className="photo-card" key={photo.id}>
          <img src={photo.url} alt={photo.title || "photo"} />

        </div>
      ))}
    </div>
  )
}

export default App
