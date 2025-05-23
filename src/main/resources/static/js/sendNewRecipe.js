document.addEventListener("DOMContentLoaded", function() {
   document.getElementById("newRecipeForm").addEventListener("submit", function(e) {
        e.preventDefault();

        const data = {
            recipeName=document.getElementById("recipeName").value,
            toolName=document.getElementById("toolName").value,
            productName=document.getElementById("productName").value,
            actionName=document.getElementById("actionName").value
        };

        fetch("/addRecepie", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
        .then(response => response.text())
        .then(result => console.log("Success:", result))
        .then(error => console.error("Error:", error));
   });
});