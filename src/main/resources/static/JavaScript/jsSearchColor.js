function searchColor() {
    const color = document.getElementById("colorInput").value.trim();

    if (!color) {
        document.getElementById("result").innerText = "Моля, въведете име на цвят.";
        return;
    }

    fetch(`/api/colors/search?name=${encodeURIComponent(color)}`)
        .then(response => {
            if (!response.ok) throw new Error("Color not found");
            return response.json();
        })
        .then(data => {
            document.getElementById("result").innerText = "Значение: " + data.meaning;
        })
        .catch(error => {
            document.getElementById("result").innerText = "Цвят не е намерен.";
        });
}