# EnergySystem
------------------------------
ENG

• *Parcela or lot* is a label, which is created with a given one-letter label and background color (Color). The label is printed in white (WHITE) and Serif font, bold, size 14. The background color of the lot can be changed. A lot can be selected with a mouse click, which it reports to the parent container.

• *The grassy surface or travnata povrsina* is a lot of green color (GREEN) and marked ".

• *The water surface or vodena povrsina* is a lot of light blue color (CYAN) and marked ~.

• *The battery or baterija* has an integer amount of current energy and a specified maximum capacity. At creation the battery is fully charged. It is possible to add a given integer amount of energy to the battery, with the excess energy being discarded after the battery is fully charged. It is possible to completely discharge the battery. It can be checked if the battery is full.

• *A producer or proizvodjac* is a lot that actively produces energy in cycles. It is created with an additionally specified integer base time and battery. The total production time is calculated as the sum of the base time and a randomly generated integer in the range [0, 300]. The manufacturer periodically waits the total time, then produces a certain number of energy units to charge the battery (with possible production failure) and waits an additional 300 milliseconds. If the producer has successfully produced energy, its inscription is printed in red (RED) during the specified interval of 300 milliseconds, after the current production, and before a new cycle of production. It is possible to stop the manufacturer.

• *The hydropower plant or hidroelektrana* is a producer of blue color (BLUE) and the label H. It can be set the number of water bodies that surround it (0 at creation). The hydroelectric power plant generates in each cycle one unit of energy for each water surface that surrounds it. Energy production is successful if the hydropower plant is surrounded by at least one body of water. The basic production time is 1500 milliseconds.

• *The plot or plac* is a grid of lots. It is created with the given number of grid rows and columns. During creation, each field of the grid is randomly initialized with grass (probability 70%) or water surface (probability 30%). One lot can be selected. By selecting a new lot, the previously selected lot is unselected. The font size of the selected lot is increased to 20. It is possible to add a producer to the selected lot, after which the number of water bodies surrounding them is updated. If no lot is selected, adding a producer is not successful. It is possible to stop the work of all manufacturers.

• *The power system or enegetski sistem* is the main application window 500 pixels wide and 500 pixels high that contains the plot and the battery. It is created with the given number of rows and columns of the board and the battery capacity. During the creation of the energy system, a plot and a battery are created. Unable to resize the window. The window contains a button for adding a new manufacturer.

----------------------
SRB

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
