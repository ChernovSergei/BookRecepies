const apiUrl = "http://localhost:8080/api/recipes";

function loadRecipes() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("recipeList");
            list.innerHTML = "";
            data.forEach(recipe => {
                const item = document.createElement("li");
                item.textContent = '${recipe.name}: ${recipe.instructions}';
                list.appendChild(item);
            });
        });
}

document.addEventListener("DOMContentLoaded", function()) {
    document.getElementById("recipeForm").addEventListener("submit", function(e)) {
        e.preventDefault();

        const name = document.getElementById("name").value;
        const instructions = document.getElementById("instructions").value;

        fetch(apiUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({name, instructions})
        })
        .then(() => {
            loadRecipes();
            this.reset();
        });
    });
    loadRecipes();
});