
export const NumberInput = ({label, placeholder, value, setValue}) => {
    return <div>
        <p>{label}</p>
        <input value={value} type="number" onChange={e => setValue(e.target.value)} placeholder={placeholder}/>
    </div>
}

export default NumberInput;