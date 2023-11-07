/* eslint-disable react/style-prop-object */

import ContentHeader from "../../Constants/ContentHeader/ContentHeader";
import Sidebar from "../../Constants/Siderbar/Sidebar";
import Table from "../../Constants/Table/Table";


/* eslint-disable jsx-a11y/anchor-is-valid */
export default function ContentStockState() 
{
    const tableData = [
        {
            id: 1,
            "Date début": "2023-01-01",
            "Date fin": "2023-01-10",
            Article: "Article 1",
            Magasin: "Magasin A",
            "Quantité initiale": 100,
            Reste: 50,
        },
        {
            id: 2,
            "Date début": "2023-02-01",
            "Date fin": "2023-02-15",
            Article: "Article 2",
            Magasin: "Magasin B",
            "Quantité initiale": 150,
            Reste: 75,
        },
        // Ajoutez d'autres objets de données ici
    ];
    
    return(
        <div class="page-content d-flex align-items-stretch">

            <Sidebar/>

            <div class="content-inner">

                <div class="container-fluid">

                    <ContentHeader title="Etat de stock"/>               

                    <div class="row">

                        <div class="col-xl-12">

                            <Table columnHeaders={["Date début", "Date fin", "Article", "Magasin", "Quantité initiale", "Reste"]} tableData={tableData}/>                                
                        </div>

                    </div>

                </div>

            </div>

        </div>
    );

}