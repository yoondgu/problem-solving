-- 코드를 입력하세요
-- 상반기 주문 테이블에는 상반기 개월의 출하번호들을 모아둔다.  PK FLAVOR
-- 출하번호마다 주문량을 가진다.
-- 7월에도 출하 번호는 여러 개가 있을 수 있다. PK SHIPMENT_ID

SELECT f.FLAVOR
FROM FIRST_HALF f
JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) JULY_TOTAL_ORDER
     FROM JULY
     GROUP BY FLAVOR) j
ON f.FLAVOR = j.FLAVOR
ORDER BY f.TOTAL_ORDER + j.JULY_TOTAL_ORDER DESC
LIMIT 3;