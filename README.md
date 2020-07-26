## Sobre PDT_DEMO ##

![Vista de login](https://github.com/sebaguadagna/PDT_DEMO/blob/master/forReadme/login.png)

---
Proyecto para UTEC de la materia PDT.
En este back end (EJB) en la tabla usuario van a observar el uso de enumerados y para qué sirven utilizandolo desde el cliente. Usamos enumerados cuando los atributos son pocos y categóricos, sexo, estados usuarios, departamentos, si o no, etc. 
Muchas de las FK en la entidad Usuario, son entidades con atributos enumerados, se trato de llegar a un nivel 2 de normalización de la represetnación del modelo en la base de datos.

## Requerimiento, descripción del back-end ##
---
Comenzamos este proyecto con wildfly 10 como requerimiento, y básicamente el back end cuenta con cuatro paquetes: 

* com.entities
* com.enumerados
* com.exception
* com.services

En el primero se encuentran declaradas casi todas las entidades (me quedan tres tablas), en un principio me parece lo mejor validar solo algunos casos de prueba y no todos, creo que en el PDT no se habla de probar todo para esta entrega. 
En el segundo paquete están los enumerados. 
En el tercero un clase para las excepciones. 
En el cuarto, ejb message beans con inyección al entitie manager, son de acceso a los DAOs
## Requerimientos para el cliente ##
* Cliente de wildfly 10 (JAR)
* Jar de hibernate core [Descargalo](https://drive.google.com/file/d/1VgScJ7MsNEfzXmxWYGRG8cNyatuT-nb-/view?usp=sharing)  para tener todas las funcionalidades del entity manager en el cliente. 

El cliente consta de 12 vistas siendo la principal el login.
