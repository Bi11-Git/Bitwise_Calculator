
# Bitwise Calculator
The bitwise operators are similar to the logical operators, except that they work on a smaller scale -- binary representations of data.
Bitwise operators are used to change individual bits in an operand. A single byte of computer memory-when viewed as 8 bits-can signify 
the true/false status of 8 flags because each bit can be used as a boolean variable that can hold one of two values: true or false. A 
flag variable is typically used to indicate the status of something. For instance, computer files can be marked as read-only. So you 
might have a $fReadOnly variable whose job would be to hold the read-only status of a file. This variable is called a flag variable 
because when $fReadOnly has a true value, it's equivalent to a football referee throwing a flag. The variable says, "Whoa! Don't modify 
this file."

The following operators are available:

Convert Number -- Print the number without any operation but you can change the data type of input or output.  
The following data types are available : Binary, Decimal and Hexadecimal  
Number AND Mask -- The AND operator compares two bits and generates a result of 1 if both bits are 1; otherwise, it returns 0.   
Number OR Mask -- The OR operator compares two bits and generates a result of 1 if the bits are complementary; otherwise, it returns 0. 
Number XOR Mask -- The EXCLUSIVE-OR operator compares two bits and generates a result of 1 if either or both bits are 1; otherwise, it
returns 0.  
NOT Number -- The COMPLEMENT operator is used to invert all of the bits of the operand.  
Number Shift Right Mask -- The SHIFT RIGHT operator moves the bits to the right, discards the far right bit, and assigns the leftmost  
bit a value of 0. Each move to the right effectively divides op1 in half.  
Number Shift left Mask -- The SHIFT LEFT operator moves the bits to the left, discards the far left bit, and assigns the rightmost bit  
a value of 0. Each move to the left effectively multiplies op1 by 2.  
Note Both operands associated with the bitwise operator must be integers.  

# Author

Βασίλης Χύσκαϊ

## installations

Install Java

```
sudo apt-get install openjdk-11-jdk
```

Install maven

```
sudo apt install maven
```

## Usage

Compile using 

```
mvn compile
```

Create a jar using 

```
mvn package
```

Run main using 

```
java -cp target/Bitwise_Calculator-1.0-SNAPSHOT.jar Calculator
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

