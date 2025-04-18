#!/usr/bin/bash
jboss-cli.sh
connect
module add --name=com.mysql --resources=./mysql-connector-j-9.2.0.jar --dependencies=javax.api,javax.transaction.api
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-class-name=com.mysql.cj.jdbc.Driver)
/subsystem=datasources/data-source=mysqlDevelop:add(jndi-name=java:/mysqlDevelop,driver-name=mysql,connection-url=jdbc:mysql://192.168.1.5:10030/mydb,user-name=mysql,password=mysql)
reload

