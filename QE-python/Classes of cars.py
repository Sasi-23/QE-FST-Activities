class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")

car1 = Car("JAGUAR", "Corolla", 2022, "Automatic", "Black")
car2 = Car("BENZ", "Civic", 2021, "Manual", "Black")
car3 = Car("Tesla", "Model 3", 2023, "Automatic", "Red")



car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()

