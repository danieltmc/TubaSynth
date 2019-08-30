all: FORCE
	javac cp jSerialComm-2.5.1.jar *.java

FORCE:

run: FORCE
	java -cp jSerialComm-2.5.1.jar:. Synth

clean:
	rm *.class
