## Реализация системы мониторинга с использованием Spring Kafka

Задание: Реализация системы мониторинга с использованием Spring Kafka

Описание: Создать систему мониторинга, которая будет отслеживать работу различных компонентов вашего приложения с помощью Spring Kafka. 
Эта система будет включать в себя Producer для отправки метрик, Consumer для их обработки и анализа, а также REST API для просмотра метрик


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white "Java 11")
![Maven](https://img.shields.io/badge/Maven-green.svg?style=for-the-badge&logo=mockito&logoColor=white "Maven")
![Spring](https://img.shields.io/badge/Spring-blueviolet.svg?style=for-the-badge&logo=spring&logoColor=white "Spring")
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![GitHub](https://img.shields.io/badge/git-%23121011.svg?style=for-the-badge&logo=github&logoColor=white "Git")
![Swagger](https://img.shields.io/badge/Swagger-%2523121011.svg?style=for-the-badge&logo=swagger&logoColor=white "Swagger")
![Kafka](https://img.shields.io/badge/Kafka-black?style=for-the-badge&logo=apachekafka&logoColor=white&labelColor=black "Kafka")


### Запуск и использование системы
Запуск сервисов осуществляется через docker-compose файл\
В сервисах producer и consumer есть Swagger, в которых описаны конечные точки сервисов\
Запросить метрики можно через методы консьюмера (Consumer):
 - GET /metrics: Получение списка всех метрик
 - GET /metrics/{id}: Получение конкретной метрики по ее идентификатору
   
Либо через метод продюсера (Producer):
 - POST /metrics: Отправка метрик работы приложения в формате JSON

После чего метрики передаются от продюсера к консьюмеру и записываются в БД, которая запущена в контейнере
