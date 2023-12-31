![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/fc25e796-c55d-44dc-89dd-e80c726da163)


# ONLINE FOOD ORDERING SYSTEM
## Final Project for the "Software Design Patterns" Course
### Group: SE-2225
#### Team members: Nurtai Turlubekov, Zhalgas Sharken
#### Teaching Assistant: Arailym Bakenova
#### Astana, 2023

## Project Overview
The Online Food Ordering System aims to streamline the process of ordering food from various restaurants through a digital platform. It offers a user-friendly Command Line Interface (CLI) allowing customers to view menus, place orders, and make payments conveniently.

The project's core idea is to enhance the dining experience by providing a seamless and efficient way for customers to order meals from a wide range of restaurants without physical presence, bringing the ease of online shopping to the food industry.

### Project Objectives:
1. **Intuitive Interface:** Develop an easily navigable interface for users to explore restaurant options, customize orders, and finalize transactions effortlessly.
2. **Restaurant Management System:** Implement a robust system for restaurants to manage menus, update item availability, and track incoming orders in real-time.
3. **Order Processing and Payment:** Create a secure and efficient order processing system allowing users to customize orders, add to cart, and make secure payments through multiple channels.
4. **Security Measures:** Incorporate robust security measures to ensure data confidentiality, secure online transactions, and safeguard both customers and restaurants from potential cyber threats.
5. **Scalability and Performance:** Design the system for scalability to accommodate increasing user and restaurant numbers while ensuring optimal performance.

## UML Diagram
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/9a871615-9433-4977-bb35-7bb9062bf402)

[GitHub link ](https://github.com/nyrta1/Online-Food-Ordering-System)

## Main Body
### Models
Utilizing the Spring Framework for class development simplifies object creation and integrates various features seamlessly. Spring offers a robust set of tools, streamlining development and ensuring efficient, maintainable code for enterprise-grade applications.
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/8e14c580-821c-4ae1-8d06-89f66523b8db)



### Protection Enhancements
Enhancing protection via encryption and the Decorator pattern fortifies sensitive information against potential attacks. Regular security protocol updates ensure a secure environment and continuous evolution of defenses to safeguard user data.
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/51925ca7-263d-4401-bc0c-a3753f046d06)
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/1e3bc6ff-ef09-42ca-972d-a02e097d1b6f)



### Database Testing
Database environment testing during operation phase ensures a seamless application launch by preemptively addressing potential issues or errors. Rigorous checks verify existence, creating databases and tables if needed for a stable foundation and reliable application.
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/4e3aea12-8aaa-44c3-b2d0-5afa58745296)



### Spring JPA Repository
Utilizing Spring JPA Repository enhances database connections, ensuring reliability in data delivery to and from the database. It streamlines data access, facilitating efficient data retrieval, and significantly contributes to system robustness and performance.
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/db8844d3-046d-41f5-aab3-04b8e9cc7778)


### Backup Database Connection: Adapter Pattern for Spring JPA Application
A text-to-SQL code conversion method serves as a backup database connection in case of Spring JPA application failure. Leveraging the Adapter pattern allows a seamless switch to an alternate database connection when needed, ensuring continuity and resilience in database operations.
![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/a8def6a8-9995-4df9-825b-314de2d7e3bb)

![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/924cc6a3-36e3-4529-b8ca-db5db8221b22)

![image](https://github.com/nyrta1/Online-Food-Ordering-System/assets/147030027/f32c0cf2-6acf-41b8-a619-27d231164365)



### Security Measures and Patterns Utilized
- **Singleton:** Used for database connections, ensuring a single, shared connection across the application.
- **Strategy:** Implemented for payment methods, allowing flexible and interchangeable payment options.
- **Factory:** Employed in object creation to centralize and streamline the instantiation process.
- **Observer:** Utilized for order notifications, ensuring timely updates on order completion.
- **Decorator:** Applied to enhance security by encrypting and decoding user information.
- **Adapter:** Implemented for a backup database connection, converting text to SQL code seamlessly.

## Project Outcomes
The project delivered a user-friendly CLI interface enabling effortless browsing, ordering, and secure transactions. It improved customer convenience, restaurant management, and enforced robust security measures.

### Key Outcomes:
- **Enhanced Customer Convenience:** Providing a streamlined way for users to order from a multitude of restaurants at their convenience.
- **Improved Restaurant Management:** Enabling restaurants to efficiently manage menus, track orders in real-time, and update item availability.
- **Robust Security Measures:** Encryption of user data and continuous security updates ensured a secure environment for both customers and restaurants.

## Challenges Faced
- **Security Implementation:** Integrating robust security measures posed initial challenges due to the complexity of encryption and ensuring seamless decoding for user information.
- **Database Testing:** Rigorous testing to ensure the database's functionality and performance required meticulous evaluation, presenting occasional intricacies in addressing potential issues.

## Insights Gained
The project emphasized the significance of adaptability and robustness in digital platforms.

### Key Insights:
- **Continuous Evolution:** The need for ongoing updates and enhancements to stay ahead of emerging security threats.
- **User-Centric Design:** Prioritizing a seamless user experience significantly impacts customer satisfaction and retention.

## Future Improvements
Moving forward, the project could benefit from:

- **Enhanced Scalability:** Further optimizing the system for increased user and restaurant numbers.
- **Refinement in Security Measures:** Continuous improvements in encryption techniques to fortify user data.
- **Expanded Payment Strategies:** Integrating additional payment methods for user convenience and flexibility.

## References
- [Singleton Design Pattern](javarush.com/groups/posts/2365-patternih-proektirovanija-singleton)
- [Strategy Design Pattern](javarush.com/groups/posts/2271-pattern-proektirovanija-strategija)
- [Factory Design Pattern](javarush.com/groups/posts/2370-pattern-proektirovanija-factory)
- [Observer Design Pattern](javarush.com/groups/posts/3421-shablon-nabljudateljh-observer)
- [Decorator Pattern](baeldung.com/java-decorator-pattern)
- [Adapter Design Pattern](javarush.com/groups/posts/2139-pattern-proektirovanija-adapter)
