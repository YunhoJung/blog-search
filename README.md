# blog-search
- Kakao, Naver 등의 Open API를 이용한 블로그 검색 서비스

## API 명세
- **URL**
  `/search`
  <br />
- **Method:**
  `GET`
  <br />
-  **URL Params**
   **Required:**
   `query=[string]`

   **Optional:**
   `sort=[string]`
   `page=[integer]`
   `size=[integer]`
   <br />
- **Success Response:**

    - **Code:** 200
      **Content:**
      ```json
      {
        "searchInfoDto":{
          "totalCount":0,
          "pageableCount":0
        },
        "blogDtoList":[
          {
            "title":"title",
            "contents":"contents",
            "url":"url",
            "postedAt":"postedAt"
          }
        ]
      }
      ```
<br />
<br />
- **URL**
`/keyword`
<br />
- **Method:**
`GET`
<br />
- **Success Response:**

- **Code:** 200
  **Content:**
  ```json
  [
    {"keyword":"keyword","count":1},
  ]
  ```

## 개발 환경
- linux
- java 11
- gradle 6.1

## 실행 방법
```shell
git clone git@github.com:YunhoJung/blog-search.git
cd blog-search
java -jar server-1.0-SNAPSHOT.jar
```

## To Do
- 인기 검색어 목록 조회 기능 Redis 캐시 적용
- Exception 핸들링 고도화
- 네이버 검색 API 연동
- 외부 API 장애 대응 고도화
