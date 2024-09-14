import java.util.*;

public class lab1_p1 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        while (true) {
            System.out.println("Please choose: 1.add    2.delete    3.print all employee    4.exit.");
            Scanner sc = new Scanner(System.in);
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("The input is not a valid number.");
                continue;
            }
            boolean exit = false;
            switch (choice) {
                case 1: {
                    System.out.print("Please enter the name of the employee for adding : ");
                    String addName = sc.nextLine();
                    boolean hasFind = false;
                    for (Employee e : list) {
                        if (e.name.equals(addName)) {
                            hasFind = true;
                            break;
                        }
                    }
                    if (hasFind) {
                        System.out.println(addName + " is already in the list");
                    } else {
                        try {
                            System.out.print("Please enter the age of the employee for adding : ");
                            int age = sc.nextInt();
                            list.add(new Employee(addName, age));
                        } catch (InputMismatchException e) {
                            System.out.println("This is not a valid input for age! Please choose again");
                        }
                    }
                    break;
                }

                case 2: {
                    if (list.isEmpty()) {
                        System.out.println("There is no employee to delete. Please choose again");
                    } else {
                        System.out.println("Please enter the name of the employee for deleting : ");
                        String deleteName = sc.next();
                        boolean hasFind = false;
                        for (Employee e : list) {
                            if (e.name.equals(deleteName)) {
                                list.remove(e);
                                hasFind = true;
                                break;
                            }
                        }
                        if (!hasFind) {
                            System.out.println("Employee not found");
                        }
                    }
                    break;
                }
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("There is no employee to print. Please choose again");
                    } else {
                        list.sort(Comparator.comparing(o -> o.name));
                        for (Employee e : list) {
                            System.out.println("name:" + e.name + "    age:" + e.age);
                        }
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose again");
            }
            if (exit) {
                break;
            }
        }

    }

    static class Employee {
        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
