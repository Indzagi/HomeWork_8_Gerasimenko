import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        firstAndLastName();                        // Задание №1
        convectorNumberOfAscii();                  // Задание №2
        aDnDSystemСountTheNumberOfHoed();          // Задание №3
        nameAlfaIsShort();                         // Задание №4
        nameOfUnknownWorldAndLength();             // Задание №5
        passwordGenerationMain();                  // Задание №6
        sortingLatinSymbols();                     // Задание №7
        czechWordsArray();                         // Задания №8
        computerScienceToFormat();                 // Задания №9
        helloWorlTheOtherWayAround();              // Задание №10
        wordСorrectionFunction();                  // Задание №11
        sumNumbersOfSymbolsFunction();             // Задание №12
        CheckingForANumberInTheText();             // Задание №13
        switchSymbolsFunctionMain();               // Задание №14
        prisonerNumberRegardingHisNameAndSurname();// Задание №15

    }

    /**
     * 1.	Создать массив char, который хранит имя и фамилию через пробел согласно таблице ASCII
     **/

    static void firstAndLastName() {
        System.out.println("Задание №1" + '\n' + "Массив char будет хранить имя и фамилию Garry Merlin");
        char[] firstAndLastNameArray = new char[]{71, 97, 114, 114, 121, 32, 77, 101, 114, 108, 105, 110};

        System.out.println(firstAndLastNameArray);
    }

    /**
     * 2.	Написать конвертор из числа в символ из таблицы ASCII.
     * Если пользователь вводит неверное значение, то уведомить его ошибкой в консоль
     **/

    static void convectorNumberOfAscii() {
        System.out.println('\n' + "Задание №2" + '\n' + "Введите значение от 0 " +
                "до 127 для вывода символа из таблицы ASCII");
        Scanner scanner = new Scanner(System.in);
        int nubmer = scanner.nextInt();

        if (nubmer >= 0 && nubmer < 128) {
            char symbol = (char) nubmer;

            System.out.println("Под числовым значением = " + nubmer + " таблицы ASCII"
                    + " находится символ - ' " + symbol + " '");
        } else {
            System.out.println("Вы ввели значение, выходящее из диапазона таблицы ASCII");
            convectorNumberOfAscii();
        }
    }

    /**
     * 3.	В вашей армии состоит 54 существа. Все они записаны у вас в виде массива
     * с обозначением H (Human), О (Orc), E (Elf), D (Dwarf). Напишите функцию, которая
     * считает кого у вас больше. [H, O, O, D, E, H ...]
     **/

    static void aDnDSystemСountTheNumberOfHoed() {
        System.out.println('\n' + "Задание №3" + '\n' + "Функция для подсчета самой " +
                "многочисленной рассы в армии" + '\n');
        char[] aDnDSystemArray = new char[54];
        int[] numbersOfSymbolWithRandom = {72, 79, 69, 68};
        int humanArmy = 0;        //72 - Human
        int orcArmy = 0;          //79 - Orc
        int elfArmy = 0;          //69 - Elf
        int dwarfArmy = 0;        //68 - Dwarf

        randomSymbolOfArmy(aDnDSystemArray, numbersOfSymbolWithRandom);

        humanArmy = countingTheNumberOfCreaturesInTheArmy(aDnDSystemArray,
                humanArmy, numbersOfSymbolWithRandom, 0);
        orcArmy = countingTheNumberOfCreaturesInTheArmy(aDnDSystemArray, orcArmy,
                numbersOfSymbolWithRandom, 1);
        elfArmy = countingTheNumberOfCreaturesInTheArmy(aDnDSystemArray,
                elfArmy, numbersOfSymbolWithRandom, 2);
        dwarfArmy = countingTheNumberOfCreaturesInTheArmy(aDnDSystemArray,
                dwarfArmy, numbersOfSymbolWithRandom, 3);

        int[] allArmyArray = {humanArmy, orcArmy, elfArmy, dwarfArmy};

//        System.out.println("72 Human " + humanArmy); //оставлю для проверки
//        System.out.println("79 Orc " + orcArmy);
//        System.out.println("69 Elf " + elfArmy);
//        System.out.println("68 Dwarf " + dwarfArmy);

        printArrayChar(aDnDSystemArray);  //оставлю для проверки

        sortingallArmyArrayToTheLargest(allArmyArray, numbersOfSymbolWithRandom);

//        printArrayInt(allArmyArray); //оставлю для проверки

//        printArrayInt(numbersOfSymbolWithRandom); //оставлю для проверки

        theLargestNumberOfArmyCharacters(allArmyArray, numbersOfSymbolWithRandom);
    }

    static int[] sortingallArmyArrayToTheLargest(int[] allArmyArray,
                                                 int[] numbersOfSymbolWithRandom) {
        for (int i = 0; i < allArmyArray.length - 1; i++) {
            for (int j = 0; j < allArmyArray.length - i - 1; j++) {
                if (allArmyArray[j] > allArmyArray[j + 1]) {
                    int temp = allArmyArray[j];
                    allArmyArray[j] = allArmyArray[j + 1];
                    allArmyArray[j + 1] = temp;

                    int temp2 = numbersOfSymbolWithRandom[j];
                    numbersOfSymbolWithRandom[j] = numbersOfSymbolWithRandom[j + 1];
                    numbersOfSymbolWithRandom[j + 1] = temp2;
                }
            }
        }
        return allArmyArray;
    }

    static void theLargestNumberOfArmyCharacters(int[] allArmyArray, int[] numbersOfSymbolWithRandom) {

        sortingallArmyArrayToTheLargest(allArmyArray, numbersOfSymbolWithRandom);
        if (allArmyArray[3] > allArmyArray[2] && numbersOfSymbolWithRandom[3] == 72) {
            System.out.println("В Армии больше всего Humans, их кол-во " + allArmyArray[3] + " существ");

        } else if (allArmyArray[3] > allArmyArray[2] && numbersOfSymbolWithRandom[3] == 79) {
            System.out.println("В Армии больше всего Orcs, их кол-во " + allArmyArray[3] + " существ");

        } else if (allArmyArray[3] > allArmyArray[2] && numbersOfSymbolWithRandom[3] == 69) {
            System.out.println("В Армии больше всего Elf's, их кол-во " + allArmyArray[3] + " существ");

        } else if (allArmyArray[3] > allArmyArray[2] && numbersOfSymbolWithRandom[3] == 68) {
            System.out.println("В Армии больше всего Dwarfs, их кол-во " + allArmyArray[3] + " существ");

        } else if ((allArmyArray[2] == allArmyArray[3]) && ((numbersOfSymbolWithRandom[3] == 72)
                && (numbersOfSymbolWithRandom[2] == 79)) || ((numbersOfSymbolWithRandom[2] == 72)
                && (numbersOfSymbolWithRandom[3] == 79))) {
            System.out.println("В Армии присутствует одинаковое кол-во существ двух расс,а имеено -  Humans и Orcs," +
                    " кол-во существ каждой рассы " + allArmyArray[3]);

        } else if ((allArmyArray[2] == allArmyArray[3]) && ((numbersOfSymbolWithRandom[3] == 72)
                && (numbersOfSymbolWithRandom[2] == 69)) || ((numbersOfSymbolWithRandom[2] == 72)
                && (numbersOfSymbolWithRandom[3] == 69))) {
            System.out.println("В Армии присутствует одинаковое кол-во существ двух расс,а имеено -  Humans и Elf's," +
                    " кол-во существ каждой рассы " + allArmyArray[3]);

        } else if ((allArmyArray[2] == allArmyArray[3]) && ((numbersOfSymbolWithRandom[3] == 72)
                && (numbersOfSymbolWithRandom[2] == 68)) || ((numbersOfSymbolWithRandom[2] == 72)
                && (numbersOfSymbolWithRandom[3] == 68))) {
            System.out.println("В Армии присутствует одинаковое кол-во существ двух расс,а имеено -  Humans и Dwarfs," +
                    " кол-во существ каждой рассы " + allArmyArray[3]);

        } else if ((allArmyArray[2] == allArmyArray[3]) && ((numbersOfSymbolWithRandom[3] == 79)
                && (numbersOfSymbolWithRandom[2] == 69)) || ((numbersOfSymbolWithRandom[2] == 79)
                && (numbersOfSymbolWithRandom[3] == 69))) {
            System.out.println("В Армии присутствует одинаковое кол-во существ двух расс,а имеено -  Orcs и Elf's," +
                    " кол-во существ каждой рассы " + allArmyArray[3]);

        } else if ((allArmyArray[2] == allArmyArray[3]) && ((numbersOfSymbolWithRandom[3] == 79)
                && (numbersOfSymbolWithRandom[2] == 68)) || ((numbersOfSymbolWithRandom[2] == 79)
                && (numbersOfSymbolWithRandom[3] == 68))) {
            System.out.println("В Армии присутствует одинаковое кол-во существ двух расс,а имеено -  Orcs и Dwarfs," +
                    " кол-во существ каждой рассы " + allArmyArray[3]);

        } else if ((allArmyArray[2] == allArmyArray[3]) && ((numbersOfSymbolWithRandom[3] == 69)
                && (numbersOfSymbolWithRandom[2] == 68)) || ((numbersOfSymbolWithRandom[2] == 69)
                && (numbersOfSymbolWithRandom[3] == 68))) {
            System.out.println("В Армии присутствует одинаковое кол-во существ двух расс,а имеено -  Elf's и Dwarfs," +
                    " кол-во существ каждой рассы " + allArmyArray[3]);

        } else {
            System.out.println("Три из четырех расс имеют одинаковое кол-во существ" + allArmyArray[3]);
        }
    }

    static int countingTheNumberOfCreaturesInTheArmy(char[] aDnDSystemArray, int countOfCreatures,
                                                     int[] numbersOfSymbolWithRandom, int j) {
        for (int i = 0; i < aDnDSystemArray.length; i++) {
            if (aDnDSystemArray[i] == numbersOfSymbolWithRandom[j]) {
                countOfCreatures += 1;
            }
        }
        return countOfCreatures;
    }

    static void randomSymbolOfArmy(char[] aDnDSystemArray, int[] numbersOfSymbolWithRandom) {
        for (int i = 0; i < aDnDSystemArray.length; i++) {
            int randomSumbol = (int) (Math.random() * 4);
            aDnDSystemArray[i] = (char) numbersOfSymbolWithRandom[randomSumbol];
        }
    }

    static void printArrayInt(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}" + '\n');
    }

    static void printArrayChar(char[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}" + '\n');
    }

    /**
     * 4.	Существует выдуманное имя Alpha. Спустя тысячелетия, имя перекочевало по множествам
     * миров и приобрело форму типичную для локального диалекта, но произношение осталось неизменным.
     * Ученые собрали информацию о возможных именах в массив и решились определить есть ли среди имен
     * [Alpha, Alfa, Alpfa] самое короткое. Найти самое короткое имя и вывести его в консоль для обозрения
     **/

    static void nameAlfaIsShort() {
        System.out.println('\n' + "Задание №4" + '\n' + "Определение самого коротного имени Альфа" + '\n');
        String[] alfaNames = {"Alpha", "Alfa", "Alpfa"};

        String alpha = alfaNames[0];
        String alfa = alfaNames[1];
        String alpfa = alfaNames[2];

        sortingNamesAlfa(alpha, alfa, alpfa);
    }

    static void sortingNamesAlfa(String alpha, String alfa, String alpfa) {

        if (alpha.length() < alfa.length() && alpha.length() < alpfa.length()) {
            System.out.println(alpha + " Является самым коротким именем из всех, собраных учеными имен Альфа");

        } else if (alfa.length() < alpha.length() && alfa.length() < alpfa.length()) {
            System.out.println(alfa + " Является самым коротким именем из всех, собраных учеными имен Альфа");

        } else if (alpfa.length() < alpha.length() && alpfa.length() < alfa.length()) {
            System.out.println(alpfa + " Является самым коротким именем из всех, собраных учеными имен Альфа");

        } else if (alpha.length() == alfa.length() && alfa.length() == alpfa.length()) {
            System.out.println("Все имена имеют одинаковую длину");

        } else {
            System.out.println("Несколько и более значений имеют самую коротку длину");
        }
    }

    /* 5.	Дано название неизведанного мира. Определить количество символов в его названии*/

    static void nameOfUnknownWorldAndLength() {
        System.out.println('\n' + "Задание №5" + '\n' + "Введите название неизведанного мира" + '\n');
        Scanner scanner = new Scanner(System.in);
        String nameOfWorld = scanner.nextLine();

        System.out.println("Количество символов в названии мира " + nameOfWorld + " = " + nameOfWorld.length());

    }

    /**
     * 6.	Создать генератор паролей, который будет генерировать случайные пароли по следующим правилам:
     * -	Пароль состоит из 8 символов
     * -	В пароле допускаются только латинские большие и маленькие буквы, цифры и символ подчеркивания
     * -	Пароль обязательно должен содержать Большие и маленькие буквы и цифры
     **/

    static void passwordGenerationMain() {
        System.out.println('\n' + "Задание №6" + '\n' + "Программа генерации случайных паролей с" +
                " обязательной большой и маленькой латинскими буквами и цифрой" + '\n');
        char[] bigLetters = new char[0];
        char[] smallLetters = new char[0];
        char[] numbers = new char[0];

        char[] password = new char[8];

        char randomSymbolToPasswordBigLetters = 0;
        char randomSymbolToPasswordSmallLetters = 0;
        char randomSymbolToPasswordNumbers = 0;

        bigLetters = fillingOut(bigLetters, 65, 90);
        smallLetters = fillingOut(smallLetters, 97, 122);
        numbers = fillingOut(numbers, 48, 57);

        numbers = addSymbolUnderline(numbers);

        char tempSymbolOfRandomSymbolsFromPassword = randomSymbolGenerationToPassword(
                randomSymbolToPasswordBigLetters, randomSymbolToPasswordSmallLetters,
                randomSymbolToPasswordNumbers, bigLetters, smallLetters, numbers);

        passwordGeneration(password, randomSymbolToPasswordBigLetters, randomSymbolToPasswordSmallLetters,
                randomSymbolToPasswordNumbers, bigLetters, smallLetters, numbers, tempSymbolOfRandomSymbolsFromPassword);

        printArrayChar(password);
    }

    static char[] passwordGeneration(
            char[] password, char randomSymbolToPasswordBigLetters,
            char randomSymbolToPasswordSmallLetters, char randomSymbolToPasswordNumbers,
            char[] bigLetters, char[] smallLetters, char[] numbers,
            char tempSymbolOfRandomSymbolsFromPassword) {

        for (int i = 3; i < password.length; i++) {

            while (password[0] != tempSymbolOfRandomSymbolsFromPassword) { // первая - обязательно большая буква

                tempSymbolOfRandomSymbolsFromPassword = randomSymbolGenerationToPassword(
                        randomSymbolToPasswordBigLetters, randomSymbolToPasswordSmallLetters,
                        randomSymbolToPasswordNumbers, bigLetters, smallLetters, numbers);

                for (int j = 0; j < bigLetters.length; j++) {

                    if (tempSymbolOfRandomSymbolsFromPassword == bigLetters[j]) {

                        password[0] = tempSymbolOfRandomSymbolsFromPassword;
                    }
                }
            }

            while (password[1] != tempSymbolOfRandomSymbolsFromPassword) { //вторая - обязательно маленькая буква

                tempSymbolOfRandomSymbolsFromPassword = randomSymbolGenerationToPassword(
                        randomSymbolToPasswordBigLetters, randomSymbolToPasswordSmallLetters,
                        randomSymbolToPasswordNumbers, bigLetters, smallLetters, numbers);

                for (int j = 0; j < smallLetters.length; j++) {

                    if (tempSymbolOfRandomSymbolsFromPassword == smallLetters[j]) {

                        password[1] = tempSymbolOfRandomSymbolsFromPassword;
                    }
                }
            }

            while (password[2] != tempSymbolOfRandomSymbolsFromPassword) { // третье значение - обязательно число от 0 до 9

                tempSymbolOfRandomSymbolsFromPassword = randomSymbolGenerationToPassword(
                        randomSymbolToPasswordBigLetters, randomSymbolToPasswordSmallLetters,
                        randomSymbolToPasswordNumbers, bigLetters, smallLetters, numbers);

                for (int j = 0; j < numbers.length - 1; j++) {

                    if (tempSymbolOfRandomSymbolsFromPassword == numbers[j]) {

                        password[2] = tempSymbolOfRandomSymbolsFromPassword;
                    }
                }
            }

            password[i] = tempSymbolOfRandomSymbolsFromPassword; // начиная с 4го значения - рандом
        }
        return password;
    }

    static char randomSymbolGenerationToPassword(
            char randomSymbolToPasswordBigLetters,
            char randomSymbolToPasswordSmallLetters,
            char randomSymbolToPasswordNumbers, char[] bigLetters,
            char[] smallLetters, char[] numbers) {

        randomSymbolToPasswordBigLetters = randomSymbolGeneration(bigLetters, randomSymbolToPasswordBigLetters);
        randomSymbolToPasswordSmallLetters = randomSymbolGeneration(smallLetters, randomSymbolToPasswordSmallLetters);
        randomSymbolToPasswordNumbers = randomSymbolGeneration(numbers, randomSymbolToPasswordNumbers);

        char tempSymbolOfRandomSymbolsFromPassword = 0;

        char[] tempArrayOfRandomSymbolsFromPassword = {randomSymbolToPasswordBigLetters,
                randomSymbolToPasswordSmallLetters, randomSymbolToPasswordNumbers};

        tempSymbolOfRandomSymbolsFromPassword = randomSymbolGeneration(
                tempArrayOfRandomSymbolsFromPassword, tempSymbolOfRandomSymbolsFromPassword);

        return tempSymbolOfRandomSymbolsFromPassword;
    }

    static char[] fillingOut(char[] arrayOfSymbol, int min, int max) {

        int lengthOfArray = max - min + 1;
        arrayOfSymbol = new char[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            arrayOfSymbol[i] = (char) (min + i);
        }

        return arrayOfSymbol;
    }

    static char[] addSymbolUnderline(char[] numbers) {
        fillingOut(numbers, 48, 57);
        char[] temp = numbers;

        numbers = new char[temp.length + 1];

        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = temp[i];
        }
        numbers[temp.length] = 95;
        return numbers;
    }

    static char randomSymbolGeneration(char[] massivOfSymbol, char randomSymbolToPassword) {

        int randomSumbol = (int) (Math.random() * (massivOfSymbol.length));
        randomSymbolToPassword = massivOfSymbol[randomSumbol];

        return randomSymbolToPassword;
    }

    /**
     * 7.	Специалисты по латинском алфавиту собрали все возможные буквы (маленькие и большие) и
     * записали их на отдельные листки, после отсортировав. Во время ланча, из-за незакрытого окна,
     * ветер разнес все листки по кабинету. Команда сумела их собрать, но отсортировать там и не удалось.
     * Необходимо отсортировать алфавит от маленьких букв к большим по их порядковому возрастанию,
     * как настоящих алфавитах
     * К примеру, EadAcDeC должно превратится в acdeACDE
     **/

    static void sortingLatinSymbols() {
        System.out.println('\n' + "Задание №7" + '\n' + "Программа сортировки алфавита от " +
                "маленьких букв к большим по их порядковому возрастанию, как в настоящих алфавитах" + '\n');

        char[] latinSymbolsArray = new char[0];

        latinSymbolsArray = latinSymbolArrayFormation(latinSymbolsArray);

        printArrayChar(latinSymbolsArray);

        theWindBlew(latinSymbolsArray);

        printArrayChar(latinSymbolsArray);

        finishSortinglatinSymbols(sortInDescendingOrder(latinSymbolsArray));

        System.out.println('\n' + "Мы помогли отсортировать алфавит от маленьких букв к " +
                "большим по их порядковому возрастанию, как в настоящих алфавитах");
        printArrayChar(latinSymbolsArray);
    }

    static char[] finishSortinglatinSymbols(char[] latinSymbolsArray) {
        for (int i = 0; i < latinSymbolsArray.length / 2; i++) {
            for (int j = 0; j < latinSymbolsArray.length / 2 - 1; j++) {
                if (latinSymbolsArray[j] > latinSymbolsArray[j + 1]) {
                    int temp = latinSymbolsArray[j];
                    latinSymbolsArray[j] = latinSymbolsArray[j + 1];
                    latinSymbolsArray[j + 1] = (char) temp;
                }
            }
        }
        for (int i = 26; i < latinSymbolsArray.length; i++) {
            for (int j = 26; j < latinSymbolsArray.length - 1; j++) {
                if (latinSymbolsArray[j] > latinSymbolsArray[j + 1]) {
                    int temp = latinSymbolsArray[j];
                    latinSymbolsArray[j] = latinSymbolsArray[j + 1];
                    latinSymbolsArray[j + 1] = (char) temp;
                }
            }
        }
        return latinSymbolsArray;
    }


    static char[] sortInDescendingOrder(char[] latinSymbolsArray) {

        for (int i = latinSymbolsArray.length - 1; i > 0; i--) {

            for (int j = latinSymbolsArray.length - i; j > 0; j--) {

                if (latinSymbolsArray[j] > latinSymbolsArray[j - 1]) {
                    int temp = latinSymbolsArray[j];
                    latinSymbolsArray[j] = latinSymbolsArray[j - 1];
                    latinSymbolsArray[j - 1] = (char) temp;
                }
            }
        }
        return latinSymbolsArray;
    }

    static char[] theWindBlew(char[] latinSymbolsArray) {
        System.out.println('\n' + "Начался ветер!!!!! Буквы разбросаны!!!!");
        for (int i = 0; i < latinSymbolsArray.length - 2; i += 2) {
            char temp1 = latinSymbolsArray[i];
            latinSymbolsArray[i] = latinSymbolsArray[i + 2];
            latinSymbolsArray[i + 2] = temp1;
            for (int j = 0; j < latinSymbolsArray.length - 3; j += 3) {
                char temp2 = latinSymbolsArray[j];
                latinSymbolsArray[j] = latinSymbolsArray[j + 3];
                latinSymbolsArray[j + 3] = temp2;
                for (int k = 0; k < latinSymbolsArray.length - 4; k += 4) {
                    char temp3 = latinSymbolsArray[k];
                    latinSymbolsArray[k] = latinSymbolsArray[k + 4];
                    latinSymbolsArray[k + 4] = temp3;
                }
            }
        }
        return latinSymbolsArray;
    }

    static char[] latinSymbolArrayFormation(char[] latinSymbolsArray) {

        latinSymbolsArray = generateArrayLatinSymbols(latinSymbolsArray, 97, 122, 0); //97 -122

        char[] copyArray = latinSymbolsArray;

        latinSymbolsArray = generateArrayLatinSymbols(latinSymbolsArray, 65, 90, 27); // 65 - 90

        for (int i = 0; i < latinSymbolsArray.length - 26; i++) {
            latinSymbolsArray[i] = copyArray[i];
        }

        return latinSymbolsArray;
    }

    static char[] generateArrayLatinSymbols(char[] latinSymbolsArray, int min, int max, int start) {
        if (start == 27) {
            start = 26;
        }
        int j = 0;
        int lengthOfArray = start + max - min + 1;
        latinSymbolsArray = new char[lengthOfArray];

        if (start == 0) {
            start = 1;
        } else if (start == 26) {
            start = 27;
        }
        for (int i = start - 1; i < lengthOfArray; i++) {
            latinSymbolsArray[i] = (char) (min + j);
            j++;
        }
        return latinSymbolsArray;
    }

    /**
     * 8.	Дано выражение на чешском языке správné řešení úkolu. Написать эквивалентное выражение
     * при помощи Unicode и сохранить его в виде массива. Результат вывести в консоль
     **/

    static void czechWordsArray() {
        System.out.println('\n' + "Задание №8" + '\n' + "Вывести эквивалентное даному " +
                "выражение в консоль, создав его при помощи Unicode в массиве" + '\n');

        String czechWords = "správné řešení úkolu";

        char[] czechWordsEquivalentArray = new char[0];

        String czechWordsEquivalent = "\u0073" + "\u0070" + "\u0072" + "\u00e1" + "\u0076" + "\u006e"
                + "\u00e9" + '\u0020' + "\u0159" + "\u0065" + "\u0161" + "\u0065" + "\u006e" +
                "\u00ed" + "\u0020" + "\u00fa" + "\u006b" + "\u006f" + "\u006c" + "\u0075";

        System.out.println("Эквивалентное выражение из строки = " + czechWordsEquivalent + '\n');

        czechWordsEquivalentArray = stringEquivalentToArrayFunction(czechWordsEquivalent, czechWordsEquivalentArray);

        System.out.print("Эквивалентное выражение из массива = ");
        printArrayCharWithoutCommas(czechWordsEquivalentArray);
    }

    static char[] stringEquivalentToArrayFunction(String czechWordsEquivalent, char[] czechWordsEquivalentArray) {

        czechWordsEquivalentArray = new char[czechWordsEquivalent.length()];

        for (int i = 0; i < czechWordsEquivalent.length(); i++) {

            czechWordsEquivalentArray[i] = czechWordsEquivalent.charAt(i);
        }
        return czechWordsEquivalentArray;
    }

    static void printArrayCharWithoutCommas(char[] czechWordsEquivalentArray) {
        for (int i = 0; i < czechWordsEquivalentArray.length; i++) {
            System.out.print(czechWordsEquivalentArray[i]);
        }
        System.out.println('\n');
    }

    /**
     * 9.	Дано слово Информатика. Пусть “вырезания” и “склеивания” сформировать строку форма Ин тик
     **/

    static void computerScienceToFormat() {
        System.out.println('\n' + "Задание №9" + '\n' + "С помощью вырезания и склеивания " +
                "сформировать строку - \"форма Ин тик\" " + '\n');

        String computerScience = "Информатика";

        char[] formatStringArray = new char[0]; // пробел в индексе 5 и 8

        formatStringArray = cuttingAndGluing(stringEquivalentToArrayFunction(computerScience, formatStringArray));

        printArrayCharWithoutCommas(formatStringArray);
    }

    static char[] cuttingAndGluing(char[] formatStringArray) {

        char[] formatStringArrayCopy = new char[formatStringArray.length + 1];

        char tempChar;

        for (int i = 2; i < formatStringArray.length - 4; i++) {

            tempChar = formatStringArray[i - 2];
            formatStringArray[i - 2] = formatStringArray[i];
            formatStringArray[i] = tempChar;
        }
        copyStringArrayToStringArrayLonger(formatStringArrayCopy, formatStringArray);

        for (int i = formatStringArrayCopy.length - 3; i > 5; i--) {

            if (i == 7) {
                formatStringArrayCopy[i + 2] = formatStringArrayCopy[i];
                formatStringArrayCopy[i + 1] = '\u0020';
            } else if (i == 6) {
                formatStringArrayCopy[i + 1] = formatStringArrayCopy[i - 1];
                formatStringArrayCopy[i - 1] = '\u0020';
            } else {
                formatStringArrayCopy[i + 2] = formatStringArrayCopy[i];
            }
        }
        return formatStringArrayCopy;
    }

    static char[] copyStringArrayToStringArrayLonger(char[] formatStringArrayCopy, char[] formatStringArray) {

        for (int i = 0; i < formatStringArray.length; i++) {
            formatStringArrayCopy[i] = formatStringArray[i];
        }
        return formatStringArrayCopy;
    }

    /**
     * 10.	 Дано предложение Hello, World! Необходимо его развернуть !dlroW ,olleH
     **/


    static void helloWorlTheOtherWayAround() {
        System.out.println('\n' + "Задание №10" + '\n' + "Программа разворота предложения " +
                "Hello, World! в !dlroW ,olleH" + '\n');

        String helloWorld = "Hello, World!";
        char[] helloWorldArray = new char[0];

        helloWorldArray = stringEquivalentToArrayFunction(helloWorld, helloWorldArray);

        helloWorldAround(helloWorldArray);

        System.out.println("На выходе получаем");
        printArrayCharWithoutCommas(helloWorldArray);
    }

    static char[] helloWorldAround(char[] helloWorldArray) {
        char temp;
        for (int i = 0; i < helloWorldArray.length - i; i++) {
            temp = helloWorldArray[helloWorldArray.length - 1 - i];
            helloWorldArray[helloWorldArray.length - 1 - i] = helloWorldArray[i];
            helloWorldArray[i] = temp;
        }
        return helloWorldArray;
    }

    /**
     * 11.	Преподаватель языковой школы проверяет домашнее задание ученика И
     * Ученик И создал массив с словесными выражениями, которые содержать ошибки [“Даная книга”, “Ложька”, “Йолка”].
     * Программа выводит в консоль данные массива и последовательно начинает исправлять ошибки, затем
     * результат выводит в консоль
     **/

    static void wordСorrectionFunction() {
        System.out.println('\n' + "Задание №11" + '\n' + "Программа исправления орфографии" + '\n');

        String[] wordsMistakesArray = {"Даная книга", "Ложька", "Йолка"};
        String[] wordsWithoutMistakesArray = {"Данная книга", "Ложка", "Ёлка"};

        String[] correctWords;

        System.out.print("Ученик сдал домашнее задание с ошибками: ");
        printArrayStringWithoutCommas(wordsMistakesArray);
        System.out.print('\n');
        correctWords = test(wordsMistakesArray, wordsWithoutMistakesArray);
        System.out.print("Выводим полностью исправленный массив слов: ");
        printArrayStringWithoutCommas(correctWords);
    }

    static String[] test(String[] wordsMistakesArray, String[] wordsWithoutMistakesArray) {

        for (int i = 0; i < wordsMistakesArray.length; i++) {
            if (!wordsMistakesArray[i].equals(wordsWithoutMistakesArray[i])) {

                System.out.printf("Мы исправили орфографию %d индекса массива с \"%s\"" +
                        " на \"%s\" и записали в масив \n", i, wordsMistakesArray[i], wordsWithoutMistakesArray[i]);
                wordsMistakesArray[i] = wordsWithoutMistakesArray[i];
            }
        }
        return wordsMistakesArray;
    }

    static void printArrayStringWithoutCommas(String[] MassivForStrings) {
        System.out.print("{");
        for (int i = 0; i < MassivForStrings.length; i++) {
            System.out.print(MassivForStrings[i]);
            if (i < MassivForStrings.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}" + '\n');
    }

    /**
     * 12.	 Пользователь вводит с клавиатуры произвольный текст (не более 5 символов) на
     * английском языке. Необходимо вычислить сумму числового представлениях всех вместе взятых символов
     **/

    static void sumNumbersOfSymbolsFunction() {
        System.out.println('\n' + "Задание №12" + '\n' + "Программа вычисления суммы" +
                " числового представлениях всех вместе взятых символов " + '\n');
        char[] ArrayToEnglishSymbols = new char[0];
        int sum;

        ArrayToEnglishSymbols = functionInitializationArrayToEnglishSymbols(ArrayToEnglishSymbols);
        printArrayChar(ArrayToEnglishSymbols);

        sum = symbolsInputFromTheConsole(ArrayToEnglishSymbols);

        System.out.printf("Сумма числовых значений введенных символов = %d", sum);
    }

    static char[] functionInitializationArrayToEnglishSymbols(char[] ArrayToEnglishSymbols) { // 65-90, 97 - 122

        int bigLittersNumber = 90 - 65 + 1;
        int smallLittersNumber = 122 - 97 + 1;
        ArrayToEnglishSymbols = new char[bigLittersNumber + smallLittersNumber];

        for (int i = 0; i < ArrayToEnglishSymbols.length / 2; i++) {

            ArrayToEnglishSymbols[i] = (char) (65 + i);
            ArrayToEnglishSymbols[26 + i] = (char) (97 + i);
        }
        return ArrayToEnglishSymbols;
    }

    static int symbolsInputFromTheConsole(char[] ArrayToEnglishSymbols) {
        System.out.println("Введите не более 5 английских символов");
        Scanner scanner = new Scanner(System.in);
        String symbolsInput = scanner.nextLine();
        int sum = 0;

        if (symbolsInput.length() > 5) {
            System.out.println("Вы ввели более 5 значений, ошибка...");
            return symbolsInputFromTheConsole(ArrayToEnglishSymbols);
        }

        for (int i = 0; i < symbolsInput.length(); i++) {
            for (int j = 0; j < ArrayToEnglishSymbols.length; j++) {
                if (symbolsInput.charAt(i) == ArrayToEnglishSymbols[j]) {
                    sum += ArrayToEnglishSymbols[j];
                }
            }
            if (sum == 0) {
                System.out.println("Вы ввели значения, не относящиеся к английским символам, ошибка...");
                return symbolsInputFromTheConsole(ArrayToEnglishSymbols);
            }
        }
        return sum;
    }

    /**
     * 13.	 Пользователь вводит с клавиатуры произвольный текст на английском языке. Выяснить,
     * содержиться ли в тексте хотя бы одна цифра
     **/

    static void CheckingForANumberInTheText() {
        System.out.println('\n' + "Задание №13" + '\n' + "Программа проверки наличия числовых" +
                " значений при вводе текста анлийскими символами, допускается ввод символов и чисел" + '\n');
        char[] arrayToEnglishSymbols = new char[0];
        char[] arrayToNumbers = new char[0];

        arrayToEnglishSymbols = functionInitializationArrayToEnglishSymbols(arrayToEnglishSymbols);

        arrayToNumbers = arrayFillingNumbersFunction(arrayToNumbers);

        symbolsInputFromTheConsoleAndCheckTheNumbers(arrayToEnglishSymbols, arrayToNumbers);
    }

    static char[] arrayFillingNumbersFunction(char[] ArrayToNumbers) {
        ArrayToNumbers = new char[10];
        for (int i = 0; i < ArrayToNumbers.length; i++) {
            ArrayToNumbers[i] = (char) (48 + i);
        }
        return ArrayToNumbers;
    }

    static int symbolsInputFromTheConsoleAndCheckTheNumbers(char[] arrayToEnglishSymbols, char[] arrayToNumbers) {
        System.out.println('\n' + "Введите произвольный текст на английском языке, допускаются цифры");
        Scanner scanner = new Scanner(System.in);
        String symbolsInput = scanner.nextLine();

        int tempNumber = 0;
        int tempNumber1 = 0;

        for (int i = 0; i < symbolsInput.length(); i++) {
            for (int j = 0; j < arrayToEnglishSymbols.length; j++) {
                if (symbolsInput.charAt(i) == arrayToEnglishSymbols[j]) {
                    tempNumber++;
                }
            }

            for (int j = 0; j < arrayToNumbers.length; j++) {

                if (symbolsInput.charAt(i) == arrayToNumbers[j]) {
                    tempNumber1++;
                }
            }
        }

        int sum = tempNumber + tempNumber1;

        if (sum < symbolsInput.length() && sum > 0) {
            System.out.printf("Кол-во цифр при вводе составило %d, при этом не все" +
                    " введенные символы на английском языке, просьба ввести данные заново! \n", tempNumber1);
            return symbolsInputFromTheConsoleAndCheckTheNumbers(arrayToEnglishSymbols, arrayToNumbers);

        } else if (sum == symbolsInput.length()) {
            System.out.printf("Кол-во цифр при вводе \"%s\" составило %d \n", symbolsInput, tempNumber1);

        } else {
            System.out.print("При вводе была допущена ошибка, просьба, ввести значения еще раз ... \n");
            return symbolsInputFromTheConsoleAndCheckTheNumbers(arrayToEnglishSymbols, arrayToNumbers);
        }

        return 0;
    }

    /**
     * 14.	Пользователь вводит с клавиатуры произвольное слово. Программа, после получения слова в работу,
     * должна поменять символы правой и левой части местами. К примеру, “Automoto” будет “otomotuA”
     **/

    static void switchSymbolsFunctionMain() {
        System.out.println('\n' + "Задание №14" + '\n' + "Программа замены символов " +
                "правой части слова и левой местами во введенном с консоли произвольном слове" + '\n');

        System.out.println("Введите произвольное слово...");
        Scanner scanner = new Scanner(System.in);
        String arbitraryWord = scanner.nextLine();

        System.out.println("Вы ввели значение " + arbitraryWord);

        arbitraryWord = switchSymbols(arbitraryWord);

        System.out.println("А получилось наоборот " + arbitraryWord);
    }

    static String switchSymbols(String arbitraryWord) {

        char[] tempArray = new char[arbitraryWord.length()];

        for (int i = 0; i < arbitraryWord.length(); i++) {

            tempArray[i] = arbitraryWord.charAt(arbitraryWord.length() - 1 - i);
        }
        arbitraryWord = new String(tempArray);

        return arbitraryWord;
    }


    /**
     * 15.	* В тюрьме для особо опасных преступников каждому заключенному присваивается номер.
     * Каждый номер рассчитывается на основе таблицы символов Unicode, в которой каждому символу
     * соответствует число. Посчитать сумму чисел своего имени и фамилии, заданных одной строкой
     * через пробел (например, “Джон Диллинджер”). Данная сумма и будет номером заключенного
     **/

    static void prisonerNumberRegardingHisNameAndSurname() {
        System.out.println('\n' + "Задание №15" + '\n' + "Программа вывода суммы чисел своего имени и " +
                "фамилии относительно таблицы символов Unicode" + '\n');
        int sum;
        System.out.println("Введите свое Имя и Фамилию через пробел...");
        Scanner scanner = new Scanner(System.in);
        String prisonerNameAndSurname = scanner.nextLine();

        System.out.println("Вы ввели имя и фамилию - " + prisonerNameAndSurname);
        sum =  stringToCharArrayUnicod(prisonerNameAndSurname);
        System.out.println("Сумма всех числовых значений символов Unicode = " + sum + " что соответствует номеру заключенного");
    }

    static int stringToCharArrayUnicod(String prisonerNameAndSurname) {
        int sum = 0;
        char[] unicodeCharsSymbols = new char[prisonerNameAndSurname.length()];
        for (int i = 0; i < prisonerNameAndSurname.length(); i++) {
            unicodeCharsSymbols[i] = prisonerNameAndSurname.charAt(i);
        }
        for (char c : unicodeCharsSymbols) { //подсмотрел в интернете, так как сам не понял, как осуществить перевод
            int code = (int) c;              //с чара в числовой номер в таблице Юникоды

            sum += code;
        }
        return sum;
    }

}









