PORT=''

while test $# -gt 0; do
    case "$1" in
        -port)
            shift
            PORT=$1
            shift
            ;;
        -check)
            command mvn -v || echo "Maven is not installed" &&
            command java -version || echo "Java is not installed"
            exit 0;
            ;;
        -help)
            echo "usage -port port_number"
            echo "tags:"
            echo " -port    The port number you want the service to run on"
            echo " -check   Checks if user has all necessary software to run service"    
            exit 0;
            ;;
        *)
            echo "Command not supported"
            exit 1;
            ;;    
    esac
done

if [[ -z $PORT ]]; then
    echo "Port number was not supplied, running on default port 8080"
    eval 'mvn spring-boot:run'
else
    eval 'mvn -Dserver.port="'$PORT'" spring-boot:run'
fi
 
