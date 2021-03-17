
_`Github Repo`_
https://github.com/EpicFate/hh.ru_Tests


**Запуск тестов организован в Jenkins.**
_`Jenkins job`_ https://jenkins.autotests.cloud/job/c03-hh.ru/

## Technology Stack
**Java, Gradle, Junit5, Selenide, Rest-Assured, Jenkins, Selenoid, Allure TestOps, Allure Reports, Telegram Bot, Jira.**


## `Screenshots`


### *Selenoid:*
**Для контейнеризации тестов использован Selenoid.**

**Можно запускать несколько браузеров одновременно (также работает локально без Selenoid)**

**Selenoid видео:**

![selenoid screenshot](images/selenoid.gif)
![selenoid screenshot](images/selenoid.png)

### *Selenoid:*

## **Паралельный запуск**

![selenoid screenshot](images/selenoid1.png)

### *Allure TestOps:*
**В качестве тест менжемент системы использован Allure TestOps. Есть интеграция с Jira**
![allure_testops screenshot](images/allure_testops_1.png)
**Тест кейсы, ручные и автоматизированные**
![allure_testops screenshot](images/allure_testops_2.png)
![allure_testops screenshot](images/allure_testops_3.png)


### *Allure Report:*
_Отчет о прохождении тестов Allure Report можно посмотреть по ссылке:_ https://jenkins.autotests.cloud/job/c03-hh.ru/25/allure/#

![allure screenshot](images/allure_1.png)
![allure screenshot](images/allure_2.png)
### *Allure Report:*
**К отчетам прикреплены скриншот и видео о прохождении теста.**

![allure screenshot](images/allure_3.png)

**Красивые отчеты для API тестов.**
![allure screenshot](images/allure_4.png)


### *Jira:*
**Интеграция _Jira_ c _Allure TestOps_**

Отображаются тесты которые указаны в _**тест плане**_, есть ссылка на запуск тестов из _**Allure TestOps**_
![jira screenshot](images/jira_1.png)

### *Telegram notification:*

**После окончания тестов результаты отправляются в Telegram.**

![telegram screenshot](images/telegram.png)
