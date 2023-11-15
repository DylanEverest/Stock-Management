import axios from 'axios';


export default function Axios ()
{
  return axios.create({
    baseURL:"http://localhost:8080",
    headers: {
      "Content-type":"application/json",
    },
  }) ;
}



