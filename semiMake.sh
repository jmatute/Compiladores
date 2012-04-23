#!/bin/bash

jflex *.flex
cup *.cup
#estricto javac -Xlint *.java
javac *.java
