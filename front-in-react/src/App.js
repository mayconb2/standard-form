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
  const [selectedState, setSelectedState] = useState(0);
  const [selectedCity, setSelectedCity] = useState(1);

  const baseURL = 'http://localhost:8090/api/v1/';

  axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
  axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

  const sendForm = () => {
    axios.post(`${baseURL}/form`, {
      name, phone, email, city: selectedCity, state: selectedState, message
    }).then(() => {
      console.log("sucess");
    })
  }

  const loadStates = async () => {
    const result = await axios(`${baseURL}/state/list-all`);
    setFedStat(result.data);
    // console.log(result.data);
  }

  const loadCities = async (estado) => {
    const result = await axios(`${baseURL}//city/list-cities-from-state/${estado}`);
    setCity(result.data);
    // console.log(result.data);
  }

  const handleStateSelect = async (e) => {
    const estado = e.target.value;
    setSelectedState(e.target.value);
    await loadCities(estado);
  }

  const handleCitySelect = (e) => {
    setSelectedCity(e.target.value);
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
        <select
          onChange={e => handleStateSelect(e)}
        >
          {fedState.map(state => <option value={state.id}>{state.name}</option>)}
        </select>

        <label>Cidade</label>
        <select
          onChange={e => handleCitySelect(e)}
        >
          {city.map(cityData => <option value={cityData.id}>{cityData.name}</option>)}
        </select>

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