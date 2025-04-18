keytool -genkey -alias mycert -keyalg RSA -keystore keystore.jks -storepass changeit -validity 3650

keytool -export -alias mycert -keystore keystore.jks -file mycert.crt -storepass changeit
