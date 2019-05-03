# cipher
This is my first personal project. It takes in a key and a message and outputs a ciphertext using a simple shift cipher. It allows the user to choose whether they want to encipher a message or decrypt it.

When the user inputs a key, for example: "apple," the program keeps only the singular occurence of a letter (for example, "apple" would become "aple") and then reassigns the alphabet based on that fixed key. in this case, the "a" in "aple" would be mapped to "a", the "p" would be mapped to "b", the "l" would be mapped to "c", and so on. however, this program only works with letters.

An example of how it works follows:
The user chooses their message to be "i love coding"
Their key is "iloveprogramming"
The program outputs the ciphertext of s beva oegsdi

I wrote this during the summer of 2017 as a simple side project to occupy my time. It is not perfectly secure and should not be used for passwords, etc but was simply a novelty project to occupy my time.

To run:
- download folder
- with terminal, cd into the directory
- type "javac Cipher.java" ; this will create the Cipher.class file, which is needed to run the program.
- type "java Cipher"
- follow the instructions in the program.
