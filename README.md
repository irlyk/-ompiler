# Сompiler


Курсовая работа студента группы ИБ-117 Лоскутова Артёма

## Запуск

*Main* класс принимает на вход название файла для считывания кода и выдаёт на выходе файл *test.class* с байт-кодом для JVM

### Библиотеки

*antlrv4* - для  генерации грамматики.

*asm-8.0.1*  - для генерации байт-кода

### 1. Большая часть грамматики языка
Файл MLL.g4 предсталяющий грамматику находится в *src/MLL/*

Пример программы на созданном языке:

```
const int a = 0;
const float b = 0.3;
const int c = a + 3;

def funcName(int a, int b){
    print(a + b);
}

main(){
    int g = 34;
    funcName(g);
    int h = g + a * 3;
    print(h);
}
```

### 2. Пример дерева разбора с помощью ***#grun***

![grun tree](https://github.com/irlyk/Compiler/blob/master/image.png)

### 3. Пример работы компилятора

| MLL                                | JVM                |
| -------------                      |:------------------:|
|``` int a = 0;  ```                 | BIPUSH 0             |
|                                    | ISTORE 1             |
|``` a = 3 + 3 * (3 + 3); // 21 ```  | BIPUSH 3             |
|                                     |  BIPUSH 3           |
|                                     |  BIPUSH 3           |
|                                     |  BIPUSH 3           |
|                                     |  IADD               |
|                                     |  IMUL               |
|                                     |  IADD               |
|                                     |  ISTORE 1           |
