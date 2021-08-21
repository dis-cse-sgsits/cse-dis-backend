set microservice=academics administration gateway infrastructure moodle user

(for %%d in in (%microservice%) do(
    echo "Current directory %%d"
    echo "Building .jar in target folder"
    cd "./cse-dis-backend/%%d/"
    mvn install
    cd
    echo "Running DIS-%%d.jar"
    java -jar "./cse-dis-backend/%%d/target/DIS-%%d.jar"&
))