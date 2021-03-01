import './App.css';
import {useState} from "react";
import Axios from "axios";

function App() {

  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [city, setCity] = useState(0);
  const [fedState, setFedStat] = useState(0);
  const [message, setMessage] = useState("");

  const baseURL = 'http://localhost:8090/api/v1/form';

  Axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
  Axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

  const sendForm = () => {
    Axios.post(baseURL, {
      name, phone, email, city, state: fedState, message
    }).then(() => {
      console.log("sucess");
    })
  }

  return (
    <div className="App">
        
        <div className="header">
          <h2>
            Registrar Solicitação Dentro do Liferay
          </h2>
        </div>

      <div className="information">

        <label>Nome:</label>
        <input 
          type="text"
          onChange={(event) => {
            setName(event.target.value)
          }}
        />

        <label>E-mail:</label>
        <input 
          type="text"
          onChange={(event) => {
            setEmail(event.target.value)
          }}
        />

        <label>Estado</label>
        <input 
          type="text"
          onChange={(event) => {
            setFedStat(event.target.value)
          }}
        />

        <label>Cidade</label>
        <input 
          type="text"
          onChange={(event) => {
            setCity(event.target.value)
          }}
        />

        <label>Telefone</label>
        <input 
          type="text"
          onChange={(event) => {
            setPhone(event.target.value)
          }}
        />

        <label>Mensagem</label>
        <input 
          type="text"
          onChange={(event) => {
            setMessage(event.target.value)
          }}
        />

        <button onClick={sendForm}>Enviar</button>
      </div>
    </div>
  );
}

export default App;