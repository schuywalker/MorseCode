MorseCode.java:

To compile this program, navigate to the directory that contains Main.java and compile the files by running "javac *.java".
Next, you can either run the program either by passing in a file path to be encoded/ decoded, or by using "interactive mode".

The first argument determines the program mode, and the second argument is the file path.\
These are some sample commands you can run if you are passing a file path as the input:

java Main encode test/test1.txt\
java Main decode test/morse1.txt\
java Main test test/test1.txt

To run the program in interactive mode, execute "java Main" without any additional arguments. You will then be prompted to choose encoding or decoding mode, and then subsequently prompted to enter an input.

Non-Alphanumeric inputs do not have a morse code mapping in this project, so they are handled by inserting "%" in place of the illegitimate input character. This allows the program to still operate in the case of bad inputs.

Liberties were also taken in terms of how to deal with whitespace and new line characters. Extra whitespace will not always be preserved, but the integrity of message should be preserved.![Screenshot 2024-02-22 at 11.17.42 AM.png](..%2F..%2F..%2F..%2Fvar%2Ffolders%2F6l%2Fmsrt_w4j3fsfctqgwkc55fvm0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_tJHCZb%2FScreenshot%202024-02-22%20at%2011.17.42%20AM.png)