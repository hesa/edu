DATE=$(shell date '+%Y-%m-%d-%H%M%S')
EDU_JAR=sandklef-edu-$(DATE).jar
EDU_PKG=com/sandklef/edu/
EDU_JAVADOC=sandklef-edu-javadoc-$(DATE).zip
CONSOLE_MENU_SOURCES=$(EDU_PKG)/ConsoleMenu/MenuItem.java $(EDU_PKG)/ConsoleMenu/ConsoleMenu.java
CONSOLE_MENU_CLASSES=$(CONSOLE_MENU_SOURCES:.java=.class)

ALL_SOURCES=$(CONSOLE_MENU_SOURCES)
ALL_CLASSES=$(CONSOLE_MENU_CLASSES)

all: $(EDU_JAR) $(EDU_JAVADOC)

javadoc:$(EDU_JAVADOC_ZIP)

$(ALL_CLASSES): $(ALL_SOURCES)
	javac $(ALL_SOURCES)

$(EDU_JAR): $(ALL_CLASSES)
	jar cf $(EDU_JAR) $(EDU_PKG)

$(EDU_JAVADOC):
	javadoc com.sandklef.edu.ConsoleMenu -d javadoc/
	cd javadoc  && zip -r $(EDU_JAVADOC) . && mv $(EDU_JAVADOC)  ../



clean:
	rm -fr $(EDU_JAR) $(EDU_JAVADOC) $(ALL_CLASSES) javadoc/ *.jar *.zip

