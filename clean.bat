if exist .project del /f .project
if exist .classpath del /f .classpath
if exist target\ rmdir /Q /S target
if exist .settings\ rmdir /Q /S .settings
if exist bin\ rmdir /Q /S bin
if exist phantomjsdriver.log del /f phantomjsdriver.log
pause;