package Client;



import entity.Position;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 2951);
            Scanner scanner = new Scanner(System.in);
        ){
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server");
            int choice =0;
            while (true)
            {
                System.out.println("1. Cau A");
                System.out.println("2. Cau B");
                System.out.println("3. Cau C");
                System.out.println("4. Câu D");
                System.out.println("5. Câu E");
                System.out.println("6. Câu F");
                System.out.println("7. Exit");
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                dos.writeInt(choice);
                switch (choice)
                {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Cau A: Nhập teen:");
                        String name = scanner.nextLine();
                        dos.writeUTF(name);
                        System.out.println("Nhap luong khoi dau:");
                        int salaryFrom = scanner.nextInt();
                        dos.writeDouble(salaryFrom);
                        System.out.println("Nhap luong ket thuc:");
                        int salaryTo = scanner.nextInt();
                        dos.writeDouble(salaryTo);
                        dos.flush();

                        List<Position> positionList = (List<Position>) ois.readObject();
                        positionList.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Cau B");
                        break;
                    case 3:
                        System.out.println("Cau C");
                        break;
                    case 4:
                        System.out.println("Cau D");
                        break;
                    case 5:
                        System.out.println("Cau E");
                        break;
                    case 6:
                        System.out.println("Cau F");
                        break;
                    case 7:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                if(choice == 7)
                    break;

            }
        } catch (Exception e) {
            System.out.println("Lỗi h");
        }
    }
}
