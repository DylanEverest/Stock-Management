export default function SelectForm(props) {
    return (
        <div className="form-group row mb-5">
            <label className="col-lg-3 form-control-label">{props.label}</label>
            <div className="col-lg-9 select mb-3">
                <select name={props.name} className="custom-select form-control" onChange={props.onChange}>
                    {props.option.map((opt, index) => (
                        <option key={index} value={opt}> {opt} </option>
                    ))}
                </select>
            </div>
        </div>
    );
}
