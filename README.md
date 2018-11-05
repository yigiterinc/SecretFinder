# SecretFinder
Implemented for CS 222-Programming Studio course in my Senior year. A console game about making guesses. Learned about Test Driven Development, List processing and a bit of string manipulation. 


For more information please refer to the original description in http://aktemur.github.io/cs222/assignment_numbergame.html

Problem Definition
I’m going to play a game with you. In this game, you pick a number hidden from me. Without loss of generality, suppose we agree that the number will have 4 digits. Another requirement is that the number has distinct (i.e. unique) digits. Suppose you pick 4097. I make a guess about the number. Suppose my guess is 6790. You will report back the similarity between your secret number and my guess. The similarity of two numbers is the count of the digits that occur in both numbers in different positions, and the count of digits that occur in the same positions. Consider 4097 and 6790. There is one digit (9) that occurs in the same position in both numbers; and there are two digits (0 and 7) that occur in different positions in both numbers. This similarity is reported as 1+ 2-. If my guess were 1256, there would be no common digits, making the similarity 0+ 0-. If my guess were 4097, the similarity would be 4+ 0-, meaning the secret number has been found.

