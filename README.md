# -_sistema_web_- :.
# 🏍️ Sistema Web:

<img width="1254" height="1254" alt="image" src="https://github.com/user-attachments/assets/a671b4e7-13f6-458b-8619-a4a5a80d70c2" />  

```
Aplicacion web desarrollada con **Java 21**, **Spring Boot**, **Thymeleaf**, **Bootstrap** y **Oracle Database 19c**.

El proyecto implementa un CRUD completo para administrar motos desde una interfaz web.

---

# 📋 Tecnologías

- Java 21
- Spring Boot 3.x
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- Maven
- Oracle Database 19c
- IntelliJ IDEA

---

# 🎯 Funcionalidades

La aplicación permite:

- Registrar motos
- Consultar motos
- Editar motos
- Eliminar motos
- Ver información de una moto
- Mostrar mensajes de operación
- Persistir información en Oracle 19c
- Interfaz web con Bootstrap

---

# 📁 Estructura del proyecto

```text
TiendaMotos/
│
├── pom.xml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ejemplo/
│   │   │           └── tiendamotos/
│   │   │               │
│   │   │               ├── TiendaMotosApplication.java
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── MotoController.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   └── Moto.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── MotoRepository.java
│   │   │               │
│   │   │               └── service/
│   │   │                   └── MotoService.java
│   │   │
│   │   └── resources/
│   │       │
│   │       ├── static/
│   │       │   └── css/
│   │       │       └── estilos.css
│   │       │
│   │       ├── templates/
│   │       │   ├── index.html
│   │       │   ├── motos.html
│   │       │   ├── crear-moto.html
│   │       │   ├── editar-moto.html
│   │       │   └── detalle-moto.html
│   │       │
│   │       └── application.properties
│   │
│   └── test/
│
└── README.md
1. Crear el proyecto

En IntelliJ IDEA seleccionar:

File
   ↓
New
   ↓
Project

Seleccionar:

Language: Java
Build System: Maven
JDK: 21

También se puede crear mediante Spring Initializr.

Dependencias:

Spring Web
Spring Data JPA
Thymeleaf
Oracle Driver
2. pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="
         http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.5</version>
        <relativePath/>
    </parent>

    <groupId>com.ejemplo</groupId>
    <artifactId>tienda-motos</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <name>tienda-motos</name>
    <description>Sistema Web de Gestión de Motos</description>

    <properties>
        <java.version>21</java.version>
    </properties>

    <dependencies>

        <!-- Spring MVC -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Thymeleaf -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <!-- Oracle -->
        <dependency>
            <groupId>com.oracle.database.jdbc</groupId>
            <artifactId>ojdbc11</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>

            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

        </plugins>
    </build>

</project>
3. Clase principal

Archivo:

src/main/java/com/ejemplo/tiendamotos/TiendaMotosApplication.java

Código:

package com.ejemplo.tiendamotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaMotosApplication {

    public static void main(String[] args) {

        SpringApplication.run(TiendaMotosApplication.class, args);

    }
}
4. Configuración Oracle 19c

Archivo:

src/main/resources/application.properties

Código:

# =====================================================
# CONFIGURACIÓN DE LA APLICACIÓN
# =====================================================

spring.application.name=tienda-motos

server.port=8080


# =====================================================
# ORACLE DATABASE 19c
# =====================================================

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl

spring.datasource.username=TIENDA_MOTOS

spring.datasource.password=123456

spring.datasource.driver-class-name=oracle.jdbc.OracleDriver


# =====================================================
# JPA / HIBERNATE
# =====================================================

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true


# =====================================================
# THYMELEAF
# =====================================================

spring.thymeleaf.cache=false

Cambiar TIENDA_MOTOS y 123456 por el usuario y contraseña configurados en Oracle.

5. Crear usuario Oracle

Ingresar a Oracle como SYSTEM.

CREATE USER TIENDA_MOTOS
IDENTIFIED BY 123456;

Asignar permisos:

GRANT CONNECT, RESOURCE TO TIENDA_MOTOS;

También:

GRANT CREATE SESSION TO TIENDA_MOTOS;
6. Crear tabla MOTO

Aunque Hibernate puede crear la tabla automáticamente debido a:

spring.jpa.hibernate.ddl-auto=update

También podemos crearla manualmente:

CREATE TABLE MOTO (
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY,
    MARCA VARCHAR2(100) NOT NULL,
    MODELO VARCHAR2(100) NOT NULL,
    ANIO NUMBER(4) NOT NULL,
    CILINDRAJE NUMBER(6) NOT NULL,
    COLOR VARCHAR2(50),
    PRECIO NUMBER(15,2),
    PRIMARY KEY (ID)
);
7. Datos de prueba
INSERT INTO MOTO
(MARCA, MODELO, ANIO, CILINDRAJE, COLOR, PRECIO)
VALUES
('Yamaha', 'MT-03', 2025, 321, 'Negro', 28500000);

INSERT INTO MOTO
(MARCA, MODELO, ANIO, CILINDRAJE, COLOR, PRECIO)
VALUES
('Honda', 'CB190R', 2024, 184, 'Rojo', 18900000);

INSERT INTO MOTO
(MARCA, MODELO, ANIO, CILINDRAJE, COLOR, PRECIO)
VALUES
('Suzuki', 'Gixxer', 2025, 155, 'Azul', 17500000);

INSERT INTO MOTO
(MARCA, MODELO, ANIO, CILINDRAJE, COLOR, PRECIO)
VALUES
('Kawasaki', 'Ninja 400', 2025, 399, 'Verde', 42000000);

INSERT INTO MOTO
(MARCA, MODELO, ANIO, CILINDRAJE, COLOR, PRECIO)
VALUES
('Bajaj', 'Dominar 400', 2024, 373, 'Gris', 24500000);

COMMIT;
8. Modelo Moto

Archivo:

src/main/java/com/ejemplo/tiendamotos/model/Moto.java

Código:

package com.ejemplo.tiendamotos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "MOTO")
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Integer cilindraje;

    @Column(length = 50)
    private String color;

    @Column(precision = 15, scale = 2)
    private BigDecimal precio;


    public Moto() {
    }


    public Moto(
            String marca,
            String modelo,
            Integer anio,
            Integer cilindraje,
            String color,
            BigDecimal precio) {

        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cilindraje = cilindraje;
        this.color = color;
        this.precio = precio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }


    public Integer getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
9. Repository

Archivo:

src/main/java/com/ejemplo/tiendamotos/repository/MotoRepository.java

Código:

package com.ejemplo.tiendamotos.repository;

import com.ejemplo.tiendamotos.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    List<Moto> findByMarcaContainingIgnoreCase(String marca);

}
10. Service

Archivo:

src/main/java/com/ejemplo/tiendamotos/service/MotoService.java

Código:

package com.ejemplo.tiendamotos.service;

import com.ejemplo.tiendamotos.model.Moto;
import com.ejemplo.tiendamotos.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private final MotoRepository motoRepository;


    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }


    public List<Moto> listarTodas() {

        return motoRepository.findAll();

    }


    public Optional<Moto> buscarPorId(Long id) {

        return motoRepository.findById(id);

    }


    public List<Moto> buscarPorMarca(String marca) {

        return motoRepository.findByMarcaContainingIgnoreCase(marca);

    }


    public Moto guardar(Moto moto) {

        return motoRepository.save(moto);

    }


    public void eliminar(Long id) {

        motoRepository.deleteById(id);

    }
}
11. Controller

Archivo:

src/main/java/com/ejemplo/tiendamotos/controller/MotoController.java

Código:

package com.ejemplo.tiendamotos.controller;

import com.ejemplo.tiendamotos.model.Moto;
import com.ejemplo.tiendamotos.service.MotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoController {

    private final MotoService motoService;


    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }


    @GetMapping
    public String listarMotos(
            @RequestParam(required = false) String marca,
            Model model) {

        if (marca != null && !marca.isBlank()) {

            model.addAttribute(
                    "motos",
                    motoService.buscarPorMarca(marca)
            );

        } else {

            model.addAttribute(
                    "motos",
                    motoService.listarTodas()
            );
        }

        model.addAttribute("marcaBusqueda", marca);

        return "motos";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {

        model.addAttribute("moto", new Moto());

        return "crear-moto";
    }


    @PostMapping("/guardar")
    public String guardarMoto(@ModelAttribute Moto moto) {

        motoService.guardar(moto);

        return "redirect:/motos";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(
            @PathVariable Long id,
            Model model) {

        Moto moto = motoService
                .buscarPorId(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Moto no encontrada: " + id
                        )
                );

        model.addAttribute("moto", moto);

        return "editar-moto";
    }


    @GetMapping("/detalle/{id}")
    public String detalleMoto(
            @PathVariable Long id,
            Model model) {

        Moto moto = motoService
                .buscarPorId(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Moto no encontrada: " + id
                        )
                );

        model.addAttribute("moto", moto);

        return "detalle-moto";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarMoto(
            @PathVariable Long id) {

        motoService.eliminar(id);

        return "redirect:/motos";
    }
}
12. Controller principal

Archivo:

src/main/java/com/ejemplo/tiendamotos/controller/HomeController.java

Código:

package com.ejemplo.tiendamotos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {

        return "index";

    }
}
13. Página principal

Archivo:

src/main/resources/templates/index.html

Código:

<!DOCTYPE html>
<html lang="es"
      xmlns:th="http://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <title>Tienda de Motos</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand"
           href="/">
            🏍️ Tienda de Motos
        </a>

        <a class="btn btn-outline-light"
           href="/motos">
            Motos
        </a>

    </div>

</nav>


<div class="container mt-5">

    <div class="p-5 mb-4 bg-light rounded-3">

        <div class="container-fluid py-5">

            <h1 class="display-5 fw-bold">
                Sistema de Gestión de Motos
            </h1>

            <p class="col-md-8 fs-5">
                Aplicación web desarrollada con
                Spring Boot, Java, Thymeleaf y Oracle 19c.
            </p>

            <a href="/motos"
               class="btn btn-primary btn-lg">
                Consultar Motos
            </a>

        </div>

    </div>

</div>


</body>

</html>
14. Página listar motos

Archivo:

src/main/resources/templates/motos.html

Código:

<!DOCTYPE html>
<html lang="es"
      xmlns:th="http://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <title>Listado de Motos</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand"
           href="/">
            🏍️ Tienda de Motos
        </a>

        <a href="/"
           class="btn btn-outline-light">
            Inicio
        </a>

    </div>

</nav>


<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-3">

        <h1>
            Listado de Motos
        </h1>

        <a href="/motos/nuevo"
           class="btn btn-success">
            + Nueva Moto
        </a>

    </div>


    <!-- BUSCADOR -->

    <form action="/motos"
          method="get"
          class="row g-2 mb-4">

        <div class="col-md-8">

            <input
                    type="text"
                    name="marca"
                    class="form-control"
                    placeholder="Buscar por marca"
                    th:value="${marcaBusqueda}">

        </div>

        <div class="col-md-2">

            <button
                    type="submit"
                    class="btn btn-primary w-100">
                Buscar
            </button>

        </div>

        <div class="col-md-2">

            <a
                    href="/motos"
                    class="btn btn-secondary w-100">
                Limpiar
            </a>

        </div>

    </form>


    <div class="table-responsive">

        <table class="table table-striped table-hover">

            <thead class="table-dark">

            <tr>

                <th>ID</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Año</th>
                <th>Cilindraje</th>
                <th>Color</th>
                <th>Precio</th>
                <th>Acciones</th>

            </tr>

            </thead>


            <tbody>

            <tr th:each="moto : ${motos}">

                <td th:text="${moto.id}">
                    1
                </td>

                <td th:text="${moto.marca}">
                    Yamaha
                </td>

                <td th:text="${moto.modelo}">
                    MT-03
                </td>

                <td th:text="${moto.anio}">
                    2025
                </td>

                <td>

                    <span th:text="${moto.cilindraje}">
                        321
                    </span>

                    cc

                </td>

                <td th:text="${moto.color}">
                    Negro
                </td>

                <td>

                    $ <span
                        th:text="${#numbers.formatDecimal(
                        moto.precio,
                        0,
                        'COMMA',
                        2,
                        'POINT')}">
                        28,500,000.00
                    </span>

                </td>


                <td>

                    <a
                            th:href="@{/motos/detalle/{id}(id=${moto.id})}"
                            class="btn btn-info btn-sm">
                        Ver
                    </a>


                    <a
                            th:href="@{/motos/editar/{id}(id=${moto.id})}"
                            class="btn btn-warning btn-sm">
                        Editar
                    </a>


                    <a
                            th:href="@{/motos/eliminar/{id}(id=${moto.id})}"
                            class="btn btn-danger btn-sm"
                            onclick="return confirm('¿Desea eliminar esta moto?');">
                        Eliminar
                    </a>

                </td>

            </tr>


            <tr th:if="${#lists.isEmpty(motos)}">

                <td
                        colspan="8"
                        class="text-center">

                    No existen motos registradas.

                </td>

            </tr>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>
15. Crear moto

Archivo:

src/main/resources/templates/crear-moto.html

Código:

<!DOCTYPE html>
<html lang="es"
      xmlns:th="http://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <title>Registrar Moto</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand"
           href="/">
            🏍️ Tienda de Motos
        </a>

    </div>

</nav>


<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-success text-white">

            <h3 class="mb-0">
                Registrar Nueva Moto
            </h3>

        </div>


        <div class="card-body">

            <form
                    th:action="@{/motos/guardar}"
                    th:object="${moto}"
                    method="post">


                <div class="row">


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Marca
                        </label>

                        <input
                                type="text"
                                th:field="*{marca}"
                                class="form-control"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Modelo
                        </label>

                        <input
                                type="text"
                                th:field="*{modelo}"
                                class="form-control"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Año
                        </label>

                        <input
                                type="number"
                                th:field="*{anio}"
                                class="form-control"
                                min="1900"
                                max="2100"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Cilindraje
                        </label>

                        <input
                                type="number"
                                th:field="*{cilindraje}"
                                class="form-control"
                                min="1"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Color
                        </label>

                        <input
                                type="text"
                                th:field="*{color}"
                                class="form-control">

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Precio
                        </label>

                        <input
                                type="number"
                                step="0.01"
                                th:field="*{precio}"
                                class="form-control"
                                min="0">

                    </div>

                </div>


                <div class="mt-3">

                    <button
                            type="submit"
                            class="btn btn-success">
                        Guardar
                    </button>

                    <a
                            href="/motos"
                            class="btn btn-secondary">
                        Cancelar
                    </a>

                </div>


            </form>

        </div>

    </div>

</div>

</body>

</html>
16. Editar moto

Archivo:

src/main/resources/templates/editar-moto.html

Código:

<!DOCTYPE html>
<html lang="es"
      xmlns:th="http://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <title>Editar Moto</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand"
           href="/">
            🏍️ Tienda de Motos
        </a>

    </div>

</nav>


<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-warning">

            <h3 class="mb-0">
                Editar Moto
            </h3>

        </div>


        <div class="card-body">

            <form
                    th:action="@{/motos/guardar}"
                    th:object="${moto}"
                    method="post">


                <input
                        type="hidden"
                        th:field="*{id}">


                <div class="row">


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Marca
                        </label>

                        <input
                                type="text"
                                th:field="*{marca}"
                                class="form-control"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Modelo
                        </label>

                        <input
                                type="text"
                                th:field="*{modelo}"
                                class="form-control"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Año
                        </label>

                        <input
                                type="number"
                                th:field="*{anio}"
                                class="form-control"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Cilindraje
                        </label>

                        <input
                                type="number"
                                th:field="*{cilindraje}"
                                class="form-control"
                                required>

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Color
                        </label>

                        <input
                                type="text"
                                th:field="*{color}"
                                class="form-control">

                    </div>


                    <div class="col-md-6 mb-3">

                        <label class="form-label">
                            Precio
                        </label>

                        <input
                                type="number"
                                step="0.01"
                                th:field="*{precio}"
                                class="form-control">

                    </div>

                </div>


                <button
                        type="submit"
                        class="btn btn-primary">
                    Actualizar
                </button>


                <a
                        href="/motos"
                        class="btn btn-secondary">
                    Cancelar
                </a>

            </form>

        </div>

    </div>

</div>

</body>

</html>
17. Detalle de moto

Archivo:

src/main/resources/templates/detalle-moto.html

Código:

<!DOCTYPE html>
<html lang="es"
      xmlns:th="http://www.thymeleaf.org">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <title>Detalle de Moto</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand"
           href="/">
            🏍️ Tienda de Motos
        </a>

    </div>

</nav>


<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-info">

            <h3>
                Detalle de la Moto
            </h3>

        </div>


        <div class="card-body">

            <dl class="row">


                <dt class="col-sm-4">
                    ID
                </dt>

                <dd class="col-sm-8"
                    th:text="${moto.id}">
                    1
                </dd>


                <dt class="col-sm-4">
                    Marca
                </dt>

                <dd class="col-sm-8"
                    th:text="${moto.marca}">
                    Yamaha
                </dd>


                <dt class="col-sm-4">
                    Modelo
                </dt>

                <dd class="col-sm-8"
                    th:text="${moto.modelo}">
                    MT-03
                </dd>


                <dt class="col-sm-4">
                    Año
                </dt>

                <dd class="col-sm-8"
                    th:text="${moto.anio}">
                    2025
                </dd>


                <dt class="col-sm-4">
                    Cilindraje
                </dt>

                <dd class="col-sm-8">

                    <span th:text="${moto.cilindraje}">
                        321
                    </span>

                    cc

                </dd>


                <dt class="col-sm-4">
                    Color
                </dt>

                <dd class="col-sm-8"
                    th:text="${moto.color}">
                    Negro
                </dd>


                <dt class="col-sm-4">
                    Precio
                </dt>

                <dd class="col-sm-8">

                    $

                    <span
                            th:text="${#numbers.formatDecimal(
                            moto.precio,
                            0,
                            'COMMA',
                            2,
                            'POINT')}">
                        28,500,000.00
                    </span>

                </dd>


            </dl>


            <a
                    href="/motos"
                    class="btn btn-secondary">
                Volver
            </a>


            <a
                    th:href="@{/motos/editar/{id}(id=${moto.id})}"
                    class="btn btn-warning">
                Editar
            </a>


        </div>

    </div>

</div>

</body>

</html>
18. CSS

Archivo:

src/main/resources/static/css/estilos.css

Código:

body {
    background-color: #f5f6f8;
}

.navbar-brand {
    font-weight: bold;
}

.card {
    border-radius: 12px;
}

.btn {
    border-radius: 8px;
}

.table {
    background-color: white;
}
19. Configurar CSS en Thymeleaf

En las páginas HTML se puede agregar:

<link
        rel="stylesheet"
        th:href="@{/css/estilos.css}">

Por ejemplo:

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1">

    <title>Tienda de Motos</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <link
            rel="stylesheet"
            th:href="@{/css/estilos.css}">

</head>
20. Ejecutar la aplicación

Desde IntelliJ IDEA ejecutar:

TiendaMotosApplication

También se puede ejecutar desde Maven:

mvn spring-boot:run
21. Abrir aplicación

En el navegador:

http://localhost:8080

Página principal:

http://localhost:8080/

Listado:

http://localhost:8080/motos

Crear:

http://localhost:8080/motos/nuevo
22. Flujo de la aplicación
                  NAVEGADOR
                      │
                      ▼
              ┌───────────────┐
              │  Controller   │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │    Service    │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │   Repository  │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │   Hibernate   │
              │      JPA      │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │   Oracle 19c  │
              └───────────────┘
23. Operaciones CRUD
Crear
GET /motos/nuevo

Muestra el formulario.

Después:

POST /motos/guardar

Guarda la moto en Oracle.

Listar
GET /motos

Consulta todas las motos.

Buscar
GET /motos?marca=Honda

Consulta motos cuya marca contiene:

Honda
Consultar detalle
GET /motos/detalle/1

Muestra la información de la moto con ID 1.

Editar
GET /motos/editar/1

Carga la información de la moto.

Después:

POST /motos/guardar

Actualiza el registro.

Eliminar
GET /motos/eliminar/1

Elimina la moto.

24. Ejemplo de navegación
Inicio
  │
  ├── Consultar Motos
  │       │
  │       ├── Ver
  │       │
  │       ├── Editar
  │       │
  │       ├── Eliminar
  │       │
  │       └── Nueva Moto
  │
  └── Inicio
25. Verificar Oracle

Desde SQL Developer:

SELECT *
FROM MOTO;

Consultar estructura:

DESC MOTO;

Contar registros:

SELECT COUNT(*)
FROM MOTO;

Buscar por marca:

SELECT *
FROM MOTO
WHERE UPPER(MARCA) LIKE '%HONDA%';
26. Verificar conexión

Si Spring Boot inicia correctamente deberían aparecer mensajes similares a:

Started TiendaMotosApplication

Y Hibernate mostrará consultas SQL como:

select
    m1_0.id,
    m1_0.anio,
    m1_0.cilindraje,
    m1_0.color,
    m1_0.marca,
    m1_0.modelo,
    m1_0.precio
from
    moto m1_0
27. Problemas comunes
Error de conexión Oracle

Verificar:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl

Confirmar que Oracle esté iniciado.

También verificar usuario:

spring.datasource.username=TIENDA_MOTOS

Y contraseña:

spring.datasource.password=123456
28. Oracle XE

Si se utiliza Oracle XE con servicio XEPDB1, utilizar:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1

Por ejemplo:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=TIENDA_MOTOS
spring.datasource.password=123456
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
29. Error de puerto 8080

Si el puerto 8080 está ocupado, modificar:

server.port=8081

Después acceder mediante:

http://localhost:8081
30. Comandos Maven

Limpiar proyecto:

mvn clean

Compilar:

mvn compile

Ejecutar:

mvn spring-boot:run

Empaquetar:

mvn package

Ejecutar JAR:

java -jar target/tienda-motos-0.0.1-SNAPSHOT.jar
31. Pruebas CRUD
Registrar

Ingresar:

http://localhost:8080/motos/nuevo

Datos:

Marca: Yamaha
Modelo: R3
Año: 2025
Cilindraje: 321
Color: Azul
Precio: 32000000

Presionar:

Guardar
Consultar

Ingresar:

http://localhost:8080/motos

Debe aparecer:

Yamaha | R3 | 2025 | 321 | Azul | 32000000
Editar

Presionar:

Editar

Modificar, por ejemplo:

Color: Negro

Presionar:

Actualizar
Eliminar

Presionar:

Eliminar

Confirmar:

¿Desea eliminar esta moto?
32. Arquitectura utilizada

El proyecto utiliza una arquitectura por capas:

┌──────────────────────────────┐
│          VIEW                │
│       Thymeleaf              │
│       Bootstrap              │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│       CONTROLLER             │
│      MotoController          │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         SERVICE              │
│        MotoService           │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│        REPOSITORY            │
│       MotoRepository         │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│           MODEL              │
│            Moto              │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         ORACLE 19c           │
│           MOTO               │
└──────────────────────────────┘
33. Conceptos utilizados

Este proyecto permite practicar:

Spring Boot
Spring MVC
Dependency Injection
Spring Data JPA
Hibernate
Thymeleaf
HTML
CSS
Bootstrap
Maven
Oracle Database
CRUD
Entity
Repository
Service
Controller
HTTP GET
HTTP POST
PathVariable
RequestParam
Model
JPA
JDBC
34. Resumen

La aplicación permite administrar una tienda de motos mediante una interfaz web.

Tecnologías principales:

Java 21
   +
Spring Boot
   +
Spring MVC
   +
Thymeleaf
   +
Bootstrap
   +
Spring Data JPA
   +
Hibernate
   +
Oracle 19c

La aplicación utiliza una arquitectura por capas:

Controller
     ↓
Service
     ↓
Repository
     ↓
JPA / Hibernate
     ↓
Oracle 19c

👨‍💻 Autor

Proyecto académico / práctico desarrollado con:

Java + Spring Boot + IntelliJ IDEA + Oracle 19c

📌 Proyecto
TiendaMotos

Aplicación web CRUD para gestión de motos.
