1.- Download this project by typing in the windows or linux console: git clone https://github.com/airineo/ExerciseCiAi.git
2.- Once downloaded, as a local test, inside the project root type: mvn spring-boot: run
This will run the spring-boot application in such a way that it will expose the rest services, which are added in an additional documentation properly for the purposes of this exercise.
3.- In case you want to deploy in a micro services environment, specifically with docker
* Generate jar -> Go to the root of the project in the console, type: mvn clean install
    * Once the process finishes, go to the specified path, which mentions "target", look for the file with the extension .jar
    * Go inside the operating system in question, previously installed docker, a jdk8 at least, or an openjdk8 for unix operating systems (check documentation for its installation itself, on its official pages.)
    * Have created the docker file for the creation of the image. (There is also documentation on the web for its creation, review.)
    * Copy the generated file, .jar for this project, copy and paste it in the same folder where the docker file is located.
    * Go to the path where the .jar and docker file are located in the console, type the command "sudo docker build -t <image name>"
    * Once the image is created, all that remains is to run it with the command: docker run <image name>
    * In this way, the docker micro services application will be available, for this case, the urls or files will be added in the additional documentation.
