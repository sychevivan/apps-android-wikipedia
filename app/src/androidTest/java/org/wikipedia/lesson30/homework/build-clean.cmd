@echo off

set IMAGE_NAME=android-jdk21
set CONTAINER_NAME=lesson-container
set DOCKERFILE=app\src\androidTest\java\org\wikipedia\lesson30\homework\Dockerfile

docker build -t %IMAGE_NAME% -f %DOCKERFILE% .

docker run --rm -d --name %CONTAINER_NAME% -v ".:/project" -w /project %IMAGE_NAME% sleep infinity

docker exec %CONTAINER_NAME% sh -c "sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew app:clean"

docker stop %CONTAINER_NAME%
