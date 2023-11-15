import Axios from "../../APISERVICE/AXIOS/AxiosAPI"
import React, { useEffect } from "react";

export default function Articles() 
{
    const axios = Axios();
    
    const createData = async () => {
        const requestData = { /* Vos données à envoyer */ };
        try {
          const response = await axios.get('/articles', requestData);
          console.log(response.data);
        } catch (error) {
          console.error('Erreur lors de l\'envoi des données:', error);
        }
      };

    console.log(createData());

    const articles = ["article1", "article2", "article3", "article"] ;
 
    return articles ;
}