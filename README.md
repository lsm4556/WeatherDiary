# 날씨 및 일기 관리 시스템 프로젝트

이 프로젝트는 날씨와 일기를 작성, 조회, 수정, 삭제하는 기능을 구현합니다.

## 프로젝트 개요 및 주요 사항

- 테스트 코드 작성
- 외부 API 데이터 활용
- JPA 방식으로 MySQL 사용

## API 리스트

### POST /create/diary

- date parameter로 날짜를 받습니다. (날짜 형식: yyyy-MM-dd)
- text parameter로 일기 내용을 받습니다.
- 외부 API에서 받아온 날씨 데이터와 함께 DB에 저장합니다.

### GET /read/diary

- date parameter로 조회할 날짜를 받습니다.
- 해당 날짜의 일기를 List 형태로 반환합니다.

### GET /read/diaries

- startDate, endDate parameter로 조회할 기간의 시작일과 종료일을 받습니다.
- 해당 기간의 일기를 List 형태로 반환합니다.

### PUT /update/diary

- date parameter로 수정할 날짜를 받습니다.
- text parameter로 수정할 새로운 일기 내용을 받습니다.
- 해당 날짜의 첫 번째 일기를 새로운 일기 내용으로 수정합니다.

### DELETE /delete/diary

- date parameter로 삭제할 날짜를 받습니다.
- 해당 날짜의 모든 일기를 삭제합니다.

## 추가 기능 구현 및 완성도 향상

- DB 관련 함수들을 트랜잭션 처리합니다.
- 매일 새벽 1시에 날씨 데이터를 외부 API에서 받아와 DB에 저장하는 로직을 구현합니다.
- logback을 이용하여 프로젝트에 로그를 남깁니다.
- ExceptionHandler을 이용한 예외 처리를 구현합니다.
- Swagger를 이용하여 API documentation을 작성합니다.

## 사용하는 사이트

- [Open Weather Map API](https://openweathermap.org/api)
  - 날씨 데이터를 얻어오는데 사용합니다.

