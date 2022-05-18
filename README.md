# IT_park_final_project - "Веб-журнал/записная книга"

3-х звенное приложение

Basis - Spring Boot

UI - (Web + Thymeleaf)

Data layer - MongoDb

Tests - JUnit Jupiter

Additional: Mongock, Actuator, Swagger

Проект содержит модуль с основной логикой (port: 8080), и логирующий модуль (port: 8085), причем логирующий модуль можно запускать по желанию. 

Работа с записями осуществляется через "крестик" - добавить, "минус" - удалить, после редактирования текстового поля подтверждение происходит по нажатию на "Enter". 
Сделав поле пустым, по нажатию на "Enter" происходит удаление. Также можно изменять статус заметки.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

"Web-journal/notebook"

three-tier application

Basis - Spring Boot

UI - (Web + Thymeleaf)

Data layer - MongoDb

Tests - JUnit Jupiter

Additional: Mongock, Actuator, Swagger

Project consist of two modules. The first moudle - bisness logic (port:8080), the second - logger (port:8085). The launch of the second module is at the discretion of the user.

Application allow you to add, delete, change notes, and switch thier status.
