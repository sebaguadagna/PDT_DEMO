## Sobre PDT_DEMO ##
---
La idea es tener una primer implementación del mapeo relaciona con el modelo de la base que diseñamos y entregamos. En este back-end si se fijan en la tabla usuario van a observar el uso de enumerados y para qué sirven utilizandolo desde el cliente. Usamos enumerados cuando los atributos son pocos y categóricos, sexo, estados usuarios, departamentos, si o no, etc. Para no complicarla en un principio deje el enumerado directamente como atributo en la entidad usuario, si bien tengo la lógica en este mismo repo para normalizar el campo de enumerados (lo hablamos en clase con bernardo profe y nos dio el ok, al igual que Sergio) deje comentado (//) en el código esa relación FK con una tabla que normalice los enumerados. 
## Requerimientos para el back-end ##
---
Emepece este proyecto con wildfly 10 como requerimiento, y básicamente el back end cuenta con cuatro paquetes: 

* com.entities
* com.enumerados
* com.exception
* com.services

En el primero se encuentran declaradas casi todas las entidades (me quedan tres tablas), en un principio me parece lo mejor validar solo algunos casos de prueba y no todos, creo que en el PDT no se habla de probar todo para esta entrega. 
En el segundo paquete están los enumerados. 
En el tercero un clase para las excepciones. 
Y el cuarto paquete una pequeña implementación como servicio para la entidad usuario, básicamente una ABM para usuario.
## Requerimientos para el cliente ##
* Cliente de wildfly 10 (JAR)
* Jar de hibernate core para tener todas las funcionalidades del entity manager en el cliente. 

El cliente básicamente prueba un Alta de usuario, pero es muy facil implementar la baja lógica y una actualización, lo voy a estar subiendo seguramente el 18 de octubre. 

