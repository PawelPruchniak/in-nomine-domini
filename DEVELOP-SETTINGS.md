**Code Style**

Aby ustandaryzować wygląd kodu w naszym projekcie powinniśmy używać jednolitych ustawień formatowania kodu.
1. Należy wejść do Settings -> Code Style -> Settings obok nazwy profilu -> Zaimportować plik code-style-settings.xml i używać go jako domyślny.
2. Plik code-style-settings.xml znajduję się w model-commom/src/main/resources.
3. Po skończonej edycji danej klasy, zawsze należy zformatować kod za pomocą **CTRL+ALT+L**.
4. Można też przy ustawieniach commita ustawić opcję "Reformat code"


**SonarLint**
1. Pobrac SonarLint i skonfigurować go tak, aby lokalnie przeprowadzał analizy.
2. Przed każdym wypchnięciem commitów (wiekszość) warningu sonarLint powinna być rozwiązana.

**Przydatne Pluginy**
1. Grep Console - pozwala ustawić kolor logów w konsoli, najlepiej odpowiednio: INFO-szary, WARN-żółty, ERROR-czerwony.
2. Rainbow brackets - koloruje brackets w kodzie, pozwala to na zwiększenie czytelności kodu.


**Branches Development**
1. master-backend - wydawanie sprawdzonej wersji dla frontendu z brancha development-backend
2. development-backend - proces developmentu rebasowanie wszystkich fixow i features
3. backend-pawel / backend-krzysiek - branche do małych fixów, szybkich zmian itp.
4. feature/XXXX - branch do rozwoju konkretnego zadania z jiry, gdzie XXXX to number taska z jiry.


**Line Separators**
1. Good development practise is to use LF line separators instead of CRLF(default on windows)
2. Go to Settings -> Code Style -> Line Separators -> set it to "Unix and macOs \n"
3. Go to Settings -> Git -> CHECK "Warn if CRLF line separators is about to commit"