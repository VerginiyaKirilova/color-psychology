function searchColor(){
    const color = document.getElementById("colorInput").value;
    fetch('/api/colors/search?name=${encodeURIComponent(color)}')
        .then(response => {
            if(!response.ok){
                throw new Error("Color not found");
        }
            return response.json();
        })
        .then(data => {
            document.getElementById("result").innerText = 'Значение : ${data.meaning}';
        })
        .catch(() => {
            document.getElementById("result").innerText = "Цветът не е намерен.";
        });
       }
    }