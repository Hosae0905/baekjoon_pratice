-- 코드를 입력하세요
/*
PRODUCT - 상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.
OFFLINE_SALE - 동일한 날짜, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.

PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액 합계를 출력하라.
매출액은 (판매가 * 판매량)
결과는 매출액 기준 내림차순, 매출액이 같다면 상품코드 기준 오름차순
*/

SELECT PRODUCT_CODE, SUM(PRICE * SALES_AMOUNT) AS SALES
FROM PRODUCT A
JOIN OFFLINE_SALE B
ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE
