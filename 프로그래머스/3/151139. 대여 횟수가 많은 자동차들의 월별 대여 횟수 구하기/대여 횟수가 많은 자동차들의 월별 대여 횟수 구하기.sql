SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE DATE_FORMAT(START_DATE, '%Y%m') >= 202208 AND DATE_FORMAT(START_DATE, '%Y%m') <= 202210
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
) AND DATE_FORMAT(START_DATE, '%Y%m') >= 202208 AND DATE_FORMAT(START_DATE, '%Y%m') <= 202210
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH(START_DATE) ASC, CAR_ID DESC

# SELECT CAR_ID
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE DATE_FORMAT(START_DATE, '%Y%m') >= 202208 AND DATE_FORMAT(START_DATE, '%Y%m') <= 202210
# GROUP BY CAR_ID
# HAVING COUNT(*) >= 5