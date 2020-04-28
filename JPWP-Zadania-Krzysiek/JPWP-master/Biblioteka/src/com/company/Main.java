package com.company;


import java.util.LinkedList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
                " fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in" +
                " culpa qui officia deserunt mollit anim id est laborum";
        List<Page> pages = new LinkedList();
        Page page1 = new Page();
        Page page2 = new Page();
        Page page3 = new Page();
        page1.setContent(text);
        page2.setContent(text);
        page3.setContent(text);
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);

        Book book = new Book();
        book.setPages(pages);
        book.setAuthor("Kowalski Jan");

        book.printBookToHtml(book,"");
    }
}

