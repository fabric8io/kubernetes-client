@echo off
SET token=%PART1% %1
CALL :upper token

echo {
echo   "kind": "ExecCredential",
echo   "apiVersion": "client.authentication.k8s.io/v1alpha1",
echo   "spec": {},
echo   "status": {
echo     "token": "%token%"
echo   }
echo }

:upper
FOR %%a IN (A B C D E F G H I J K L M N O P Q R S T U V W X Y Z) DO CALL SET "%1=%%%1:%%a=%%a%%%"
GOTO :EOF
