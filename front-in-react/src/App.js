import React, { useState, useEffect } from 'react';
import './App.css';
import axios from "axios";

function App() {

  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [city, setCity] = useState([]);
  const [fedState, setFedStat] = useState([]);
  const [message, setMessage] = useState("");

  const baseURL = 'http://localhost:8090/api/v1/';

  axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
  axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

  const sendForm = () => {
    axios.post(`${baseURL}/form`, {
      name, phone, email, city, state: fedState, message
    }).then(() => {
      console.log("sucess");
    })
  }

  const loadStates = async () => {
    const result = await axios(`${baseURL}/state/list-all`);
    setFedStat(result.data);
    console.log(result.data);
  }

  useEffect(async () => {
    loadStates();
  }, [name], [phone], [email], [city], [message]);

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
        <select>
          {fedState.map(state => <option value={state.id}>{state.name}</option>)}
        </select>

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