import  { useEffect, useState } from "react";
import Axios from "../../APISERVICE/AXIOS/AxiosAPI";

export default function Units() {
  const axiosInstance = Axios();
  const [units, setUnits] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axiosInstance.get('/units');


        // Check if listMagasins is present in the API response
        const listUnits = response.data.listUnit || [];

        // Extract the magasin names from listMagasins
        const unitsNames = listUnits.map(units => units.name);

        // Update the state with the extracted magasin names
        setUnits(unitsNames);
      } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
      }
    };

    fetchData(); // Call the fetchData function when the component mounts
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []); // The empty dependency array ensures that this effect runs only once on mount

  return units;
}
