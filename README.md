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

# Aula 02 - Escrevendo Testes
1. Criar um pacote para testes em **src/test/java**
2. Criar uma classe de testes
3. Criar métodos de teste com a JUnit5 annotation **@Test**

## Annotations
### @Test
A mais básica de todas, oriunda de **org.junit.jupiter.api.Test**

### @DisplayName(String)
Quando o nome do método não sugestiona suficientemente o que precisamos saber sobre o que ele faz, podemos escolher trocar a aparência do nome do método na saída dos resultados do método, no console, para algo que seja mais entendível. Na saída retornará a string passada na annotation

### Composição de uma assinatura do método:
**\<modificador de acesso>** **\<tipo de retorno>** **\<nome do método>** **(\<parâmetros>)**

- modificador de acesso: em testes, não é necessário
- tipo de retorno: especificamos como void
- nome do método: nomeamos com algo que demonstre o que o método faz
- parâmetros: o que o método irá receber, pode ser até vazio

# Aula 03 - Ciclo de Vida dos Métodos
## Métodos de Configuração - Before Annotation
Usados com a finalidade de que um método seja executado antes de qualquer outra coisa ou mesmo dos outros métodos. Podemos usar uma configuração que seja executada antes de tudo ou que precise ser executada antes de cada método de teste.

### @BeforeAll
Ao método é especificado que o código dentro dele seja executado antes de qualquer coisa nesta classe de teste, antes de qualquer método de teste seja executado. Não usar private no modificador de acesso do método.

### @BeforeEach
Nós vamos assumir que também precisamo de algum tipo de configuração que execute toda vez antes que um método de teste inicie sua execução

## Métodos de Limpeza - After Annotation
Usados em conjunto com os métodos de configuração, com função de finalização, eles fecham o que foi configurado anteriormente ou após a execução dos métodos.

### @AfterAll
Usado para finalizar todas as configurações após todas as execuções de todos métodos de teste.

### @AfterEach
Usado para finalizar após cada execução de cada método de teste.

### @TestInstance(Lifecycle.PER_CLASS)
Usado para que não tenhamos que marcar todos os métodos de configuração e limpeza como estáticos