import { fireEvent, render, screen } from "@testing-library/react";
import Button from "./Button";

describe("Button test", () => {
    it("should render the text passed on props", () => {
        render(<Button text={"Du texte"}/>)
    })
})