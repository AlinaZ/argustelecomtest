Запуск приложения
1. Установить Wildfly 20.0.1 Final, Maven, СУБД MySQL 
2. В MySQL создать базу web_db
3. Выполнить скрипт schema.sql - создание схемы БД
4. Выполнить скрипт data.sql из папки resources проекта - заполнение базы данными
5. Запустить jboss-cli.bat или .sh и создать datasource в сервере приложений следующими командами:
  добавить в модули драйвер mysql
  module add --name=com.mysql --resources=~/.m2/repository/mysql/mysql-connector-java/8.0.17/mysql-connector-java-8.0.17.jar --dependencies=javax.api,javax.transaction.api
  добавить драйвер в конфигурацию сервера
  /subsystem=datasources/jdbc-driver=mysql:add(driver-name="mysql",driver-module-name="com.mysql",driver-class-name=com.mysql.cj.jdbc.Driver)
  добавить datasource для базы данных web_db
  data-source add --jndi-name=java:jboss/datasources/mySQL --name=web_db --connection-url=jdbc:mysql://localhost:3306/web_db?useUnicode=true&serverTimezone=UTC&useSSL=false --driver-name=mysql --user-name=root --password=root
6. В командной строке перейти в директорию проекта: cd ~/connectmodel
7. Выполнить mvn package
8. Скопировать из папки ~/connectmodel/target файл connectmodel-1.0-SNAPSHOT.war и вставить в папку wildfly ~\wildfly-20.0.1.Final\standalone\deployments
9. В браузере первая страница приложения будет отображаться по адресу http://localhost:8080/connectmodel-1.0-SNAPSHOT/ и http://localhost:8080/connectmodel-1.0-SNAPSHOT/nodes.xhtml
10. Переход на вторую страницу второго задания осуществляется по кнопкам Show node links соответственно каждому узлу в таблице со страницы 1
11. Вернуться на первую страницу кнопкой Back to nodes

Задание 1. Разработать пакет Entity Bean для приведенной предметной модели. Каждую сущность связать с
базой данных посредством JPA-аннотаций. 
Код сущностей - https://github.com/AlinaZ/argustelecomtest/tree/master/src/main/java/ru/argustelecom/model
Файл заполнения базы демоданными - https://github.com/AlinaZ/argustelecomtest/tree/master/src/main/resources/data.sql

Задание 2. Необходимо разработать Web-приложение для просмотра данных БД задачи 1. Приложение должно иметь две страницы. Приложение должно быть целостное, должно обладать
хотя бы минимальным дизайном. Слой подготовки данных для отображения оформить в виде Session Bean. Страницы – на JSF. 
Код слоя доступа к данным БД - https://github.com/AlinaZ/argustelecomtest/tree/master/src/main/java/ru/argustelecom/dao
Код сервисного слоя, содержащего бизнес-логику по формированию требуемых данных - https://github.com/AlinaZ/argustelecomtest/tree/master/src/main/java/ru/argustelecom/service
Объекты для представления результатов, из которых JSF берет данные - https://github.com/AlinaZ/argustelecomtest/tree/master/src/main/java/ru/argustelecom/view
Контроллеры для 1 и 2 страниц  приложения - https://github.com/AlinaZ/argustelecomtest/tree/master/src/main/java/ru/argustelecom/controller 

Задание 4. Написать unit-тесты с использоватьем mockito. Написать unit-тесты с использованием mockito
Код тестов - https://github.com/AlinaZ/argustelecomtest/tree/master/src/test/java/ru/argustelecom
Тесты проверяют сервисы и контроллеры
 
