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
[GitHub link](https://github.com/nyrta1/Online-Food-Ordering-System)

## Main Body
### Models
Utilizing the Spring Framework for class development simplifies object creation and integrates various features seamlessly. Spring offers a robust set of tools, streamlining development and ensuring efficient, maintainable code for enterprise-grade applications.

### Protection Enhancements
Enhancing protection via encryption and the Decorator pattern fortifies sensitive information against potential attacks. Regular security protocol updates ensure a secure environment and continuous evolution of defenses to safeguard user data.

### Database Testing
Database environment testing during operation phase ensures a seamless application launch by preemptively addressing potential issues or errors. Rigorous checks verify existence, creating databases and tables if needed for a stable foundation and reliable application.

### Spring JPA Repository
Utilizing Spring JPA Repository enhances database connections, ensuring reliability in data delivery to and from the database. It streamlines data access, facilitating efficient data retrieval, and significantly contributes to system robustness and performance.

### Backup Database Connection: Adapter Pattern for Spring JPA Application
A text-to-SQL code conversion method serves as a backup database connection in case of Spring JPA application failure. Leveraging the Adapter pattern allows a seamless switch to an alternate database connection when needed, ensuring continuity and resilience in database operations.

## Conclusion
Throughout the Online Food Ordering System's development, the goal was to enhance user experiences and streamline operations for both customers and restaurants. Key design patterns and frameworks like Spring were utilized to deliver a user-friendly interface, efficient order processing, and robust security measures.

### Key Points and Patterns Used
Various design patterns enhanced the system's functionality and security:
- Singleton
- Strategy
- Factory
- Observer
- Decorator
- Adapter

## Project Outcomes
The project delivered a user-friendly CLI interface enabling effortless browsing, ordering, and secure transactions. It improved customer convenience, restaurant management, and enforced robust security measures.

## Challenges Faced
- Security Implementation
- Database Testing intricacies

## Insights Gained
Adaptability and robustness in digital platforms are crucial. Insights include continuous evolution for security and prioritizing a seamless user experience.

## Future Improvements
- Enhanced Scalability
- Refinement in Security Measures
- Expanded Payment Strategies

## References
- [Singleton Design Pattern](javarush.com/groups/posts/2365-patternih-proektirovanija-singleton)
- [Strategy Design Pattern](javarush.com/groups/posts/2271-pattern-proektirovanija-strategija)
- [Factory Design Pattern](javarush.com/groups/posts/2370-pattern-proektirovanija-factory)
- [Observer Design Pattern](javarush.com/groups/posts/3421-shablon-nabljudateljh-observer)
- [Decorator Pattern](baeldung.com/java-decorator-pattern)
- [Adapter Design Pattern](javarush.com/groups/posts/2139-pattern-proektirovanija-adapter)
