MOV R0, #0x2F ;input
Mov ACC, R0
MOV B, #0x02
DIV AB
MOV R1, ACC
AJMP Welcome
loop:
INC R1
Welcome:
MOV ACC, R0
MOV B, R1 ;The idea Move R1 to B Divide ACC by B Check if B is Zero Decrement R1
DIV AB
MOV ACC, B; Mov Remainder
JZ Composite
DEC R1
DJNZ R1, loop
MOV R0,#0x01 ;output
AJMP fin
Composite:
MOV R0,#0x00;output
fin:
END






