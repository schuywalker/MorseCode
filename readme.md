TL;DR
To see program in action, run these commands:\
javac *.java\
java Main test test/test1.txt\
java Main test test/test2.txt\
java Main test test/test3.txt\
java Main test test/test4.txt\
java Main decode test/morse1.txt\
java Main decode test/morse2.txt\

MorseCode.java:

This program encodes and decodes morse code.
To compile this program, navigate to the directory that contains Main.java and compile the files by running "javac *.java".
Next, you can either run the program either by passing in a file path to be encoded/ decoded, or by using "interactive mode".

FILE PATH MODE:\
The first command line argument determines the program mode, and the second argument is the file path.\
These are some sample commands you can run if you are passing a file path as the input:

java Main encode test/test1.txt\
java Main decode test/morse1.txt\
java Main test test/test1.txt

INTERACTIVE MODE:\
To run the program in interactive mode, execute "java Main" without any additional arguments. You will then be presented with instructions to choose encoding or decoding mode, and then subsequently prompted to enter an input.

TECHNICAL DETAILS:\
Non-Alphanumeric inputs do not have a morse code mapping in this project, so they are handled by inserting "%" in place of the illegitimate input character. This allows the program to still operate in the case of bad inputs.

Liberties were also taken in terms of how to deal with whitespace and new line characters. My aim was to always preserve the integrity of the message, even if whitespace in the decoded message is not identical to whitespace in the input to the encoder.

