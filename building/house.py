"""
Модуль house.py
Містить базовий клас House, який описує загальні атрибути та методи для будівлі.
"""

from dataclasses import dataclass

@dataclass
class House:
    """Базовий клас предметної області — Будинок.

    Атрибути:
        address (str): адреса будівлі
        floors (int): кількість поверхів
        area (float): загальна площа в квадратних метрах
    """
    address: str
    floors: int
    area: float

    def __post_init__(self):
        # базова валідація вхідних даних
        if self.floors < 1:
            raise ValueError('Кількість поверхів має бути принаймні 1')
        if self.area <= 0:
            raise ValueError('Площа має бути додатною')

    def info(self) -> str:
        """Повертає коротку інформацію про будинок."""
        return f"Будинок: {self.address}, поверхів: {self.floors}, площа: {self.area} м²"

    def area_per_floor(self) -> float:
        """Розрахунок площі на один поверх."""
        return self.area / self.floors

    def can_park(self) -> bool:
        """Простий приклад методу: чи можна розмістити паркінг всередині будівлі."""
        return self.area > 500
