## Тестовое задание для ЦФТ
***
### Утилита фильтрации содержимого файлов.
При запуске утилиты в командной строке подается несколько файлов, содержащих в
перемешку целые числа, строки и вещественные числа.
Задача утилиты записать разные типы данных в разные файлы. Целые числа в один
выходной файл, вещественные в другой, строки в третий.<br/>
По умолчанию файлы с результатами располагаются в текущей папке с именами **integers.txt**, **floats.txt**, **strings.txt**.
Дополнительно с помощью опции **-o** нужно уметь задавать путь для результатов.<br/> Опция **-p**
задает префикс имен выходных файлов. Например **-o** _**/some/path**_ **-p** **_result_**_ задают вывод в
файлы _**/some/path/result_integers.txt**_, _**/some/path/result_strings.txt**_ и тд.<br/>
По умолчанию файлы результатов перезаписываются. С помощью опции **-a** можно задать
режим добавления в существующие файлы.<br/>
В процессе фильтрации данных собирается статистика по каждому типу данных.
Статистика поддерживаеться двух видов: краткая и полная. Выбор статистики
производится опциями -s и -f. Краткая статистика содержит только
количество элементов записанных в исходящие файлы. Полная статистика для чисел
дополнительно содержит минимальное и максимальное значения, сумма и среднее.
Полная статистика для строк, помимо их количества, содержит также размер самой
короткой строки и самой длинной.
### Пример использования:
> Пример входного файла in1.txt<br/>
Lorem ipsum dolor sit amet<br/>
45<br/>
Пример<br/>
3.1415<br/>
consectetur adipiscing<br/>
-0.001<br/>
тестовое задание<br/>
100500 <br/>
 
>Пример входного файла in2.txt<br/>
Нормальная форма числа с плавающей запятой<br/>
1.528535047E-25<br/>
Long<br/>
1234567890123456789<br/>

>Пример запуска утилиты<br/>
java -jar util.jar -s -a -p sample- in1.txt in2.txt<br/>
### Исходящие файлы:
>sample-integers.txt<br/>
45<br/>
1234567890123456789<br/>
100500<br/>

>sample-floats.txt<br/>
1.528535047E-25<br/>
3.1415<br/>
-0.001<br/>

>sample-strings.txt<br/>
Lorem ipsum dolor sit amet<br/>
Нормальная форма числа с плавающей запятой<br/>
Пример<br/>
Long<br/>
consectetur adipiscing<br/>
тестовое задание<br/>