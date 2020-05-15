FROM openjdk:8u201-jdk-alpine3.9

RUN apk update && apk add --update nginx python py-pip tzdata fontconfig ttf-dejavu redis && rm -rf /var/cache/apk/*

ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN date

COPY target/desafio-itau.jar /opt/app.jar

ENV SPRING_PROFILES_ACTIVE=dev

EXPOSE 8080:8080

WORKDIR /opt

ENTRYPOINT ["java", "-XX:-OmitStackTraceInFastThrow", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=1", "-XshowSettings:vm", "-Djava.security.egd=file:/dev/./urandom","-jar", "app.jar" ]
