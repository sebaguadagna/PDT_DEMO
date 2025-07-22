## Sobre PDT_DEMO ##

![Vista de login](https://github.com/sebaguadagna/PDT_DEMO/blob/master/forReadme/login.png)

---
Proyecto para UTEC
back-end (EJB) 
Muchas de las FK en la entidad Usuario, son entidades con atributos enumerados, la bd fue llevada a la segunda forma normal de la represetnación del modelo.

## Requerimiento, descripción del back-end ##
---
Comenzamos este proyecto con wildfly 10 como requerimiento, el back-end cuenta con los siguientes paquetes: 

* com.entities
* com.enumerados
* com.exception
* com.services

En el primero se encuentran declaradas todas las entidades que vamos a estar ocupando.
En el segundo paquete están los enumerados. 
En el tercero un clase especificametne para las excepciones. 
En el cuarto, ejb message beans con inyección al entitie manager (son de acceso a los DAOs)
## Requerimientos para el cliente ##
* Cliente de wildfly 10 (JAR)
* Jar de hibernate core [Descargalo](https://drive.google.com/file/d/1VgScJ7MsNEfzXmxWYGRG8cNyatuT-nb-/view?usp=sharing)  para tener todas las funcionalidades del entity manager en el cliente. 

El cliente consta de 12 vistas siendo la principal el login.
