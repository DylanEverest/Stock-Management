/* eslint-disable react/style-prop-object */

import Sidebar from "../../Constants/Siderbar/Sidebar";
import Table from "../../Constants/Table/Table";
import ContentHeader from "../ContentHeader/ContentHeader";

/* eslint-disable jsx-a11y/anchor-is-valid */
export default function ContentStockState() 
{

    return(
        <div class="page-content d-flex align-items-stretch">
            {/* side */}
            <Sidebar/>
            <div class="content-inner">
                <div class="container-fluid">
                    {/* header content */}
                    <ContentHeader/>               
                    <div class="row">
                        <div class="col-xl-12">
                            {/* table */}
                            <Table/>                                

                        </div>
                    </div>
                </div>
            </div>
        </div>
    );

}