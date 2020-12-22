# Development Environment
## One Time Setup
* Make sure angular-cli is installed globally `npm install -g @angular/cli`
* Run `npm install` from webui folder to download UI dependencies 
## Build UI
* Run command `ng build` which builds UI files and places them in `webui/dist/webui` folder
* Copy all files from `webui/dist/webui/` to `src/main/resources/static` folder so that spring boot can serve it
## Test
* Download fiximulator from http://fiximulator.org/FIXimulator_0.41.zip
* Run command `java -jar FIXimulator_0.41/dist/FIXimulator_0.41.jar`
* Start SpringBootApp FixplaygroundApplication.main() class
* Go to browser `http://localhost:8080`