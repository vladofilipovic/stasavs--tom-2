# Објектно оријентисано програмирање — Програмски језик Јава — Том 2

Примери из уџбеника за предмет Објектно оријентисано програмирање на Математичком факултету Универзитета у Београду.

## Структура пројекта

Сви примери су организовани у пакете по конвенцији:

```
rs.math.oop.gXX.pYY.opisPrimera
```

где је `XX` редни број главе (01–18), `YY` редни број примера у глави, а `opisPrimera` кратак опис.

```
tom-2/
├── src/                  # Изворни код примера
│   └── rs/math/oop/
│       ├── g01/          # Глава 1 — Рефлексија
│       ├── g02/          # Глава 2 — Забелешке (анотације)
│       ├── ...
│       └── g18/          # Глава 18 — REST веб сервиси
├── resources/            # Ресурсне датотеке (XML, properties, persistence.xml)
├── build.gradle          # Gradle конфигурација (аутоматско преузимање библиотека)
├── gradlew               # Gradle wrapper за macOS/Linux
├── gradlew.bat           # Gradle wrapper за Windows
└── README.md
```

## Ресурси (resources/)

Директоријум `resources/` садржи улазне датотеке које примери учитавају током извршавања.

| Датотека | Главе | Намена |
|----------|-------|--------|
| `biblioteka.xml` | 6 | Пример XML документа за вежбе рашчлањавања и обраде |
| `biblioteka.xsd` | 6 | XML Schema за валидацију датотеке `biblioteka.xml` |
| `poruke_en_US.properties` | 12 | Скуп порука на енглеском за примере интернационализације |
| `poruke_sr_RS.properties` | 12 | Скуп порука на српском за примере интернационализације |
| `META-INF/persistence.xml` | 16 | Конфигурација JPA јединице постојаности (`mojaPU`) |

## Захтеви

- JDK 25 или новији
- IntelliJ IDEA 2026.1 (или Eclipse 2026-03)
- Интернет конекција (за прво преузимање библиотека)

> **Напомена:** Gradle НЕ мора да се инсталира ручно. Пројекат садржи Gradle wrapper (`gradlew` / `gradlew.bat`) који аутоматски преузима и инсталира потребну верзију Gradle-а при првом покретању.

## Брзи почетак (командна линија)

Ако желите само да компајлирате и проверите да све ради, без IDE-а:

```bash
git clone https://github.com/matf-oop-java/tom-2.git
cd tom-2
./gradlew build        # macOS / Linux
gradlew.bat build      # Windows
```

Gradle ће аутоматски преузети све потребне библиотеке (JUnit, Jackson, Hibernate, Jersey, JavaFX итд.) и компајлирати све примере.

## Подешавање пројекта у IntelliJ IDEA

### Корак 1 — Преузимање и отварање

1. Клонирајте репозиторијум:
   ```
   git clone https://github.com/matf-oop-java/tom-2.git
   ```
2. Покрените IntelliJ IDEA
3. Изаберите **File → Open...**
4. Пронађите клонирани директоријум и кликните **Open**
5. IntelliJ ће препознати `build.gradle` и понудити да увезе пројекат као Gradle пројекат — кликните **OK** / **Trust Project**
6. Сачекајте да IntelliJ заврши увоз и индексирање (трака напретка при дну екрана) — током овог процеса Gradle аутоматски преузима све библиотеке

### Корак 2 — Подешавање JDK

1. Отворите **File → Project Structure** (`Ctrl+Alt+Shift+S` на Windows/Linux, `Cmd+;` на macOS)
2. У одељку **Project**:
   - **SDK**: изаберите JDK 25 (ако није на листи, кликните **Add SDK → JDK** и пронађите директоријум где је JDK 25 инсталиран)
   - **Language level**: изаберите `25`
3. Кликните **Apply**, затим **OK**

### Корак 3 — Подешавање кодирања (UTF-8)

Ово је неопходно за исправан приказ ћирилице:

1. Отворите **File → Settings** (`Ctrl+Alt+S`) на Windows/Linux, или **IntelliJ IDEA → Settings** на macOS
2. Идите на **Editor → File Encodings**
3. Подесите:
   - **Global Encoding**: `UTF-8`
   - **Project Encoding**: `UTF-8`
   - **Default encoding for properties files**: `UTF-8`
4. Кликните **Apply**, затим **OK**

### Корак 4 — Делегирање покретања Gradle-у

Ово подешавање је **обавезно** да би сви примери (укључујући JavaFX) исправно радили:

1. Отворите **File → Settings** (`Ctrl+Alt+S`) на Windows/Linux, или **IntelliJ IDEA → Settings** на macOS
2. Идите на **Build, Execution, Deployment → Build Tools → Gradle**
3. Промените **"Build and run using"** са `IntelliJ IDEA` на **`Gradle`**
4. Промените **"Run tests using"** са `IntelliJ IDEA` на **`Gradle`**
5. Кликните **Apply**, затим **OK**

### Корак 5 — Покретање примера

1. У панелу **Project** пронађите жељени пример, нпр. `src/rs/math/oop/g01/p01/`
2. Кликните десним тастером на датотеку која садржи `main()` метод
3. Изаберите **Run 'ImeKlase.main()'**
4. Излаз програма појављује се у панелу **Run** при дну екрана

> **Напомена:** Сви примери, укључујући JavaFX (глава 5) и JPA/Hibernate (глава 16), покрећу се на исти начин. Gradle аутоматски подешава module-path за JavaFX и classpath за све остале библиотеке.

## Подешавање пројекта у Eclipse

### Корак 1 — Увоз пројекта

1. Покрените Eclipse
2. Изаберите **File → Import... → Gradle → Existing Gradle Project**
3. Кликните **Browse...** и пронађите клонирани директоријум
4. Кликните **Finish** — Eclipse ће аутоматски покренути Gradle и преузети све библиотеке

### Корак 2 — Подешавање JDK

1. Кликните десним тастером на пројекат → **Properties → Java Build Path**
2. Картица **Libraries**: подесите **JRE System Library** на JDK 25

### Корак 3 — Кодирање

1. Кликните десним тастером на пројекат → **Properties → Resource**
2. Подесите **Text file encoding** на `UTF-8`

## Библиотеке

Све библиотеке се аутоматски преузимају преко Gradle-а (дефинисане у `build.gradle`):

| Библиотека | Главе | Намена |
|------------|-------|--------|
| JUnit Jupiter 5.14 | 13 | Оквир за јединично тестирање |
| Jackson Databind 2.18 | 7, 18 | JSON серијализација/десеријализација |
| H2 Database 2.3 | 14 | In-memory база података за JDBC примере |
| HikariCP 6.2 | 14 | Скуп конекција са базом података |
| Hibernate 6.6 | 16 | JPA провајдер за ORM примере |
| Jakarta Servlet API 6.1 | 17 | API за сервлет примере |
| Jersey 3.1 + Grizzly 4.0 | 18 | JAX-RS имплементација и HTTP сервер за REST примере |
| JavaFX 25 | 5 | Графички оквир (аутоматски за текућу платформу) |

## Решавање честих проблема

| Проблем | Решење |
|---------|--------|
| `Could not resolve dependencies` | Проверите интернет конекцију — Gradle преузима библиотеке са интернета |
| Ћирилица се приказује као `????` или `ÐÐ°Ð¼Ð¾` | Подесите кодирање на UTF-8 (Корак 3 у IntelliJ упутству) |
| `JavaFX runtime components are missing` | У IntelliJ-у: Settings → Build Tools → Gradle → поставите **"Build and run using"** на **Gradle** (Корак 4) |
| `persistence.xml not found` | Покрените `./gradlew build` да се ресурси правилно копирају |
| `error: release version 25 not supported` | Инсталирајте JDK 25 и подесите га као Project SDK |
| IntelliJ не препознаје Gradle | Изаберите **File → Open**, не File → New — IntelliJ мора да види `build.gradle` |
| `gradlew: Permission denied` (macOS/Linux) | Покрените `chmod +x gradlew` у терминалу |

## Аутори

Сташа Вујичић Станковић, Владимир Филиповић, Александар Картељ, Душан Тошић

Математички факултет, Универзитет у Београду
