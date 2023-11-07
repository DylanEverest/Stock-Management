import React, { useState } from 'react';

export default function Table(props) {
    // Créez un état pour stocker les données de la table
    // const [tableData, setTableData] = useState([
    //     {
    //         id: 1,
    //         dateDebut: '2023-01-01',
    //         dateFin: '2023-01-10',
    //         article: 'Article 1',
    //         magasin: 'Magasin A',
    //         quantiteInitiale: 100,
    //         reste: 50,
    //     },
    //     {
    //         id: 2,
    //         dateDebut: '2023-02-01',
    //         dateFin: '2023-02-15',
    //         article: 'Article 2',
    //         magasin: 'Magasin B',
    //         quantiteInitiale: 150,
    //         reste: 75,
    //     },
    //     // Ajoutez d'autres données ici
    // ]);

    return (
        <div className="widget has-shadow">
            <div className="widget-header bordered no-actions d-flex align-items-center">
                <h4>Border</h4>
            </div>
            <div className="widget-body">
                <div className="table-responsive">
                    <table className="table table-bordered mb-0">
                        <thead>
                            <tr>
                                {props.columnHeaders.map((header, index) => (
                                    <th key={index}>{header}</th>
                                ))}
                            </tr>
                        </thead>
                        <tbody>
                            {props.tableData.map((row) => (
                                <tr key={row.id}>
                                    {props.columnHeaders.map((header, index) => (
                                        <td key={index}>{row[header]}</td>
                                    ))}

                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
