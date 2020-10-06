#SelenideAllTests
Привет! Спасибо, что выбрали SelenideAllTests - фреймворк, который проверяет базовые функции Jira! :)

## Введение
Данный проект создан с помощью фрейморка Selenide и поддерживает возможность развертывания в Docker с созданием билдов 
в CircleCI.
Проект содержит тесты, которые проверяют кейсы:
1. Логин в Jira;
2. Логин в Jira с ошибочными credentials;
3. Создание тикета;
4. Просмотр только что созданного тикета;
5. Добавление комментария в тикет.

## Перед началом работы
Пожалуйста, убедитесь, что на вашем компьютере установлены:
 1. java 1.8 jdk ( проверка наличия - запуск в консоли команды `javac -version`);
 2. Docker (проверка наличия - запуск в консоли команды `docker --version`);
 3. Git (проверка наличия - запуск в консоли команды `git --version`);
 4. Maven (проверка наличия - запуск в консоли команды `mvn --version`).

 
## Инсталяция проекта - клонирование из из GitHub
* В консоли перейдите в необходимую директорию и выполните команду: `git init`.
* Далее, запустите команду `git clone https://github.com/IrinaYu/SelenideAllTests.git`.


## Запуск тестов 

### 1. Из IntelliJ IDEA
* Откройте проект через File - Open - документ pom.xml из неоходимой директории.
* Пожалуйста, убедитесь, что в pom.xml подтянулись все dependencies и plugins.
```java
    <plugins>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <version>3.1</version>
                   <configuration>
                       <source>1.8</source>
                       <target>1.8</target>
                   </configuration>
               </plugin>
               <!-- Following plugin executes the testng tests -->
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-surefire-plugin</artifactId>
                   <version>2.14.1</version>
                   <configuration>
                       <!-- Suite testng xml file to consider for test execution -->
                       <suiteXmlFiles>
                           <suiteXmlFile>testng.xml</suiteXmlFile>
                       </suiteXmlFiles>
                   </configuration>
               </plugin>
           </plugins>
```
```java
    <dependencies>
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>3.141.59</version>
            </dependency>
            <dependency>
                <groupId>org.testng</groupId>
                <artifactId>testng</artifactId>
                <version>7.3.0</version>
            </dependency>
            <dependency>
                <groupId>io.github.bonigarcia</groupId>
                <artifactId>webdrivermanager</artifactId>
                <version>4.1.0</version>
            </dependency>
            <dependency>
                <groupId>com.codeborne</groupId>
                <artifactId>selenide</artifactId>
                <version>5.13.1</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>com.codeborne</groupId>
                <artifactId>selenide</artifactId>
                <version>5.13.1</version>
                <scope>compile</scope>
            </dependency>
        </dependencies>
```
* Также проверьте, что бы в /src/test/java во всех тестах прогрузились зависимости.
* Правой кнопкой мышки нажмите на testng.xml. Выберите "Run'.../testng.xml'"
* Появление во вкладке 4:Run в IDEA такого результата (Test passed: 12) будет означать, что тесты запустились и успешно прошли.
***
![screenshot of sample](https://i.ibb.co/hRYMdW3/Screenshot-from-2020-10-06-20-21-29.png)

### 2. Из консоли компьютера
* Перейдите из консоли в директорию склонированного ранее проекта.
* Убедитесь, что в директории присутсвует файл POM.xml



REQUIREMENTS
The minimum requirement by Yii is that your Web server supports PHP 5.1.0 or above. Yii has been tested with Apache HTTP server on Windows and Linux operating systems.

Please access the following URL to check if your Web server reaches the requirements by Yii, assuming "YiiPath" is where Yii is installed:

  http://hostname/YiiPath/requirements/index.php
QUICK START
Yii comes with a command line tool called "yiic" that can create a skeleton Yii application for you to start with.

On command line, type in the following commands:

    $ cd YiiPath/framework                (Linux)
    cd YiiPath\framework                  (Windows)

    $ ./yiic webapp ../testdrive          (Linux)
    yiic webapp ..\testdrive              (Windows)
The new Yii application will be created at "YiiPath/testdrive". You can access it with the following URL:

    http://hostname/YiiPath/testdrive/index.php
WHAT'S NEXT
Please visit the project website for tutorials, class reference and join discussions with other Yii users.

The Yii Developer Team http://www.yiiframework.com