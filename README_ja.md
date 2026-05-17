再起動時

mvn package

docker compose restart tomcat

docker rm -f my-tomcat

docker compose up -d tomcat --no-deps

# 再構築

- cd C:\git_repository\nwproject_docker
- mvnw clean package
- docker再構築
