## 💻 Projeto

Esse projeto permite que seja criado um curso e a ele seja atribuído lições contendo link para os vídeos.

## 📀 Como rodar

Antes de iniciar a aplicação é necessário instalar o [Docker](https://www.docker.com/) para que o Docker Compose consiga gerar um container com o banco de dados MySQL, depois basta apenas iniciar a aplicação utilizando no ROOT o comando "mvn spring-boot:run" ou utilizar uma IDE.

## 🧾️ Modelo de entidade relacional

<p>
 <img src="./github/CourseDB.png" ALT="Diagrama de Entidade e Relacionamento">
</p>

## 🚪 EndPoints da aplicação

Cursos(Course):

Metodos Get:
- /api/courses -> Devolve todos os cursos registrados
- /api/courses/{id} -> Fornece um curso específico através de um ID fornecido

Metodo Post:
- /api/courses -> Cria um curso

Metodo Put:
- /api/courses -> Atualiza os detalhes de um curso

Metodo Delete:
- /api/courses/{id} -> Deleta um curso inteiro através de seu ID

## 🔧 Tecnologias


Foi usado nesse projeto :

- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)

Dependências Maven:
- [Hibernate](https://hibernate.org/orm/)
- [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
- [MySQL Driver](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j)
- [Spring Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)
- [Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
- [Docker Compose](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-docker-compose/3.1.1)

Programas necessários:
- [MySQL](https://www.mysql.com/)
- [Docker](https://www.docker.com/)