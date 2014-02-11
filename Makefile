EDU_JAR=sandklef-edu.jar
EDU_PKG=com/sandklef/edu/

CONSOLE_MENU_SOURCES=$(EDU_PKG)/ConsoleMenu/MenuItem.java $(EDU_PKG)/ConsoleMenu/ConsoleMenu.java
CONSOLE_MENU_CLASSES=$(CONSOLE_MENU_SOURCES:.java=.class)

ALL_SOURCES=$(CONSOLE_MENU_SOURCES)
ALL_CLASSES=$(CONSOLE_MENU_CLASSES)

all: $(EDU_JAR)

$(ALL_CLASSES): $(ALL_SOURCES)
	javac $(ALL_SOURCES)

$(EDU_JAR): $(ALL_CLASSES)
	jar cf $(EDU_JAR) $(ALL_CLASSES)

clean:
	rm -fr $(ALL_JARS) $(ALL_CLASSES) 

