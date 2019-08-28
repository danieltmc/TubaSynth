all: FORCE
	javac cp comm.java *.java

FORCE:

run: FORCE
	java Synth

clean:
	rm *.class
