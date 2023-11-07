export default function FormOutStock(props) 
{

    return(
        <div class="widget has-shadow">
            <div class="widget-header bordered no-actions d-flex align-items-center">
                <h4>Remplir</h4>
            </div>
            <div class="widget-body">
                <form class="form-horizontal">
                    
                    <div class="form-group row d-flex align-items-center mb-5">
                        <label class="col-lg-3 form-control-label">Quantite</label>
                        <div class="col-lg-9">
                            <input type="text" class="form-control"/>
                            <small>
                                En Kg.
                            </small>
                        </div>
                    </div>

                    <div class="form-group row mb-5">
                        <label class="col-lg-3 form-control-label">Articles</label>
                        <div class="col-lg-9 select mb-3">
                            <select name="account" class="custom-select form-control">
                                <option>option 1</option>
                                <option>option 2</option>
                                <option>option 3</option>
                                <option>option 4</option>
                            </select>
                        </div>
                        
                    </div>
                    <div class="form-group row mb-5">
                            <label class="col-lg-3 form-control-label">Magasin</label>
                            <div class="col-lg-9 select mb-3">
                                <select name="account" class="custom-select form-control">
                                    <option>option 1</option>
                                    <option>option 2</option>
                                    <option>option 3</option>
                                    <option>option 4</option>
                                </select>
                            </div>
                    </div>
                </form>
            </div>
        </div>
    );

}