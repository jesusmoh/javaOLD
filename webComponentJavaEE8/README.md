# Build
mvn clean package && docker build -t webComponentJavaEE8/webComponentJavaEE8 .

# RUN

docker rm -f webComponentJavaEE8 || true && docker run -d -p 8080:8080 -p 4848:4848 --name webComponentJavaEE8 webComponentJavaEE8/webComponentJavaEE8 