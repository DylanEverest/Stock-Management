// Importe les modules nécessaires
import React, { useState } from 'react';
import Axios from '../../../../Services/APISERVICE/AXIOS/AxiosAPI';
import Articles from '../../../../Services/DataForms/Articles/Articles';
import Magasins from '../../../../Services/DataForms/Magasins/Magasins';
import SubmitButton from '../../../Constants/Buttons/SubmitButtons';
import DateInput from '../../../Constants/FormTools/DateInput';
import SelectForm from '../../../Constants/FormTools/Select';

export default function FormOutStock() {
  const [formData, setFormData] = useState({
    quantity: '',
    date: '',
    article: '',
    store: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Construction du JSON à partir des données du formulaire
    const jsonData = {
      quantity: formData.quantity,
      movementDate: formData.date ,
      article: formData.article,
      store: formData.store,
    };

    console.log(jsonData);

    try 
    {
      // Appel à l'API localhost:8080/stockStatus en méthode POST
      const axios = Axios();
      axios.post("/out",jsonData)

    } catch (error) {
      console.error('Erreur inattendue : ', error);
    }
  };

  return (
    <div className="widget has-shadow">
      <div className="widget-header bordered no-actions d-flex align-items-center">
        <h4>Remplir</h4>
      </div>
      <div className="widget-body">
        <form className="form-horizontal" onSubmit={handleSubmit}>
          <div className="form-group row d-flex align-items-center mb-5">
            <label className="col-lg-3 form-control-label">Quantite</label>
            <div className="col-lg-9">
              <input
                type="text"
                className="form-control"
                name="quantity"
                onChange={handleChange}
              />
              <small>unit to</small>
            </div>
          </div>

          <DateInput label={'Date de sortie'} name="date" onChange={handleChange} />

          <SelectForm label={'Articles'} option={Articles()} name="article" onChange={handleChange} />

          <SelectForm label={'Magasins'} option={Magasins()} name="store" onChange={handleChange} />

          <div className="text-right">
            <SubmitButton />
          </div>
        </form>
      </div>
    </div>
  );
}
