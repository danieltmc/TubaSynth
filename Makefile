all: FORCE
	javac cp comm.jar *.java

FORCE:

run: FORCE
	java -cp comm.jar:. Synth

clean:
	rm *.class
