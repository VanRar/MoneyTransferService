# Курсовой проект "Сервис перевода денег"

## Описание проекта 

Разработано приложение - REST-сервис. Сервис представляет интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации. Заранее подготовленное веб-приложение (FRONT) подключается к разработанному сервису без доработок и использовать его функционал для перевода денег.

## Описание приложения

- Сервис предоставляет REST интерфейс для интеграции с FRONT
- Сервис реализует все методы перевода с одной банковской карты на другую описанные в протоколе https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml
- Все изменения записываются в файл (лог переводов в формате с указанием даты, времени, карта с которой было списание, карта зачисления, сумма, комиссия, результат операции если был)

## Описание реализации

- Приложение разработано с использованием Spring Boot
- Использован сборщик пакетов maven
- Для запуска используется docker, docker-compose
- Код размещен на github
- Код покрыт unit тестами с использованием mockito
- Шаги реализации:
- Изучить протокол получения и отправки сообщений
- Схема приложений (сделана в miro):

![diagram (3)](https://github.com/VanRar/MoneyTransferService/blob/master/%D1%81%D1%85%D0%B5%D0%BC%D0%B0.jpg)

- Написан dockerfile
- Приложение упаковано и поднято в docker:

![diagram (3)](https://github.com/VanRar/MoneyTransferService/blob/master/docker.jpg)

- Приложение протестировано с помощью postman (пост запрос тестировался при поднятом сервисе в docker)

![diagram (3)](https://github.com/VanRar/MoneyTransferService/blob/master/%D0%BF%D0%BE%D1%81%D1%82%D0%BC%D0%B0%D0%BD.jpg?raw=true)

- Написан docker-compose скрипт для запуска FRONT и написанного REST-SERVICE
- Написан README.md к проекту.

## Запуск приложения

### Фронт
1. FRONT доступен по адресу https://github.com/serp-ya/card-transfer, можно выкачать репозиторий и запустить nodejs приложение локально 
(в описании репозитория фронта добавлена информация как запустить) или использовать уже развернутое демо приложение по адресу https://serp-ya.github.io/card-transfer/ (тогда ваш api должен быть запущен по адресу http://localhost:5500/).
> Весь api фронта был описан в соответствии yaml (https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml)
файла по спецификации openapi (подробнее тут https://swagger.io/specification/ и тут https://starkovden.github.io/introduction-openapi-and-swagger.html)
2. Создать в корне проекта FRONT Dockerfile, скопировать и вставить в него следующее содержимое:
```
FROM node:10-alpine as build-step
RUN mkdir /app
EXPOSE 3000
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build
CMD ["npm", "run", "start"]
```
3. Упаковать FRONT  в docker-контейнер c именем образа frontend
4. Запустить FRONT командой docker compose up -d frontend

### REST-Service (MoneyTransferService)
1. Склонировать данный репозиторий
2. Упаковать в контейне (имя - moneytransferservice)
3. запустить командой docker compose up -d moneytransferservice
4. Фронт, который работает с рест будет доступен по ссылке: http://localhost:3000/card-transfer
