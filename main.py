"""
Точка входу програми.
"""

from building import House, OfficeCenter


def demo():
    # Створюємо базовий об'єкт House
    house = House(address='вул. Центральна, 1', floors=2, area=240.0)
    print(house.info())
    print(f'Площа на поверх: {house.area_per_floor():.2f} м²')
    print('Паркінг всередині:', 'так' if house.can_park() else 'ні')

    print('\n--- Офісний центр demo ---')
    # Створюємо OfficeCenter
    office = OfficeCenter(
        address='просп. Нова, 10',
        floors=10,
        area=3200.0,
        tenant_list=['Компанія А', 'Компанія Б'],
        meeting_rooms=6,
        has_cafeteria=True
    )

    print(office.info())
    print(f'Орендарів: {office.tenant_count()}')
    office.add_tenant('Компанія В')
    print('Після додавання орендаря:', office.tenant_list)
    office.remove_tenant('Компанія А')
    print('Після видалення орендаря:', office.tenant_list)
    print('Оцінка місткості:', office.capacity_estimate())


if __name__ == '__main__':
    demo()
