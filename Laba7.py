def main():
    nRows = int(input("Введіть розмір квадратної матриці: "))
    filler1 = input("Введіть перший символ-заповнювач: ")
    filler2 = input("Введіть другий символ-заповнювач: ")

    # перевіряємо, що обидва символи по одному
    if len(filler1) != 1 or len(filler2) != 1:
        print("Потрібно ввести рівно один символ у кожному полі!")
        return

    with open("MyFile.txt", "w", encoding="utf-8") as fout:
        for i in range(nRows):
            # 🔹 тут ми вибираємо символ залежно від парності рядка
            if i % 2 == 0:
                symbol = filler1
            else:
                symbol = filler2

            line = ""
            for j in range(nRows):
                if j >= nRows - 1 - i:
                    line += symbol + " "
                else:
                    line += "  "
            print(line)
            fout.write(line + "\n")

    print("Результат збережено у файл MyFile.txt")
if __name__ == "__main__":
    main()
