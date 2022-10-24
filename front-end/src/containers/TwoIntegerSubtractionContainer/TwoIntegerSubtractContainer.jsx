import { useState } from "react";
import Button from "../../components/Button/Button";
import NumberInput from "../../components/NumberInput/NumberInput";
import mathService from "../../service/MathService";

export const TwoIntegerSubtractionContainer = () => {
    const [one, setOne] = useState();
    const [two, setTwo] = useState();
    const [result, setResult] = useState();

    const handleSubmit = (e) => {
        e.preventDefault()
        mathService.subtract(one,two).then((response) => {
            setResult(response.data.result)
        }).catch((error) => console.log(error))
    }


    return <div>
        <form onSubmit={handleSubmit}>
            <NumberInput placeholder={"One"} value={one} setValue={setOne} />
            <NumberInput placeholder={"Two"} value={two} setValue={setTwo}/>
            <Button text={"Soustrait"}/>
        </form>
        {result && <h1>{result}</h1>}
    </div>
}

export default TwoIntegerSubtractionContainer;