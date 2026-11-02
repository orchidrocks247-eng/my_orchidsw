# Orchid College Website (Student Project)

A responsive informational website for **Nagesh Karajagi Orchid College of Engineering & Technology, Solapur**. Built with HTML, CSS, JavaScript and a small Java HTTP server. Java classes demonstrate OOP concepts (encapsulation, constructors, objects and separation of responsibilities).

> **Important:** This is an independent student project, not the official college website and not affiliated with or endorsed by the institute. Verify all facts, admissions, fees, staff, facilities and notices using the official site before relying on them.

## Features
- Responsive home page and navigation
- About section and institute overview
- Six engineering departments listed on the college website
- Admissions link to the official page
- Contact details and clickable phone/email
- Java backend endpoint at `/api/college`
- Java model classes: `College` and `Department`

## Requirements
- JDK 17 or later
- Any code editor (VS Code, Eclipse, IntelliJ IDEA)
- A modern web browser

## Run locally

Open a terminal in the project root:

```bash
javac -d out src/college/*.java
java -cp out college.CollegeServer
```

Open **http://localhost:8080** in your browser. Keep the terminal running while using the site. Press `Ctrl + C` to stop the server.

## Project structure

```text
Orchid-College-Website/
├── src/
│   └── college/
│       ├── College.java
│       ├── Department.java
│       ├── CollegeData.java
│       └── CollegeServer.java
├── public/
│   ├── index.html
│   ├── style.css
│   └── app.js
├── .gitignore
└── README.md
```

## Customize
- Update verified college content in `src/college/CollegeData.java`.
- Change page layout in `public/index.html`.
- Change colors and responsive layout in `public/style.css`.
- Change menu and API loading behavior in `public/app.js`.

Do not add private student information, passwords, API keys or confidential college documents to a public repository.

## Official information sources
- College home: https://orchidengg.ac.in/
- Contact: https://orchidengg.ac.in/contact-us/
- Admissions: https://orchidengg.ac.in/admissions/

Some details on the official website can change. This demo deliberately links to official pages for current admissions information rather than hard-coding changing deadlines or fees.
