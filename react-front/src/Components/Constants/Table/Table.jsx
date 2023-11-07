/* eslint-disable jsx-a11y/anchor-is-valid */
export default function Table(props) 
{

    return (
        <div class="widget has-shadow">
        <div class="widget-header bordered no-actions d-flex align-items-center">
            <h4>Border</h4>
        </div>
        <div class="widget-body">
            <div class="table-responsive">
                <table class="table table-bordered mb-0">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer Name</th>
                            <th>Country</th>
                            <th>Ship Date</th>
                            <th><span >Status</span></th>
                            <th>Order Total</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><span class="text-primary">054-01-FR</span></td>
                            <td>Lori Baker</td>
                            <td>US</td>
                            <td>10/21/2017</td>
                            <td><span ><span class="badge-text badge-text-small info">Paid</span></span></td>
                            <td>$139.45</td>
                            <td class="td-actions">
                                <a><i class="la la-edit edit"></i></a>
                                <a><i class="la la-close delete"></i></a>
                            </td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    )
    
}