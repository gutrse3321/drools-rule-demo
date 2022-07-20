FROM openjdk:11.0-jre-slim
ADD server/target/alice-server-1.0-SNAPSHOT.jar app.jar
RUN echo "Asia/shanghai" > /etc/timezone
#RUN echo "47.18.251.85 peer1" > /etc/hosts
#RUN echo "47.18.251.86 peer2" > /etc/hosts
#RUN echo "47.18.251.89 peer1mirror" > /etc/hosts
#RUN echo "47.18.251.90 peer2mirror" > /etc/hosts
ENTRYPOINT java -Xms128m -Xmx512m -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar /app.jar
