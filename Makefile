Record = Record.java
Table = Table.java
Files = Files.java
Printer = Printer.java
Database = Database.java


%: %.java
	javac $@.java
	java -ea $@
