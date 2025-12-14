package Demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// LƯU Ý: Đã loại bỏ dòng 'package Exception.Demo;' để đảm bảo code chạy được trong môi trường này.

/**
 * Class ExceptionMiniProject
 * Đây là một mini project tổng hợp để demo toàn bộ kiến thức về Java Exception
 * dựa trên tài liệu đã cung cấp.
 *
 * Các kiến thức bao gồm:
 * 1. Phân loại Exception (Checked vs Unchecked).
 * 2. Các Exception phổ biến (Arithmetic, NullPointer, NumberFormat, v.v.).
 * 3. Cấu trúc xử lý: try-catch, try-finally, try-catch-finally.
 * 4. Xử lý nhiều block catch và try lồng nhau.
 * 5. Các phương thức của object Exception (getMessage, printStackTrace).
 */
public class ExceptionMiniProject {

    /** Biến Scanner dùng chung cho toàn bộ chương trình để nhập liệu từ bàn phím */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Phương thức main: Điểm bắt đầu của chương trình.
     * Sử dụng vòng lặp while để tạo menu lựa chọn chức năng demo.
     */
    public static void main(String[] args) {
        // [Image of Java Exception Hierarchy Chart]
        while (true) {
            System.out.println("\n================ JAVA EXCEPTION MINI PROJECT ================");
            System.out.println("1. Demo ArithmeticException (Lỗi toán học)");
            System.out.println("2. Demo NullPointerException (Lỗi biến null)");
            System.out.println("3. Demo NumberFormatException (Lỗi định dạng số)");
            System.out.println("4. Demo ArrayIndexOutOfBoundsException (Lỗi chỉ số mảng)");
            System.out.println("5. Demo ClassCastException (Lỗi ép kiểu)");
            System.out.println("6. Demo Checked Exception (Lỗi File/IO - Compile time)");
            System.out.println("7. Demo Try-Finally (Không có catch)");
            System.out.println("8. Demo Nested Try-Catch (Try lồng nhau)");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn chức năng (0-8): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    demoArithmeticException();
                    break;
                case "2":
                    demoNullPointerException();
                    break;
                case "3":
                    demoNumberFormatException();
                    break;
                case "4":
                    demoArrayIndexOutOfBounds();
                    break;
                case "5":
                    demoClassCastException();
                    break;
                case "6":
                    demoCheckedException();
                    break;
                case "7":
                    demoTryFinally();
                    break;
                case "8":
                    demoNestedTryCatch();
                    break;
                case "0":
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    /**
     * 1. Demo ArithmeticException
     * Đây là một Runtime Exception (Unchecked) thường gặp khi chia cho 0.
     * Demo cấu trúc cơ bản: try - catch.
     */
    private static void demoArithmeticException() {
        System.out.println("\n--- Demo 1: ArithmeticException ---");
        try {
            System.out.print("Nhập số bị chia: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập số chia (hãy nhập 0 để gây lỗi): ");
            int b = Integer.parseInt(scanner.nextLine());

            /**
             * Nếu b = 0, dòng lệnh dưới đây sẽ ném ra ArithmeticException.
             * Chương trình sẽ dừng flow hiện tại và nhảy vào block catch.
             */
            int result = a / b;
            System.out.println("Kết quả: " + result);

        } catch (ArithmeticException ex) {
            /**
             * Bắt lỗi chia cho 0.
             * Sử dụng các phương thức của Exception class như trong slide.
             */
            System.out.println("\n[BẮT ĐƯỢC NGOẠI LỆ!]");
            System.out.println("Tên lỗi (toString): " + ex.toString());
            System.out.println("Thông điệp (getMessage): " + ex.getMessage());
            System.out.println("Stack Trace (printStackTrace):");
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            /** Xử lý trường hợp người dùng nhập chữ thay vì số */
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên!");
        }
    }

    /**
     * 2. Demo NullPointerException
     * Xảy ra khi cố gắng truy cập phương thức hoặc thuộc tính của một object đang là null.
     */
    private static void demoNullPointerException() {
        System.out.println("\n--- Demo 2: NullPointerException ---");
        try {
            String str = null;
            System.out.println("Khởi tạo String str = null;");

            /** * Dòng này sẽ gây lỗi vì 'str' đang là null, không thể gọi .length().
             * Đây là lỗi logic lập trình (Unchecked Exception).
             */
            System.out.print("Độ dài chuỗi là: " + str.length());

        } catch (NullPointerException ex) {
            System.out.println("[LỖI] Truy cập vào đối tượng null: " + ex.getMessage());
        }
    }

    /**
     * 3. Demo NumberFormatException
     * Xảy ra khi cố gắng chuyển đổi (parse) một chuỗi không đúng định dạng sang số.
     */
    private static void demoNumberFormatException() {
        System.out.println("\n--- Demo 3: NumberFormatException ---");
        try {
            System.out.print("Nhập vào một chuỗi bất kỳ (ví dụ 'abc'): ");
            String input = scanner.nextLine();

            /** Cố gắng ép kiểu chuỗi sang số nguyên */
            int number = Integer.parseInt(input);
            System.out.println("Số bạn vừa nhập là: " + number);

        } catch (NumberFormatException ex) {
            System.out.println("[LỖI] Không thể chuyển đổi chuỗi ký tự thành số!");
            System.out.println("Chi tiết lỗi: " + ex.toString());
        }
    }

    /**
     * 4. Demo ArrayIndexOutOfBoundsException
     * Xảy ra khi truy cập vào chỉ số mảng không tồn tại (âm hoặc lớn hơn size - 1).
     */
    private static void demoArrayIndexOutOfBounds() {
        System.out.println("\n--- Demo 4: ArrayIndexOutOfBoundsException ---");
        try {
            int[] arr = new int[5]; // Mảng có index từ 0 đến 4
            System.out.println("Đã tạo mảng int[5] (index hợp lệ: 0-4).");

            System.out.print("Nhập index bạn muốn truy cập (hãy nhập 5 hoặc 10): ");
            int index = Integer.parseInt(scanner.nextLine());

            /** Truy cập mảng tại vị trí index */
            arr[index] = 50;
            System.out.println("Đã gán giá trị 50 vào arr[" + index + "]");

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("[LỖI] Truy cập ngoài chỉ số mảng!");
            System.out.println("Index gây lỗi: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Vui lòng nhập index là số nguyên.");
        }
    }

    /**
     * 5. Demo ClassCastException
     * Xảy ra khi ép kiểu đối tượng sang một subclass mà nó không thuộc về.
     * Ví dụ: Ép kiểu một Object (thực chất là String) sang Integer.
     */
    private static void demoClassCastException() {
        System.out.println("\n--- Demo 5: ClassCastException ---");
        try {
            Object obj = "Đây là chuỗi String";
            System.out.println("Object obj = \"Đây là chuỗi String\";");

            /** * Cố gắng ép kiểu String sang Integer.
             * String không có quan hệ kế thừa với Integer -> Lỗi Runtime.
             */
            Integer number = (Integer) obj;
            System.out.println("Số là: " + number);

        } catch (ClassCastException ex) {
            System.out.println("[LỖI] Ép kiểu không hợp lệ!");
            System.out.println(ex.toString());
        }
    }

    /**
     * 6. Demo Checked Exception (IOException, FileNotFoundException)
     * Checked Exception bắt buộc phải xử lý tại thời điểm biên dịch (compile time).
     * Sử dụng cấu trúc try-catch-finally đầy đủ.
     */
    private static void demoCheckedException() {
        System.out.println("\n--- Demo 6: Checked Exception & Try-Catch-Finally ---");

        // Khai báo reader bên ngoài try để có thể đóng trong finally
        BufferedReader reader = null;

        try {
            System.out.print("Nhập tên file muốn mở (file không tồn tại để test): ");
            String fileName = scanner.nextLine();

            /**
             * FileReader có thể ném ra FileNotFoundException (Checked Exception).
             * Java bắt buộc phải try-catch đoạn này, nếu không sẽ báo lỗi biên dịch.
             */
            reader = new BufferedReader(new FileReader(fileName));
            System.out.println("Nội dung file đầu tiên: " + reader.readLine());

        } catch (IOException ex) {
            /** Xử lý lỗi IO hoặc không tìm thấy file */
            System.out.println("[LỖI] Không thể đọc file hoặc file không tồn tại.");
            System.out.println("Message: " + ex.getMessage());

        } finally {
            /**
             * Khối finally LUÔN LUÔN được thực thi dù có lỗi hay không.
             * Thường dùng để đóng tài nguyên (close file, close connection).
             */
            System.out.println("--> Khối finally đang chạy: Đóng kết nối file.");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 7. Demo Try-Finally (Không có Catch)
     * Lỗi vẫn sẽ xảy ra và làm dừng chương trình (hoặc ném ra ngoài),
     * nhưng khối finally vẫn được đảm bảo chạy trước khi crash.
     * (Lưu ý: Để demo không bị crash app chính, tôi sẽ catch lỗi ở bên ngoài hàm này gọi nó).
     */
    private static void demoTryFinally() {
        System.out.println("\n--- Demo 7: Try - Finally (No Catch) ---");
        try {
            try {
                System.out.println("Trong khối try...");
                int data = 25 / 0; // Gây lỗi ArithmeticException
                System.out.println("Dòng này sẽ không được in ra: " + data);
            } finally {
                /** Code này chạy ngay cả khi lỗi chia cho 0 xảy ra ở trên */
                System.out.println("--> Finally: Code này luôn chạy dù có lỗi hay không!");
            }
        } catch (ArithmeticException e) {
            System.out.println("(Bắt lỗi ở bên ngoài để chương trình không bị dừng đột ngột)");
        }
    }

    /**
     * 8. Demo Nested Try-Catch (Xử lý ngoại lệ lồng nhau)
     * Thể hiện việc xử lý lỗi cục bộ bên trong một khối try lớn.
     */
    private static void demoNestedTryCatch() {
        System.out.println("\n--- Demo 8: Nested Try-Catch ---");
        try {
            // Khối try bên ngoài
            System.out.println("Bắt đầu khối try ngoài...");

            try {
                // Khối try bên trong 1: Xử lý chia cho 0
                System.out.println("  [Trong] Thực hiện phép chia 10/0");
                int a = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("  [Trong] Bắt lỗi chia cho 0: " + e.getMessage());
            }

            try {
                // Khối try bên trong 2: Xử lý mảng
                int[] arr = new int[2];
                System.out.println("  [Trong] Truy cập arr[5]");
                arr[5] = 10;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  [Trong] Bắt lỗi index mảng: " + e.getMessage());
            }

            System.out.println("Kết thúc khối try ngoài (Chương trình vẫn chạy tiếp nhờ đã catch bên trong).");

        } catch (Exception e) {
            System.out.println("Bắt lỗi chung ở khối ngoài (nếu có lỗi chưa được xử lý bên trong).");
        }
    }
}