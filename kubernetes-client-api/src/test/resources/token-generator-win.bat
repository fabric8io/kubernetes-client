@REM
@REM Copyright (C) 2015 Red Hat, Inc.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM         http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM

@echo off
IF [%1]==[] (
    SET token=%PART1%
) ELSE (
    SET token=%PART1% %~1
)

CALL :upper token

echo {
echo   "kind": "ExecCredential",
echo   "apiVersion": "client.authentication.k8s.io/v1",
echo   "spec": {},
echo   "status": {
echo     "token": "%token%"
echo   }
echo }
GOTO :EOF

:upper
FOR %%a IN (A B C D E F G H I J K L M N O P Q R S T U V W X Y Z) DO CALL SET "%1=%%%1:%%a=%%a%%%"
