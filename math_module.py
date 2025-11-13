import math
import struct

# Функція для обчислення виразу y = tg(x) / ctg(x)
def calculate_y(x_degrees):
    """
    Приймає кут у градусах, переводить його в радіани
    і обчислює y = tg(x) / ctg(x).
    """
    try:
        x_radians = math.radians(x_degrees)  # переведення у радіани
        tan_x = math.tan(x_radians)
        y = tan_x / (1 / tan_x)  # ctg(x) = 1 / tg(x)
        return y
    except ZeroDivisionError:
        return None  # якщо ctg(x) не визначена

# Функція запису результатів у текстовий файл
def write_to_text(filename, data):
    with open(filename, "w", encoding="utf-8") as f:
        for x, y in data:
            f.write(f"x = {x:.3f}° ({math.radians(x):.4f} рад), y = {y if y is not None else 'undefined'}\n")

# Функція зчитування з текстового файлу
def read_from_text(filename):
    with open(filename, "r", encoding="utf-8") as f:
        content = f.read()
    return content

# Функція запису результатів у двійковий файл
def write_to_binary(filename, data):
    with open(filename, "wb") as f:
        for x, y in data:
            # Якщо y невизначене — запишемо 0.0
            f.write(struct.pack("dd", x, y if y is not None else 0.0))

# Функція читання з двійкового файлу
def read_from_binary(filename):
    result = []
    with open(filename, "rb") as f:
        while chunk := f.read(16):  # 2 числа double = 16 байт
            x, y = struct.unpack("dd", chunk)
            result.append((x, y))
    return result
