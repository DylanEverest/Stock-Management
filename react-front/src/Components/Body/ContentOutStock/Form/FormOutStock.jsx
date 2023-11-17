// Importe les modules nécessaires
import React, { useState } from 'react';
import Axios from '../../../../Services/APISERVICE/AXIOS/AxiosAPI';
import Articles from '../../../../Services/DataForms/Articles/Articles';
import Magasins from '../../../../Services/DataForms/Magasins/Magasins';
import Units from '../../../../Services/DataForms/Units/Units';
import SubmitButton from '../../../Constants/Buttons/SubmitButtons';
import DateInput from '../../../Constants/FormTools/DateInput';
import SelectForm from '../../../Constants/FormTools/Select';

export default function FormOutStock() {
  const [formData, setFormData] = useState({
    quantity: '',
    date: '',
    article: '',
    store: '',
    unit : ''
  });

  const [errorMessage, setErrorMessage] = useState('');


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
      unit:formData.units
    };


    console.log(jsonData);
    try 
    {
      // Appel à l'API localhost:8080/stockStatus en méthode POST
      const axios = Axios();
      const response = await axios.post("/out",jsonData)

      console.log(response.data)
      if (response.data.errors !== null) {
        setErrorMessage(response.data.errors);
      } else {
        // Réinitialise le message d'erreur s'il n'y a pas d'erreurs
        setErrorMessage('');
      }

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
        {errorMessage && (
            <div className="alert alert-danger" role="alert">
              {errorMessage}
            </div>
          )}

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

          <DateInput label={'date'} name="date" onChange={handleChange} />

          <SelectForm label={'Articles'} option={Articles()} name="article" onChange={handleChange} />


          <SelectForm label={'Magasins'} option={Magasins()} name="store" onChange={handleChange} />

          <SelectForm label= {'units'} option ={Units()} name="units" onChange={handleChange} />

          <div className="text-right">
            <SubmitButton />
          </div>
        </form>
      </div>
    </div>
  );
}
