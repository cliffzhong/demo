#!/bin/sh
export secret_key=test


export JAVA_OPTS="$JAVA_OPTS -Ddatabase.username=${DB_USERNAME}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.password=${DB_PW}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.serverName=jdbc:postgresql://${DB_URL}:${DB_PORT}/${DB_NAME}"
