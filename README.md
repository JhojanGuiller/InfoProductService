# MICROSERVICE PRODUCT
Este microservicio muestra todos los productos que ofrece el banco.

## INSTALACION
Descargar docker de https://www.docker.com/get-started

Abrir una consola de comandos y ejecutar el siguiente comando para descargar una imagen Mongo
- docker pull mongo

Clonar este repositorio en una carpeta local

En la consola de comando ingresar a la carpata donde se descargo este repositorio
- cd <ruta>/InfoProductService
- docker-compose up --build -d

Verificar si los container se levantaron con exito
- docker ps

## ESTRUCTURA DEL PRODUCTO
{
  "IdProducto": Integer,
  "tipoProducto": String,
  "producto": String
}

## RUTAS
El container del microservicio esta corriendo en el puerto 8082

Las rutas son las siguientes:

- Obtener todos los productos [Metodo GET]
  - http://localhost:8082/products

- Obtener un producto por id [Metodo GET]
  - http://localhost:8082/products/<id>

- Agregar un producto nuevo [Metodo POST]
  - http://localhost:8082/products/addProduct

- Actualizar un producto [Metodo PUT]
  - http://localhost:8082/products/updateProduct/<id>

- Eliminar un producto [Metodo DELETE]
  - http://localhost:8082/products/updateProduct/<id>
