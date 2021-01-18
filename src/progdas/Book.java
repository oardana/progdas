/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progdas;


import java.util.Scanner;
import java.util.ArrayList;

public class Book {

    public static void main(String[] args) {

        // Algoritma
        // Buat sebuah array of object allBooks, yang berisi kumpulan buku dan yang bersifat global sehingga bisa diakses dimana saja
        // Buat sebuah variable isUsed dengan tipe data boolean untuk menyimpan apakah pengguna akan keluar dari program atau tidak
        ArrayList allBooks = new ArrayList();
        Boolean isUsed = true;

        // Lakukan pengkondisian, selagi variable isUsed = true, maka selalu jalankan kode dibawah
        while (isUsed) {

            // Munculkan Tulisan
            // Pilihan Sebagai Berikut
            // 1. Masukan Data Buku
            // 2. Hapus Data Buku
            // 3. Lihat Data Buku
            // 4. Keluar
            System.out.print("\n");
            System.out.print("\n");
            System.out.println("------------------ Data Perpustakaan ------------------");
            System.out.println("-------------------- Pilihan Menu --------------------- \n");
            System.out.println("1. Masukan data buku");
            System.out.println("2. Hapus data buku");
            System.out.println("3. Lihat data buku");
            System.out.println("4. Keluar \n");

            // Munculkan Tulisan Masukan Pilihan dan tangkap ke variable selection
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Masukan Pilihan: ");
            Integer selection = keyboard.nextInt();

            // Lakukan pengkondisian 
            // Jika variable selection == 1
            if (selection == 1) {
                // Jalankan Funsi Insert Data dan masukan ke dalam variable array global allBooks,
                ArrayList books = new ArrayList<String>();
                books = insertData();
                for (int i = 0; i < books.size(); i++) {
                    allBooks.add(books.get(i));
                }
                // Jika variable selection == 2
            } else if (selection == 2) {
                    // Tampilkan Semua Data terlebih dahulu
                    showList(allBooks);
        
                    // Jalankan Fungsi getIndexDeletedData yang mengembalikan nilai nomor data
                    int indexData = getIndexDeletedData();
                    
                    // Hapus variable global allBooks index ke indexData
                    allBooks.remove(indexData);
                    
                    // Tampilkan Pesan Sukses data terhapus
                    System.out.println("++++++++++++++++" + " Data ke - " + ( indexData + 1 ) + " Terhapus " + "+++++++++++++++++++++++++");
                
                // Jika variable selection == 3
            } else if (selection == 3) {
                // Jalankan Fungsi Show Data dan berikan argumen variable allBooks
                showList(allBooks);

                // Jika variable selection == 4
            } else if (selection == 4) {
                // Jalankan Fungsi Exit Program
                if(exitProgram()) {
                    // Jika exit program = true, maka ubah variable global isUsed ke false 
                    isUsed = false;
                }
            } else {
                System.out.println("Input yang anda masukan salah");
            }
        }
    }

    // Fungsi Insert Data
    static ArrayList<String> insertData() {
        Scanner keyboard = new Scanner(System.in);

        // Tanyakan jumlah data yang akan di input dan masukan ke dalam variable amountOfData
        System.out.print("\n");
        System.out.print("Jumlah data yang akan diinput : ");
        Integer amountOfData = keyboard.nextInt();
        System.out.print("\n");

        // Buat sebuah array [] untuk menyimpan semua buku yang akan di inputkan (books)
        ArrayList books = new ArrayList<String>();

        // Jalankan perulangan sesuai jumlah variable amountData3
        
        for (int i = 0; i < amountOfData; i++) {
            // Buat sebuah array asosiatif yang nantinya akan menyimpan data perbuku (book)
            ArrayList book = new ArrayList<String>();

            // Tanyakan dan tangkap kode buku, ke dalam variable book dengan key bookCode
            System.out.print("Kode Buku     : ");
            int bookCode = keyboard.nextInt();

            // Seperti new line \n
            keyboard.nextLine();

            // Tanyakan dan tangkap judul buku, ke dalam variable book dengan key bookTitle
            System.out.print("Judul Buku    : ");
            String bookTitle = keyboard.nextLine();

            // Tanyakan dan tangkap stok buku, ke dalam variable book dengan key numberOfBooks
            System.out.print("Stok Buku     : ");
            Integer numberOfBooks = keyboard.nextInt();
            System.out.println("===================================");

            // Sehingga nanti akan menghasilan array assosiatif book seperti berikut
            // ex: book [
            //        'bookCode'      => 00123,      
            //        'bookTitle'     => 'Gerhana', 
            //        'numberOfBooks' => 15
            //      ];
            book.add(bookCode);
            book.add(bookTitle);
            book.add(numberOfBooks);

            // Setelah itu masukan variable book ke dalam variable books
            books.add(book);
            // Lakukan perulangan tadi sampai sama dengan jumlah variable amountData 
            
        }
        // Setelah perulangan tadi diharapkan variable books akan seperti berikut
        // books = [book, book, book,... ]
        // Lalu kembalikan nilai (return) variable books
        return books;

    }

    // Fungsi Show Data
    // Tangkap argumen ke dalam parameter books
    static void showList(ArrayList books) {

        System.out.print("\n");
        System.out.format("+--------+-------------+----------------+-----------+%n");
        System.out.format("|   No   | Kode Buku   |   Judul Buku   |    Stok   |%n");
        System.out.format("+--------+-------------+----------------+-----------+%n");

//         Jalankan perulangan sesuai jumlah books
        for (int i = 0; i < books.size(); i++) {
            // lalu tampilkan sesuai masing masing key
            ArrayList<Object> item = (ArrayList) books.get(i);
            System.out.format("| %-6d | %-11s | %-14s | %-9s |%n", i+1 ,item.get(0),item.get(1),item.get(2));
        }
        System.out.format("+--------+-------------+----------------+-----------+%n");
    }
    
    // Fungsi Delete Data
    static int getIndexDeletedData() {
        Scanner keyboard = new Scanner(System.in);
        
        // Tanyakan data ke berapa yang akan dihapus dan tangkap ke dalam variable deletedNumber
        System.out.print("\n");
        System.out.print("Hapus data ke : ");
        Integer indexOfDeletedData = keyboard.nextInt() - 1;
        
        // Lalu kembalikan nilai (return) variable deletedNumber
        return indexOfDeletedData;
    }

    // Fungsi Exit Program
    static boolean exitProgram() {
        Scanner keyboard = new Scanner(System.in);
        boolean answered = false;
        boolean isExit = false;
        
        // Tangkap dan tanyakan apakah ingin keluar, ke dalam variable is Exit
        while (!answered) {        
            System.out.print("\n");
            System.out.println("APAKAH ANDA YAKIN KELUAR DARI PROGRAM?");
            System.out.println("[Y]                         [N]");
            System.out.print("                ");
            String askIsExit = keyboard.nextLine();

            // Lakukan pengkondisian dan kembalikan nilai (return) boolean
            if( askIsExit.equals("y") ) {
                answered = true;
                isExit = true;
            } else if( askIsExit.equals("Y") ) {
                answered = true;
                isExit = true;
            } else if( askIsExit.equals("n") ) {
                answered = true;
                isExit = false;
            } else if( askIsExit.equals("N") ) {
                answered = true;
                isExit = false;
            } else {
                System.out.println("Input Yang Anda Masukan Salah!");
                answered = false;
            }
        }
        
        return isExit;
    }
}
