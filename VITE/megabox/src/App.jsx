
import BoxOfficeCard from "./BoxOfficeCard.jsx";
import {datas} from "./js/data.js"

function App() {
  
    return (
            <div className="box_office">
              {datas.map((ele)=> { return <BoxOfficeCard Key={ele.rank}  data={ele} />  })}
            </div>
    );
}

export default App;
