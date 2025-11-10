\echo 'Вывод всех роботов'
SELECT * 
  FROM jaegers 
 ORDER BY model_name;

\echo 'Вывод только не уничтоженных роботов'
SELECT * 
  FROM jaegers 
 WHERE status NOT IN ('Destroyed') 
 ORDER BY model_name;

\echo 'Вывод только роботов серии Mark-1 и Mark-4'
SELECT * 
  FROM jaegers 
 WHERE mark IN (1, 4)
 ORDER BY model_name;

\echo 'Вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark'
SELECT * 
  FROM jaegers 
 WHERE mark NOT IN (1, 2) 
 ORDER BY mark DESC;

\echo 'Вывод информации о самых старых роботах'
SELECT * 
  FROM jaegers 
 WHERE launch =
	   (SELECT MIN(launch)
		  FROM jaegers)
 ORDER BY model_name;

\echo 'Вывод инфо тех роботов, которые уничтожили больше всех kaiju'
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill = 
	   (SELECT MAX(kaiju_kill)
	      FROM jaegers)
 ORDER BY model_name;

\echo 'Вывод среднего веса роботов с округлением до 3 знаков'
SELECT ROUND(AVG(weight), 3) AS avg_weight
  FROM jaegers;

\echo 'Увеличение числа убитых kaiju на 1 у неразрушенных роботов'
UPDATE jaegers 
   SET kaiju_kill = kaiju_kill + 1
 WHERE status NOT IN ('Destroyed');

SELECT * 
  FROM jaegers
 ORDER BY model_name;

\echo 'Удаление уничтоженных роботов'
DELETE 
  FROM jaegers
 WHERE status = 'Destroyed';
 
SELECT *
  FROM jaegers
 ORDER BY model_name;

