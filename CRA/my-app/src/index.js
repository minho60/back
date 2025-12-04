// index.js 는 리액트의 입구이다.
import ReactDOM from 'react-dom/client';
// import App from './App';
import './index.css';



function App2() {
  return <h1 className='txtcolor'> hello CRA </h1>;

}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <App2 />

);



