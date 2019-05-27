all: FORCE
	javac *.java

FORCE:

run: FORCE
	java Synth

clean:
	rm *.class
