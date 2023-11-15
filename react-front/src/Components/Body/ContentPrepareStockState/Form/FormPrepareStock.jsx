import React, { useState } from 'react';
import Magasins from '../../../../Services/DataForms/Magasins/Magasins';
import SubmitButton from '../../../Constants/Buttons/SubmitButtons';
import DateInput from '../../../Constants/FormTools/DateInput';
import SelectForm from '../../../Constants/FormTools/Select';
import SimpleInput from '../../../Constants/FormTools/SimpleInput';

export default function FormPrepareStock(props) {
  const [formData, setFormData] = useState({
    beginDate: '',
    endDate: '',
    article: '',
    store: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Construction du JSON à partir des données du formulaire
    const jsonData = {
      beginDate: formData.beginDate,
      endDate: formData.endDate,
      article: formData.article,
      store: formData.store
    };

    try {
      // Appel à l'API localhost:8080/stockStatus en méthode POST
      const response = await fetch('http://localhost:8080/stockStatus', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
      });

      if (response.ok) {
        // Récupération des données de réponse
        const responseData = await response.json();

        // Redirection vers la page "/stockstate" avec les données de réponse
        props.history.push('/stockstate', { responseData });
      } else {
        console.error('Erreur lors de la requête API');
      }
    } catch (error) {
      console.error('Erreur inattendue : ', error);
    }
  };

  return (
    <div class="widget has-shadow">
      <div class="widget-header bordered no-actions d-flex align-items-center">
        <h4>Remplir</h4>
      </div>
      <div class="widget-body">
        <form class="form-horizontal" onSubmit={handleSubmit}>

          <DateInput label={"Date début"} name="beginDate" onChange={handleChange} />

          <DateInput label={"Date fin"} name="endDate" onChange={handleChange} />

          <SimpleInput label={"Articles"} name="article" onChange={handleChange} />

          <SelectForm label={"Magasins"} option={Magasins()} name="store" onChange={handleChange} />

          <div className="text-right">
            <SubmitButton />
          </div>

        </form>
      </div>
    </div>
  );
}
