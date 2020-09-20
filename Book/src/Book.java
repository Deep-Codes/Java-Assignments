// Deepankar Bhade
// 20.09.2020
// JAVA EXP 7
public class Book {
     String name;
     String author;
     int price;
     public Book (String name , String author , int price){
        this.name = name;
        this.author = author;
        this.price = price;
     }
     // Parent Method
     void display (){
         System.out.println("Name: "+this.name+"\n"+ "Author: "+this.author+"\n"+"Price: "+this.price+"\n");
     }

     // Reference_Book Class
     static class Reference_Book extends Book{
         String reference;
         public Reference_Book(String name, String author, int price ,String reference) {
             super(name, author, price);
             this.reference = reference;
         }
         // Method Overriding
         void display(){
             System.out.println("Reference Method Overriding\n");
             System.out.println("Name: "+this.name+"\n"+ "Author: "+this.author+"\n"+"Price: "+this.price+"\n"+"Reference Book: "+this.reference);
         }
     }

    // Magazine Class
    static class Magazine extends Book{
        String magazine;
        public Magazine(String name, String author, int price ,String magazine) {
            super(name, author, price);
            this.magazine = magazine;
        }
        // Method Overriding
        void display(){
            System.out.println("Magazine Method Overriding\n");
            System.out.println("Name: "+this.name+"\n"+ "Author: "+this.author+"\n"+"Price: "+this.price+"\n"+"Magazine: "+this.magazine);
        }
    }


    public static void main(String args[]){
        Book book1 = new Book("JavaScript","Deepankar Bhade",499);
        book1.display();
        Reference_Book ref1 = new Reference_Book("JavaScript","Deepankar Bhade",499,"Java Help");
        ref1.display();
        Magazine mag1 = new Magazine("JavaScript","Deepankar Bhade",499,"Dev Guides");
        mag1.display();
    }
}
