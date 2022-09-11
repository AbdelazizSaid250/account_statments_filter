# account_statments_filter
[![Contributors][contributors-shield]][contributors-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- ABOUT THE PROJECT -->
# Java Project
This is a web project using Java 1.8, Spring Boot, Spring JPA, Spring Data Rest, Spring Security, Hibernate, Postgres, Lombok


## Steps to Use the Project

1. Install Postgres db into your localhost with user _**postgres**_ and password _**postgres**_.
2. Run the postgres schema which attached to the into the resources section.
3. Run this command ```mvn clean install``` then run the main class.
4. Open the browser and open this url `http://localhost:8080/filter/adminStatement`, it will redirect you to the login page.
5. Once login with the user **_admin_** with password **_admin_**, then try to login with this endpoint `filter/userStatement`, you will find authorization error page.
6. Try to open this endpoint `filter/adminStatement`, you will find that the response will run successfully.
7. Open this url `http://localhost:8080/logout` to logout and it will redirect you to the login page.
8. Do the same steps from step 5 with the user **_user_** and password **_user_**.
9. Wait for 5 minutes and run this endpoint again `filter/userStatement`, the session will be invalidated and will redirect to the login page.
10. Install SolarLing plugin to show you everything.


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/AbdelazizSaid250
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/abdelaziz-said-4a9b12127