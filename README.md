Запуск приложения
1. Установить Wildfly 20.0.1 Final, Maven
2. Установить СУБД MySQL
3. В MySQL создать базу web_db
4. Выполнить скрипты schema.sql и data.sql из папки resources проекта
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
10. Переход на вторую страницу второго задания осуществляется по кнопкам Show node links соответственно каждому узлу в таюлице со страницы 1
11. Вернуться на первую страницу можно кнопкой Back to nodes
