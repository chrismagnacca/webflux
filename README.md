# Spring WebFlux & Spring WebMvc

## Environment Setup

* Install Java 8+
```
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

<br>

* Install Gradle (4.8 as an example)

------------------------------------------------------------
Gradle 4.8
------------------------------------------------------------

```
Build time:   2018-06-04 10:39:58 UTC
Revision:     9e1261240e412cbf61a5e3a5ab734f232b2f887d

Groovy:       2.4.12
Ant:          Apache Ant(TM) version 1.9.11 compiled on March 23 2018
JVM:          1.8.0_181 (Oracle Corporation 25.181-b13)
OS:           Mac OS X 10.13.6 x86_64
```
<hr>

## Project Setup (both SpringWebFlux & SpringWebMvc work similarly)

* Ensure the Project Builds Locally

```
reactive $ ./gradlew :SpringWebFlux:clean :SpringWebFlux:build
BUILD SUCCESSFUL in 4s
8 actionable tasks: 8 executed
reactive $
```
<br>

* Run the Project
```
reactive $ ./gradlew :SpringWebFlux:bootRun
```
<br>

* (_Optional_) Run the Project in Debug to expose JMX for Remote Debug. 
This will pause startup until you connect to the running instance so that you 
can debug application startup and application context creation.
```
reactive $ ./gradlew :SpringWebFlux:bootRun --info --debug-jvm
```
<br>

## Using Gatling to Produce Load

* Run the Gatling Project

```
reactive $ ./gradlew :SpringWebGatling:gatlingRun
```
<br>

* Examine Simulation results in `build/reports` 
