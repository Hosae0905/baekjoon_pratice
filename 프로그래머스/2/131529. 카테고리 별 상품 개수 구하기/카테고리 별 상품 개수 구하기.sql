-- 코드를 입력하세요
/*
PRODUCT 테이블에서 카테고리 코드별 상품 개수를 출력한다.
상품 카테고리 코드는 앞 2자리만 사용한다.
상품 카테고리 코드 기준으로 오름차순 정렬한다.
*/
SELECT LEFT(PRODUCT_CODE, 2) AS CATEGORY, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY PRODUCT_CODE