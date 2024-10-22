-- 코드를 입력하세요
/*
BOOK 테이블에서 경제 카테고리에 속하는 도서들의 도서 ID, 저자명, 출판일 리스트를 출력하라.
결과는 출판일을 기준으로 오름차순 정렬한다.
*/

SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK A
JOIN AUTHOR B
ON A.author_id = B.author_id
WHERE A.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE