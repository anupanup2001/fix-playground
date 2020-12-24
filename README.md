# Development Environment
## One Time Setup
* Make sure angular-cli is installed globally `npm install -g @angular/cli`
* Run `npm install` from webui folder to download UI dependencies 
## Build UI
* Below steps are needed if Springboot has to host angular. In development mode, `ng serve`
  in webui folder will start ui server at `http://localhost:4200` All api requests would be
  redirected to port 8080 where API server runs
* Run command `ng build` which builds UI files and places them in `webui/dist/webui` folder
* Copy all files from `webui/dist/webui/` to `src/main/resources/static` folder so that spring boot can serve it
## Test
* Download fiximulator from http://fiximulator.org/FIXimulator_0.41.zip
* Run command `java -jar FIXimulator_0.41/dist/FIXimulator_0.41.jar`
* Start SpringBootApp FixplaygroundApplication.main() class
* Go to browser `http://localhost:8080` if hosted by spring boot or `http://localhost:4200` if hosted
by angular development server

# References
* Blox Material - CSS Framework for UI: https://material.src.zone/components
* Material Design Foundation - https://material.io/design/foundation-overview
* Spring MVC - https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-controller
* websocket with Spring - https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket-stomp-client