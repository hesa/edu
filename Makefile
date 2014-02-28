DATE=$(shell date '+%Y-%m-%d-%H%M%S')
EDU_JAR=sandklef-edu-$(DATE).jar
EDU_PKG=com/sandklef/edu/
EDU_JAVADOC=sandklef-edu-javadoc-$(DATE).zip


CONSOLE_MENU_SOURCES=$(EDU_PKG)/ConsoleMenu/MenuItem.java $(EDU_PKG)/ConsoleMenu/ConsoleMenu.java
CONSOLE_MENU_CLASSES=$(CONSOLE_MENU_SOURCES:.java=.class)

MOVEME_MENU_SOURCES=$(EDU_PKG)/MoveMe/ControlPanel.java \
 $(EDU_PKG)/MoveMe/MoveMeControl.java \
 $(EDU_PKG)/MoveMe/Field.java \
 $(EDU_PKG)/MoveMe/MoveMe.java \
 $(EDU_PKG)/MoveMe/FindPath.java \
 $(EDU_PKG)/MoveMe/Box.java \
 $(EDU_PKG)/MoveMe/FindControl.java

MOVEME_MENU_CLASSES=$(MOVEME_MENU_SOURCES:.java=.class)

KODER_SOURCES=$(EDU_PKG)/koder/CodeTab.java $(EDU_PKG)/koder/Koder.java $(EDU_PKG)/koder/Builder.java
KODER_CLASSES=$(KODER_SOURCES:.java=.class)


ALL_SOURCES=$(CONSOLE_MENU_SOURCES) $(MOVEME_MENU_SOURCES) $(KODER_SOURCES)
ALL_CLASSES=$(CONSOLE_MENU_CLASSES) $(MOVEME_MENU_CLASSES) $(KODER_CLASSES)

all: $(ALL_CLASSES)

dist: $(EDU_JAR) $(EDU_JAVADOC)

javadoc:$(EDU_JAVADOC)

$(ALL_CLASSES): $(ALL_SOURCES)
	javac $(ALL_SOURCES)

$(EDU_JAR): $(ALL_CLASSES)
	jar cf $(EDU_JAR) $(EDU_PKG)

$(EDU_JAVADOC):
	javadoc com.sandklef.edu.ConsoleMenu -d javadoc/
	cd javadoc  && zip -r $(EDU_JAVADOC) . && mv $(EDU_JAVADOC)  ../



clean:
	rm -fr $(EDU_JAR) $(EDU_JAVADOC) $(ALL_CLASSES) javadoc/ *.jar *.zip

