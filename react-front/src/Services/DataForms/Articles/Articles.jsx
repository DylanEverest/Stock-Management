import { useEffect, useState } from "react";
import Axios from "../../APISERVICE/AXIOS/AxiosAPI";

export default function Articles() {
  const axiosInstance = Axios();
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axiosInstance.get('/articles');
        console.log(response.data);

        // Check if listArticles is present in the API response
        const listArticles = response.data.listArticles || [];

        // Extract the nameArticles values from listArticles
        const articleNames = listArticles.map(article => article.nameArticles);

        // Update the state with the extracted article names
        setArticles(articleNames);
      } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
      }
    };

    fetchData(); // Call the fetchData function when the component mounts
  }, []); // The empty dependency array ensures that this effect runs only once on mount

  return articles;
}
