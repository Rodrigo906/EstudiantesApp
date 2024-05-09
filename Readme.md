# Aplicación

* Java 17
* Base de datos H2 en memoria

# Comandos

Construir la imagen
```
docker build -t app-estudiante:latest -f .\docker\Dockerfile .
```

# Subir imagen al registry de github

* Generar token de acceso

* Loguearse en el registry
```
echo $PAT | docker login ghcr.io --username <USUARIO GITHUB> --password-stdin
echo <TOKEN> | docker login ghcr.io -u rodrigo906 --password-stdin
```

* Contruir la imagen
```
docker build -t <TAG IMAGEN> -f <PATH DOCKERFILE>
docker build -t ghcr.io/rodrigo906/estudiantes:latest -f .\docker\Dockerfile
```

* Subir la imagen
```
docker push <TAG DE IMAGEN>
docker push ghcr.io/rodrigo/estudiantes:latest
```

Prueba