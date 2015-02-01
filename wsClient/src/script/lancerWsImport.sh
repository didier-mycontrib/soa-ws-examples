# -d src ou -d src/main/java ou ...
wsimport -d ../main/java -keep http://localhost:8080/wsCalculateur/services/calculateur?wsdl
wsimport -d ../main/java -keep http://localhost:8080/wsCalculateur/services/uploadWs?wsdl
echo "fin"; read fin
