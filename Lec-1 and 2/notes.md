## 1. Java Portability and Execution Model

### Why Was Portability an Issue?

Learnt about why portability was an issue and how Java fixed it.

Other languages like C/C++ are generally platform-dependent (OS + Processor/Architecture) because they are compiled into platform-specific machine code. Because of this, the same source code may need to be compiled again for different platforms. Hence, they are not as portable as Java.

### How Did Java Solve This Problem?

Java fixed this by generating intermediate code, also known as **bytecode**.

This bytecode is platform-independent and portable.

Now, to run this bytecode on any machine, that machine needs a **JVM (Java Virtual Machine)** suitable for that platform.

The JVM itself is platform-dependent because it is designed for a particular OS + Processor/Architecture.

### How Does the JVM Execute Bytecode?

The JVM executes bytecode using an **Interpreter** and a **JIT (Just-In-Time) Compiler**.

* The **Interpreter** executes bytecode directly.
* The **JIT Compiler** converts frequently executed ("hot") bytecode into platform-specific machine code so that it can be executed faster.

Basically, when Java code starts executing, the JVM can use the Interpreter to execute bytecode.

While the program is running, the JVM monitors which parts of the code are executed frequently.

If some code is executed frequently, the JIT Compiler compiles that bytecode into native machine code.

The next time that code is executed, the already compiled machine code can be used instead of repeatedly interpreting the same bytecode.

Therefore, Java uses a **hybrid execution model** involving both interpretation and JIT compilation.

This provides a balance between quick startup and good runtime performance.

### Other Features of Java

Java provides features such as:

* Portability
* Simplicity
* Security

**Simplicity:** Simplicity is achieved by hiding complex implementation details through concepts such as abstraction, automatic memory management, etc.

**Security:** Java also provides security mechanisms through the JVM that control how Java applications interact with system resources and other restricted operations.

Historically, Java used a security mechanism known as the **Sandbox Model**, especially for running untrusted code such as Java applets.

---

## 2. JVM, JRE and JDK

### JVM (Java Virtual Machine)

JVM (Java Virtual Machine) is responsible for executing Java bytecode.

It uses an Interpreter to execute bytecode and a JIT (Just-In-Time) Compiler to compile frequently executed bytecode into platform-specific machine code.

The JVM is platform-dependent because a separate JVM implementation is required for different platforms.

This is what allows the same platform-independent Java bytecode to run on different platforms.

The JVM also manages memory and provides features such as **Garbage Collection**, which automatically removes objects that are no longer reachable or needed by the application.

### JRE (Java Runtime Environment)

Java Runtime Environment (JRE) consists of the JVM along with Java Runtime Libraries required to run Java applications.

These libraries provide functionality such as input/output, networking, collections, etc., during execution.

So, JRE basically provides everything required to **RUN** a Java application.

### JDK (Java Development Kit)

Java Development Kit (JDK) consists of the Java development tools along with the Java runtime components required to develop, compile and run Java applications.

It contains tools such as:

* `javac` — Java Compiler
* `java` — Java application launcher
* `javadoc` — Documentation generator
* `jar` — Tool for creating and managing JAR files
* Other development tools

To convert Java source code into bytecode, we use `javac` (Java Compiler), which is provided by the JDK.

So, JDK basically provides everything required to **DEVELOP, COMPILE and RUN** a Java application.

---

## 3. Java SE, Java EE and Java ME

### Java SE (Java Standard Edition)

Java SE is the standard/core Java platform.

It provides the fundamental Java features, such as:

* The Java language
* OOP concepts
* Classes
* Collections
* Input/Output (I/O)
* Networking
* Multithreading

### Java EE (Java Enterprise Edition)

Java EE, now known as **Jakarta EE**, provides additional APIs and specifications for building enterprise-level applications such as web applications, REST services, and large-scale backend systems.

### Java ME (Java Micro Edition)

Java ME was designed for resource-constrained devices such as older mobile phones, embedded devices, and other small devices.

It is much less prominent today, while Android became the dominant platform for mobile application development.

---

## 4. Installing the JDK

Installed **JDK 25** from the Oracle website.

---

## 5. Practical Demo: Converting Java Source Code to Bytecode and Running It Using the JVM

### Step 1: Create a Java Source File

Created a file named `Demo.java` and wrote a simple Hello World program.

### Step 2: Compile the Java Source Code

To convert Java source code into bytecode, `javac` was used with the following command:

```bash
javac Demo.java
```

A file named `Demo.class` was created.

This `.class` file contains platform-independent Java bytecode.

### Step 3: Run the Compiled Java Program

To run the bytecode, we used the `java` command:

```bash
java Demo
```

The JVM starts the execution of the bytecode using the Interpreter and may use the JIT Compiler for frequently executed code.

### Step 4: Observe the Output

The program prints:

```text
Hello World!!
```

---

## Summary

* **Java Source Code (`.java`)** is compiled into platform-independent bytecode.
* **`javac`** compiles Java source code into bytecode.
* **Bytecode (`.class`)** can run on any compatible platform with a suitable JVM.
* **JVM** executes bytecode using interpretation and, in typical modern implementations, JIT compilation.
* **JRE** conceptually provides the JVM and runtime libraries required to run Java applications.
* **JDK** provides the tools and runtime components required to develop, compile and run Java applications.
* **Java SE** provides the core Java platform.
* **Jakarta EE** provides enterprise application specifications and APIs.
* **Java ME** targets resource-constrained devices.
