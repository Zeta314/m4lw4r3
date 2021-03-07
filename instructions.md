# Instructions

This a list of all the available m4lw4r3 instructions.

## Comparison

| Instruction 	| Argument 1 	| Argument 2 	|       Example      	|
|:-----------:	|:----------:	|:----------:	|:------------------:	|
|   COMPAREC  	|  REGISTER  	|  CONSTANT  	| COMPAREC R0 0x1234 	|
|   COMPARE   	|  REGISTER  	|  REGISTER  	|    COMPARE R0 R1   	|

## Data manipulation

| Instruction 	| Argument 1 	| Argument 2 	|         Example        	|
|:-----------:	|:----------:	|:----------:	|:----------------------:	|
|     COPY    	|  REGISTER  	|  REGISTER  	|       COPY R0 R1       	|
|    LOADBC   	|   ADDRESS  	|  REGISTER  	|     LOADBC 0x01 R0     	|
|    LOADB    	|  REGISTER  	|  REGISTER  	|       LOADB R0 R1      	|
|    LOADIC   	|   ADDRESS  	|  REGISTER  	|    LOADIC 0x1234 R0    	|
|    LOADI    	|  REGISTER  	|  REGISTER  	|       LOADI R0 R1      	|
|     SETR    	|  REGISTER  	|  CONSTANT  	|     SETR R0 0x1234     	|
|     SWAP    	|  REGISTER  	|  REGISTER  	|       SWAP R0 R1       	|
|   WRITEBC   	|  REGISTER  	|   ADDRESS  	|     WRITEBC R0 0x01    	|
|    WRITEB   	|  REGISTER  	|  REGISTER  	|      WRITEB R0 R1      	|
|   WRITEIC   	|  REGISTER  	|   ADDRESS  	|     WRITEIC R0 0x01    	|
|    WRITEI   	|  REGISTER  	|  REGISTER  	|      WRITEI R0 R1      	|
|   WRITESC   	|  REGISTER  	|   STRING   	| WRITESC R0 "TEST 1234" 	|

## User interface IO
| Instruction 	| Argument 1 	| Argument 2 	|   Example  	|
|:-----------:	|:----------:	|:----------:	|:----------:	|
|    READC    	|  REGISTER  	|            	|  READC R0  	|
|    READCM   	|  REGISTER  	|            	|  READCM R0 	|
|    WRITEC   	|  REGISTER  	|            	|  WRITEC R0 	|
|   WRITECM   	|  REGISTER  	|            	| WRITECM R0 	|
|    WRITES   	|  REGISTER  	|            	|  WRITES R0 	|

## Jumps
| Instruction 	| Argument 1 	| Argument 2 	|   Example   	|
|:-----------:	|:----------:	|:----------:	|:-----------:	|
|    FOLLOW   	|  REGISTER  	|            	|  FOLLOW R0  	|
|    JUMPE    	|   ADDRESS  	|            	|  JUMPE 0x04 	|
|    JUMPGE   	|   ADDRESS  	|            	| JUMPGE 0x04 	|
|    JUMPG    	|   ADDRESS  	|            	|  JUMPG 0x04 	|
|     JUMP    	|   ADDRESS  	|            	|  JUMP 0x04  	|
|    JUMPNE   	|   ADDRESS  	|            	| JUMPNE 0x04 	|
|    JUMPNZ   	|   ADDRESS  	|            	| JUMPNZ 0x04 	|
|    JUMPSE   	|   ADDRESS  	|            	| JUMPSE 0x04 	|
|    JUMPS    	|   ADDRESS  	|            	|  JUMPS 0x04 	|
|    JUMPZ    	|   ADDRESS  	|            	|  JUMPZ 0x04 	|

## Labels and functions
| Instruction 	| Argument 1 	| Argument 2 	|       Example      	|
|:-----------:	|:----------:	|:----------:	|:------------------:	|
|     CALL    	|    LABEL   	|            	|  CALL SCRIPT_START 	|
|    LABEL    	|   STRING   	|            	|     LABEL loop     	|
|    REACHE    	|   ADDRESS  	|            	|  REACHE 0x04 	|
|    REACHGE   	|   ADDRESS  	|            	| REACHGE 0x04 	|
|    REACHG    	|   ADDRESS  	|            	|  REACHG 0x04 	|
|     REACH    	|   ADDRESS  	|            	|  REACH 0x04  	|
|    REACHNE   	|   ADDRESS  	|            	| REACHNE 0x04 	|
|    REACHNZ   	|   ADDRESS  	|            	| REACHNZ 0x04 	|
|    REACHSE   	|   ADDRESS  	|            	| REACHSE 0x04 	|
|    REACHS    	|   ADDRESS  	|            	|  REACHS 0x04 	|
|    REACHZ    	|   ADDRESS  	|            	|  REACHZ 0x04 	|
|    RETURN   	|            	|            	|       RETURN  |

## Binary math
| Instruction 	| Argument 1 	| Argument 2 	|    Example   	|
|:-----------:	|:----------:	|:----------:	|:------------:	|
|     ANDC    	|  REGISTER  	|  CONSTANT  	| ANDC R0 0xFF 	|
|     AND     	|  REGISTER  	|  REGISTER  	|   AND R0 R1  	|
|     NOT     	|  REGISTER  	|            	|    NOT R0    	|
|     ORC     	|  REGISTER  	|  CONSTANT  	|  ORC R0 0x9a 	|
|      OR     	|  REGISTER  	|  REGISTER  	|   OR R0 R1   	|
|     XORC    	|  REGISTER  	|  CONSTANT  	| XORC R0 0x12 	|
|     XOR     	|  REGISTER  	|  REGISTER  	|   XOR R0 R1  	|

## Math 
| Instruction 	| Argument 1 	| Argument 2 	|     Example     	|
|:-----------:	|:----------:	|:----------:	|:---------------:	|
|     ADDC    	|  REGISTER  	|  CONSTANT  	|  ADDC R0 0x1234 	|
|     ADD     	|  REGISTER  	|  REGISTER  	|    ADD R0 R1    	|
|     DIVC    	|  REGISTER  	|  CONSTANT  	|  DIVC R0 0x1234 	|
|     DIV     	|  REGISTER  	|  REGISTER  	|    DIV R0 R1    	|
|    MULTC    	|  REGISTER  	|  CONSTANT  	| MULTC R0 0x1234 	|
|     MULT    	|  REGISTER  	|  REGISTER  	|    MULT R0 R1   	|
|     SUB     	|  REGISTER  	|  REGISTER  	|    SUB R0 R1    	|
|     SUBC    	|  REGISTER  	|  CONSTANT  	|  SUBC R0 0x1234 	|

## Stack utils
| Instruction 	| Argument 1 	| Argument 2 	|     Example     	|
|:-----------:	|:----------:	|:----------:	|:---------------:	|
|     POP     	|  REGISTER  	|            	|      POP R0     	|
|    PUSHC    	|  CONSTANT  	|            	| PUSH 0x12345678 	|
|     PUSH    	|  REGISTER  	|            	|     PUSH R0     	|

## Generic utils
| Instruction 	| Argument 1 	| Argument 2 	| Example 	|
|:-----------:	|:----------:	|:----------:	|:-------:	|
|     NULL    	|            	|            	|   NULL  	|
|     HALT    	|            	|            	|   HALT  	|
