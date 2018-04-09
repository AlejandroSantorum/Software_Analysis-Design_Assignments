JAVAC=javac
BUILD_DIR=build
ZIP_NAME=GR2202_AlejandroDavid
DIST_PATH=./*
JFLAGS=-d $(BUILD_DIR) -cp $(BUILD_DIR) -sourcepath $(SRC_DIR)/java/
SRC_DIR=src
sources = $(wildcard $(SRC_DIR)/*.java) \
			$(wildcard $(SRC_DIR)/**/*.java)
			
classes = $(sources:.java=.class)

all: $(classes) doc

%.class : %.java
	$(JAVAC) $(JFLAGS) $<

.PHONY: doc
doc: $(sources)
	mkdir -p doc
	javadoc -d doc -encoding utf8 -docencoding utf8 -charset utf8 -author $(sources)

.PHONY: dist
dist:
	zip -r $(ZIP_NAME).zip $(DIST_PATH)
.PHONY: clean
clean :
	rm -rf $(BUILD_DIR)/*.class doc *.zip