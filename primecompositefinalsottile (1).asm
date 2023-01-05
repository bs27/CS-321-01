;set data memory to zero
MOV SP,#0x3F ;place stack at location 0x40
MOV 0x60, #0x20 ; set counter
MOV 0x20, #0x08; set a value in memory address 0x20
MOV 0x70, #0x20 ; unaltered starting address
main:
MOv R0, 0x60
MOV ACC,@r0    ;value at counter to the accumulator 
jz output ;check if the list has reached the end
MOV PSW, #0x18 ; set the PSW to anything
PUSH 0x60 ; push counter onto the stack
PUSH PSW ; this way we can restore the PSW upon return
ACALL subr ; call the subroutine which pushes return 
                 ; address onto the stack (LOWB HIGHB)
      ;Pop and return parmeter
Mov 0x10, R1
POP PSW
MOV R0, B
sjmp end
       
       
      subr:
      ;ADD A, R0
      ; build up the stack frame
POP 0x71 ; pop the return address HIGHB 
POP 0x72 ; pop the return address LOWB 
POP 0x73 ; pop the PSW
POP 0x74 ; pop the parameter
MOV PSW, #0x00 ; set the PSW to anything
MOV R0, 0x74 ; use the parameter ;input
Mov ACC, @R0
subb a, #0x01
jz prime
Mov ACC, @R0
Subb a,#0x02
jz prime
Mov ACC, @R0
MOV B, #0x02
DIV AB
MOV R1, ACC
AJMP Welcome
      loop:
INC R1
      Welcome:
MOV ACC, @R0
MOV B, R1 ;The idea Move R1 to B Divide ACC by B Check if B is Zero Decrement R1
DIV AB
Mov 0x11, ACC
MOV ACC, B; Mov Remainder
JZ Composite
DEC R1
DJNZ R1, loop
MOV B,#0x01 ;output
AJMP fin
      Composite:
MOV B,#0x00;output
      fin:
      ; prepare for return by restoring the stack frame
PUSH 0x73 ; restore the PSW
PUSH 0x72 ; push the return address LOWB
PUSH 0x71 ; push the return address HIGHB
RET ; return
       
      end:
MOV B, ACC
JZ compositehell;alter list
prime:
INC 0x60;its a prime increment counter
sjmp main
compositehell:
MOV R1, 0x60
loopdeloop:
Inc R1
Mov ACC, @R1
Jnz loopdeloop
Mov @R1, 0x10
Mov R0, 0x60
Mov @R0, 0x11
sjmp main
output: