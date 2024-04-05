[Insomnia_2024-04-05.json](https://github.com/szatrio/my-locker-api/files/14879081/Insomnia_2024-04-05.json)# my-locker-api

## Table of Contents

-  [Introduction](#introduction)

-  [Technology](#Technology)

-  [Insomnia Collection](#Collection)
  
-  [Database design](#Database) 

---

## Introduction


<p>My locker api is locker rent minimalized app</p>

  

## Technology


- Java

- Spring Boot

- Hibernate

- JPA

- MySQL

- Jakarta Validation

  

## Insomnia Collection

[Uploading Insomnia_2024-04-{"_type":"export","__export_format":4,"__export_date":"2024-04-05T02:20:07.926Z","__export_source":"insomnia.desktop.app:v8.6.1","resources":[{"_id":"req_771b0b2af58e414fb6124b0aae9492d7","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712283224595,"created":1712283083681,"url":"http://localhost:8080/api/open-locker","name":"Open Locker","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"userId\":\"6f31e230-d337-4ec8-8aad-2bbb7317d9fe\",\n\t\"lockerId\":\"2042cf56-b02c-4b65-8c66-5a038eaf6e55\",\n\t\"password\":\"dkWblZ\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712283083681,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"wrk_cdc10631afcc4ee0ba79becf37abba98","parentId":null,"modified":1712257677474,"created":1712257677474,"name":"My Locker API","description":"","scope":"collection","_type":"workspace"},{"_id":"req_ef67715c81674fc288a4903ed7676443","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712282844475,"created":1712282501887,"url":"http://localhost:8080/api/book-locker","name":"Book Locker","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"userId\":\"6f31e230-d337-4ec8-8aad-2bbb7317d9fe\",\n\t\"lockerId\":\"2042cf56-b02c-4b65-8c66-5a038eaf6e55\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712282501887,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_33bc97efe48e45149ca95134238f947a","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712282703388,"created":1712274405514,"url":"http://localhost:8080/api/lockers-list","name":"Get Locker List","description":"","method":"GET","body":{"mimeType":"application/json","text":""},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712274405514,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_ad2ae7afeb654f57b354e9c70ecfa01e","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712270213683,"created":1712270157265,"url":"http://localhost:8080/api/lockers","name":"Create Locker","description":"","method":"GET","body":{"mimeType":"application/json","text":""},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712270157265,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_a062bb30dd234b3aa9d9f173cf2510c3","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712270178401,"created":1712257690272,"url":"http://localhost:8080/api/users","name":"Register User","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\":\"Ani Amina\",\n\t\"phoneNumber\":\"085189172918\",\n\t\"idNumber\":\"87392827382\",\n\t\"email\":\"ani@abc.com\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712270120621.5,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_22f13fc97189462eb74e516036ea6148","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712274428037,"created":1712269649173,"url":"http://localhost:8080/api/users","name":"Get User List","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712270102299.75,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_b674c6150d5d4a2c9d2208bd1fa0c125","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712270184670,"created":1712270038813,"url":"http://localhost:8080/api/users/6f31e230-d337-4ec8-8aad-2bbb7317d9fe","name":"Get User","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712270093138.875,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_2cf9800692d04f148c29c82db393a56d","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712270144909,"created":1712270083978,"url":"http://localhost:8080/api/users/6f31e230-d337-4ec8-8aad-2bbb7317d9fe","name":"Update User","description":"","method":"PUT","body":{"mimeType":"application/json","text":"{\n\t\"name\":\"Ani Aminaamina\",\n\t\"phoneNumber\":\"085189172918\",\n\t\"idNumber\":\"87392827382\",\n\t\"email\":\"ani@abc.com\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1712270083978,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"env_d42e38fb97f4b45080c583038806b0e6a07ba86f","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712257677478,"created":1712257677478,"name":"Base Environment","data":{},"dataPropertyOrder":null,"color":null,"isPrivate":false,"metaSortKey":1712257677478,"_type":"environment"},{"_id":"jar_d42e38fb97f4b45080c583038806b0e6a07ba86f","parentId":"wrk_cdc10631afcc4ee0ba79becf37abba98","modified":1712257677480,"created":1712257677480,"name":"Default Jar","cookies":[],"_type":"cookie_jar"}]}05.json…]()



----


## Database

![image](https://github.com/szatrio/my-locker-api/assets/31741060/775b5ac8-48de-4ff5-b951-eb734c112d7a)




  

License

----

  

© Satrio Utomo
