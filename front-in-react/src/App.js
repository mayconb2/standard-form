import React, { useState, useEffect } from 'react';
import './App.css';
import axios from "axios";

function App() {

  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [city, setCity] = useState([]);
  const [fedState, setFedStat] = useState([{name: 'Selecione um estado', id: 0, ferative_unit: 'SS'}]);
  const [message, setMessage] = useState("");
  const [selectedState, setSelectedState] = useState(1);
  const [selectedCity, setSelectedCity] = useState(0);

  const baseURL = 'http://localhost:8090/api/v1/';

  axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
  axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

  const sendForm = () => {
    if (!containAllInformation()) {
      alert('Todos os campos são obrigatórios!');
      return
    }
    axios.post(`${baseURL}/form`, {
      name, phone, email, city: selectedCity, state: selectedState, message
    }).then((data) => {
      alert(`Agendamento Realizado! Seu protocolo é ${data.data.protocol}`)
      // clearForm();
    }).catch(e => {
      console.log(e);
      alert('Não foi possível realizar o agendamento. Tenta mais tarde');
      // clearForm();
    }).finally(() => {
      clearForm();
    })
  }

  const containAllInformation = () => {
    if (!name || !email || !selectedCity || !selectedState || !phone || message) {
      return false;
    }
  }

  const clearForm = () => {
    setName('');
    setPhone('');
    setEmail('');
    setSelectedState('');
    setSelectedCity('');
    setMessage('');

  }

  const loadStates = async () => {
    const result = await axios(`${baseURL}/state/list-all`);
    setFedStat([...fedState, ...result.data]);
  }

  const loadCities = async (estado) => {
    const result = await axios(`${baseURL}//city/list-cities-from-state/${estado}`);
    const orderedCities = result.data.sort((a,b) => {return a.name.localeCompare(b.name)})
    setCity(orderedCities);
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
  }, []);

  useEffect(() => {
    if(city.length > 0 ) {
      setSelectedCity(city[0].id)
    }
  }, [city]);

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
          value={name}
          type="text"
          onChange={(event) => {
            setName(event.target.value)
          }}
        />

        <label>E-mail:</label>
        <input 
          value={email}
          type="text"
          onChange={(event) => {
            setEmail(event.target.value)
          }}
        />

        <label>Estado</label>
        <select
          defaultValue={{label: "Selecione um estado", value: 0}}
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
          value={phone}
          type="text"
          onChange={(event) => {
            setPhone(event.target.value)
          }}
        />

        <label>Mensagem</label>
        <input 
          value={message}
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