# Објектно оријентисано програмирање — Програмски језик Јава — Том 2

Примери из уџбеника за предмет Објектно оријентисано програмирање на Математичком факултету Универзитета у Београду.

## Структура пројекта

Сви примери су организовани у пакете по конвенцији:

```
rs.math.oop.gXX.pYY.opisPrimera
```

где је `XX` редни број главе (01–18), `YY` редни број примера у глави, а `opisPrimera` кратак опис.

```
tom2/
├── src/                  # Изворни код примера
│   └── rs/math/oop/
│       ├── g01/          # Глава 1 — Рефлексија
│       ├── g02/          # Глава 2 — Забелешке (анотације)
│       ├── ...
│       └── g18/          # Глава 18 — REST веб сервиси
├── resources/            # Ресурсне датотеке (XML, properties, persistence.xml)
├── lib/                  # Спољашње JAR библиотеке
│   ├── h2/               # H2 база података
│   ├── hibernate/        # Hibernate (JPA провајдер)
│   ├── hikari/           # HikariCP скуп конекција
│   ├── jackson/          # Jackson JSON библиотека
│   ├── javafx/           # JavaFX (mac/, win/, linux/)
│   ├── jersey/           # Jersey JAX-RS + Grizzly HTTP сервер
│   ├── junit/            # JUnit 5 (Jupiter + Platform)
│   └── servlet/          # Jakarta Servlet API
└── README.md
```

## Библиотеке (lib/)

Директоријум `lib/` садржи спољашње библиотеке (JAR датотеке) потребне за примере у одређеним главама.

| Директоријум | Главе | Садржај |
|----------|-------|---------|
| `h2` | 14 | H2 база података — драјвер за JDBC примере са in-memory базом (`jdbc:h2:mem:`) |
| `hibernate` | 16 | Hibernate (JPA провајдер) и пратеће библиотеке за ORM примере |
| `hikari` | 14 | HikariCP — скуп конекција са базом података |
| `jackson` | 7, 18 | Jackson Databind — серијализација и десеријализација JSON докумената |
| `javafx` | 5 | JavaFX графички оквир; садржи три поддиректоријума (`mac/`, `win/`, `linux/`) — изабрати онај који одговара платформи |
| `jersey` | 18 | Jersey (JAX-RS имплементација) и Grizzly HTTP сервер за REST примере |
| `junit` | 13 | JUnit 5 (Jupiter + Platform) — оквир за јединично тестирање |
| `servlet` | 17 | Jakarta Servlet API — потребан за компилацију сервлет примера |

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

## Подешавање пројекта у IntelliJ IDEA — корак по корак

Пошто `.idea/` конфигурација није укључена у репозиторијум, пројекат треба подесити ручно. Следећа упутства важе за **све платформе** (Windows, macOS, Linux).

### Корак 1 — Преузимање и отварање

1. Клонирајте репозиторијум:
   ```
   git clone https://github.com/vladofilipovic/UdzbenikJava2.git
   ```
2. Покрените IntelliJ IDEA
3. Изаберите **File → Open...**
4. Пронађите клонирани директоријум и кликните **Open**
5. Када IntelliJ пита о типу пројекта, изаберите **Open as Project**
6. Сачекајте да се индексирање заврши (трака напретка при дну екрана)

### Корак 2 — Подешавање JDK

1. Отворите **File → Project Structure** (`Ctrl+Alt+Shift+S` на Windows/Linux, `Cmd+;` на macOS)
2. У одељку **Project**:
   - **SDK**: изаберите JDK 25 (ако није на листи, кликните **Add SDK → JDK** и пронађите директоријум где је JDK 25 инсталиран)
   - **Language level**: изаберите `25`
   - **Compiler output**: унесите путању `out` (нпр. путања_до_пројекта/out)
3. Кликните **Apply**

### Корак 3 — Означавање изворних директоријума

У истом прозору **Project Structure**, одаберите одељак **Modules**:

1. Ако не постоји модул, кликните **+** → **New Module** → **Java** → **Next** → **Finish**
2. Изаберите модул у левом панелу и отворите картицу **Sources**
3. Означите директоријуме:
   - Кликните десним тастером на `src` → **Mark as: Sources** (плава боја)
   - Кликните десним тастером на `resources` → **Mark as: Resources** (жута боја са иконом)
4. Кликните **Apply**

> **Важно:** Директоријум `resources` мора бити означен као Resources да би `persistence.xml`, XML и properties датотеке биле доступне на classpath-у током извршавања.

### Корак 4 — Додавање библиотека (JAR датотека)

У истом прозору **Project Structure**, одаберите одељак **Libraries**:

1. Кликните **+** → **Java**
2. Пронађите директоријум `lib/junit/` и означите **све JAR датотеке** унутра → кликните **OK**
3. Дајте библиотеци име `junit` → кликните **OK**
4. Поновите поступак (кораке 1–3) за сваки поддиректоријум у `lib/`:

| Библиотека | Директоријум | Све JAR датотеке |
|------------|-------------|:----------------:|
| `junit` | `lib/junit/` | да (11 датотека) |
| `jackson` | `lib/jackson/` | да (5 датотека) |
| `h2` | `lib/h2/` | да (1 датотека) |
| `hikari` | `lib/hikari/` | да (3 датотеке) |
| `hibernate` | `lib/hibernate/` | да (11 датотека) |
| `servlet` | `lib/servlet/` | да (1 датотека) |
| `jersey` | `lib/jersey/` | да (17 датотека) |
| `javafx` | `lib/javafx/<платформа>/` | да — видети напомену испод |

> **JavaFX — избор платформе:**
> - На **macOS**: додајте JAR датотеке из `lib/javafx/mac/`
> - На **Windows**: додајте JAR датотеке из `lib/javafx/win/`
> - На **Linux**: додајте JAR датотеке из `lib/javafx/linux/`
>
> Додајте **само** директоријум за своју платформу.

5. Проверите да се све библиотеке појављују у одељку **Modules → Dependencies** са квачицом ✓
6. Кликните **Apply**, затим **OK**

### Корак 5 — Подешавање кодирања (UTF-8)

Ово је неопходно за исправан приказ ћирилице:

1. Отворите **File → Settings** (`Ctrl+Alt+S`) на Windows/Linux, или **IntelliJ IDEA → Settings** на macOS
2. Идите на **Editor → File Encodings**
3. Подесите:
   - **Global Encoding**: `UTF-8`
   - **Project Encoding**: `UTF-8`
   - **Default encoding for properties files**: `UTF-8`
4. Кликните **Apply**, затим **OK**

### Корак 6 — Покретање примера

**Обични примери (главе 1–4, 6–18 осим JavaFX):**

1. У панелу **Project** пронађите жељени пример, нпр. `src/rs/math/oop/g01/p01/`
2. Кликните десним тастером на датотеку која садржи `main()` метод
3. Изаберите **Run 'ImeKlase.main()'**
4. Излаз програма појављује се у панелу **Run** при дну екрана

**JavaFX примери (глава 5):**

JavaFX примери захтевају додатне VM опције. За сваки JavaFX пример:

1. Кликните десним тастером на датотеку → **Run** (прво покретање ће вероватно јавити грешку)
2. Отворите **Run → Edit Configurations...**
3. Изаберите конфигурацију за JavaFX пример
4. У поље **VM options** додајте (или **Modify options → Add VM options** ако поље није видљиво):

   На **macOS**:
   ```
   --module-path lib/javafx/mac --add-modules javafx.controls,javafx.fxml
   ```
   На **Windows**:
   ```
   --module-path lib/javafx/win --add-modules javafx.controls,javafx.fxml
   ```
   На **Linux**:
   ```
   --module-path lib/javafx/linux --add-modules javafx.controls,javafx.fxml
   ```

5. Кликните **Apply**, затим **OK** и поново покрените пример

> **Савет:** Можете копирати VM опције из једне конфигурације у другу да не куцате поново за сваки JavaFX пример.

## Подешавање пројекта у Eclipse

### Корак 1 — Увоз пројекта

1. Покрените Eclipse
2. Изаберите **File → Import... → General → Existing Projects into Workspace**
3. Кликните **Browse...** и пронађите клонирани директоријум
4. Ако Eclipse не препозна пројекат, изаберите **File → New → Java Project**, уклоните квачицу **Use default location** и наведите путању до клонираног директоријума

### Корак 2 — Подешавање JDK и изворних директоријума

1. Кликните десним тастером на пројекат → **Properties → Java Build Path**
2. Картица **Source**:
   - Додајте `src` као изворни директоријум
   - Додајте `resources` као изворни директоријум
3. Картица **Libraries**:
   - Подесите **JRE System Library** на JDK 25
   - Кликните **Add JARs...** и додајте све JAR датотеке из сваког поддиректоријума у `lib/` (исто као у Кораку 4 за IntelliJ)
   - За `lib/javafx/` додајте само JAR датотеке за своју платформу

### Корак 3 — Кодирање

1. Кликните десним тастером на пројекат → **Properties → Resource**
2. Подесите **Text file encoding** на `UTF-8`

### Корак 4 — JavaFX конфигурација

1. Кликните десним тастером на JavaFX класу → **Run As → Run Configurations...**
2. Картица **Arguments → VM arguments**:
   ```
   --module-path lib/javafx/<платформа> --add-modules javafx.controls,javafx.fxml
   ```
   (замените `<платформа>` са `mac`, `win` или `linux`)

## Решавање честих проблема

| Проблем | Решење |
|---------|--------|
| `error: package javafx.* does not exist` | Нисте додали JavaFX JAR датотеке или недостају VM опције `--module-path` и `--add-modules` |
| `ClassNotFoundException: org.junit.jupiter.*` | Додајте све JAR датотеке из `lib/junit/` у библиотеке пројекта |
| Ћирилица се приказује као `????` или `ÐÐ°Ð¼Ð¾` | Подесите кодирање на UTF-8 (Корак 5 у IntelliJ упутству) |
| `persistence.xml not found` | Директоријум `resources` мора бити означен као **Resources** (не Sources) |
| `NoClassDefFoundError: org/hibernate/*` | Додајте **све** JAR датотеке из `lib/hibernate/` (укључујући `hibernate-commons-annotations` и `jakarta.xml.bind-api`) |
| JavaFX пример се не покреће на Windows/Linux | Проверите да користите `lib/javafx/win/` односно `lib/javafx/linux/` уместо `mac/` |
| `error: release version 25 not supported` | Инсталирајте JDK 25 и подесите га као Project SDK |

## Аутори

Сташа Вујичић Станковић, Владимир Филиповић, Александар Картељ, Душан Тошић

Математички факултет, Универзитет у Београду
