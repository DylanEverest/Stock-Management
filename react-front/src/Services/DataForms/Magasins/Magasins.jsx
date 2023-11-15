import React, { useEffect, useState } from "react";
import Axios from "../../APISERVICE/AXIOS/AxiosAPI";

export default function Magasins() {
  const axiosInstance = Axios();
  const [magasins, setMagasins] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axiosInstance.get('/magasins');
        console.log(response.data);

        // Check if listMagasins is present in the API response
        const listMagasins = response.data.listMagasins || [];

        // Extract the magasin names from listMagasins
        const magasinNames = listMagasins.map(magasin => magasin.nameMagasin);

        // Update the state with the extracted magasin names
        setMagasins(magasinNames);
      } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
      }
    };

    fetchData(); // Call the fetchData function when the component mounts
  }, []); // The empty dependency array ensures that this effect runs only once on mount

  return magasins;
}
