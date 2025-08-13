#!/bin/bash
CLASSPATH=./lib/*

javac -cp "$CLASSPATH" ./*.java

java -cp ".:$CLASSPATH" CARTER_227_PROY_FINAL


