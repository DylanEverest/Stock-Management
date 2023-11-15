import Magasins from "../../../../Services/DataForms/Magasins/Magasins";
import SubmitButton from "../../../Constants/Buttons/SubmitButtons";
import DateInput from "../../../Constants/FormTools/DateInput";
import SelectForm from "../../../Constants/FormTools/Select";
import SimpleInput from "../../../Constants/FormTools/SimpleInput";

export default function FormPrepareStock(props) 
{
    return(
        <div class="widget has-shadow">
        <div class="widget-header bordered no-actions d-flex align-items-center">
            <h4>Remplir</h4>
        </div>
        <div class="widget-body">
            <form class="form-horizontal">
                
                <DateInput label={"Date debut"}/>

                <DateInput label={"Date fin"} />

                <SimpleInput label={"Articles"} />

                <SelectForm label={"Magasins"} option={Magasins()}/>           
                
                <div className="text-right">
                    <SubmitButton/>
                </div>

            </form>

        </div>
    </div>

    );
}