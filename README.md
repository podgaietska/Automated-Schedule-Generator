# Wildlife Rescue Centre

![](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![](https://img.shields.io/badge/JUnit5-25A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white) ![](https://img.shields.io/badge/MySQL-4479A1.svg?style=for-the-badge&logo=MySQL&logoColor=white)

### Colaborators

- Nicole Izdraila (30147366)
- Mariia Podgaietska
- Afrah Mohammad
- Axel Sanchez (30145429)

### How to run the program

- Compile program

```bash
javac -cp "lib/mysql-connector-java-8.0.23.jar" -d bin src/edu/ucalgary/oop/*.java
```

- Run program in MacOS

```bash
java -cp "lib/mysql-connector-java-8.0.23.jar:bin" edu.ucalgary.oop.Main
```

- Run program in Windows

```bash
java -cp "lib/mysql-connector-java-8.0.23.jar;bin" edu.ucalgary.oop.Main
```

### How to run the tests

- Compile tests

```bash
javac -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" -d bin src/edu/ucalgary/oop/*.java test/edu/ucalgary/oop/*.java
```

- Run tests in MacOS

```bash
java -cp "bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore edu.ucalgary.oop.AnimalTest edu.ucalgary.oop.CleaningCageTest edu.ucalgary.oop.FeedingScheduleTest edu.ucalgary.oop.TaskTest edu.ucalgary.oop.TreatmentTest
```
