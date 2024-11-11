; A macro with two parameters
; Implements the write system call
   %macro write_string 2 
      mov   eax, 4
      mov   ebx, 1
      mov   ecx, %1
      mov   edx, %2
      int   80h
   %endmacro
 
section	.text
   global _start            ;must be declared for using gcc
	
_start:                     ;tell linker entry point
   write_string msg1, len1               
   write_string msg2, len2    
   write_string msg3, len3  
	
   mov eax,1                ;system call number (sys_exit)
   int 0x80                 ;call kernel

section	.data
msg1 db	'Hello, programmers!',0xA,0xD 	
len1 equ $ - msg1			

msg2 db 'Welcome to the world of,', 0xA,0xD 
len2 equ $- msg2 

msg3 db 'Linux assembly programming! '
len3 equ $- msg3

section	.text
   global _start         ;must be declared for using gcc
	
_start:	                 ;tell linker entry point

   mov	eax, 45		 ;sys_brk
   xor	ebx, ebx
   int	80h

   add	eax, 16384	 ;number of bytes to be reserved
   mov	ebx, eax
   mov	eax, 45		 ;sys_brk
   int	80h
	
   cmp	eax, 0
   jl	exit	;exit, if error 
   mov	edi, eax	 ;EDI = highest available address
   sub	edi, 4		 ;pointing to the last DWORD  
   mov	ecx, 4096	 ;number of DWORDs allocated
   xor	eax, eax	 ;clear eax
   std			 ;backward
   rep	stosd            ;repete for entire allocated area
   cld			 ;put DF flag to normal state
	
   mov	eax, 4
   mov	ebx, 1
   mov	ecx, msg
   mov	edx, len
   int	80h		 ;print a message

exit:
   mov	eax, 1
   xor	ebx, ebx
   int	80h
	
section	.data
msg    	db	"Allocated 16 kb of memory!", 10
len     equ	$ - msg