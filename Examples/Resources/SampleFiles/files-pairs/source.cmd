CALL :subroutine1 param1 param2 ...
ECHO %result% was returned from subroutine1

CALL :subroutine2 param1 param2 ...
ECHO %result% was returned from subroutine2

GOTO :EOF
REM The above line ends the main invocation of the command processor and so exits the script

:subroutine1 
  SETLOCAL
  commands using parameters %1, %2, .... and setting %retval%
  ENDLOCAL & SET result=%retval% 
  GOTO:EOF
  REM The above line ends the child invocation of the command processor and so returns to just after CALL subroutine1 in the main script

:subroutine2 
  SETLOCAL
  commands using parameters %1, %2, .... and setting %retval%
  ENDLOCAL & SET result=%retval% 
  GOTO:EOF
  REM The above line ends the child invocation of the command processor and so returns to just after CALL subroutine2 in the main script