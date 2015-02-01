set MYSQL_HOME=C:\Program Files\MySQL\MySQL Server 5.0
set PRJ_DIR=C:\workspace\cxf_gestion_taux_frais
net start MySql
cd "%PRJ_DIR%"
"%MYSQL_HOME%/bin/mysql" -u root -p < tauxfraisdb.sql
pause