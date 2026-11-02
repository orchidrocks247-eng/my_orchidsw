const menuToggle = document.getElementById("menuToggle");
const nav = document.getElementById("nav");
menuToggle.addEventListener("click", () => nav.classList.toggle("open"));
document.getElementById("year").textContent = new Date().getFullYear();

// Load institute details from the Java backend. Static page content remains as a fallback.
fetch("/api/college")
  .then(response => {
    if (!response.ok) throw new Error("College API unavailable");
    return response.json();
  })
  .then(data => {
    document.getElementById("aboutText").textContent = data.about;
    document.getElementById("address").textContent = data.address;
  })
  .catch(error => console.info("Showing built-in college information:", error.message));
