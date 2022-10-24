import logo from './logo.svg';
import './App.css';
import { TwoIntegerAdditionContainer } from './containers/TwoIntegerAdditionContainer/TwoIntegerAdditionContainer';
import TwoIntegerSubtractionContainer from './containers/TwoIntegerSubtractionContainer/TwoIntegerSubtractContainer';

function App() {
  return (
    <div className="App">
      <TwoIntegerAdditionContainer/>
      <TwoIntegerSubtractionContainer/>
    </div>
  );
}

export default App;
