/*
현재 사용중인 로컬 DB는 H2,
H2 DB는 메모리 DB라 프로젝트 실행할때마다 스키마가 새로 생성되어 테이블 구조 변경시 일일히 alter table과 같이 수정할 필요가 없다.
하지만 이로 인해, 프로젝트 코드를 수정하고 다시 실행시키면 이전 데이터가 초기화
그래서 여기에 그냥 박아두는거임 테스트 용으로
*/

insert into post (title, author, content, created_date, modified_date) values ('테스트1', 'test1@gmail.com', '테스트1의 본문', now(), now());
insert into post (title, author, content, created_date, modified_date) values ('테스트2', 'test2@gmail.com', '테스트2의 본문', now(), now());