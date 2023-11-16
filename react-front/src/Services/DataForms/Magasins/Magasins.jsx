import  { useEffect, useState } from "react";
import Axios from "../../APISERVICE/AXIOS/AxiosAPI";

export default function Magasins() {
  const axiosInstance = Axios();
  const [magasins, setMagasins] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axiosInstance.get('/stores');
        // console.log(response.data);

        // Check if listMagasins is present in the API response
        const listStore = response.data.listStore || [];

        // Extract the magasin names from listMagasins
        const magasinNames = listStore.map(store => store.storeName);

        // Update the state with the extracted magasin names
        setMagasins(magasinNames);
      } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
      }
    };

    fetchData(); // Call the fetchData function when the component mounts
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []); // The empty dependency array ensures that this effect runs only once on mount

  return magasins;
}
