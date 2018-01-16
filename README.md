# GameLife

Игра «Жизнь» — клеточный автомат, придуманный английским математиком Джоном Конвеем в 1970 году. 
Место действия этой игры — это размеченная на клетки поверхность или плоскость
Каждая клетка на этой поверхности может находиться в двух состояниях: быть «живой» или быть «мёртвой» (пустой). Каждая клетка имеет восемь соседей (окружающих клеток), кроме граничных клеток. 
Распределение живых клеток в начале игры называется первым поколением. Каждое следующее поколение рассчитывается на основе предыдущего. 
Правила расчета нового поколения:
 в пустой (мертвой) клетке, рядом с которой ровно три живые клетки, зарождается жизнь;
 если у живой клетки есть две или три живые соседки, то эта клетка продолжает жить в следующем покалении; в противном случае (если соседей меньше двух или больше трёх) клетка умирает «от одиночества» или «от перенаселенности» (Не переходит в следующее поколение).
Игра прекращается, если на поле не останется ни одной «живой» клетки, если при очередном шаге ни одна из клеток не меняет своего состояния (складывается стабильная конфигурация) или если конфигурация на очередном шаге в точности (без сдвигов и поворотов) повторит себя же на одном из более ранних шагов (складывается периодическая конфигурация).
