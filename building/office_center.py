"""
Модуль office_center.py
Містить похідний клас OfficeCenter від House із додатковими атрибутами
і методами, специфічними для офісних центрів.
"""

from dataclasses import dataclass
from typing import List
from .house import House

@dataclass
class OfficeCenter(House):
    """Офісний центр — похідний клас від House.

    Додає:
       - tenant_list: список орендарів
       - meeting_rooms: кількість переговорних кімнат
       - has_cafeteria: чи є їдальня/кафетерій
    """
    tenant_list: List[str]
    meeting_rooms: int = 0
    has_cafeteria: bool = False

    def tenant_count(self) -> int:
        """Повертає кількість орендарів."""
        return len(self.tenant_list)

    def add_tenant(self, tenant_name: str) -> None:
        """Додає орендаря в список (без дублікатів)."""
        if tenant_name not in self.tenant_list:
            self.tenant_list.append(tenant_name)

    def remove_tenant(self, tenant_name: str) -> bool:
        """Видаляє орендаря. Повертає True, якщо успішно."""
        try:
            self.tenant_list.remove(tenant_name)
            return True
        except ValueError:
            return False

    def capacity_estimate(self, avg_people_per_100sqm: float = 10.0) -> int:
        """Оціночна місткість офісного центру."""
        people = int((self.area / 100.0) * avg_people_per_100sqm)
        return max(1, people)

    def info(self) -> str:
        """Розширена інформація для офісного центру."""
        base = super().info()
        return (f"{base} | Офісний центр — орендарів: {self.tenant_count()}, "
                f"переговорних кімнат: {self.meeting_rooms}, їдальня: {self.has_cafeteria}")
