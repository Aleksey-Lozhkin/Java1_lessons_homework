package lesson5;

public class main {

    // 6.	* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    // Метод должен принимать в качестве параметра массив сотрудников.
    // Вывести в main() возраст и зарплату сотрудника до и после вызова метода;
    private static void increaser(Employee[] emp, byte age, float increment){
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getAge() > age) {
                emp[i].setSalary(increment);
                emp[i].isSalaryChanged = true;
            }
        }
    }

    // 7.	** Написать методы (принимающие на вход массив сотрудников),
    // вычисляющие средний возраст и среднюю зарплату сотрудников,
    // вывести результаты работы в консоль.
    private static float averageSalary(Employee[] emp){
        float result = 0;
        for (int i = 0; i < emp.length; i++)
            result += emp[i].getSalary();

        return result / emp.length;
    }

    private static float averageAge(Employee[] emp){
        float result = 0;
        for (int i = 0; i < emp.length; i++)
            result += emp[i].getAge();

        return result / emp.length;
    }

    public static void main(String[] args) {
        // 1.	Создать класс "Сотрудник" с полями: ФИО, должность, телефон,
        // зарплата, возраст;
        Employee e = new Employee("Aleksey", "Ivanovich",
                "Lozhkin", "8(495)000-11-22",
                "developer", 80000, 1989);

        // 4.	Вывести при помощи методов из пункта 3 ФИО и должность.
        System.out.println("Please welcome our " + e.getPosition() + ", " +
                e.getName() + " " + e.getSecondName() + " " + e.getSurname() + ".");

        // 5.	Создать массив из 5 сотрудников. С помощью цикла вывести
        // информацию только о сотрудниках старше 40 лет;

        Employee[] employees = {
                e,
                new Employee("Andrey", "Viktorovich",
                        "Bezrukov", "8(495)111-22-33",
                        "fitter", 52000, 1973),
                new Employee("Evgeniy", "Viktorovich",
                        "Del'finov", "8(495)222-33-44",
                        "project manager", 40000, 1963),
                new Employee("Natalia", "Pavlovna",
                        "Keks", "8(495)333-44-55",
                        "senior developer", 90000, 1990),
                new Employee("Tatiana", "Sergeevna",
                        "Krasotkina", "8(495)444-55-66",
                        "accountant", 50000, 1983)
        };

        for (int i = 0; i < employees.length; i++)
            if (employees[i].getAge() > 40)
                System.out.println(employees[i].getFullInfo());

        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i].getFullInfo());

        increaser(employees, (byte)45, 5000.0f);

        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < employees.length; i++)
            if (employees[i].isSalaryChanged)
                System.out.println(employees[i].getFullInfo());
        System.out.println("--------------------------------------------------------");
        System.out.println("Avg. age: " + averageAge(employees) + " years");
        System.out.println("Avg. salary: " + averageSalary(employees) + " RUR");
    }

    public static class Employee {
        private static final int CURRENT_YEAR = 2020;

        private String surname;
        private String secondName;
        private String name;
        private String position;
        private String phone;
        private float salary;
        boolean isSalaryChanged;
        private int birthYear;
        private static int id = 0;
        public int uid;

        // 2.	Конструктор класса должен заполнять эти поля при создании объекта;
        Employee (String name,
                  String secondName,
                  String surname,
                  String phone,
                  String position,
                  float salary,
                  int birthYear) {
            this.birthYear = birthYear;
            this.name = name;
            this.surname = surname;
            this.secondName = secondName;
            this.position = position;
            this.phone = phone;
            this.salary = salary;
            this.uid = ++id;
        }

        // 3.	Внутри класса «Сотрудник» написать методы, которые возвращают
        // значение каждого поля;
        int getAge() {
            return CURRENT_YEAR - birthYear;
        }

        int getSalary() {
            return (int)salary;
        }

        void setSalary(int salary) {
            this.salary = salary;
        }

        void setSalary(float difference) {
            this.salary = this.salary + difference;
        }

        String getSecondName() {
            return secondName;
        }

        String getName() {
            return name;
        }

        String getSurname() {
            return surname;
        }

        String getPosition() {
            return position;
        }

        String getPhone() {
            return phone;
        }

        String getFullInfo() {
            return  this.name + " " +
                    this.secondName + " " +
                    this.surname + ", " +
                    this.getAge() + " years old, " +
                    this.position + ". Phone number: " +
                    this.phone + ". Salary is " +
                    this.getSalary() + " RUR.";
        }

    }
}