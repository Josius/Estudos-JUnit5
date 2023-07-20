# Aula 01 - Configurações

## Criar projeto maven pela IDE ou usando terminal
O comando abaixo criará um **maven-archetype-quickstart**:
```properties
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```
## Apagar diretórios
Apagar os diretórios e seus conteúdos abaixo dos caminhos em **src/main/java** e em **src/test/java**

## Configurar pom.xml
### Apagar tag name
No pom.xml apagar a tag **name** 
```xml
<name>junit5-tuto</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

```

### Trocar a dependência 
Ainda no pom.xml, trocar a dependência:
```xml
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.11</version>
	<scope>test</scope>
</dependency>
```
pela mais lts mais atual (no caso, usei a JUnit Jupiter (Aggregator) » 5.9.3):

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>
```

### No plugin maven-compiler-plugin
Estará assim:
```xml
<plugin>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.8.0</version>
</plugin>
```
Deixar assim para especificar o versão do jdk (no meu caso, o JDK 17):
```xml
<plugin>
	<artifactId>maven-compiler-plugin</artifactId>
		<configuration>
			<source>17</source>
			<target>17</target>
		</configuration>
	<version>3.8.0</version>
</plugin>
```
E por fim, **rebuild** o projeto com o novo pom.xml