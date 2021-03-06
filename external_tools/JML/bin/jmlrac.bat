@ECHO OFF
rem  @(#)$Date: 2004/01/27 11:58:27 $
rem
rem jmlrac --  script for running java programs compiled with
rem            the JML runtime assertion checker compiler
rem
rem SYNOPSIS: set CLASSPATH and run java

call jmlenv.bat

set JMLMODELSJAR=%JMLDIR%\bin\jmlmodels.jar

if not "%1"=="--nocheckmodels" goto endnocheckmodels
:nocheckmodels
shift
set JMLMODELSJAR=c:\JML\bin\jmlmodelsnonrac.jar
goto processoptions
:endnocheckmodels

rem save the old CLASSPATH
set OLDCLASSPATH=%CLASSPATH%
set CLASSPATH=%CLASSPATH%;%JUNITDIR%\junit.jar;%JMLDIR%\bin\jmljunitruntime.jar;%JMLMODELSJAR%

set CMDLINE_ARGS=%1
:getargs
shift
if "%1"=="" goto endgetargs
set CMDLINE_ARGS=%CMDLINE_ARGS% %1
goto getargs
:endgetargs

rem You can use `java' or `jre -cp %CLASSPATH%' below
rem but these have to be in your PATH

java -Xbootclasspath/a:%JMLDIR%\bin\jmlruntime.jar %CMDLINE_ARGS%

rem restore the old CLASSPATH
set CLASSPATH=%OLDCLASSPATH%
set CMDLINE_ARGS=
set JMLMODELSJAR=
set OLDCLASSPATH=

rem Copyright (C) 2004-2003 Iowa State University
rem
rem This file is part of JML
rem
rem JML is free software; you can redistribute it and/or modify
rem it under the terms of the GNU General Public License as published by
rem the Free Software Foundation; either version 2, or (at your option)
rem any later version.
rem
rem JML is distributed in the hope that it will be useful,
rem but WITHOUT ANY WARRANTY; without even the implied warranty of
rem MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
rem GNU General Public License for more details.
rem
rem You should have received a copy of the GNU General Public License
rem along with JML; see the file COPYING.  If not, write to
rem the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
