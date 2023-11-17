import React, { useState } from 'react';
import Axios from '../../../Services/APISERVICE/AXIOS/AxiosAPI';

export default function Table(props) {
    const { formData, handleSubmit, handleInputChange, responseData ,errorMessage } = DataHandler();

    return (
        <div className="widget has-shadow">
            <div className="widget-header bordered no-actions d-flex align-items-center">
                <h4>Border</h4>
            </div>
            <div className="widget-body">
                {errorMessage && (
                <div className="alert alert-danger" role="alert">
                {errorMessage}
                </div>
            )}
                <div className="table-responsive">
                    <form onSubmit={handleSubmit}>
                        <table className="table table-bordered mb-0">
                            <thead>
                                <tr>
                                    {props.form.map((header, index) => (
                                        <th key={index}>
                                            <input
                                                type="text"
                                                className="form-control"
                                                name={header}
                                                placeholder={header}
                                                value={formData[header]}
                                                onChange={handleInputChange}
                                            />
                                        </th>
                                    ))}
                                    <th></th>
                                    <th></th>
                                    <th>
                                        <button className="btn btn-gradient-01" type="submit">
                                            Submit
                                        </button>
                                    </th>
                                </tr>
                                <tr>
                                    {props.columnHeaders.map((header, index) => (
                                        <th key={index}>{header}</th>
                                    ))}
                                </tr>
                            </thead>
                            <tbody>
                                {responseData && responseData.errors === null && (
                                    <tr>
                                        <td>{responseData.beginDate}</td>
                                        <td>{responseData.endDate}</td>
                                        <td>{responseData.article}</td>
                                        <td>{responseData.store}</td>
                                        <td>{responseData.initialQuantity}</td>
                                        <td>{responseData.finalQuantity}</td>
                                        <td>{responseData.priceValue}</td>
                                    </tr>
                                )}
                                {props.tableData.map((row) => (
                                    <tr key={row.id}>
                                        {props.columnHeaders.map((header, index) => (
                                            <td key={index}>{row[header]}</td>
                                        ))}
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    );
}

function DataHandler() {
    const axiosInstance = Axios();

    const [formData, setFormData] = useState({
        beginDate: '',
        endDate: '',
        article: '',
        store: ''
    });

    const [errorMessage, setErrorMessage] = useState('');


    const [responseData, setResponseData] = useState(null);

    const handleInputChange = (e) => {
        console.log(formData)

        setFormData({ ...formData, [e.target.name]: e.target.value 
                    });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axiosInstance.post('/stockStatus', formData);
            setResponseData(response.data);
            console.log(response.data); // Gérer la réponse comme nécessaire
            if (response.data.errors !== null) {
                setErrorMessage(response.data.errors);
              } else {
                // Réinitialise le message d'erreur s'il n'y a pas d'erreurs
                setErrorMessage('');
            }
        } catch (error) {
            console.error('Une erreur s\'est produite lors de la soumission du formulaire', error);
        }
    };

    return {
        formData,
        handleSubmit,
        handleInputChange,
        responseData,
        errorMessage
    };
}
