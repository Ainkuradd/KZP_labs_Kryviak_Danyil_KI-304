from math_module import calculate_y, write_to_text, read_from_text, write_to_binary, read_from_binary

def main():
    print("Програма обчислює y = tg(x) / ctg(x)")
    print("Введіть значення x у градусах (можна кілька через пробіл):")

    # Введення кількох значень x
    try:
        user_input = input("x = ")
        xs = [float(i) for i in user_input.split()]
    except ValueError:
        print("Помилка: введіть лише числа.")
        return

    # Обчислення для кожного x
    results = [(x, calculate_y(x)) for x in xs]

    # Запис у файли
    write_to_text("results.txt", results)
    write_to_binary("results.bin", results)

    # Вивід результатів з текстового файлу
    print("\n=== Вміст текстового файлу ===")
    print(read_from_text("results.txt"))

    # Вивід результатів з двійкового файлу
    print("=== Вміст двійкового файлу (прочитано) ===")
    binary_data = read_from_binary("results.bin")
    for x, y in binary_data:
        print(f"x = {x:.2f}°, y = {y:.6f}")

if __name__ == "__main__":
    main()
