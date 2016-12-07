# Assignment 03: SOAP Web Services

## [Introduction to Service Design and Engineering](https://github.com/IntroSDE) | [University of Trento](http://www.unitn.it/)

# Sever

URL of my server: [https://secure-refuge-6052.herokuapp.com/](https://secure-refuge-6052.herokuapp.com/)  
Client repository: [https://github.com/abonte/introsde-2016-assignment-3-client](https://github.com/abonte/introsde-2015-assignment-3-client)  
I worked alone

### Install
In order to execute this server locally you need the following technologies (in the brackets you see the version used to develop):

* Java (jdk1.8.0)
* ANT (version 1.9.4)

Then, clone the repository. Run in your terminal:

```
git clone https://github.com/abonte/introsde-2015-assignment-3-server && cd introsde-2015-assignment-3-server
```

and run the following command:
```
ant install
```
### Getting Started
To run the server locally then run:
```
ant start
```
### Code
**packages:**  
*[src/introsde/assignment/soap/dao](src/introsde/assignment/soap/dao)*: contains the data access object; 
*[src/introsde/assignment/soap/model](src/introsde/assignment/soap/model)*: contains the definition of *Person*, *HealthMeasureHistory*;  
*[src/introsde/assignment/soap/endpoint](src/introsde/assignment/soap/endpoint)*: stand alone server;  
*[src/introsde/assignment/soap/ws](src/introsde/assignment/soap/ws)*: SOAP web service;  
