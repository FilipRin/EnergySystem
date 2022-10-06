# EnergySystem
------------------------------
• *Парцела* је натпис (Label), који се ствара са задатом једнословном ознаком и бојом позадине
(Color). Ознака се исписује белом бојом (WHITE) и фонтом Serif, подебљано, величине 14.
Парцели може да се промени боја позадине. Парцела може да се изабере кликом миша, што она
пријављује родитељском контејнеру.

• *Травната површ* је парцела зелене боје (GREEN) и
ознаке ".

• *Водена површ* је парцела светло плаве боје (CYAN) и
ознаке ~.

• *Батерија* има целобројну количину тренутне енергије и
задати максимални капацитет. При стварању батерија је
потпуно пуна. Могуће је додати задату целобројну
количину енергије батерији, при чему се вишак енергије
одбацује након што се батерија потпуно напуни. Могуће
је потпуно испразнити батерију. Може се проверити да ли
је батерија пуна.

• *Произвођач* је парцела која активно производи енергију у
циклусима. Ствара се са додатно задатим целобројним
основним временом и батеријом. Укупно време
производње се рачуна као збир основног времена и случајно генерисаног целог броја у опсегу [0,
300]. Произвођач периодично сачека укупно време, затим произведе извесан број јединица
енергије којима пуни батерију (уз могући неуспех производње) и додатно сачека 300
милисекунди. Уколико је произвођач успешно произвео енергију, његов натпис се исписује
црвеном бојом (RED) у току наведеног интервала од 300 милисекунди, након текуће производње,
а пре новог циклуса производње. Могуће је зауставити произвођача.

• *Хидроелектрана* је произвођач плаве боје (BLUE) и ознаке H. Може да јој се постави број
водених површина које је окружују (при стварању 0). Хидроелектрана генерише у сваком
циклусу по једну јединицу енергије за сваку водену површ која је окружује. Производња енергије
је успешна уколико хидроелектрану окружује барем једна водена површ. Основно време
производње је 1500 милисекунди.

• *Плац* је решетка парцела. Ствара се са задатим бројем редова и колона решетке. Приликом
стварања свако поље решетке се насумично иницијализује травнатом (вероватноћа 70%) или
воденом површи (вероватноћа 30%). Може да се изабере једна парцела. Избором нове парцеле,
претходно изабраној парцели се поништава избор. Изабраној парцели се величина фонта увећава
на 20. Могуће је додати произвођача на изабрану парцелу, након чега се хидроелектранама
ажурира број водених површина које их окружују. Уколико ни једна парцела није изабрана,
додавање произвођача није успешно. Могуће је зауставити рад свих произвођача.

• *Енергетски систем* је главни прозор апликације ширине 500 и висине 500 пиксела који садржи
плац и батерију. Ствара се са задатим бројем редова и колона плаца и капацитетом батерије. У
току стварања енергетског система направе се плац и батерија. Није могуће променити величину
прозора. Прозор садржи дугме (Button) за додавање новог произвођача.
